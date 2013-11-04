package br.com.jogodamemoria.jogo.objetos;

public class Jogador {

    private Long id;
    private String nome;
    private String pontos;

    public Jogador() {
        super();
        this.id = id;
        this.nome = nome;
        this.pontos = pontos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPontos() {
        return pontos;
    }

    public void setPontos(String pontos) {
        this.pontos = pontos;
    }


}
