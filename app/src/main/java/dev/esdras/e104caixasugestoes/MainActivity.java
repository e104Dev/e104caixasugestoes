package dev.esdras.e104caixasugestoes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //TODO: Declarar os objetos de interação
    EditText editTextSugesto, editTextNome;
    Spinner spinnerCurso, spinnerTipo;

    // Arrays para padronizar os dados de envio ao banco de dados
    List<String> cursos = Arrays.asList("sistemas", "administracao", "logistica");
    List<String> tipos = Arrays.asList("sugestao", "elogio", "comentario", "reclamacao");

    String curso = "", tipo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO: Inicializar os objetos conforme o Layout e seus respectivos IDs.
        editTextSugesto = findViewById(R.id.editTextSugestao);
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
    public void abrirSugestoes(View view) {
        //TODO: Capturar os dados do formulário
        String conteudo = editTextSugesto.getText().toString();
        String nome = editTextNome.getText().toString();

        //TODO: Validar a entrada de dados, nao permitindo envio de sugestões não preenchidas
        if(conteudo.isEmpty()) {
            Toast.makeText(getApplicationContext(), "O conteúdo é obrigatório", Toast.LENGTH_SHORT).show();
            return;
        }

        //TODO: Enviar os dados para o Web000Host e aguardar resposta
        enviarRequisicao(nome, conteudo);

        //TODO: Abrir a tela com as sugestões
        Intent intent = new Intent(this, SugestaoListActivity.class);
        startActivity(intent);
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
    private void enviarRequisicao(String nome, String conteudo) {
        RequestQueue queue = Volley.newRequestQueue(this);

        // URL de seu script para inclusão em banco de dados
        String url = "SEU SCRIPT INSERT AQUI";

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Aguarde")
                .setMessage("Gravando sugestão...")
                .create();
        alertDialog.show();

        //Criação de requisição do Volley API
        StringRequest postRequest = new StringRequest(Request.Method.POST, url, response -> {
            // Fechar alerta ao concluir a requisição
            alertDialog.dismiss();
        }, error -> {
            alertDialog.dismiss();
            Toast.makeText(getApplicationContext(), "Erro ao enviar requisição", Toast.LENGTH_SHORT).show();
        }){
            // Adequação dos dados utilizando o $_POST do PHP para recepção dos dados.
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("curso",curso);
                params.put("tipo",tipo);
                params.put("nome",nome);
                params.put("conteudo",conteudo);
                return params;
            }
        };

        // A dicionar requisição à fila pára gerenciamento do Volley API
        queue.add(postRequest);
    }
}