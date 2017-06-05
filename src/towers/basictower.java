package towers;

import com.badlogic.gdx.math.Rectangle;

import enemy.Entity;

public class basictower extends Entity{
		private String sprite;
		private float angle;
		private float x;
		private float y;
		private float enemyX;
		private float enemyY;
		private Rectangle rect;
		public basictower(){
			super();
			sprite = "BasicTower.png";
			this.x = 0;
			this.y = 0;
			angle = 0;
			rect = new Rectangle();
			rect.x = x;
			rect.y = y;
		}public void rotate(float enemyX, float enemyY){
			this.enemyX = enemyX;
			this.enemyY = enemyY;
			angle =(float) Math.atan(enemyY/enemyX);
		}public void position(float x, float y){
			this.x = x;
			this.y = y;
		}
		public boolean Right(){
			if(enemyX-x>0){
				return false;
			}
			else{
				return true;
			}
		}public boolean Up(){
			if(enemyY-y>0){
				return false;
			}
			else{
				return true;
			}
		}
		public String sprite(){
			return sprite;
			
		}
		public float angle(){
			return angle;
		}
		public float originX(){
			return x+width/2;
		}
		public float originY(){
			return y+height/2;
		}public float getX(){
			return x;
		}public float getY(){
			return y;
		}public Rectangle rect(){
			return rect;
		}
		
	}
