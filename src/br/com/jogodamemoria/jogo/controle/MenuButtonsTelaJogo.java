package br.com.jogodamemoria.jogo.controle;

import android.app.AlertDialog;
import android.app.Dialog;
import android.view.MotionEvent;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.widget.*;
import android.widget.Button;

import org.cocos2d.events.CCTouchDispatcher;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGRect;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import br.com.jogodamemoria.R;
import br.com.jogodamemoria.configuracoes.Assets;
import br.com.jogodamemoria.configuracoes.Esconde;
import br.com.jogodamemoria.jogo.Objetos.Jogador;
import br.com.jogodamemoria.jogo.Objetos.Score;
import br.com.jogodamemoria.jogo.scenes.TelaDoJogo;

import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.resolucaoDaTela;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenHeight;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenWidth;

public class MenuButtonsTelaJogo extends CCLayer {

    private static final ScheduledExecutorService tempo = Executors.newSingleThreadScheduledExecutor();
    private CCSprite antigo, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, imagens[] = {i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16};

    private CGPoint primeiraPosicao, segundaPosicao;
    private int selectedId , opCategoria, count = 0, tag1, tag2, x, y, ultimoBotaoClicado = -1, quantBotoesClicados = 0, quant_erros = 0;
    private TelaDoJogo delegate;
    private String[] retornoCategoria;
    private Score score;
    private Jogador jogador;


    public static MenuButtonsTelaJogo questionButtons() {
        return new MenuButtonsTelaJogo();
    }

    public MenuButtonsTelaJogo() {
        this.setIsTouchEnabled(true);
        criaDialog();
    }

    public void setDelegate(TelaDoJogo delegate) {
        this.delegate = delegate;
    }

    public void setimagens() {
        for (int i = 0; i < imagens.length; i++) {
            this.imagens[i] = CCSprite.sprite(Esconde.ESCONDE);
        }
        Collections.shuffle(Arrays.asList(retornoCategoria));
    }

