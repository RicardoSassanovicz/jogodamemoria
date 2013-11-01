package br.com.jogodamemoria.configuracoes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.cocos2d.nodes.CCDirector;

import br.com.jogodamemoria.R;


public class ToastManager {

    public static final int SUCESS  = 0;
    public static final int ERROR  = 1;

    public static void show(final Context context, final String text, final int toastType) {
        CCDirector.sharedDirector().getActivity().runOnUiThread(new Runnable() {
            public void run() {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.toast_layout, null);
        TextView tv = (TextView) layout.findViewById(R.id.tvTexto);
        tv.setText(text);
        LinearLayout llRoot = (LinearLayout) layout.findViewById(R.id.llRoot);
        int bg = 0;
        switch (toastType) {
            case SUCESS:
                bg  = R.drawable.toast_background_green;
                break;
            case ERROR:
                bg  = R.drawable.toast_background_red;
                break;
        }
        llRoot.setBackgroundResource(bg);
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
        }
    });
    }
}
