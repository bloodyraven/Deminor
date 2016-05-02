package main;
import javax.swing.JFrame;

import bean.Game;
import ui.GamePanel;


public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame("Deminor");
		f.setContentPane(new GamePanel(new Game(30)));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	
}
