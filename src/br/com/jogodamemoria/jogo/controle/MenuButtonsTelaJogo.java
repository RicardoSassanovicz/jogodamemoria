package br.com.jogodamemoria.jogo.controle;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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
import br.com.jogodamemoria.configuracoes.ToastManager;
import br.com.jogodamemoria.jogo.cenas.TelaDoJogo;
import br.com.jogodamemoria.jogo.objetos.Jogador;
import br.com.jogodamemoria.jogo.objetos.JogadorDao;

import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.resolucaoDaTela;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenHeight;
import static br.com.jogodamemoria.configuracoes.ConfigDispositivo.screenWidth;

public class MenuButtonsTelaJogo extends CCLayer {

    public final ScheduledExecutorService tempo = Executors.newSingleThreadScheduledExecutor();
    public CCSprite i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, imagens[] = {i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16};
    public CGPoint primeiraPosicao, segundaPosicao;
    public int x, ultimoBotaoClicado = -1, quantBotoesClicados = 0;
    public TelaDoJogo delegate;
    public String[] retornoCategoria = Assets.ImagensAnimais;
    public String nomeJogador = "";

    public static MenuButtonsTelaJogo questionButtons() {
        return new MenuButtonsTelaJogo();
    }

    public MenuButtonsTelaJogo() {
        this.setIsTouchEnabled(true);
        criaDialogConfiguracao();

        setimagens();
        setPosicoes();

    }

    public void setDelegate(TelaDoJogo delegate) {
        this.delegate = delegate;
    }

