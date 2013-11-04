package br.com.jogodamemoria;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.cocos2d.nodes.CCDirector;

import java.util.ArrayList;
import java.util.List;

import br.com.jogodamemoria.configuracoes.Assets;
import br.com.jogodamemoria.jogo.objetos.Item;

/**
 * Created by ricardo on 03/11/13.
 */
public class ItemsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_list);
        populateItemList();
        populateListView();
    }

    private List<Item> items = new ArrayList<Item>();

    private void populateItemList() {
        items.add(new Item(Assets.ABACAXI.toString(),R.drawable.pineapple,"Abacaxi"));
        items.add(new Item(Assets.BANANA.toString(),R.drawable.banana,"Banana"));
        items.add(new Item(Assets.CEREJA.toString(),R.drawable.cherry,"Cereja"));
        items.add(new Item(Assets.COCO.toString(),R.drawable.coconut,"Coco"));
        items.add(new Item(Assets.KIWI.toString(),R.drawable.kiwi,"Kiwi"));
        items.add(new Item(Assets.LARANJA.toString(),R.drawable.orange,"Laranja"));
        items.add(new Item(Assets.LIMAO.toString(),R.drawable.lemon,"Limão"));
        items.add(new Item(Assets.MACA.toString(),R.drawable.apple,"Maça"));
        items.add(new Item(Assets.MANGA.toString(),R.drawable.mango,"Manga"));
        items.add(new Item(Assets.TOMATE.toString(),R.drawable.tomato,"Tomate"));
        items.add(new Item(Assets.MORANGO.toString(),R.drawable.strawberry,"Morango"));
    }

    private void populateListView() {
        ArrayAdapter<Item> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.final_lista);

        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Item> {
        public MyListAdapter() {
            super(CCDirector.sharedDirector().getActivity(), R.layout.activity_final_item, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Make sure we have a view to work with (may have been given null)
            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.activity_final_item, parent, false);
            }

            // Find the car to work with.
            Item currentCar = items.get(position);

            // Fill the view
            ImageView imageView = (ImageView)itemView.findViewById(R.id.icon_Categoria);
            imageView.setImageResource(currentCar.getImagem());

            // Make:
            TextView makeText = (TextView) itemView.findViewById(R.id.DescricaoDoItemUS);
            makeText.setText(currentCar.getDescricao().substring(0, currentCar.getDescricao().length() -4));

            TextView makeText2 = (TextView) itemView.findViewById(R.id.DescricaoDoItemBR);
            makeText2.setText(currentCar.getTraducao());


            return itemView;
        }
    }
}
