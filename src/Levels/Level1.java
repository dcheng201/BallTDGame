package Levels;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import Main.levelManager;
import Screen.TowerContainer;
import entity.BasicAttack;
import entity.SimpleButton;
import entity.TowerCreations;
import towers.TowerSelection;
import towers.basictower;

public class Level1 implements Screen{
	private basictower basictower;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	
	//map
	private TiledMap map;
	private TiledMapRenderer maprender;
	//tower
	private Texture current;
	//options
	private Stage stage;

	private int a = 0;
//	
	//towercreations
	private BasicAttack attacks;
	private TowerSelection menu;
	private boolean clicked = false;
	@Override
	public void show() {
		// TODO Auto-generated method stub
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		stage = new Stage();
		
		Gdx.input.setInputProcessor(stage);
		//camera
		camera = new OrthographicCamera(w,h);		
		camera.setToOrtho(false, w,h);
		camera.update();
		
		basictower = new basictower();
		
		//map
		map = new TmxMapLoader().load("levelb.tmx");
		maprender = new OrthogonalTiledMapRenderer(map);

		batch = new SpriteBatch();
		menu = new TowerSelection();

		current = new Texture(Gdx.files.internal("BasicTower.png"));

		stage.addActor(menu.getTable());
		
	}
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		//setting up mouse x and y and clear the graphics
		int x = Gdx.input.getX();
		int y = Gdx.input.getY();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		
		// map render
		maprender.setView(camera);
		maprender.render();
		stage.act(delta);
		stage.draw();
		batch.begin();
		//tower from button to map
		if(menu.getClicked() == true){
			batch.draw(menu.towerspawners().get(a), x, -y+480);
			if(Gdx.input.isTouched() == true){
				TowerCreations a1 = new TowerCreations(menu.getCurrent(), x, y);
				menu.towers(a1);
				menu.Clicked(false);
			}
		}
		//rotation
		for(int i = 0; i< menu.towers().size();i++){
			x = Gdx.input.getX();
			y = Gdx.input.getY();
			menu.towers().get(i).renderer(batch);
//			//System.out.println("x: "+x+ " y: " +y);
			menu.towers().get(i).update(x, y, batch);
		}
		
		System.out.println(delta);
		batch.end();
	}
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
	}

	public void dispose(){
		batch.dispose();
		current.dispose();
		stage.dispose();
		menu.atlas.dispose();
		menu.skin.dispose();

	}
}
