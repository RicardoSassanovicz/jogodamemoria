package br.com.jogodamemoria.jogo.controle;

import android.view.MotionEvent;

import br.com.jogodamemoria.jogo.interfaces.ButtonDelegate;

import org.cocos2d.nodes.CCSprite;
import org.cocos2d.events.CCTouchDispatcher;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.types.CGRect;
import org.cocos2d.types.CGPoint;

public class Button extends CCLayer{

    private CCSprite imagemBotao;

    private ButtonDelegate delegate;

    public Button(String imagemBotao) {
        this.setIsTouchEnabled(true);
        this.imagemBotao = CCSprite.sprite(imagemBotao);
        this.addChild(this.imagemBotao);

    }
    //#### define qual botao vai ser chamado! ####
    public void setDelegate(ButtonDelegate sender) {
        this.delegate = sender;
    }

    //#### avisa ao delegate quando o botao foi tocado ####
    @Override
    protected void registerWithTouchDispatcher() {
        CCTouchDispatcher.sharedDispatcher()
                .addTargetedDelegate(this, 0, false);
    }

    @Override
    public boolean ccTouchesBegan(MotionEvent event) {
        //#### pega localizac��o do touch ####
        CGPoint touchLocation = CGPoint.make(event.getX(), event.getY());

        touchLocation = CCDirector.sharedDirector()
                .convertToGL(touchLocation);
        touchLocation = this.convertToNodeSpace(touchLocation);

        // Verifica toque no bot��o
        if (CGRect.containsPoint(
                this.imagemBotao.getBoundingBox(), touchLocation)) {
            delegate.buttonClicked(this);
        }
        return true;
    }
}
