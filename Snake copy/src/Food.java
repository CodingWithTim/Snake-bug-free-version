
public class Food{
	private int x;
	private int y;
	
	public Food() {
		this.randomSpawn();
	}
	
	public void randomSpawn() {
		x = (int)(Math.random() * (Game.width-1));
		y = (int)(Math.random() * (Game.height-1));
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
