package br.com.jogodamemoria.jogo.controle;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.types.CGPoint;

import br.com.jogodamemoria.configuracoes.Frutas;
import br.com.jogodamemoria.jogo.interfaces.ButtonDelegate;
import br.com.jogodamemoria.jogo.scenes.TelaDoJogo;

import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.resolucaoDaTela;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenHeight;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenWidth;

/**
 * Created by ricardo on 04/10/13.
 */
public class FrutasButtons extends CCLayer implements ButtonDelegate{

    private Button morangoButton, bananaButton, laranjaButton, limaoButton, macaButton, peraButton, cerejaButton, kiwiButton, tomateButton, mangaButton;
    private Button imagens[] = {morangoButton, bananaButton, laranjaButton, limaoButton, macaButton, peraButton, cerejaButton, kiwiButton, tomateButton, mangaButton};

    private TelaDoJogo delegate;
    private Button captButton;

    public static FrutasButtons frutasButtons(){
        return new FrutasButtons();
    }

    public FrutasButtons(){
        //seta o botao como clicavel
        this.setIsTouchEnabled(true);
        setImagens();
        setDelegate();
        setPosicao();
        //exibeNaTela();
    }

    public void setImagens(){
        this.imagens[0] = new Button(Frutas.MORANGO);
        this.imagens[1] = new Button(Frutas.BANANA);
        this.imagens[2] = new Button(Frutas.LARANJA);
        this.imagens[3] = new Button(Frutas.LIMAO);
        this.imagens[4] = new Button(Frutas.CEREJA);
        this.imagens[5] = new Button(Frutas.MACA);
        this.imagens[6] = new Button(Frutas.PERA);
        this.imagens[7] = new Button(Frutas.KIWI);
        this.imagens[8] = new Button(Frutas.TOMATE);
        this.imagens[9] = new Button(Frutas.MANGA);
    }

    public void setDelegate(){

        for (int i = 0; i < imagens.length; i++) {
            this.imagens[i].setDelegate(this);
        }
    }

    public void setPosicao(){


        this.imagens[0].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 135, screenHeight() - 400)));
        this.imagens[1].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 285, screenHeight()- 400)));
        this.imagens[2].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 435, screenHeight() - 400)));
        this.imagens[3].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 585, screenHeight()- 400)));
        this.imagens[4].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 135, screenHeight() - 550)));
        this.imagens[5].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 285, screenHeight()- 550)));
        this.imagens[6].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 435, screenHeight()- 550)));
        this.imagens[7].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 585, screenHeight()- 550)));
//       this.imagens[8].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 135, screenHeight()- 700)));
//       this.imagens[9].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 285, screenHeight() - 700)));


    }
    public void exibeNaTela(){

        for (int i = 0; i < imagens.length; i++) {
            addChild(imagens[i]);
        }

    }

    public void setDelegate(TelaDoJogo delegate) {
        this.delegate = delegate;
    }

    @Override
    public void buttonClicked(Button sender) {
        this.captButton = sender;
    }

    public Button[] getImagens() {
        return imagens;
    }

    public void setImagens(Button[] imagens) {
        this.imagens = imagens;
    }
}
