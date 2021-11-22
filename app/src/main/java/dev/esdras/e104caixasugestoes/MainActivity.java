package dev.esdras.e104caixasugestoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import dev.esdras.e104caixasugestoes.views.AnotacaoActivity;
import dev.esdras.e104caixasugestoes.views.SugestaoActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abriCaixaSugestoes(View view) {
        Intent intent = new Intent(this, SugestaoActivity.class);
        startActivity(intent);
    }

    public void abrirMinhasAnotacoes(View view) {
        Intent intent = new Intent(this, AnotacaoActivity.class);
        startActivity(intent);
    }
}