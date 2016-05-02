package bean;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Case {

	private boolean mine;
	private boolean flag;
	private boolean discovered;
	private int nbVoisins;
	private Button button;
	private Game g;
	private Dimension d;
	
	public Case(Game g) {
		this.setG(g);
		this.mine=false;
		this.flag=false;
		this.discovered=false;
		this.nbVoisins=0;
		this.button=new Button();
		button.addMouseListener(new ButtonListener());
		this.d = getXY(this);
	}

	public boolean isMine() {
		return mine;
	}

	public void setMine(boolean mine) {
		this.mine = mine;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
		if(flag) {
			this.button.setLabel("X");
		} else {
			this.button.setLabel("");
		}
	}

	public boolean getDiscovered() {
		return discovered;
	}

	public void setDiscovered(boolean discovered) {
		this.discovered = discovered;
		if(discovered) {
			if (nbVoisins != 0) {
				this.button.setLabel(""+nbVoisins);
			} else {
				this.button.setBackground(Color.LIGHT_GRAY);
			}
			this.button.setEnabled(false);
		}
	}
	
	public Dimension getXY(Case c) {
		Case[][] grille = g.getGrille();
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[0].length; j++) {
				if(c.equals(grille[i][j])) {
					return new Dimension(i, j);
				}
			}
		}
		return null;
	}
	
	public void recursif(Dimension d) {
		
	}

	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}

	public int getNbVoisins() {
		return nbVoisins;
	}

	public void setNbVoisins(int nbVoisins) {
		this.nbVoisins = nbVoisins;
	}

	public Game getG() {
		return g;
	}

	public void setG(Game g) {
		this.g = g;
	}

	public Dimension getD() {
		return d;
	}

	public void setD(Dimension d) {
		this.d = d;
	}

	private class ButtonListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			if(arg0.getButton() == MouseEvent.BUTTON1) {
				if(mine) {
					button.setBackground(Color.red);
				}
				if(!discovered && flag == false && !mine) {
					setDiscovered(true);
					if(nbVoisins == 0) {
						recursif(d);
					}
				}
			}
			if(arg0.getButton() == MouseEvent.BUTTON3) {
				if(flag) {
					setFlag(false);
				} else {
					setFlag(true);
				}
			}
		}
		
	}
	
}
