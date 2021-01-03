import java.awt.Rectangle;
import java.util.ArrayList;

public class Snake {
	private ArrayList<Rectangle> body;
	private String currentMove; // UP, DOWN, LEFT, RIGHT
	
	public Snake() {
		body = new ArrayList<Rectangle>();
		
		//add three rectangles
		Rectangle temp = new Rectangle(Game.dimension, Game.dimension);
		temp.setLocation(Game.width / 2 * Game.dimension, Game.height / 2 * Game.dimension);
		body.add(temp);
		
		temp = new Rectangle(Game.dimension, Game.dimension);
		temp.setLocation((Game.width / 2 - 1)* Game.dimension, Game.height / 2 * Game.dimension);
		body.add(temp);
		
		temp = new Rectangle(Game.dimension, Game.dimension);
		temp.setLocation((Game.width / 2 - 2)* Game.dimension, Game.height / 2 * Game.dimension);
		body.add(temp);
		
		currentMove = "Nothing";
	}
	
	public void move() {
		if(currentMove != "Nothing") {
			Rectangle a = body.get(0);
			
			Rectangle temp = new Rectangle(Game.dimension, Game.dimension);
		
			if(currentMove == "UP") {	
				temp.setLocation(a.x, a.y-Game.dimension);
				body.add(0, temp);
			}
			else if(currentMove == "DOWN") {
				temp.setLocation(a.x, a.y+Game.dimension);
				body.add(0, temp);
			}
			else if(currentMove == "LEFT") {
				temp.setLocation(a.x-Game.dimension, a.y);
				body.add(0, temp);
			}
			else {
				temp.setLocation(a.x+Game.dimension, a.y);
				body.add(0, temp);
			}
		
			body.remove(body.size()-1);
		}
	}
	
	public void grow() {
		Rectangle a = body.get(0);
		
		Rectangle temp = new Rectangle(Game.dimension, Game.dimension);
	
		if(currentMove == "UP") {	
			temp.setLocation(a.x, a.y-Game.dimension);
			body.add(0, temp);
		}
		else if(currentMove == "DOWN") {
			temp.setLocation(a.x, a.y+Game.dimension);
			body.add(0, temp);
		}
		else if(currentMove == "LEFT") {
			temp.setLocation(a.x-Game.dimension, a.y);
			body.add(0, temp);
		}
		else {
			temp.setLocation(a.x+Game.dimension, a.y);
			body.add(0, temp);
		}
	}
	
	public void up() {
		currentMove = "UP";
	}
	
	public void down() {
		currentMove = "DOWN";
	}
	
	public void left() {
		currentMove = "LEFT";
	}
	
	public void right() {
		currentMove = "RIGHT";
	}
	
	public int length() {
		return body.size();
	}
	
	public int getXPos() {
		return (int) body.get(0).x;
	}
	
	public int getYPos() {
		return (int) body.get(0).y;
	}
	
	public String getMove() {
		return currentMove;
	}
	
	public ArrayList<Rectangle> getBody(){
		return body;
	}
}
