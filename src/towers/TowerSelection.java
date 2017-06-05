package towers;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import Levels.Level9;
import Main.levelManager;
import entity.TowerCreations;

public class TowerSelection {
	private Texture current;
	private Table table;
	private Stage stage;
	public Skin skin;
	public TextureAtlas atlas;
	private TextButton temp;
	private ArrayList<TextButton> textbuttons;
	private levelManager levelm;
	private ArrayList<Texture> towerspawners;
	private int a = 0;
	private boolean clicked = false;
	private ArrayList<TowerCreations> towers;

	public TowerSelection(){
		atlas = new TextureAtlas("ui/button.pack");
		skin = new Skin(Gdx.files.internal("ui/menusSkin.json"),atlas);
		
		
		table = new Table(skin);
		
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		table.setX(240);
		table.row();
		table.add().width(40);
		table.add().width(40);
		table.add().width(40);
		table.add().width(40);
		table.row();
		
		towers = new ArrayList<TowerCreations>();

		towerspawners = new ArrayList<Texture>();

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
				clicked = true;
				current = new Texture(Gdx.files.internal("BasicTower.png"));
				towerspawners.add(current);
			}
		});
		textbuttons.get(1).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				current = new Texture(Gdx.files.internal("BasicTower.png"));
			}
			
		});textbuttons.get(2).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				current = new Texture(Gdx.files.internal("BasicTower.png"));
			}
		});textbuttons.get(3).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				current = new Texture(Gdx.files.internal("BasicTower.png"));
			}
		});textbuttons.get(4).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				current = new Texture(Gdx.files.internal("BasicTower.png"));
			}
		});textbuttons.get(5).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				current = new Texture(Gdx.files.internal("BasicTower.png"));
			}
		});textbuttons.get(6).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				current = new Texture(Gdx.files.internal("BasicTower.png"));
			}
		});textbuttons.get(7).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				current = new Texture(Gdx.files.internal("BasicTower.png"));
			}
		});textbuttons.get(8).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((Game) Gdx.app.getApplicationListener()).setScreen(new Level9());
			}
		});textbuttons.get(9).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				current = new Texture(Gdx.files.internal("BasicTower.png"));
			}
		});textbuttons.get(10).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				current = new Texture(Gdx.files.internal("BasicTower.png"));
			}
		});textbuttons.get(11).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				current = new Texture(Gdx.files.internal("BasicTower.png"));
			}
		});textbuttons.get(12).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				current = new Texture(Gdx.files.internal("BasicTower.png"));
			}
		});textbuttons.get(13).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				current = new Texture(Gdx.files.internal("BasicTower.png"));
			}
		});textbuttons.get(14).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				current = new Texture(Gdx.files.internal("BasicTower.png"));
			}
		});textbuttons.get(15).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				current = new Texture(Gdx.files.internal("BasicTower.png"));
			}
		});textbuttons.get(16).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				current = new Texture(Gdx.files.internal("BasicTower.png"));
			}
		});textbuttons.get(17).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				current = new Texture(Gdx.files.internal("BasicTower.png"));
			}
		});textbuttons.get(18).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				current = new Texture(Gdx.files.internal("BasicTower.png"));
			}
		});textbuttons.get(19).addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				current = new Texture(Gdx.files.internal("BasicTower.png"));
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
	}public void Clicked(boolean click){
		clicked = click;
	}public void towers(TowerCreations a){
		towers.add(a);
	}
	
	public Table getTable(){
		return table;
	}
	public boolean getClicked(){
		return clicked;
	}
	public ArrayList<Texture> towerspawners(){
		return towerspawners;
	}
	public Texture getCurrent(){
		return current;
	}
	public ArrayList<TowerCreations> towers(){
		return towers;	
	}
	
}
	