package dev.esdras.e104caixasugestoes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    //TODO: Declarar os objetos de interação

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO: Inicializar os objetos conforme o Layout e seus respectivos IDs.
    }

    public void abrirSugestoes(View view) {
        //TODO: Capturar os dados do formulário

        //TODO: Validar a entrada de dados, nao permitindo envio de sugestões não preenchidas

        //TODO: Enviar os dados para o Web000Host e aguardar resposta

        //TODO: Abrir a tela com as sugestões
        Intent intent = new Intent(this, SugestaoListActivity.class);
        startActivity(intent);
    }
}