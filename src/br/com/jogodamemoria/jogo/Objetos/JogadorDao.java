package br.com.jogodamemoria.jogo.objetos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.jogodamemoria.banco.BancoDados;

public class JogadorDao {

    SQLiteDatabase db;

    public JogadorDao(Context ctx) {
        db = BancoDados.getDB(ctx);
    }

    public void salvar(Jogador jogador) {
        ContentValues values = new ContentValues();
        values.put("nome", jogador.getNome());
        values.put("pontos", jogador.getPontos());
        db.insert(BancoDados.NOME_TABELA, null, values);
        System.out.println("salvou !");
    }

    public void excluir(String id) {
        String[] selectionArgs = new String[] { id };
        System.out.println("Deletou !"+id);
        db.delete(BancoDados.NOME_TABELA, "_id = ?", selectionArgs);

    }
    public List<Jogador> listar(){
        String[] coluns = new String[] { "_id", "nome","pontos" };
        List<Jogador> jogadores = new ArrayList<Jogador>();

        Cursor c = db.query(BancoDados.NOME_TABELA, coluns,null, null,
                null, null, null);
        c.moveToFirst();

        while (c.moveToNext()) {
            Jogador jogador = new Jogador();
            jogador.setId(c.getLong(c.getColumnIndex("_id")));
            jogador.setNome(c.getString(c.getColumnIndex("nome")));
            jogador.setPontos(c.getString(c.getColumnIndex("pontos")));
            jogadores.add(jogador);
        }
        return jogadores;
    }

}