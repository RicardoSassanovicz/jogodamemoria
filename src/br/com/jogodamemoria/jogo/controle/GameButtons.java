package br.com.jogodamemoria.jogo.controle;

import org.cocos2d.layers.CCLayer;

import br.com.jogodamemoria.jogo.cenas.TelaDoJogo;
public class GameButtons extends CCLayer{

    private TelaDoJogo delegate;

    public static GameButtons gameButtons() {
        return new GameButtons();
    }

    public GameButtons() {
        //habilita o touch
        this.setIsTouchEnabled(true);
        setButtonspPosition();
    }
    private void setButtonspPosition() {
    }

    public void setDelegate(TelaDoJogo telaDoJogo) {
        this.delegate = telaDoJogo;
    }
}
