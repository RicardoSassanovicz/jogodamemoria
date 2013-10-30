package br.com.jogodamemoria;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import org.cocos2d.nodes.CCDirector;

import java.util.List;

import br.com.jogodamemoria.jogo.controle.JogadorAdapter;
import br.com.jogodamemoria.jogo.objetos.Jogador;
import br.com.jogodamemoria.jogo.objetos.JogadorDao;

public class JogadorActivity extends ListActivity {
	
	JogadorDao dao;
	JogadorAdapter adapter;
	List<Jogador> jogadores;


    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dao = new JogadorDao(CCDirector.sharedDirector().getActivity());
        jogadores = dao.listar();
		adapter = new JogadorAdapter(CCDirector.sharedDirector().getActivity(), R.layout.activity_jogador_item, jogadores);
		setListAdapter(adapter);
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);



		atualizaLista();
	}
	private void atualizaLista() {
		List<Jogador> p = dao.listar();
		jogadores.clear();
		jogadores.addAll(p);
		adapter.notifyDataSetChanged();
	}

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        final Jogador j = jogadores.get(position);



        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("Deseja excluir "+j.getNome().toString()+" ?");
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                JogadorDao dao = new JogadorDao(JogadorActivity.this);
                dao.excluir(j.getId().toString());
                atualizaLista();
            }
        });

        dialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();
    }

}
