package dev.esdras.e104caixasugestoes.views;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import dev.esdras.e104caixasugestoes.R;
import dev.esdras.e104caixasugestoes.adapters.AnotacoesAdapter;
import dev.esdras.e104caixasugestoes.viewmodels.AnotacaoViewModel;
import dev.esdras.e104caixasugestoes.model.entity.Anotacao;

public class AnotacaoActivity extends AppCompatActivity {

    TextInputLayout textInputLayout;
    AnotacoesAdapter anotacoesAdapter;
    RecyclerView recyclerView;
    private AnotacaoViewModel viewModel;
    private String categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anotacao);

        textInputLayout = findViewById(R.id.textInputAnotacao);
        Spinner spinnerCategoria = findViewById(R.id.spinnerCategoria);
        spinnerCategoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                categoria = ((TextView) view).getText().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        viewModel = new ViewModelProvider(this).get(AnotacaoViewModel.class);
        anotacoesAdapter = new AnotacoesAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerViewAnotacoes);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(anotacoesAdapter);


        viewModel.getAllAnotacoes().observe(this, anotacoes -> {
            anotacoesAdapter.setAnotacoes(anotacoes);
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void salvarAnotacao(View view) {
        String conteudo = Objects.requireNonNull(textInputLayout.getEditText()).getText().toString();
        Anotacao anotacao = new Anotacao(conteudo, categoria,
                LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

        if(anotacao.getAnotacao().isEmpty()) {
            Toast.makeText(getApplicationContext(),
                    "Você esqueceu de preencher a anotação!", Toast.LENGTH_SHORT).show();
            return;
        }

        viewModel.insert(anotacao);

        Log.d("ANOTACAO", anotacao.toString());
        textInputLayout.getEditText().setText("");
    }
}