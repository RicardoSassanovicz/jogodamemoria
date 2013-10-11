package br.com.jogodamemoria.jogo.Objetos;

import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

import java.util.Random;

import br.com.jogodamemoria.jogo.interfaces.PecasEngineDelegate;

import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.resolucaoDaTela;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenHeight;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenWidth;

/**
 * Created by ricardo on 10/10/13.
 */
public class Pecas extends CCSprite {

    private PecasEngineDelegate delegate;
//    private float x , y;

    public Pecas(String imagem){
        super(imagem);
//        //Pecas nasce em uma posição randômica..
//        x = new Random().nextInt(Math.round(screenWidth()));
//        //Mas nasce no topo da tela..
//        y = screenHeight();
    }

    public void start() {
        this.setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 135, screenHeight() - 400)));
    }

    public PecasEngineDelegate getDelegate() {
        return delegate;
    }

    public void setDelegate(PecasEngineDelegate delegate) {
        this.delegate = delegate;
    }


}
