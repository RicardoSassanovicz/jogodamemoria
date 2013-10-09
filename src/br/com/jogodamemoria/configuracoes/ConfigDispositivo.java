package br.com.jogodamemoria.configuracoes;

import org.cocos2d.types.CGSize;
import org.cocos2d.types.CGPoint;
import org.cocos2d.nodes.CCDirector;

/**
 * Created by ricardo on 21/09/13.
 */

public class ConfigDispositivo {

    public static CGPoint resolucaoDaTela(CGPoint gcPoint) {
        return gcPoint;
    }
    public static float screenWidth() {
        return winSize().width;
    }
    public static float screenHeight() {
        return winSize().height;
    }
    public static CGSize winSize() {
        return CCDirector.sharedDirector().winSize();
    }

}
