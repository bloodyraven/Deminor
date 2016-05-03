package bean;

import java.awt.Dimension;

import constantes.Constantes;

public class Game {

	private Case[][] grille;
	private int nbMines;

	public Game(int nbMines) {
		this.nbMines = nbMines;
		init();
		poseMines();
		setVoisins();
	}

	public void recursif(Dimension d) {
		int i = (int) d.getWidth();
		int j = (int) d.getHeight();
		grille[i][j].setDiscovered(true);
		afficheAutour(i, j);
		if(!haveVoisin(i - 1, j - 1) && !isDiscovered(i - 1, j - 1)) {
			recursif(new Dimension(i - 1, j - 1));
		}
		if(!haveVoisin(i, j - 1) && !isDiscovered(i, j - 1)) {
			recursif(new Dimension(i, j - 1));
		}
		if(!haveVoisin(i + 1, j - 1) && !isDiscovered(i + 1, j - 1)) {
			recursif(new Dimension(i + 1, j - 1));
		}
		if(!haveVoisin(i - 1, j + 1) && !isDiscovered(i - 1, j + 1)) {
			recursif(new Dimension(i - 1, j + 1));
		}
		if(!haveVoisin(i, j + 1) && !isDiscovered(i, j + 1)) {
			recursif(new Dimension(i, j + 1));
		}
		if(!haveVoisin(i + 1, j + 1) && !isDiscovered(i + 1, j + 1)) {
			recursif(new Dimension(i + 1, j + 1));
		}
		if(!haveVoisin(i - 1, j) && !isDiscovered(i - 1, j)) {
			recursif(new Dimension(i - 1, j));
		}
		if(!haveVoisin(i + 1, j) && !isDiscovered(i + 1, j)) {
			recursif(new Dimension(i + 1, j));
		}
	}
	
	private void afficheAutour(int i, int j) {
		try {
			grille[i][j-1].setDiscovered(true);
			grille[i + 1][j - 1].setDiscovered(true);
			grille[i - 1][j - 1].setDiscovered(true);
			grille[i - 1][j + 1].setDiscovered(true);
			grille[i][j + 1].setDiscovered(true);
			grille[i + 1][j + 1].setDiscovered(true);
			grille[i - 1][j].setDiscovered(true);
			grille[i + 1][j].setDiscovered(true);
		} catch(Exception e) {}
	}
	
	private boolean isDiscovered(int a, int b) {
		try {
			if (grille[a][b].getDiscovered()) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	private boolean haveVoisin(int a, int b) {
		try {
			if (grille[a][b].getNbVoisins() == 0) {
				return false;
			}
		} catch (Exception e) {
			return true;
		}
		return true;
	}

	private void setVoisins() {
		int voisins;
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[0].length; j++) {
				voisins = 0;
				voisins += isMine(i - 1, j - 1);
				voisins += isMine(i, j - 1);
				voisins += isMine(i + 1, j - 1);
				voisins += isMine(i - 1, j + 1);
				voisins += isMine(i, j + 1);
				voisins += isMine(i + 1, j + 1);
				voisins += isMine(i - 1, j);
				voisins += isMine(i + 1, j);
				grille[i][j].setNbVoisins(voisins);
			}
		}
	}

	private int isMine(int a, int b) {
		try {
			if (grille[a][b].isMine()) {
				return 1;
			}
		} catch (Exception e) {
			return 0;
		}
		return 0;
	}

	private void init() {
		grille = new Case[Constantes.width][Constantes.height];
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[0].length; j++) {
				grille[i][j] = new Case(this, new Dimension(i, j));
			}
		}
	}

	private void poseMines() {
		int minesAPoser = nbMines;
		while (minesAPoser != 0) {
			Case c = grille[(int) (Math.random() * Constantes.width)][(int) (Math
					.random() * Constantes.height)];
			if (!c.isMine()) {
				c.setMine(true);
				minesAPoser--;
			}
		}
	}

	public Case[][] getGrille() {
		return grille;
	}

	public void setGrille(Case[][] grille) {
		this.grille = grille;
	}

	public int getNbMines() {
		return nbMines;
	}

	public void setNbMines(int nbMines) {
		this.nbMines = nbMines;
	}

}
