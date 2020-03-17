package animalKingdom;

import java.awt.Color;

public class Giant extends Critter {
	private String s;
	private int step;

	public Giant() {

	}

	public final Color getColor() {
		return Color.GRAY;
	}

	public Action getMove(CritterInfo info) {
		step++;
		if (info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		} else if (info.getFront() == Neighbor.EMPTY) {
			return Action.HOP;
		}
		return Action.RIGHT;
	}

	public String toString() {
		if (step >= 0 && step < 6) {
			s = "fee";
		} else if (step > 6 && step <= 12) {
			s = "fie";
		} else if (step > 12 && step <= 18) {
			s = "foe";
		} else if (step > 18 && step <= 24) {
			s = "fum";
		}
		if (step > 24) {
			this.step = 0;
		}
		return s;

	}
}
