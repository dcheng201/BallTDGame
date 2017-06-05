package Main;

import com.badlogic.gdx.Screen;

import Levels.Level1;
import Levels.Level2;
import Levels.Level3;
import Levels.Level4;

public class levelManager {
	private int t;
	private Screen current;
	public levelManager(int i){
		t = i;
	}

	public int stringNumber(){
		return t;
	}
}
