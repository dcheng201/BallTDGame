package Main;

import java.awt.Color;
import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import Levels.Level1;
import Levels.Level10;
import Levels.Level11;
import Levels.Level2;
import Levels.Level3;
import Levels.Level4;
import Levels.Level5;
import Levels.Level6;
import Levels.Level7;
import Levels.Level8;
import Levels.Level9;
import aurelienribon.tweenengine.TweenManager;

public class Level implements Screen{
	private Stage stage;
	private Table table;
	private Skin skin;
	private TextureAtlas atlas;
	private TweenManager tween;
//	private BitmapFont black;
	private TextButton temp;
	private levelManager levelm;
	private ArrayList<TextButton> textbuttons;
	@Override
	public void show() {
		// TODO Auto-generated method stub
		stage = new Stage();
		
		Gdx.input.setInputProcessor(stage);
		atlas = new TextureAtlas("ui/button.pack");
		skin = new Skin(Gdx.files.internal("ui/menusSkin.json"),atlas);
		
//		black = new BitmapFont(Gdx.files.internal("black.fnt"),false);
		
		table = new Table(skin);
		
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		

		//heading
		Label heading = new Label("Level Selection", skin);
		table.add(heading).colspan(10).center();
		table.row();
		table.add().width(table.getWidth()/4);
		table.add().width(table.getWidth()/4);
		table.add().width(table.getWidth()/4);
		table.add().width(table.getWidth()/4);
		table.row();

		String leveln;
		textbuttons = new ArrayList<TextButton>();
		for(int i = 1; i<=20;i++){
			levelm = new levelManager(i);
			leveln = ""+i;
			temp = new TextButton(leveln,skin);
			textbuttons.add(temp);		
	
		}		
		textbuttons.get(0).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new Level1());
			}
		});
		textbuttons.get(1).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new Level2());
			}
			
		});textbuttons.get(2).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new Level3());
			}
		});textbuttons.get(3).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new Level4());
			}
		});textbuttons.get(4).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new Level5());
			}
		});textbuttons.get(5).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new Level6());
			}
		});textbuttons.get(6).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new Level7());
			}
		});textbuttons.get(7).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new Level8());
			}
		});textbuttons.get(8).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new Level9());
			}
		});textbuttons.get(9).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new Level10());
			}
		});textbuttons.get(10).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new Level11());
			}
		});textbuttons.get(11).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new Level1());
			}
		});textbuttons.get(12).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new Level1());
			}
		});textbuttons.get(13).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new Level1());
			}
		});textbuttons.get(14).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new Level1());
			}
		});textbuttons.get(15).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new Level1());
			}
		});textbuttons.get(16).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new Level1());
			}
		});textbuttons.get(17).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new Level1());
			}
		});textbuttons.get(18).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new Level1());
			}
		});textbuttons.get(19).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new Level2());
			}
		});
		
		for(int i = 1; i<= 20;i++){
			textbuttons.get(i-1).pad(10);
			table.add(textbuttons.get(i-1));
			table.debug();
			if(i%4 == 0){
				table.row();
			}
		}
		stage.addActor(table);
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		table.debugAll();
		
		stage.act(delta);
		stage.draw();
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

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		dispose();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		stage.dispose();
		atlas.dispose();
		skin.dispose();
	}

}
