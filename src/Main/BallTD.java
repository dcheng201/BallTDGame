package Main;

import com.badlogic.gdx.Game;

import Screen.Splash;

public class BallTD extends Game{
	public static final String TITLE = "BallTD",VERSION = "ALPHA 0.1";
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		setScreen(new Splash());
	}
}
