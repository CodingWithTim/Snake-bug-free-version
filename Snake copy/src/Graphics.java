import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Graphics 
extends JPanel
implements ActionListener{
	private Timer t = new Timer(100, this);
	public String state; // START, END, RUNNING
	
	private Snake s;
	private Food f;
	
	private Game game;

	public Graphics(Game g) {
		t.start();
		state = "START";
		
		s = g.getPlayer();
		f = g.getFood();
		
		game = g;
		
		//add a key listener for key detection 
		this.addKeyListener(g);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
	}
	
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		
		//change Graphics to 2d Graphics
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.black);
		g2d.fillRect(0, 0, Game.width * Game.dimension, Game.height * Game.dimension);
		
		if(state == "START") {
			g2d.setColor(Color.white);
			g2d.drawString("Press Any Key", Game.width / 2 * Game.dimension - 40, Game.height / 2 * Game.dimension - 20);
		}
		else if(state == "END") {
			g2d.setColor(Color.white);
			g2d.drawString("Your Score: " + (s.length()-3), Game.width / 2 * Game.dimension - 40, Game.height / 2 * Game.dimension - 20);
		}
		else {
			//draw food
			g2d.setColor(Color.red);
			g2d.fillRect(f.getX() * Game.dimension, f.getY() * Game.dimension, Game.dimension, Game.dimension);
			
			//draw snake
			g2d.setColor(Color.green);
			for(Rectangle r : s.getBody()) {
				g2d.fill(r);
			}
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
		if(state == "RUNNING") {
			if(game.check_food_collision() == true) {
				s.grow();
				f.randomSpawn();
			}
			else if(game.check_wall_collisions() == true) {
				state = "END";
			}
			else if(game.check_self_collision() == true) {
				state = "END";
			}
			else {
				s.move();
			}
		}
	}
}
