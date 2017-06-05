package Main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

public class MainMenu implements Screen{
	private Stage stage;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;
	private TextButton buttonPlay, buttonExit;
//	private BitmapFont white, black;
	private Label heading;
	private TweenManager tween;
	@Override
	public void show() {
		stage = new Stage();
		
		Gdx.input.setInputProcessor(stage); 
		atlas = new TextureAtlas("ui/button.pack");
		skin = new Skin(Gdx.files.internal("ui/menusSkin.json"),atlas);
//		skin = new Skin(atlas);

		table = new Table(skin);
		
//		white = new BitmapFont(Gdx.files.internal("white.fnt"),false);
//		black = new BitmapFont(Gdx.files.internal("black.fnt"),false);
		
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		//button creation
/*		TextButtonStyle textbuttonStyle = new TextButtonStyle();
		textbuttonStyle.up = skin.getDrawable("button.9");
		textbuttonStyle.down = skin.getDrawable("buttonpressed.9");
		textbuttonStyle.pressedOffsetX = 1;
		textbuttonStyle.pressedOffsetY = -1;
		textbuttonStyle.font = black;
*/		
		
		buttonPlay = new TextButton("PLAY",skin);
		buttonPlay .pad(20);
		buttonPlay.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new Level());
			}
		});
		buttonExit = new TextButton("EXIT", skin);
		buttonExit.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				Gdx.app.exit();
			}
		});
		buttonExit.pad(20);

		//heading
		heading = new Label(BallTD.TITLE, skin );
		heading.setFontScale(5);
		
		//adding on table
		table.add(heading);
		table.getCell(heading).spaceBottom(50);
		table.row();
		table.add(buttonPlay);
		table.row();
		table.add(buttonExit);
		table.debug();
		stage.addActor(table);
		
		//animations
		tween = new TweenManager();
		Tween.registerAccessor(Actor.class, new ActorAccessor());
		
		Timeline.createSequence().beginSequence()
			.push(Tween.set(buttonPlay, ActorAccessor.ALPHA).target(0))
			.push(Tween.set(buttonExit, ActorAccessor.ALPHA).target(0))
			.push(Tween.from(heading, ActorAccessor.ALPHA, 0.5f).target(0))
			.push(Tween.to(buttonPlay, ActorAccessor.ALPHA, 0.5f).target(1))
			.push(Tween.to(buttonExit, ActorAccessor.ALPHA, 0.5f).target(1))
			.end().start(tween)
			;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		

		//stage.setDebugAll(true);
		stage.act(delta);
		tween.update(delta);
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
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		stage.dispose();
		atlas.dispose();
		skin.dispose();
//		black.dispose();
//		white.dispose();
	}

}
