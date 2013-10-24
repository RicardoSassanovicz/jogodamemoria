package br.com.jogodamemoria.jogo.controle;


import android.app.Dialog;
import android.view.View;
import android.view.Window;

import br.com.jogodamemoria.R;
import br.com.jogodamemoria.configuracoes.Assets;
import br.com.jogodamemoria.jogo.interfaces.ButtonDelegate;
import br.com.jogodamemoria.jogo.scenes.TelaDoJogo;
import br.com.jogodamemoria.jogo.scenes.TelaPreparaJogo;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.transitions.CCFadeTransition;
import org.cocos2d.types.CGPoint;
import org.cocos2d.nodes.CCDirector;

import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.resolucaoDaTela;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenHeight;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenWidth;

/**
 * Created by ricardo on 23/09/13.
 */


public class MenuButtonsTelaTitulo extends CCLayer implements ButtonDelegate {

    private Button playButton;
    private Button highScoredButton;
    private Button opcoesButton;


    @Override
    public void buttonClicked(Button sender) {

        //Quando Clicar no Botao Play, ira chamar a tela do jogo!
        if (sender.equals(this.playButton)) {
            //Diteror chama pra mim a tela do jogo e cria ela pra mim!
            CCDirector.sharedDirector().replaceScene(
                    CCFadeTransition.transition(1.0f, TelaDoJogo.createGame())
            );
        }
        if (sender.equals(this.highScoredButton)) {
            System.out.println("Clicou em: Highscore");
        }
        if (sender.equals(this.opcoesButton)){
            CCDirector.sharedDirector().getActivity().runOnUiThread(new Runnable() {
                public void run() {

                    final Dialog dialog = new Dialog(CCDirector.sharedDirector().getActivity());
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.dialog_help);

                    final android.widget.Button btnOk = (android.widget.Button) dialog.findViewById(R.id.buttonHelpOk);


                    btnOk.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                }
            });
        }


    }

    public MenuButtonsTelaTitulo() {
        this.setIsTouchEnabled(true);

        //seta os botoes para os devidas imagens
        this.playButton = new Button(Assets.PLAY);
        this.highScoredButton = new Button(Assets.HIGHSCORE);
        this.opcoesButton = new Button(Assets.OPCOES);

        //seta os botoes ao delegate
        this.playButton.setDelegate(this);
        this.highScoredButton.setDelegate(this);
        this.opcoesButton.setDelegate(this);

        // coloca os bot��es na posi����o correta
        setButtonspPosition();

        addChild(this.playButton);
        addChild(this.highScoredButton);
        addChild(this.opcoesButton);

    }



    // Posi����o dos Bot��es
    public void setButtonspPosition(){


        playButton.setPosition(resolucaoDaTela
                (CGPoint.ccp(screenWidth() - 200, screenHeight() - 700))
        );
        highScoredButton.setPosition(resolucaoDaTela
                (CGPoint.ccp(screenWidth() - 200, screenHeight() - 850))
        );
        opcoesButton.setPosition(resolucaoDaTela
                (CGPoint.ccp(screenWidth() - 200, screenHeight() - 1000))
        );

    }


}
