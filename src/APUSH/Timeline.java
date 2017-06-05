 package APUSH;

import java.awt.Font;
import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Timeline implements Screen{
		private SpriteBatch batch;
		private OrthographicCamera camera;
		private Texture timeline;
		private float x;
		
	
		@Override
		public void show() {
			// TODO Auto-generated method stub
			batch = new SpriteBatch();
			timeline = new Texture(Gdx.files.internal("timeline2.png"));
			
			x = 0;
		}
		@Override
		public void render(float delta) {
			// TODO Auto-generated method stub
			batch.begin();
			batch.draw(timeline, x, 0);
			if(Gdx.input.isKeyPressed(Input.Keys.LEFT)&x<0){
				x= x+10;
			}
			if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)&x>-3900){
				x = x-10;
			}
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
			dispose();
		}
		public void dispose(){
			batch.dispose();
		}
	

}
