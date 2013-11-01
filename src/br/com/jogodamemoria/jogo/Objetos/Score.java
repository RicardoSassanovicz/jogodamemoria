package br.com.jogodamemoria.jogo.objetos;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.opengl.CCBitmapFontAtlas;
import org.cocos2d.types.ccColor3B;

import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenHeight;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenWidth;

/**
 * Created by ricardo on 27/09/13.
 */
public class Score extends CCLayer {

    public int score;

    String pontos;

    private CCBitmapFontAtlas text;

    public Score(){
        this.score = 0;

        this.text = CCBitmapFontAtlas.bitmapFontAtlas(
                String.valueOf(this.score),
                "UniSansSemiBold_Numbers_240.fnt");
        this.text.setScale(1.5f);
        this.setPosition(screenWidth()-80, screenHeight()-80);
        this.addChild(this.text);
    }

    public void acrecenta() {
        score+=10;

        this.text.setString(String.valueOf(this.score));

        if (score < 0){
            text.setColor(ccColor3B.ccRED);
        }else{
            text.setColor(ccColor3B.ccWHITE);
        }

    }
    public void tira() {
        score-=3;
        this.text.setString(String.valueOf(this.score));

        if (score < 0){
            text.setColor(ccColor3B.ccRED);
        }else{
            text.setColor(ccColor3B.ccWHITE);
        }

    }

    public String getScore() {
        return pontos = String.valueOf(this.score);
    }
}
