package br.com.jogodamemoria.jogo.scenes;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.types.CGPoint;
import org.cocos2d.layers.CCScene;

import br.com.jogodamemoria.configuracoes.Assets;
import br.com.jogodamemoria.jogo.Objetos.Score;
import br.com.jogodamemoria.jogo.controle.GameButtons;
import br.com.jogodamemoria.jogo.controle.MenuButtonsTelaJogo;
import br.com.jogodamemoria.jogo.screens.ScreenBackground;

import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.resolucaoDaTela;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenHeight;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenWidth;

/**
 * Created by ricardo on 24/09/13.
 */

//TELA DO JOGO
public class TelaDoJogo extends CCLayer{

    private ScreenBackground background;
    private CCLayer scoreLayer;
    private Score score;

    //ADICIONA O BACKGROUND A TELA DO JOGO
    private TelaDoJogo() {

        this.background = new ScreenBackground(Assets.BACKGROUND);
        this.background.setPosition(resolucaoDaTela(
                        CGPoint.ccp(screenWidth() / 2.0f, screenHeight() / 2.0f)));
        this.addChild(this.background);

        GameButtons gameButtonsLayer = GameButtons.gameButtons();
        gameButtonsLayer.setDelegate(this);
        this.addChild(gameButtonsLayer);

        MenuButtonsTelaJogo menuButtonsTelaJogoLayer = MenuButtonsTelaJogo.questionButtons();
        menuButtonsTelaJogoLayer.setDelegate(this);
        this.addChild(menuButtonsTelaJogoLayer);

        //novo camada para a pontuação
        this.scoreLayer = CCLayer.node();
        this.addChild(this.scoreLayer);

        //invoca nossos objetos
        this.addGameObjects();
    }
    //CRIA A TELA DO JOGO
        public static CCScene createGame() {
        CCScene scene = CCScene.node();
        TelaDoJogo layer = new TelaDoJogo();
        scene.addChild(layer);
        return scene;
    }

    private void addGameObjects() {
        this.score = new Score();
        this.scoreLayer.addChild(this.score);
    }

}
