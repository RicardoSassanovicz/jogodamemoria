package br.com.jogodamemoria.jogo.cenas;

import android.content.Intent;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.transitions.CCRotoZoomTransition;
import org.cocos2d.types.CGPoint;

import br.com.jogodamemoria.ItemsActivity;
import br.com.jogodamemoria.configuracoes.Assets;
import br.com.jogodamemoria.jogo.controle.Button;
import br.com.jogodamemoria.jogo.interfaces.ButtonDelegate;
import br.com.jogodamemoria.jogo.telas.ScreenBackground;

import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.resolucaoDaTela;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenHeight;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenWidth;

/**
 * Created by ricardo on 22/10/13.
 */
public class FinalDoJogo extends CCLayer implements ButtonDelegate {

    private ScreenBackground background;
    private Button finalButton, verButton;

    public CCScene scene(){
        CCScene scene = CCScene.node();
        scene.addChild(this);
        return scene;
    }
    public FinalDoJogo() {

        this.background = new ScreenBackground(Assets.BACKGROUND);
        this.background.setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() / 2.0f, screenHeight() / 2.0f)));
        this.addChild(this.background);

        // imagem
        CCSprite titulo = CCSprite.sprite(Assets.FINAL);
        titulo.setPosition(resolucaoDaTela(CGPoint.ccp( screenWidth() /2 ,screenHeight() - 460 ))) ;
        this.addChild(titulo);

        this.setIsTouchEnabled(true);
        this.finalButton = new Button(Assets.JOGARNOVAMENTE);
        this.finalButton.setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() /2 ,screenHeight() - 850))) ;
        this.finalButton.setDelegate(this);
        this.addChild(this.finalButton);

        this.setIsTouchEnabled(true);
        this.verButton = new Button(Assets.JOGARNOVAMENTE);
        this.verButton.setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() /2 ,screenHeight() - 1000))) ;
        this.verButton.setDelegate(this);
        this.addChild(this.verButton);

    }
    @Override
    public void buttonClicked(Button sender) {
        if (sender.equals(this.finalButton)) {
//            SoundEngine.sharedEngine().pauseSound();
            CCDirector.sharedDirector()
                    .replaceScene(CCRotoZoomTransition.transition(1.0f, new TelaDeTitulo().cena()));
        }
        if(sender.equals(this.verButton)){
            Intent it = new Intent(CCDirector.sharedDirector().getActivity(), ItemsActivity.class);
            CCDirector.sharedDirector().getActivity().startActivity(it);
        }
    }


}
