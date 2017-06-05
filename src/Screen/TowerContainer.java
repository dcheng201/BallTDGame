package Screen;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class TowerContainer {
	private ArrayList<Rectangle> x;
	Rectangle rect = new Rectangle();
	ArrayList<ShapeRenderer> y;
	ShapeRenderer shapes;
	public TowerContainer(){
		x = new ArrayList<Rectangle>();
		rect.height = 32;
		rect.width = 32;
		rect.x = 480;
		rect.y = 0;
	}public void create(){
		for(int i = 0; i < 12; i++){
			for(int i1 = 0 ; i1<5;i1++){
				x.add(rect);
				rect.x = rect.x + 32;

			}
			rect.x = 480;
			rect.y = rect.y + 32;
		}
	}
	public Rectangle rects(int i){
		return x.get(i);
	}
	public String image(int x, int y){
		if(x>480&& x<512 && y>0 &&y >32){
			return "";
		}else return "";
	}
}
