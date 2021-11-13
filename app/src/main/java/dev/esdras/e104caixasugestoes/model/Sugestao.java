package dev.esdras.e104caixasugestoes.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

import dev.esdras.e104caixasugestoes.R;

public class Sugestao {

    public String tipo;
    public String conteudo;
    public String curso;
    @JsonProperty("nome")
    public String aluno;
    @JsonProperty("data-hora")
    public String data;
    public int idRecurso;

    public Sugestao(String tipo, String conteudo, String curso, String aluno, String data) {
        this.tipo = tipo;
        this.conteudo = conteudo;
        this.curso = curso;
        this.aluno = aluno;
        this.data = data;
        this.idRecurso = toResourceId(tipo);
    }

    public Sugestao() {
    }

    public Integer toResourceId(String tipo) {
        Map<String, Integer> map = new HashMap<>();
        map.put("sugestao", R.drawable.idea);
        map.put("elogio",R.drawable.like);
        map.put("reclamacao", R.drawable.brokenheart);
        map.put("comentario", R.drawable.chat);

        return map.get(tipo);
    }

    public String toUtf8(String tipo) {
        Map<String, String> map = new HashMap<>();
        map.put("sugestao", "Sugestão");
        map.put("elogio","Elogio");
        map.put("reclamacao", "Reclamação");
        map.put("comentario", "Comentário");

        return map.get(tipo);
    }
}
