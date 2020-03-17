package animalKingdom;

import java.awt.Color;
import java.util.Random;

public class NinjaCat extends Critter {

	public NinjaCat() {

	}

	public String toString() {
		return "NJ";
	}

	public Color getColor() {
		Random random = new Random();
		Color color = new Color(random.nextInt(0xFFFFFF));
		return color;
	}

	public Action getMove(CritterInfo info) {
		if (info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		} else if (info.getFront() == Neighbor.EMPTY) {
			return Action.HOP;
		}
		return Action.RIGHT;
	}
}
