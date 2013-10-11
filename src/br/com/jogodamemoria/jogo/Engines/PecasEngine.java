package br.com.jogodamemoria.jogo.Engines;

import org.cocos2d.layers.CCLayer;
import br.com.jogodamemoria.configuracoes.Question;
import br.com.jogodamemoria.jogo.Objetos.Pecas;
import br.com.jogodamemoria.jogo.interfaces.PecasEngineDelegate;

public class PecasEngine extends CCLayer{

    public PecasEngineDelegate delegate;

    public PecasEngine() {
        
        this.getDelegate().criaPeca(new Pecas(Question.PERGUNTA1));
    }

    public void setDelegate(PecasEngineDelegate delegate) {
        this.delegate = delegate;
    }

    public PecasEngineDelegate getDelegate() {
        return delegate;
    }
}