    public void setimagens() {

        for (int i = 0; i < imagens.length; i++) {
            this.imagens[i] = CCSprite.sprite("Question.png");
        }

        //Collections.shuffle(Arrays.asList(retornoCategoria));
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

//    private void embaralhaExibeTodos() {
//    //Embaralha as imagens com o método Suffle
//
//       Collections.shuffle(Arrays.asList(imagens));
//        for (int i = 0; i < imagens.length; i++) {
//            this.imagens[i] = CCSprite.sprite(retornoCategoria[i]);
//        }
//
//    }

    //esconde a figura e seta a pergunta
    private void esconde(int i, CGPoint pos) {

        this.imagens[i].setVisible(false);
        this.imagens[i] = CCSprite.sprite("Question.png");
//        this.imagens[i].setTag(tag);
        this.imagens[i].setPosition(pos);
        addChild(imagens[i]);

    }

    //MOSTRA IMAGENS[]
    private void mostra(int i, CGPoint pos) {

        this.imagens[i].setVisible(false);
        this.imagens[i] = CCSprite.sprite(retornoCategoria[i]);
//        this.imagens[i].setTag(tag);
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
//    private void criaToast(final String is) {
//        CCDirector.sharedDirector().getActivity().runOnUiThread(new Runnable() {
//            public void run() {
//        LayoutInflater inflater = (LayoutInflater)
//                CCDirector.sharedDirector().getActivity().getSystemService
//                        (CCDirector.sharedDirector().getActivity().LAYOUT_INFLATER_SERVICE);
//        View layout = inflater.inflate(R.layout.toast_layout, null);
//        TextView tv = (TextView) layout.findViewById(R.id.tvTexto);
//        tv.setText(is);
//        LinearLayout llRoot = (LinearLayout) layout.findViewById(R.id.llRoot);
//        Drawable img;
//        int bg;
//        img = CCDirector.sharedDirector().getActivity().getResources().getDrawable(R.drawable.toast_background_green);
//        bg  = R.drawable.toast_background_green;
//        tv.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null);
//        llRoot.setBackgroundResource(bg);
//        Toast toast = new Toast(CCDirector.sharedDirector().getActivity());
//        //toast.setGravity(Gravity.CENTER, 0, 0);
//        toast.setDuration(Toast.LENGTH_SHORT);
//        toast.setView(layout);
//        toast.show();
//            }
//        });
//    }

    public void buttonClicked(CCSprite sender) {

        //inicio da verificação
        for (int i = 0; i < imagens.length; i++) {
            //indentifica qual foi o botao clicado do meu vetor
            if (sender.equals(imagens[i])) {

                //primeira jogada
                if (ultimoBotaoClicado == -1) {

                    this.primeiraPosicao = imagens[i].getPosition();
                    mostra(i, primeiraPosicao);
                    ultimoBotaoClicado = i;
                }
                //segunda jogada
                else if (retornoCategoria[i] == retornoCategoria[ultimoBotaoClicado]) {
                    quantBotoesClicados += 2;

                    this.segundaPosicao = imagens[i].getPosition();
                    mostra(i, segundaPosicao);
                    ToastManager.show(CCDirector.sharedDirector().getActivity(),
                            retornoCategoria[i].toString().substring(0, retornoCategoria[i].length()-4),
                            ToastManager.SUCESS);
                    ultimoBotaoClicado = -1;
                    delegate.score.acrecenta();
                    verificaFinalDoJogo();
                }

                else {

                    this.segundaPosicao = imagens[i].getPosition();
                    mostra(i, segundaPosicao);
                    x = i;
                    this.setIsTouchEnabled(false);
                    //executa o meu tempo
                    //executarTempo(2000);
                    Runnable run = new Runnable() {
                        @Override
                        public void run() {
                            esconde(ultimoBotaoClicado, primeiraPosicao);
                            esconde(x, imagens[x].getPosition());
                            ToastManager.show(CCDirector.sharedDirector().getActivity()," Ops :(", ToastManager.ERROR);
                            ultimoBotaoClicado = -1;
                            primeiraPosicao = null;
                            segundaPosicao = null;
                            delegate.score.tira();
                            setIsTouchEnabled(true);
                        }
                    };
                    //tempo de 1 segundos
                    tempo.schedule(run, 1, TimeUnit.SECONDS);
                }
            }
        }
        //antigo = null;
    }

    private void verificaFinalDoJogo() {
        if (quantBotoesClicados >= 15) {
            insereJogador();
            ToastManager.show(CCDirector.sharedDirector().getActivity(), "Congratulations! :)",
                    ToastManager.SUCESS);
            executarTempo(3000);
            delegate.iniciarFinaldoJogo();

        }

    }

    private void insereJogador() {
        if(nomeJogador.equals("")){
            nomeJogador = "Player";
        }
        JogadorDao dao = new JogadorDao(CCDirector.sharedDirector().getActivity());
        Jogador jogador = new Jogador();
        jogador.setNome(nomeJogador);
        jogador.setPontos(delegate.score.getScore());
        dao.salvar(jogador);
    }

    private void criaDialogConfiguracao() {

        CCDirector.sharedDirector().getActivity().runOnUiThread(new Runnable() {
            public void run() {
                final Dialog dialog = new Dialog(CCDirector.sharedDirector().getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_opcoes);
                final EditText edNome = (EditText) dialog.findViewById(R.id.editTextJogador);
                final RadioGroup radioGroupCategoria = (RadioGroup) dialog.findViewById(R.id.radioGroupCategoria);
                final RadioGroup radioGroupDificuldade = (RadioGroup) dialog.findViewById(R.id.rbdificuldade);
                final RadioButton radioAnimais = (RadioButton) dialog.findViewById(R.id.radioButton_Animais);
                final RadioButton radioFrutas = (RadioButton) dialog.findViewById(R.id.radioButton_Frutas);
                final RadioButton radioEasy = (RadioButton) dialog.findViewById(R.id.radioButtonFacil);
                final RadioButton radioHard = (RadioButton) dialog.findViewById(R.id.radioButtonDificil);
                final Button btnOk = (Button) dialog.findViewById(R.id.button_Ok);

                btnOk.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        nomeJogador = edNome.getText().toString();
                        if (radioGroupCategoria.getCheckedRadioButtonId() == radioAnimais.getId()) {
                            retornoCategoria = Assets.ImagensAnimais;
                            dialog.dismiss();
                        }else{
                            retornoCategoria = Assets.ImagensFrutas;
                            dialog.dismiss();
                        }
                        Collections.shuffle(Arrays.asList(retornoCategoria));
                    }
                });
                dialog.show();
            }
        });



    }
    public void executarTempo(int tempo){
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}