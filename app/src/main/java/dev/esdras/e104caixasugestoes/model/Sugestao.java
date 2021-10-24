package dev.esdras.e104caixasugestoes.model;

public class Sugestao {

    public String tipo;
    public String conteudo;
    public String curso;
    public String aluno;
    public String data;
    public int idRecurso;

    public Sugestao(String tipo, String conteudo, String curso, String aluno, String data, int idRecurso) {
        this.tipo = tipo;
        this.conteudo = conteudo;
        this.curso = curso;
        this.aluno = aluno;
        this.data = data;
        this.idRecurso = idRecurso;
    }
}
