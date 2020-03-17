package animalKingdom;

import java.awt.Color;

public class WhiteTiger extends Critter {
	private boolean infected = false;

	public WhiteTiger() {

	}

	public final Color getColor() {
		return Color.WHITE;
	}

	public Action getMove(CritterInfo info) {
		if (info.getFront() == Neighbor.OTHER) {
			infected = true;
			return Action.INFECT;
		} else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
			return Action.LEFT;
		} else if (info.getFront() == Neighbor.SAME) {
			infected = true;
			return Action.RIGHT;
		}
		return Action.HOP;
	}

	public String toString() {
		if (infected) {
			return "tgr";
		}
		return "TGR";
	}

}
