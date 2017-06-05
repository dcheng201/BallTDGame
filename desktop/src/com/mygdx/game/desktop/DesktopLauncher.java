package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

import APUSH.APUSH;
import Main.BallTD;
import Main.Main;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = BallTD.TITLE +"v"+BallTD.VERSION;
		config.vSyncEnabled = true;
		config.width = 640;
		config.height = 480;
		new LwjglApplication(new BallTD(), config);
/*		config.vSyncEnabled = true;
		config.title = "Timeline";
		config.title = "Title";
		config.height = 600;
		config.width = 600;
		new LwjglApplication(new APUSH(), config);*/
	}
	
}
