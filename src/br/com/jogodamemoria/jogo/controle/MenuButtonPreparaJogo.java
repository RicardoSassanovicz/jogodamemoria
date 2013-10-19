package br.com.jogodamemoria.jogo.controle;

import android.app.ActionBar;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import org.cocos2d.Cocos2D;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCLabel;
import org.cocos2d.nodes.CCLabelAtlas;
import org.cocos2d.nodes.CCNode;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.transitions.CCFadeTransition;
import org.cocos2d.types.CGPoint;
import org.cocos2d.utils.javolution.TextBuilder;
import org.w3c.dom.Text;

import br.com.jogodamemoria.configuracoes.Assets;
import br.com.jogodamemoria.jogo.interfaces.ButtonDelegate;
import br.com.jogodamemoria.jogo.scenes.TelaDoJogo;
import br.com.jogodamemoria.jogo.scenes.TelaPreparaJogo;

import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.resolucaoDaTela;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenHeight;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenWidth;

/**
 * Created by ricardo on 18/10/13.
 */
public class MenuButtonPreparaJogo extends CCLayer implements ButtonDelegate{


    private Button comecarButton;
    private RelativeLayout.LayoutParams layoutParams;
    private EditText txv;
    TelaPreparaJogo delegate;
    private CCLabel label;


    public void setDelegate(TelaPreparaJogo delegate) {
        this.delegate = delegate;
    }

    @Override
    public void buttonClicked(Button sender) {

        if (sender.equals(this.comecarButton)) {
            CCDirector.sharedDirector().replaceScene(
                    CCFadeTransition.transition(1.0f, TelaDoJogo.createGame())
            );
        }

    }

    public static MenuButtonPreparaJogo preparaJogo() {
        return new MenuButtonPreparaJogo();
    }

    public MenuButtonPreparaJogo() {

        this.setIsTouchEnabled(true);

        criaEdText();


        //seta os botoes para os devidas imagens
        this.comecarButton = new Button(Assets.COMECAR);

        //seta os botoes ao delegate
        this.comecarButton.setDelegate(this);

        // coloca os bot��es na posi����o correta
        setButtonspPosition();
        addChild(this.comecarButton);
    }

    public void setButtonspPosition(){
        comecarButton.setPosition(resolucaoDaTela
                (CGPoint.ccp(screenWidth() - 360, screenHeight() - 1200))
        );
    }

    public void criaEdText(){


        layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        txv = new EditText(CCDirector.sharedDirector().getActivity());
        CCDirector.sharedDirector().getActivity().addContentView(txv, layoutParams);
        txv.setText("ABC");
    }

}
