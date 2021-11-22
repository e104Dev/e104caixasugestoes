package dev.esdras.e104caixasugestoes.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import dev.esdras.e104caixasugestoes.model.dao.AnotacaRepository;
import dev.esdras.e104caixasugestoes.model.entity.Anotacao;

public class AnotacaoViewModel extends AndroidViewModel {

    private AnotacaRepository repository;
    private final LiveData<List<Anotacao>> mAllAnotacoes;

    public AnotacaoViewModel(@NonNull Application application) {
        super(application);
        repository = new AnotacaRepository(application);
        mAllAnotacoes = repository.getAllAnotacoes();
    }

    public LiveData<List<Anotacao>> getAllAnotacoes() {
        return mAllAnotacoes;
    }

    public void insert(Anotacao anotacao) {
        repository.insert(anotacao);
    }
}
