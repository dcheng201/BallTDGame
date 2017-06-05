package entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class TowerCreations {
	private Sprite skin;
	private float x;
	private float y;
	public TowerCreations(Texture texture, float x,float y){
		skin = new Sprite(texture);
		this.x = x;
		this.y = -y+480;
		skin.setPosition(this.x, this.y);
		skin.setSize(30, 30);
		skin.setOrigin(skin.getWidth()/2, skin.getHeight()/2);
		skin.setRotation(0);
		
		
	}
	public void renderer(SpriteBatch batch){
		skin.draw(batch);
	}
	public void update(int ex, int ey, SpriteBatch batch){
		float distance = (float) Math.sqrt(Math.pow((ex-x), 2)+Math.pow(ey-y, 2));
		float degrees;
		if(distance!= 0){
			degrees = MathUtils.radiansToDegrees*MathUtils.atan2((480-ey-y) , (ex-x));
		}else{
			degrees = 0;
		}
		skin.setRotation(degrees);
		skin.draw(batch);
	}

	public Sprite skin(){
		return skin;
	}
	public float x(){
		return x;
	}
	public float y(){
		return y;
	}
}
