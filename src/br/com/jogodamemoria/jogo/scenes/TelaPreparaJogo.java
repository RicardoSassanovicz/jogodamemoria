package br.com.jogodamemoria.jogo.scenes;

import android.widget.EditText;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.types.CGPoint;

import br.com.jogodamemoria.configuracoes.Assets;
import br.com.jogodamemoria.jogo.controle.MenuButtonPreparaJogo;
import br.com.jogodamemoria.jogo.screens.ScreenBackground;

import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.resolucaoDaTela;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenHeight;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenWidth;

/**
 * Created by ricardo on 18/10/13.
 */
public class TelaPreparaJogo extends CCLayer{



    private ScreenBackground background;

    public TelaPreparaJogo() {

        this.background = new ScreenBackground(Assets.BACKGROUND);
        this.background.setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() / 2.0f, screenHeight() / 2.0f)));
        this.addChild(this.background);

        MenuButtonPreparaJogo menuLayer = MenuButtonPreparaJogo.preparaJogo();
        menuLayer.setDelegate(this);
        this.addChild(menuLayer);

    }

    public static CCScene createGame() {
        CCScene scene = CCScene.node();
        TelaPreparaJogo layer = new TelaPreparaJogo();
        scene.addChild(layer);
        return scene;
    }

    public CCScene cena () {
        CCScene cena = CCScene.node();
        cena.addChild(this);
        return cena;
    }


}
