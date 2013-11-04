package br.com.jogodamemoria.jogo.objetos;

/**
 * Created by ricardo on 03/11/13.
 */

public class Conf {

    public static String nome;
    public static String dificuldade;
    public static String[] categoria;

    public Conf(String nome, String dificuldade, String[] categoria) {
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String[] getCategoria() {
        return categoria;
    }

    public void setCategoria(String[] categoria) {
        this.categoria = categoria;
    }
}
