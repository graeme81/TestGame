package game;

import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;

public class GetOutGame implements ActionListener, KeyListener{
	
	public static final int WIDTH = 800, HEIGHT = 500;
	public Renderer renderer;
	public static Rectangle player;
	public int ticks = 0, yMotion = 0;
	public static ArrayList<Rectangle> platforms;
	
	public GetOutGame() {
		JFrame f = new JFrame();
		
		renderer = new Renderer();
		Timer timer = new Timer(20, this);
		
		f.add(renderer);
		f.setTitle("GET OUT!");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocation(250, 100);
		f.setSize(WIDTH, HEIGHT);
		f.setResizable(false);
		f.setVisible(true);
		f.addKeyListener(this);
		f.setFocusable(true);					// what does it do?
		f.setFocusTraversalKeysEnabled(false);	// what does it do?
		
		player = new Rectangle(WIDTH/7 - 10, 50, 20, 20);
		platforms = new ArrayList<Rectangle>();
		
		addPlatforms();
		
		timer.start();
	}
	
	public void addPlatforms() {
		int length = 200;
		int thickness = 20;
		
		platforms.add(new Rectangle((WIDTH/2) + 100, (HEIGHT/2) - 20, length, thickness ));
		platforms.add(new Rectangle((WIDTH/2) - 300, (HEIGHT/2) - 20, length, thickness ));
	}
	
//	public void paintPlatform(Graphics g, Rectangle p) {
//		g.setColor(Color.DARK_GRAY);
//		g.fillRect(p.x, p.y, p.width, p.height);
//	}

	public static void repaint(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(new Color(102,51,0)); // brown
		g.fillRect(0, HEIGHT-100, WIDTH, 100);
		
		g.setColor(Color.GREEN);
		g.fillRect(player.x, player.y, player.width, player.height);
		
		g.setColor(new Color(102,51,0)); // brown
		
		for(Rectangle r : platforms) {
			g.fillRect(r.x,r.y,r.width,r.height);
		}
		
		//mid line white
		g.setColor(Color.WHITE);
		g.drawLine(WIDTH/2, 0, WIDTH/2, HEIGHT);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		ticks++;
		
		if(ticks % 2 == 0 && yMotion < 15) {
			yMotion +=2;
		}
		if(player.y < HEIGHT - 120) {
			player.y += yMotion;
		}else {
			player.y = HEIGHT - 120;
		}

		renderer.repaint();
		
	}
	 

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_UP) {
			up();
		}
		if (code == KeyEvent.VK_DOWN) {
			down();
		}
		if (code == KeyEvent.VK_LEFT) {
			left();
		}
		if (code == KeyEvent.VK_RIGHT) {
			right();
		}
		
		
	}

	private void right() {
		player.x+=4;
		System.out.println("pressed");
		
	}

	private void left() {
		player.x-=4;
		System.out.println("pressed");
		
		
	}

	private void down() {
		player.y++;
		System.out.println("pressed");
		
		
	}

	private void up() {
		player.y--;
		System.out.println("pressed");
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
}
