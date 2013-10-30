package br.com.jogodamemoria.jogo.controle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.jogodamemoria.R;
import br.com.jogodamemoria.jogo.objetos.Jogador;

public class JogadorAdapter extends ArrayAdapter<Jogador>{
	
	Context context;
	int layout;
	List<Jogador> jogadores;
	Jogador jogador;

	public JogadorAdapter(Context context, int txtViewResourceId, List<Jogador> objects) {
		super(context, txtViewResourceId, objects);
		this.context = context;
		this.layout = txtViewResourceId;
		this.jogadores = objects;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflate = (LayoutInflater)
				context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View iteView = inflate.inflate(layout, null);

        TextView tvNome = (TextView) iteView.findViewById(R.id.jogador_nome);
		TextView tvPontos = (TextView) iteView.findViewById(R.id.jogador_pontos);
		
		jogador = jogadores.get(position);

        tvNome.setText(jogador.getNome());
		tvPontos.setText(jogador.getPontos());
		return iteView;
	}

}
