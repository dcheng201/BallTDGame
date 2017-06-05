package entity;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class BasicAttack {
	private Sprite attack;
	private ArrayList<Sprite> attacks;
	private float x;
	private float y;
	private float timer;
	public BasicAttack(Texture texture, float x,float y){
		
		this.x = x;
		this.y = -y+480;
		attack = new Sprite(new Texture(Gdx.files.internal("ui/BasicAttack.png")));
		attack.setPosition(this.x, this.y);
		attack.setOrigin(attack.getWidth()/2, attack.getHeight()/2);
		
		attacks = new ArrayList<Sprite>();
		timer = 0;
		
	}
	public void update(int ex, int ey,SpriteBatch batch,float delta){
		attack(ex,ey,batch);
		timer = timer+ delta; 
		if(timer>= 1){
			attack(ex,ey,batch);
			timer = 0;
		}
		
	}
	public void attack(int ex, int ey,SpriteBatch batch){
		float distance = (float) Math.sqrt(Math.pow((ex-x), 2)+Math.pow(ey-y, 2));
		float degrees;
		if(distance!= 0){
			degrees = MathUtils.radiansToDegrees*MathUtils.atan2((480-ey-y) , (ex-x));
		}else{
			degrees = 0;
		}
		attack.translateX(MathUtils.cos(degrees)*10);
		attack.translateY(MathUtils.sin(degrees)*10);
		attack.draw(batch);
	}
}
