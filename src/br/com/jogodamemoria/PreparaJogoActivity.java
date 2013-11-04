package br.com.jogodamemoria;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.cocos2d.nodes.CCDirector;
import org.cocos2d.transitions.CCRotoZoomTransition;

import br.com.jogodamemoria.configuracoes.Assets;
import br.com.jogodamemoria.jogo.cenas.TelaDoJogo;
import br.com.jogodamemoria.jogo.objetos.Conf;

/**
 * Created by ricardo on 03/11/13.
 */
public class PreparaJogoActivity extends Activity {

    EditText edNome;
    RadioGroup radioGroupCategoria, radioGroupDificuldade;
    RadioButton radioAnimais,radioFrutas,radioEasy,radioHard;
    Button btnOk;
    public Conf conf;
    TelaDoJogo delegate;


    public static PreparaJogoActivity preparaJogoActivity() {
        return new PreparaJogoActivity();
    }

    public PreparaJogoActivity() {
        this.conf = conf;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_opcoes);

        edNome = (EditText) findViewById(R.id.editTextJogador);
        radioGroupCategoria = (RadioGroup) findViewById(R.id.radioGroupCategoria);
        radioGroupDificuldade = (RadioGroup) findViewById(R.id.rbdificuldade);
        radioAnimais = (RadioButton) findViewById(R.id.radioButton_Animais);
        radioFrutas = (RadioButton) findViewById(R.id.radioButton_Frutas);
        radioEasy = (RadioButton) findViewById(R.id.radioButtonFacil);
        radioHard = (RadioButton) findViewById(R.id.radioButtonDificil);
        btnOk = (Button) findViewById(R.id.button_Ok);
        criaConfiguracao();
    }

    private void criaConfiguracao() {

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (radioGroupCategoria.getCheckedRadioButtonId() == radioAnimais.getId()
                        && radioGroupDificuldade.getCheckedRadioButtonId() == radioEasy.getId()) {

//                  primeira conferencia FACIL E ANIMAIS
                    conf = new Conf(edNome.getText().toString(),"facil",Assets.ImagensAnimaisEasy);
                    chamatelajogo();

                }else if (radioGroupCategoria.getCheckedRadioButtonId() == radioAnimais.getId()
                        && radioGroupDificuldade.getCheckedRadioButtonId() == radioHard.getId()) {

//                  segunda conferencia DIFICIL E ANIMAIS
                    conf = new Conf(edNome.getText().toString(),"dificil",Assets.ImagensAnimaisHard);
                    chamatelajogo();
                } else if (radioGroupCategoria.getCheckedRadioButtonId() == radioFrutas.getId()
                        && radioGroupDificuldade.getCheckedRadioButtonId() == radioEasy.getId()) {
                    //terceira conferencia FACIL E FRUTAS
                    conf = new Conf(edNome.getText().toString(),"facil",Assets.ImagensFrutasEasy);
                    chamatelajogo();

                } else if (radioGroupCategoria.getCheckedRadioButtonId() == radioFrutas.getId()
                        && radioGroupDificuldade.getCheckedRadioButtonId() == radioHard.getId()) {
                    //terceira conferencia DIFICIL E FRUTAS
                    conf = new Conf(edNome.getText().toString(),"dificil",Assets.ImagensFrutasHard);
                    chamatelajogo();
                }
                //Collections.shuffle(Arrays.asList(RETORN));
            }

        });
    }
    public void chamatelajogo(){
        CCDirector.sharedDirector().replaceScene(
                CCRotoZoomTransition.transition(1.0f, TelaDoJogo.createGame())
        );
        finish();
    }

}
