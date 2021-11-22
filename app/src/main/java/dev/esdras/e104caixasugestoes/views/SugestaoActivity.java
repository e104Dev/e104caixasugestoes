package dev.esdras.e104caixasugestoes.views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

import dev.esdras.e104caixasugestoes.R;
import dev.esdras.e104caixasugestoes.model.Sugestao;

public class SugestaoActivity extends AppCompatActivity {

    private static final String TAG = "SugestaoActivity";

    //TODO: Declarar os objetos de interação
    EditText editTextSugestao, editTextNome;
    Spinner spinnerCurso, spinnerTipo;

    // Arrays para padronizar os dados de envio ao banco de dados
    List<String> cursos = Arrays.asList("sistemas", "administracao", "logistica");
    List<String> tipos = Arrays.asList("sugestao", "elogio", "comentario", "reclamacao");

    String curso = "", tipo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugestao);

        //TODO: Inicializar os objetos conforme o Layout e seus respectivos IDs.
        editTextSugestao = findViewById(R.id.editTextSugestao);
        editTextNome = findViewById(R.id.editTextNome);

        spinnerCurso = findViewById(R.id.spinnerCurso);
        spinnerTipo = findViewById(R.id.spinnerTipo);

        // Adicionar o evento para capturar o curso selecionado
        spinnerCurso.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                curso = cursos.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Adicionar o evento para capturar o tipo de sugestão selecionada
        spinnerTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tipo = tipos.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    /**
     * Orquestrador para validação de dados de entrada, envio de requisição e abertura da tela de sugestões.
     * @param view View - Classe de vículo entre view e controller
     */
    public void salvarSugestao(View view) throws JsonProcessingException, JSONException {
        //TODO: Capturar os dados do formulário
        String conteudo = editTextSugestao.getText().toString();
        String nome = editTextNome.getText().toString();

        //TODO: Validar a entrada de dados, nao permitindo envio de sugestões não preenchidas
        if(conteudo.isEmpty()) {
            Toast.makeText(getApplicationContext(), "O conteúdo é obrigatório", Toast.LENGTH_SHORT).show();
            return;
        }

        //TODO: Enviar os dados para o Web000Host e aguardar resposta
        enviarRequisicao(nome, conteudo);
    }

    public void visualizarSugestoes(View view) {
        Intent intent = new Intent(this, SugestaoListActivity.class);
        startActivity(intent);
    }

    /**
     * Envio de requisição POST para a aplicação PHP que persistirá a sugestão em base de dados.
     * @param nome String - Nome do usuário
     * @param conteudo String - Conteúdo da sugestão
     */
    private void enviarRequisicao(String nome, String conteudo) throws JsonProcessingException, JSONException {
        RequestQueue queue = Volley.newRequestQueue(this);

        // URL de seu script para inclusão em banco de dados
        String url = "https://e104caixasugestoes.herokuapp.com/api/v1/sugestao";

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Aguarde")
                .setMessage("Gravando sugestão...")
                .create();
        alertDialog.show();

        Sugestao sugestao = new Sugestao(tipo,conteudo,curso,nome);
        JSONObject jsonObject = new JSONObject(new ObjectMapper().writeValueAsString(sugestao));

        //Criação de requisição do Volley API
        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, response -> {
            alertDialog.dismiss();
            Toast.makeText(getApplicationContext(), "Sugestão enviada com sucesso!", Toast.LENGTH_SHORT).show();
            editTextSugestao.setText("");
        }, error -> {
            alertDialog.dismiss();
            Toast.makeText(getApplicationContext(), "Erro ao gravar novo registro.", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "Erro ao enviar requisição POST", error);
        });

        // A dicionar requisição à fila pára gerenciamento do Volley API
        queue.add(postRequest);
    }
}