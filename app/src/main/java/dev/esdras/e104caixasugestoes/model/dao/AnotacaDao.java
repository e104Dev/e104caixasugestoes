package dev.esdras.e104caixasugestoes.model.dao;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import dev.esdras.e104caixasugestoes.model.entity.Anotacao;

@Dao
public interface AnotacaDao {

    @Query("SELECT * FROM anotacao ORDER BY id ")
    LiveData<List<Anotacao>> getAll();

    @Insert
    void salvar(Anotacao anotacao);

    @Delete
    void apagar(Anotacao anotacao);
}
