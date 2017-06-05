package Main;


import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardEndHandler;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;


import Screen.TowerContainer;
import towers.basictower;

public class Main extends ApplicationAdapter implements InputProcessor{
	private MyInputProcessor inputprocessor;
	private Texture current;
	private basictower basictower;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private ArrayList <Rectangle> rect;
	private ArrayList <Texture> tow;
	private int count;
	private BitmapFont font;
	private TowerContainer towercon;
	private ShapeRenderer shapes;
	private Texture tiled;
	private Rectangle tower1;
	private String message;
	private Rectangle recta;
	private boolean dragged;
	class TouchInfo{
		public float touchX = 0;
		public float touchY = 0;
		public boolean touched = false;
		private Stage stage;
	}
	private Map<Integer, TouchInfo> touches = new HashMap<Integer, TouchInfo>();
	public void create(){
		//splash screen
		//input processor
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		batch = new SpriteBatch();
		camera = new OrthographicCamera(w,h);		
		basictower = new basictower();
	
		current = new Texture(basictower.sprite());
		batch = new SpriteBatch();
		count = 0;
		rect = new ArrayList<Rectangle>();
		towercon = new TowerContainer();

		shapes = new ShapeRenderer();
		tiled = new Texture("levelb.png");
		font = new BitmapFont();
		font.setColor(Color.BLUE);
		for(int i = 0; i<2;i++){
			touches.put(i, new TouchInfo());
		}
		recta = new Rectangle();
		dragged = false;
		spawnTower();
		}
	public void render(){
		super.render();
		Gdx.gl.glClearColor(1, 1f, 1f, 2);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(tiled, 0, 0);
		for(Rectangle x:rect){
			if(dragged == false && x.x != 480){
       		}else{
       		}
		}

		batch.end();
		
		//container
		shapes.begin(ShapeType.Line);
	     shapes.setProjectionMatrix(batch.getProjectionMatrix());
		shapes.setColor(Color.BLUE);
			
		shapes.end();
		shapes.updateMatrices();
		dragged = false;

	}
	
	private void spawnTower(){
		
		recta.x = 480;
		recta.y = 0;
		recta.width = 32;
		recta.height = 32;
		rect.add(recta);
	}

	public void dispose(){
		super.dispose();
		batch.dispose();
		current.dispose();
		shapes.dispose();
		tiled.dispose();
		font.dispose();
	}
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		if(screenX>480&& screenX < 512 && screenY >0&& screenY <32){
			recta.x = screenX;
			recta.y = screenY;
		}
		Gdx.app.log(message,""+screenX);
		dragged = true;
		return true;
	}
	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}