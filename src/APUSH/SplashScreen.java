package APUSH;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.scenario.Settings;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenAccessor;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

public class SplashScreen implements Screen{
	

	private SpriteBatch batch;
	private Sprite splash;
	private TweenManager tweenmanager;

	@Override
	public void show() {
		// TODO Auto-generated method stub
		tweenmanager = new TweenManager();
		Tween.registerAccessor(Sprite.class, new SpriteAccessor());
		// TODO Auto-generated method stub
		batch = new SpriteBatch();
		Texture splashTexture = new Texture(Gdx.files.internal("ui/Microsoft-Logo-PNG.png"));
		splash = new Sprite(splashTexture);
		splash.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		Tween.set(splash,SpriteAccessor.ALPHA).target(0).start(tweenmanager);
		Tween.to(splash,SpriteAccessor.ALPHA,2).target(1).repeatYoyo(1, 0.5f).setCallback(new TweenCallback(){
			public void onEvent(int type,BaseTween<?> source ){
				((Game) Gdx.app.getApplicationListener()).setScreen(new Timeline());
			}
		}).start(tweenmanager);
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		splash.draw(batch);
		batch.end();

		tweenmanager.update(delta);
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
