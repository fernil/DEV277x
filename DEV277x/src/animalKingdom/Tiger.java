package animalKingdom;

import java.awt.Color;
import java.util.Random;

import animalKingdom.Critter.Action;
import animalKingdom.Critter.Neighbor;

public class Tiger extends Critter {
	private int step;
	private Random random = new Random();
	private Color[] color = { Color.RED, Color.GREEN, Color.BLUE };
	private Color c = color[random.nextInt(3)];

	public Tiger() {
	}

	public final String toString() {
		return "TGR";
	}

	public Action getMove(CritterInfo info) {
		step++;
		if (info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		} else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
			return Action.LEFT;
		} else if (info.getFront() == Neighbor.SAME) {
			return Action.RIGHT;
		}
		return Action.HOP;
	}

	public Color getColor() {
		if (step % 3 == 0) {
			c = color[random.nextInt(3)];
			return c;
		}
		return this.c;
	}
}
