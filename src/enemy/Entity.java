package enemy;

public class Entity {
	protected float height = 32;
	protected float width = 32;
	public int speed;
	public Entity(){
		
	}
	public void speed(int speed){
		this.speed = speed;
	}
	public float height(){
		return height;
	}
	public float width(){
		return width;
	}
}
