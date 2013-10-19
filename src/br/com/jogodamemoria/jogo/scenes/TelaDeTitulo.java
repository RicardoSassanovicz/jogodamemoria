package br.com.jogodamemoria.jogo.scenes;


import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

import br.com.jogodamemoria.configuracoes.Assets;
import br.com.jogodamemoria.jogo.controle.MenuButtonsTelaTitulo;
import br.com.jogodamemoria.jogo.screens.ScreenBackground;

import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.resolucaoDaTela;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenHeight;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenWidth;


/**
 * Created by ricardo on 21/09/13.
 */

//#### Layer cria a tela ####
public class TelaDeTitulo extends CCLayer {

    //### Adicionando o background na tela de abertura TitleScreen ####

    private ScreenBackground background;

    //#### Instacia uma tela do framework ####
    //#### Prepara os elementos que irao ser usados background, logo, e bot��es.####
    public CCScene cena () {
        //#### Invocando m��todo node() ####
        CCScene cena = CCScene.node();
        cena.addChild(this);
        return cena;
    }

    public TelaDeTitulo (){
        // background
        this.background = new ScreenBackground(Assets.BACKGROUND);
        this.background.setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() / 2.0f, screenHeight() / 2.0f)));
        this.addChild(this.background);

        // logo
        CCSprite title = CCSprite.sprite(Assets.LOGO);
        title.setPosition(resolucaoDaTela(CGPoint.ccp( screenWidth() / 2 , screenHeight() - 230 )));
        this.addChild(title);

        // Botoes =D
        MenuButtonsTelaTitulo menuLayer = new MenuButtonsTelaTitulo();
        this.addChild(menuLayer);


    }


    }





