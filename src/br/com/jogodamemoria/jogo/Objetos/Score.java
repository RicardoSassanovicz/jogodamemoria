package br.com.jogodamemoria.jogo.Objetos;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.opengl.CCBitmapFontAtlas;

import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenHeight;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenWidth;

/**
 * Created by ricardo on 27/09/13.
 */
public class Score extends CCLayer {

    private int score;

    private CCBitmapFontAtlas text;

    public Score(){
        this.score = 0;
        this.text = CCBitmapFontAtlas.bitmapFontAtlas(
                String.valueOf(this.score),
                "UniSansSemiBold_Numbers_240.fnt");
        this.text.setScale((float) 240 / 240);
        this.setPosition(screenWidth()-50, screenHeight()-50);
        this.addChild(this.text);
    }

    public void increase() {
        score++;
        this.text.setString(String.valueOf(this.score));
    }
}
