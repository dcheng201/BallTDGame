package Screen;

import com.badlogic.gdx.maps.tiled.TiledMap;

public class Level {
	private TiledMap tiled;
	private int level;
	public Level(){
		level = 0;
		tiled = new TiledMap();
	}
}
