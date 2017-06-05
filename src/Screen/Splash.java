package Screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Main.MainMenu;
import Tween.SpriteAccessor;
import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

public class Splash implements Screen{
	private SpriteBatch batch;
	private Sprite splash;
	private TweenManager tweenmanager;
	@Override
	public void show() {
		tweenmanager = new TweenManager();
		Tween.registerAccessor(Sprite.class, new SpriteAccessor());
		// TODO Auto-generated method stub
		batch = new SpriteBatch();
		Texture splashTexture = new Texture(Gdx.files.internal("Title.png"));
		splash = new Sprite(splashTexture);
		splash.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		Tween.set(splash,SpriteAccessor.ALPHA).target(0).start(tweenmanager);
		Tween.to(splash,SpriteAccessor.ALPHA,2).target(1).repeatYoyo(1, 0.5f).setCallback(new TweenCallback(){
			public void onEvent(int type,BaseTween<?> source ){
				((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
			}
		}).start(tweenmanager);
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl20.glClearColor(0, 0, 0, 1);
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		tweenmanager.update(delta);

		batch.begin();
		
		splash.draw(batch);
		batch.end();

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
		batch.dispose();
		splash.getTexture().dispose();
	}

}
