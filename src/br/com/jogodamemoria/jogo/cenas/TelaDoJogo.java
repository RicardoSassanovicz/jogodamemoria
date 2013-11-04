package br.com.jogodamemoria.jogo.cenas;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.transitions.CCRotoZoomTransition;
import org.cocos2d.types.CGPoint;

import br.com.jogodamemoria.PreparaJogoActivity;
import br.com.jogodamemoria.configuracoes.Assets;
import br.com.jogodamemoria.jogo.controle.MenuButtonsTelaJogoDificil;
import br.com.jogodamemoria.jogo.controle.MenuButtonsTelaJogoFacil;
import br.com.jogodamemoria.jogo.objetos.Conf;
import br.com.jogodamemoria.jogo.objetos.Score;
import br.com.jogodamemoria.jogo.telas.ScreenBackground;

import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.resolucaoDaTela;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenHeight;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenWidth;

/**
 * Created by ricardo on 24/09/13.
 */

//TELA DO JOGO
public class TelaDoJogo extends CCLayer{

    public ScreenBackground background;
    public CCLayer scoreLayer, jogadorLayer;
    public Score score;
    public static CCDirector DIRETOR;

    PreparaJogoActivity delegate = new PreparaJogoActivity();

    //ADICIONA O BACKGROUND A TELA DO JOGO
    public TelaDoJogo() {


        this.background = new ScreenBackground(Assets.BACKGROUND);
        this.background.setPosition(resolucaoDaTela(
                        CGPoint.ccp(screenWidth() / 2.0f, screenHeight() / 2.0f)));
        this.addChild(this.background);

        verificaDificuldade();

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

    public void iniciarFinaldoJogo() {
       DIRETOR.sharedDirector()
                .replaceScene(CCRotoZoomTransition.transition(1.0f, new FinalDoJogo().scene()));
    }

    public void verificaDificuldade(){

        if(Conf.dificuldade == "dificil"){
            System.out.println("Entrou Dificil");
            MenuButtonsTelaJogoDificil menuButtonsTelaJogoDificilLayer = MenuButtonsTelaJogoDificil.questionButtons();
            menuButtonsTelaJogoDificilLayer.setDelegate(this);
            this.addChild(menuButtonsTelaJogoDificilLayer);

        }else if(Conf.dificuldade == "facil"){
            System.out.println("Entrou Facil");
            MenuButtonsTelaJogoFacil menuButtonsTelaJogoFacilLayer = MenuButtonsTelaJogoFacil.questionButtons();
            menuButtonsTelaJogoFacilLayer.setDelegate(this);
            this.addChild(menuButtonsTelaJogoFacilLayer);
        }
    }

}
