package dev.esdras.e104caixasugestoes;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dev.esdras.e104caixasugestoes.adapters.SugestaoAdapter;
import dev.esdras.e104caixasugestoes.model.Sugestao;

public class SugestaoListActivity extends AppCompatActivity {

    List<Sugestao> sugestoes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugestao_list);

        // Criar mensagem de carregamento, esta mensagem será concluida apenas ao finalizar a requisição ao 000WebHost
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle(R.string.titulo_alerta_carregamento)
                .setMessage(R.string.mensagem_carregamento)
                .create();
        alertDialog.show();

        // Criar e configurar a RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerViewSugestoes);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        //Criação da requisição ao 000WebHost
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        // Neste trecho você irá adicionar a url que realiza a consulta ao banco gerando o JSON.
        String url = "https://e104caixasugestoes.herokuapp.com/api/v1/sugestoes";

        // Criação da requisição utilizando a API Volley
        StringRequest request = new StringRequest(Request.Method.GET, url, response -> {
            Log.d("Response->", response);
            try {
                // Ao concluir a requisição, iremos converter o JSON recebido em um array de objetos do tipo Sugestao
                sugestoes = Arrays.asList(new ObjectMapper().readValue(response, Sugestao[].class));

                // Criação do Adapter, passando a lista de objetos do tipo Sugestão como argumento no construtor.
                SugestaoAdapter sugestaoAdapter = new SugestaoAdapter(sugestoes);

                // Configurando o Adapter de Dados para exibir na RecyclerView.
                recyclerView.setAdapter(sugestaoAdapter);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            // Fechando a caixa de dialogo de carregamento
            alertDialog.dismiss();
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Fechando a caixa de dialogo de carregamento em caso de erros ocorrerem.
                alertDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Oop... Algo deu errado no carregamento!", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(request);
    }
}