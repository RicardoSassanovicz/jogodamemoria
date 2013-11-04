package br.com.jogodamemoria.jogo.objetos;

/**
 * Created by ricardo on 03/11/13.
 */
public class Item {

    private String descricao;
    private int imagem;
    private String traducao;

    public Item(String descricao, int imagem, String traducao) {
        this.descricao = descricao;
        this.imagem = imagem;
        this.traducao = traducao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getTraducao() {
        return traducao;
    }

    public void setTraducao(String traducao) {
        this.traducao = traducao;
    }
}
