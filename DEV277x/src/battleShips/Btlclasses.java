package battleShips;

public class Btlclasses {
	public static void printMap(String[][] x) {
		System.out.println("   0123456789");
		for (int i = 0; i < 10; i++) {
			
			System.out.print(i + " |");
			for (int j = 0; j < 10; j++) {
				if (x[i][j] == null) {
					System.out.print(" ");
				} else
					System.out.print(x[i][j]);
			}
			System.out.println("| " + i);
		}
		System.out.println("   0123456789");
	}

	public static int coor(int x) {
		if (x > 9 || x < 0) {
			return -1;
		}
		return x;
	}

}
