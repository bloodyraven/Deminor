package bean;

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
	
	private void setVoisins() {
		int voisins;
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[0].length; j++) {
				try {
					voisins=0;
					voisins+=isMine(i-1, j-1);
					voisins+=isMine(i, j-1);
					voisins+=isMine(i+1, j-1);
					voisins+=isMine(i-1, j+1);
					voisins+=isMine(i, j+1);
					voisins+=isMine(i+1, j+1);
					voisins+=isMine(i-1, j);
					voisins+=isMine(i+1, j);
					grille[i][j].setNbVoisins(voisins);
				} catch(Exception e) {}
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
				grille[i][j] = new Case(this);
			}
		}
	}
	
	private void poseMines() {
		int minesAPoser = nbMines;
		while(minesAPoser != 0) {
			Case c = grille[(int)(Math.random()*Constantes.width)][(int)(Math.random()*Constantes.height)];
			if(!c.isMine()) {
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
