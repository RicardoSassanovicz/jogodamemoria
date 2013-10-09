package br.com.jogodamemoria.jogo.controle;

import br.com.jogodamemoria.jogo.scenes.TelaDoJogo;

import org.cocos2d.layers.CCLayer;

/**
 * Created by ricardo on 25/09/13.
 */
public class GameButtons extends CCLayer{



    private TelaDoJogo delegate;

    public static GameButtons gameButtons() {
        return new GameButtons();
    }

    public GameButtons() {
        //habilita o touch
        this.setIsTouchEnabled(true);

        //Configura as figuras


        // Configura posições
        setButtonspPosition();

        // Adiciona os botões na tela

    }


    private void setButtonspPosition() {
        // Posição dos botões

    }

    public void setDelegate(TelaDoJogo telaDoJogo) {
        this.delegate = telaDoJogo;

    }
}
