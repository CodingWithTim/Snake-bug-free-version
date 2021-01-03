import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Game 
implements KeyListener{
	//objects
	private Snake player;
	private Food food;
	private Graphics draw;
	
	//the game board is going to be base on tile
	public static final int width = 30;
	public static final int height = 30;
	public static final int dimension = 20;
	protected JFrame window;
	
	public Game() {
		//initializes the window
		window = new JFrame();
		
		//initializes the objects
		player = new Snake();
		food = new Food();
		
		draw = new Graphics(this);
		window.add(draw);
		
		
		window.setTitle("Snake");
		window.setSize(width * dimension, height * dimension);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	//public functions
	private void start() {
		draw.state = "RUNNING";
	}
	
	@Override
	public void keyTyped(KeyEvent e) {	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(draw.state != "START") {
			if(keyCode == KeyEvent.VK_W && player.getMove() != "DOWN") {
				player.up();
			}
		
			if(keyCode == KeyEvent.VK_S && player.getMove() != "UP") {
				player.down();
			}
		
			if(keyCode == KeyEvent.VK_A && player.getMove() != "RIGHT") {
				player.left();
			}
		
			if(keyCode == KeyEvent.VK_D && player.getMove() != "LEFT") {
				player.right();
			}
		}
		else {
			this.start();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {	}

	public boolean check_wall_collisions() {
		if(player.getXPos() < 0 || player.getXPos() >= width * dimension
				|| player.getYPos() < 0 || player.getYPos() >= height * dimension) {
			return true;
		}
		return false;
	}
	
	public boolean check_food_collision() {
		if(player.getXPos() == food.getX() * dimension && player.getYPos() == food.getY() * dimension) {
			return true;
		}
		return false;
	}
	
	public boolean check_self_collision() {
		for(int i = 1; i < player.length(); i++) {
			if(player.getBody().get(0).x == player.getBody().get(i).x && 
					player.getBody().get(0).y == player.getBody().get(i).y) {
				return true;
			}
		}
		return false;
	}

	public Snake getPlayer() {
		return player;
	}

	public void setPlayer(Snake player) {
		this.player = player;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}
}
