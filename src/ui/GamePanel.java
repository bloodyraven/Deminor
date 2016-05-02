package ui;

import java.awt.GridLayout;

import javax.swing.JPanel;

import bean.Case;
import bean.Game;
import constantes.Constantes;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public GamePanel(Game g) {
		this.setLayout(new GridLayout(Constantes.width, Constantes.height));
		Case[][] grille = g.getGrille();
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[0].length; j++) {
				this.add(grille[i][j].getButton());
			}
		}
	}
}