    public void setPosicoes() {

        this.imagens[0].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 135, screenHeight() - 400)));
        this.imagens[1].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 285, screenHeight() - 400)));
        this.imagens[2].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 435, screenHeight() - 400)));
        this.imagens[3].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 585, screenHeight() - 400)));
        this.imagens[4].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 135, screenHeight() - 550)));
        this.imagens[5].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 285, screenHeight() - 550)));
        this.imagens[6].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 435, screenHeight() - 550)));
        this.imagens[7].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 585, screenHeight() - 550)));
        this.imagens[8].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 135, screenHeight() - 700)));
        this.imagens[9].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 285, screenHeight() - 700)));
        this.imagens[10].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 435, screenHeight() - 700)));
        this.imagens[11].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 585, screenHeight() - 700)));
        this.imagens[12].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 135, screenHeight() - 850)));
        this.imagens[13].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 285, screenHeight() - 850)));
        this.imagens[14].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 435, screenHeight() - 850)));
        this.imagens[15].setPosition(resolucaoDaTela(CGPoint.ccp(screenWidth() - 585, screenHeight() - 850)));

        for (int i = 0; i < imagens.length; i++) {
            addChild(imagens[i]);
        }
    }

    //avisa ao delegate quando o botao foi tocado
    @Override
    protected void registerWithTouchDispatcher() {
        CCTouchDispatcher.sharedDispatcher()
                .addTargetedDelegate(this, 0, false);
    }

    @Override
    public boolean ccTouchesBegan(MotionEvent event) {
        //#### pega localizac��o do touch ####
        CGPoint touchLocation = CGPoint.make(event.getX(), event.getY());

        touchLocation = CCDirector.sharedDirector()
                .convertToGL(touchLocation);
        touchLocation = this.convertToNodeSpace(touchLocation);

        // Verifica toque no bot��o

        for (int i = 0; i < imagens.length; i++) {
            if (CGRect.containsPoint(
                    this.imagens[i].getBoundingBox(), touchLocation)) {
                this.buttonClicked(imagens[i]);
            }
        }
        return true;
    }

    private void embaralhaExibeTodos() { //Embaralha as imagens com o método Suffle

        Collections.shuffle(Arrays.asList(imagens));
        for (int i = 0; i < imagens.length; i++) {
            this.imagens[i] = CCSprite.sprite(retornoCategoria[i]);
        }

    }

    //esconde a figura e seta a pergunta
    private void esconde(int i, CGPoint pos, int tag) {
        this.imagens[i].setVisible(false);
        this.imagens[i] = CCSprite.sprite(Esconde.ESCONDE);
        this.imagens[i].setTag(tag);
        this.imagens[i].setPosition(pos);
        addChild(imagens[i]);

    }

    //MOSTRA IMAGENS[]
    private void mostra(int i, CGPoint pos, int tag) {
        this.imagens[i].setVisible(false);
        this.imagens[i] = CCSprite.sprite(retornoCategoria[i]);
        this.imagens[i].setTag(tag);
        this.imagens[i].setPosition(pos);
        addChild(imagens[i]);
    }

    //EXIBE MENSAGEM
    private void criaMensagem(final String titulo, final String texto) {
        CCDirector.sharedDirector().getActivity().runOnUiThread(new Runnable() {
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(CCDirector.sharedDirector().getActivity());
                builder.setTitle(titulo);
                builder.setMessage(texto);
                builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    //EXIBE UMA MENSAGEM TIPO TOAST
    private void criaToast(final String is) {
        CCDirector.sharedDirector().getActivity().runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(CCDirector.sharedDirector().getActivity(), is, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void buttonClicked(CCSprite sender) {

        //inicio da verificação
        for (int i = 0; i < imagens.length; i++) {

      


            //indentifica qual foi o botao clicado do meu vetor
            if (sender.equals(imagens[i])) {
                //primeira jogada
                if (ultimoBotaoClicado == -1) {
                    this.tag1 = imagens[i].getTag();
                    this.primeiraPosicao = imagens[i].getPosition();
                    mostra(i, primeiraPosicao, tag1);
                    ultimoBotaoClicado = i;
                }
                //segunda jogada
                else if (retornoCategoria[i] == retornoCategoria[ultimoBotaoClicado]) {
                    quantBotoesClicados += 2;
                    this.tag2 = imagens[i].getTag();
                    this.segundaPosicao = imagens[i].getPosition();
                    mostra(i, segundaPosicao, tag2);
                    criaToast(" Parabéns!");
                    ultimoBotaoClicado = -1;
                    delegate.score.acrecenta();


                    if (quantBotoesClicados == 16) {
                        this.delegate.iniciarFinaldoJogo();
                        break;
                    }
                }
                //se não for igual, volta tudo..
                else {
                    this.tag2 = imagens[i].getTag();
                    this.segundaPosicao = imagens[i].getPosition();
                    mostra(i, segundaPosicao, tag2);
                    x = i;
                    //executa o meu tempo
                    Runnable run = new Runnable() {
                        public void run() {
                            esconde(ultimoBotaoClicado, primeiraPosicao, tag1);
                            esconde(x, imagens[x].getPosition(), imagens[x].getTag());
                            //criaMensagem("Atenção", "Errou!");
                            criaToast(" Ops :(");
                            ultimoBotaoClicado = -1;
                            primeiraPosicao = null;
                            segundaPosicao = null;
                            delegate.score.tira();
                        }
                    };
                    //tempo de 1 segundos
                    tempo.schedule(run, 1, TimeUnit.SECONDS);
                }
            }
        }
        //antigo = null;
    }

    private void criaDialog() {

        CCDirector.sharedDirector().getActivity().runOnUiThread(new Runnable() {
            public void run() {

            final Dialog dialog = new Dialog(CCDirector.sharedDirector().getActivity());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog_opcoes);
            final EditText edNome = (EditText) dialog.findViewById(R.id.editTextJogador);
            final RadioGroup radioGroupCategoria = (RadioGroup) dialog.findViewById(R.id.radioGroupCategoria);
            final RadioButton radioAnimais = (RadioButton) dialog.findViewById(R.id.radioButton_Animais);
            final RadioButton radioFrutas = (RadioButton) dialog.findViewById(R.id.radioButton_Frutas);
            final Button btnOk = (Button) dialog.findViewById(R.id.button_Ok);
            radioFrutas.setChecked(true);


                btnOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //delegate.jogador.nomeJogador(edNome.getText().toString());

                    if (radioGroupCategoria.getCheckedRadioButtonId()==radioAnimais.getId()){
                        retornoCategoria = Assets.ImagensAnimais;

                    }else if (radioGroupCategoria.getCheckedRadioButtonId()==radioFrutas.getId()){
                        retornoCategoria = Assets.ImagensFrutas;
                    }
                    setimagens();
                    setPosicoes();

                    dialog.dismiss();
                }
            });
            dialog.show();
            }
        });
    }

}