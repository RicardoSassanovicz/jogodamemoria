package br.com.jogodamemoria.jogo.scenes;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import br.com.jogodamemoria.R;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.transitions.CCFadeTransition;
import org.cocos2d.types.CGPoint;

import br.com.jogodamemoria.configuracoes.Assets;
import br.com.jogodamemoria.jogo.screens.ScreenBackground;

import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.resolucaoDaTela;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenHeight;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenWidth;

/**
 * Created by ricardo on 18/10/13.
 */
public class TelaPreparaJogo extends CCLayer{

    private ScreenBackground background;
    private EditText edJogador;
    private RadioButton rbDificil, rbFacil, rbFrutas, rbAnimais;
    private RadioGroup rgCategoria;
    String sTJogador;


    public TelaPreparaJogo() {
        this.background = new ScreenBackground(Assets.BACKGROUND);
        this.background.setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() / 2.0f, screenHeight() / 2.0f)));
        this.addChild(this.background);
        criaMensagem();
    }

    public static CCScene createGame() {
        CCScene scene = CCScene.node();
        TelaPreparaJogo layer = new TelaPreparaJogo();
        scene.addChild(layer);
        return scene;
    }

    public CCScene cena () {
        CCScene cena = CCScene.node();
        cena.addChild(this);
        return cena;
    }

    private void criaMensagem() {
        CCDirector.sharedDirector().getActivity().runOnUiThread(new Runnable() {
            public void run() {
                LayoutInflater inflater = CCDirector.sharedDirector().getActivity().getLayoutInflater();
                View inflator = inflater.inflate(R.layout.dialog_signin, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(CCDirector.sharedDirector().getActivity());
                builder.setView(inflater.inflate(R.layout.dialog_signin, null));

                    rgCategoria = (RadioGroup) inflator.findViewById(R.id.RadioTipoCategoria);
                    edJogador = (EditText) inflator.findViewById(R.id.editTextJogador);
                    rbAnimais = (RadioButton) inflator.findViewById(R.id.radioButtonAnimais);
                    rbDificil = (RadioButton) inflator.findViewById(R.id.radioButtonDificil);
                    rbFacil = (RadioButton) inflator.findViewById(R.id.radioButtonFacil);
                    rbFrutas = (RadioButton) inflator.findViewById(R.id.radioButtonFrutas);

                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                CCDirector.sharedDirector().replaceScene(
                                        CCFadeTransition.transition(1.0f, TelaDoJogo.createGame()));

                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dialog.cancel();
                            }
                        });
                builder.create();
                builder.show();
            }
        });
    }

    public RadioButton getRbDificil() {
        return rbDificil;
    }

    public void setRbDificil(RadioButton rbDificil) {
        this.rbDificil = rbDificil;
    }

    public EditText getEdJogador() {
        return edJogador;
    }

    public void setEdJogador(EditText edJogador) {
        this.edJogador = edJogador;
    }

    public RadioButton getRbFacil() {
        return rbFacil;
    }

    public void setRbFacil(RadioButton rbFacil) {
        this.rbFacil = rbFacil;
    }

    public RadioButton getRbAnimais() {
        return rbAnimais;
    }

    public void setRbAnimais(RadioButton rbAnimais) {
        this.rbAnimais = rbAnimais;
    }

    public RadioButton getRbFrutas() {
        return rbFrutas;
    }

    public void setRbFrutas(RadioButton rbFrutas) {
        this.rbFrutas = rbFrutas;
    }

    public RadioGroup getRgCategoria() {
        return rgCategoria;
    }

    public void setRgCategoria(RadioGroup rgCategoria) {
        this.rgCategoria = rgCategoria;
    }
}
