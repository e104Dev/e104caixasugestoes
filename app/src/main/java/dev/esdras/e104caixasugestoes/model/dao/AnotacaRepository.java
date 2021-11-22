package dev.esdras.e104caixasugestoes.model.dao;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import dev.esdras.e104caixasugestoes.model.entity.Anotacao;

public class AnotacaRepository {

    private AnotacaDao mAnotacaDao;
    private LiveData<List<Anotacao>> mAnotacoes;

    public AnotacaRepository(Application application) {
        AppDatabase appDatabase = AppDatabase.getRoomDatabase(application);
        mAnotacaDao = appDatabase.anotacaDao();
        mAnotacoes = mAnotacaDao.getAll();
    }

    public LiveData<List<Anotacao>> getAllAnotacoes() {
        return mAnotacoes;
    }

    public void insert(Anotacao anotacao) {
       AppDatabase.databaseWriteExecutor.execute(()->{
           mAnotacaDao.salvar(anotacao);
       });
    }
}
