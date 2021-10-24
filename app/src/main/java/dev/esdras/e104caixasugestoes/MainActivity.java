package dev.esdras.e104caixasugestoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirSugestoes(View view) {



        Intent intent = new Intent(this, SugestaoListActivity.class);
        startActivity(intent);
    }
}