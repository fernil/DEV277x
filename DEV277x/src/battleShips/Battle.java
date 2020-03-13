package battleShips;

import java.util.Random;
import java.util.Scanner;

public class Battle extends Btlclasses {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		String[][] bg = new String[10][10];
		System.out.println("Welcome to Battle Ships game.");
		System.out.println("The sea is empty right now. Each player can have only five ships.");
		printMap(bg);
		System.out.println("@ on the map marks your ship,\n- is a missed shot,\n! means opponent hit ship,\nx means your ships hit by opponent or yourself.");
		System.out.println("Give coordinates to five of your ships(Range 0-9x0-9)");
		for (int i = 0; i < 5; i++) {
			System.out.println("Ship " + (i + 1));
			System.out.print("Enter X coordinate for your ship " + (i + 1) + ":");
			int x = sc.nextInt();
			while (coor(x) < 0) {
				System.out.print("Enter proper value:");
				x = sc.nextInt();
			}
			System.out.print("Enter Y coordinate for your ship " + (i + 1) + ":");
			int y = sc.nextInt();
			while (coor(y) < 0) {
				System.out.print("Enter proper value:");
				y = sc.nextInt();
			}

			boolean tr = true;
			while (tr) {
				if (bg[x][y] == null) {
					bg[x][y] = "@";
					tr = false;
				} else {
					System.out.println("The Ship is already here, choose different coordinates.");
					System.out.println("Enter X coordinate for your ship " + (i + 1) + ":");
					x = sc.nextInt();
					while (coor(x) < 0) {
						System.out.println("Enter proper value:");
						x = sc.nextInt();
					}
					System.out.println("Enter Y coordinate for your ship " + (i + 1) + ":");
					y = sc.nextInt();
					while (coor(y) < 0) {
						System.out.println("Enter proper value:");
						y = sc.nextInt();
					}
				}

			}
		}
		printMap(bg);
		String[][] cbg = new String[10][10];
		Random random = new Random();
		for (int a = 0; a < 5; a++) {
			int xc = random.nextInt(10);
			int yc = random.nextInt(10);
			if (cbg[xc][yc] == null && bg[xc][yc] == null) {
				cbg[xc][yc] = "@";
			} else {
				a--;
			}
		}
		int playerShips = 5;
		int computerShips = 5;
		System.out.println("Let's start!");

		while (playerShips != 0 && computerShips != 0) {

			System.out.println("Your turn.");
			System.out.println("Enter X coordinate for your shot:");
			int xg = sc.nextInt();
			while (coor(xg) < 0) {
				System.out.println("Enter proper value:");
				xg = sc.nextInt();
			}
			System.out.println("Enter Y coordinate for your shot:");
			int yg = sc.nextInt();
			while (coor(yg) < 0) {
				System.out.println("Enter proper value:");
				yg = sc.nextInt();
			}
			if (cbg[xg][yg] != null) {
				System.out.println("Boom! You sunk the ship!");
				computerShips--;
				cbg[xg][yg] = null;
				bg[xg][yg] = "!";
				if(computerShips==0) {
					System.out.println("Player's ships: " + playerShips + " | Computer's ships: " + computerShips);					
					System.out.println();
					printMap(bg);
					System.out.println("^^^^^^^^^^^^^^^^^");
					break;
				}
			} else {
				if (bg[xg][yg] == "@") {
					System.out.println("Oh no, you sunk your own ship :(");
					playerShips--;
					bg[xg][yg] = "x";
					if(playerShips==0) {						
						System.out.println("Player's ships: " + playerShips + " | Computer's ships: " + computerShips);
						System.out.println();
						printMap(bg);
						System.out.println("^^^^^^^^^^^^^^^^^");
						break;
					}
				} else {
					System.out.println("Sorry, you missed");
					bg[xg][yg] = "-";
				}
			}
			
			Thread.sleep(500);
			System.out.println("Computer's turn.");
			int xcg = random.nextInt(10);
			int ycg = random.nextInt(10);
			Thread.sleep(500);
			if (bg[xcg][ycg] == "@") {
				System.out.println("The Computer sunk one of your ships!");
				playerShips--;
				bg[xcg][ycg] = "X";
			} else {
				if (cbg[xcg][ycg] == "@") {
					System.out.println("Computer hit its ship!");
					computerShips--;
					bg[xcg][ycg]="!";
				} else {
					System.out.println("Computer missed");
				}

			}
			Thread.sleep(500);
			System.out.println("Player's ships: " + playerShips + " | Computer's ships: " + computerShips);
			System.out.println();
			printMap(bg);
			System.out.println("^^^^^^^^^^^^^^^^^");
		}
		
		System.out.println("Game over.");
		if (playerShips < 1) {
			System.out.println("Sorry, you lose.");
		} else {
			System.out.println("You win!");
		}
		sc.close();
	}
}
