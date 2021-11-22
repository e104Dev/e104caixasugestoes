package dev.esdras.e104caixasugestoes.model.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "anotacao")
public class Anotacao {

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String anotacao;
    private String categoria;
    private String data;

    @Ignore
    public Anotacao(String anotacao, String categoria, String data) {
        this.anotacao = anotacao;
        this.categoria = categoria;
        this.data = data;
    }

    public Anotacao() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Anotacao{" +
                "id=" + id +
                ", anotacao='" + anotacao + '\'' +
                ", categoria='" + categoria + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
