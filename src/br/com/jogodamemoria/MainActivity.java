package br.com.jogodamemoria;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;

import br.com.jogodamemoria.jogo.scenes.TelaDeTitulo;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        //#### não vai mais ser chamado a activityMain ####
        //setContentView(R.layout.activity_main);

        //#### definindo orientação como landscape ####
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //#### configura a tela ####
        CCGLSurfaceView glSurfaceView = new CCGLSurfaceView(MainActivity.this);
        setContentView(glSurfaceView);
        CCDirector.sharedDirector().attachInView(glSurfaceView);

        //#### configura CCDirector ####
        CCDirector.sharedDirector().setScreenSize(720, 1280);
        //#### abre tela principal ####
        CCScene cena = new TelaDeTitulo().cena();
        CCDirector.sharedDirector().runWithScene(cena);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
