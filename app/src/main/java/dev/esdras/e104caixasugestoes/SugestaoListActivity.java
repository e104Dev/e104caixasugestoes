package dev.esdras.e104caixasugestoes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import dev.esdras.e104caixasugestoes.adapters.SugestaoAdapter;
import dev.esdras.e104caixasugestoes.model.SugestaoDataSource;

public class SugestaoListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugestao_list);

        //TODO: Receber os dados do Web000Host

        SugestaoAdapter sugestaoAdapter = new SugestaoAdapter(SugestaoDataSource.sugestoes);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewSugestoes);
        recyclerView.setAdapter(sugestaoAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}