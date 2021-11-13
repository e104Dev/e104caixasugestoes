package dev.esdras.e104caixasugestoes;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

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
import java.util.stream.Collectors;

import dev.esdras.e104caixasugestoes.adapters.SugestaoAdapter;
import dev.esdras.e104caixasugestoes.model.Sugestao;
import dev.esdras.e104caixasugestoes.model.SugestaoDataSource;

public class SugestaoListActivity extends AppCompatActivity {

    List<Sugestao> sugestoes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugestao_list);

        String url = "https://esdrasilva.000webhostapp.com/caixasugestoes/get_all_suggestions.php1";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle(R.string.titulo_alerta_carregamento)
                .setMessage(R.string.mensagem_carregamento)
                .create();
        alertDialog.show();

        StringRequest request = new StringRequest(Request.Method.GET, url, response -> {
            //Aqui ele te entrega a resposta completa
            Log.d("Response->", response);
            try {
                sugestoes = Arrays.asList(new ObjectMapper().readValue(response, Sugestao[].class));
                SugestaoAdapter sugestaoAdapter = new SugestaoAdapter(sugestoes);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                RecyclerView recyclerView = findViewById(R.id.recyclerViewSugestoes);
                recyclerView.setAdapter(sugestaoAdapter);
                recyclerView.setLayoutManager(linearLayoutManager);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            alertDialog.dismiss();
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Erro", error.getLocalizedMessage());
                alertDialog.dismiss();
                AlertDialog erroDialog;
                erroDialog = new AlertDialog.Builder(getApplicationContext())
                        .setTitle("Falha no carregamento")
                        .setMessage("Oop... Algo deu errado no carregamento!\n".concat(error.getLocalizedMessage()))
                        .setPositiveButton("OK", null)
                        .create();
                alertDialog.show();
            }
        });

        requestQueue.add(request);

        //TODO: Receber os dados do Web000Host
//        if (carregarSugestoes()) {
//            SugestaoAdapter sugestaoAdapter = new SugestaoAdapter(sugestoes);
//            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//            RecyclerView recyclerView = findViewById(R.id.recyclerViewSugestoes);
//            recyclerView.setAdapter(sugestaoAdapter);
//            recyclerView.setLayoutManager(linearLayoutManager);
//        } else {
//            AlertDialog alertDialog1 = new AlertDialog.Builder(this)
//                    .setTitle(R.string.titulo_alerta_carregamento)
//                    .setMessage("Não há registros...")
//                    .create();
//            alertDialog1.show();
//        }



    }

    private boolean carregarSugestoes() {
        String url = "https://esdrasilva.000webhostapp.com/caixasugestoes/get_all_suggestions.php";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle(R.string.titulo_alerta_carregamento)
                .setMessage(R.string.mensagem_carregamento)
                .create();
        alertDialog.show();

        StringRequest request = new StringRequest(Request.Method.GET, url, response -> {
            //Aqui ele te entrega a resposta completa
            Log.d("Response->", response);
            try {
                sugestoes = Arrays.asList(new ObjectMapper().readValue(response, Sugestao[].class));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            alertDialog.dismiss();
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Erro", error.getLocalizedMessage());
            }
        });

        requestQueue.add(request);

        return Boolean.FALSE.equals(sugestoes.isEmpty());
    }
}