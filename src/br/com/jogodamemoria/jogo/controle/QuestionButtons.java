package br.com.jogodamemoria.jogo.controle;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.types.CGPoint;

import br.com.jogodamemoria.jogo.Objetos.Pecas;
import br.com.jogodamemoria.jogo.interfaces.ButtonDelegate;
import br.com.jogodamemoria.jogo.scenes.TelaDoJogo;

import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.resolucaoDaTela;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenHeight;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenWidth;

/**
 * Created by ricardo on 05/10/13.
 */
public class QuestionButtons extends CCLayer implements ButtonDelegate {



    //private Button p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16;
    private Button i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16;
    private Button botao2;
    //private Button pergunta[] = {p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16};
    private Button imagens[] = {i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16};
    private Pecas pecas;

    private TelaDoJogo delegate;

    public static QuestionButtons questionButtons(){
        return new QuestionButtons();
    }

    public QuestionButtons(){
        this.setIsTouchEnabled(true);
        setimagens();
        setDelegates();
        setPosicoes();
        //pecas.jogar();

        exibeNaTela();
    }

    public void setDelegate(TelaDoJogo delegate) {
        this.delegate = delegate;
    }

    @Override
    public void buttonClicked(Button sender) {

        //this.botao2 = sender;

    }

    public Button getBotao2() {
        return botao2;
    }

    public void setBotao2(Button botao2) {
        this.botao2 = botao2;
    }

    public void setimagens() {


//
//        this.i1 = new Button(Question.PERGUNTA1);
//        this.i2 = new Button(Question.PERGUNTA1);
//        this.i3 = new Button(Question.PERGUNTA1);
//        this.i4 = new Button(Question.PERGUNTA1);
//        this.i5 = new Button(Question.PERGUNTA1);
//        this.i6 = new Button(Question.PERGUNTA1);
//        this.i7 = new Button(Question.PERGUNTA1);
//        this.i8 = new Button(Question.PERGUNTA1);
//        this.i9 = new Button(Question.PERGUNTA1);
//        this.i10 = new Button(Question.PERGUNTA1);
//        this.i11 = new Button(Question.PERGUNTA1);
//        this.i12 = new Button(Question.PERGUNTA1);
//        this.i13 = new Button(Question.PERGUNTA1);
//        this.i14 = new Button(Question.PERGUNTA1);
//        this.i15 = new Button(Question.PERGUNTA1);
//        this.i16 = new Button(Question.PERGUNTA1);

    }
    public void setDelegates(){

        for (int i = 0; i < imagens.length; i++) {
            this.imagens[i].setDelegate(this);
        }
//          teste
//
//
//        this.i1.setDelegate(this);
//        this.i2.setDelegate(this);
//        this.i3.setDelegate(this);
//        this.i4.setDelegate(this);
//        this.i5.setDelegate(this);
//        this.i6.setDelegate(this);
//        this.i7.setDelegate(this);
//        this.i8.setDelegate(this);
//        this.i9.setDelegate(this);
//        this.i10.setDelegate(this);
//        this.i11.setDelegate(this);
//        this.i12.setDelegate(this);
//        this.i13.setDelegate(this);
//        this.i14.setDelegate(this);
//        this.i15.setDelegate(this);
//        this.i16.setDelegate(this);

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
    }

    public void exibeNaTela(){

        for (int i = 0; i < imagens.length; i++) {
            addChild(imagens[i]);
        }
//
//        addChild(i1);
//        addChild(i2);
//        addChild(i3);
//        addChild(i4);
//        addChild(i5);
//        addChild(i6);
//        addChild(i7);
//        addChild(i8);
//        addChild(i9);
//        addChild(i10);
//        addChild(i11);
//        addChild(i12);
//        addChild(i13);
//        addChild(i14);
//        addChild(i15);
//        addChild(i16);
    }
/*

    public Button[] getImagens() {
        return imagens;
    }

    public void setImagens(Button[] imagens) {
        this.imagens = imagens;
    }

    */
}
