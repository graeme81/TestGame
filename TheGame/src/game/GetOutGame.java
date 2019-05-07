package game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GetOutGame implements ActionListener{
	
	public final int HEIGHT = 500, WIDTH = 800;
	public Renderer renderer;
	
	public GetOutGame() {
		JFrame f = new JFrame();
		
		renderer = new Renderer();
		Timer timer = new Timer(20, this);
		
		f.add(renderer);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocation(250, 100);
		f.setSize(WIDTH, HEIGHT);
		f.setResizable(false);
		f.setVisible(true);
		
		timer.start();
	}

	public static void repaint(Graphics g) {
		
		System.out.println("hello");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		renderer.repaint();
		
	}
	
	

}
