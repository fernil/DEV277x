package animalKingdom;

import java.awt.Color;
import java.util.Random;

public class Bear extends Critter {
	private boolean polar;
	private String move;
	private Color color;

	public Bear() {
		move = "/";
		Random random=new Random();
		if(random.nextInt(2)==1) {
			polar=true;
		}
	}

	public Bear(boolean polar) {
		this.polar = polar;
		move = "/";
		if (polar) {
			this.color = Color.WHITE;
		}
		this.color = Color.BLACK;
	}

	public Color getColor() {
		
		if (polar) {
			return Color.WHITE;
		}
		return Color.BLACK;
	}

	public String toString() {
		if (move.equals("\\")) {
			this.move = "/";
			return "/";
		}
		this.move = "\\";
		return "\\";
	}

	public Action getMove(CritterInfo info) {
		if (info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		} else if (info.getFront() == Neighbor.EMPTY) {
			return Action.HOP;
		}
		return Action.LEFT;
	}
}
