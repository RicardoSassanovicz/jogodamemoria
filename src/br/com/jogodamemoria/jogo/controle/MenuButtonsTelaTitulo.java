package br.com.jogodamemoria.jogo.controle;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.Window;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.transitions.CCRotoZoomTransition;
import org.cocos2d.types.CGPoint;

import br.com.jogodamemoria.JogadorActivity;
import br.com.jogodamemoria.R;
import br.com.jogodamemoria.configuracoes.Assets;
import br.com.jogodamemoria.jogo.cenas.TelaDoJogo;
import br.com.jogodamemoria.jogo.interfaces.ButtonDelegate;

import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.resolucaoDaTela;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenHeight;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenWidth;

public class MenuButtonsTelaTitulo extends CCLayer  implements ButtonDelegate {

    private Button playButton;
    private Button highScoredButton;
    private Button opcoesButton;

    @Override
    public void buttonClicked(Button sender) {

        //Quando Clicar no Botao Play, ira chamar a tela do jogo!
        if (sender.equals(this.playButton)) {
            //Diteror chama pra mim a tela do jogo e cria ela pra mim!
            CCDirector.sharedDirector().replaceScene(
                    CCRotoZoomTransition.transition(1.0f, TelaDoJogo.createGame())
            );
        }
        if (sender.equals(this.highScoredButton)) {

            Intent it = new Intent(CCDirector.sharedDirector().getActivity(), JogadorActivity.class);
            CCDirector.sharedDirector().getActivity().startActivity(it);
        }
        if (sender.equals(this.opcoesButton)){
            criaDialogOpcoes();
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

    private void criaDialogOpcoes() {

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
