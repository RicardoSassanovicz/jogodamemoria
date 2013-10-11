package br.com.jogodamemoria.jogo.controle;

import android.provider.MediaStore;

import org.cocos2d.actions.interval.CCFadeOut;
import org.cocos2d.actions.interval.CCScaleBy;
import org.cocos2d.actions.interval.CCSpawn;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.types.CGPoint;

import br.com.jogodamemoria.configuracoes.Animais;
import br.com.jogodamemoria.configuracoes.Assets;
import br.com.jogodamemoria.configuracoes.Frutas;
import br.com.jogodamemoria.configuracoes.Question;
import br.com.jogodamemoria.jogo.interfaces.ButtonDelegate;
import br.com.jogodamemoria.jogo.scenes.TelaDoJogo;

import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.resolucaoDaTela;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenHeight;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenWidth;

/**
 * Created by ricardo on 05/10/13.
 */
public class QuestionButtons extends CCLayer implements ButtonDelegate{

    private CGPoint botaoPress;
    private Button i1;
    private Button i2;
    private Button i3;
    private Button i4;
    private Button i5;
    private Button i6;
    private Button i7;
    private Button i8;
    private Button i9;
    private Button i10;
    private Button i11;
    private Button i12;
    private Button i13;
    private Button i14;
    private Button i15;
    private Button i16;
    private Button botaoPecasArrayFrutas[];
    private Button imagens[] = {i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16};
    public FrutasButtons frutasButtons = new FrutasButtons();


    private TelaDoJogo delegate;

    public static QuestionButtons questionButtons(){
        return new QuestionButtons();
    }

    public QuestionButtons(){
        this.setIsTouchEnabled(true);
        setimagens();
        setPosicoes();
    }

    public void setDelegate(TelaDoJogo delegate) {
        this.delegate = delegate;
    }

    public void setimagens() {
        for (int i = 0; i < imagens.length; i++) {
            this.imagens[i] = new Button(Question.PERGUNTA1);
            this.imagens[i].setDelegate(this);
        }
    }

    public void setPosicoes(){

        this.imagens[0].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 135, screenHeight() - 400)));
        this.imagens[1].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 285, screenHeight()- 400)));
        this.imagens[2].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 435, screenHeight()- 400)));
        this.imagens[3].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 585, screenHeight()- 400)));
        this.imagens[4].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 135, screenHeight()- 550)));
        this.imagens[5].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 285, screenHeight()- 550)));
        this.imagens[6].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 435, screenHeight()- 550)));
        this.imagens[7].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 585, screenHeight()- 550)));
        this.imagens[8].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 135, screenHeight()- 700)));
        this.imagens[9].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 285, screenHeight()- 700)));
        this.imagens[10].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 435, screenHeight()- 700)));
        this.imagens[11].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 585, screenHeight()- 700)));
        this.imagens[12].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 135, screenHeight()- 850)));
        this.imagens[13].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 285, screenHeight()- 850)));
        this.imagens[14].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 435, screenHeight()- 850)));
        this.imagens[15].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 585, screenHeight()- 850)));

        for (int i = 0; i < imagens.length; i++) {
            addChild(imagens[i]);
        }
    }

    @Override
    public void buttonClicked (Button sender) {

     botaoPecasArrayFrutas = frutasButtons.getImagens();

        for (int i = 0; i <  imagens.length; i++){
            if (sender.equals(imagens[i])){

                this.imagens[i].setVisible(false);

//                this.botaoPress = imagens[i].getPosition();
//                this.imagens[i] = new Button(Frutas.CEREJA);
//                this.setPosition(botaoPress);
//                this.imagens[i].setDelegate(this);
//                addChild(imagens[i]);
            }
        }
    }
}
