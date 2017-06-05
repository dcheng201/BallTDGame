package Main;

import com.badlogic.gdx.Game;

import Screen.Splash;

public class Menu extends Game {


	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		setScreen(new Splash());
	}



}
