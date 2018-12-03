//TODO use full screen mode so that we don't have to keep printng the board in terminal (just like less or vim)



import java.util.Scanner;
public class PokemonGridGame {
	private static final int ROWS = 15;
	private static final int COLS = 50;
	public static void main(String[] args) {
		int rowPos = ROWS / 2;
		int colPos = COLS / 2;
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to pokemon, in this game, you will learn how to move up and down a grid");
		System.out.println("Now tell me, what was your name was again");
		String name = scan.next();
		scan.nextLine();
		System.out.println("Of course, " + name + ", glad to meet you");
		System.out.println("This is the grid, and it's pretty simple to move around it actually\n\nNow i want you to press 'W' 'A' 'S' or 'D' to move in the corresponding direction");
		move(name, rowPos, colPos);
	}

	private static void grid(String name, int rowPos, int colPos) {
		for (int r = 0; r <= ROWS; r++) {
			for (int c = 0; c <= COLS; c++) {
				if (r == rowPos && c == colPos) {
					System.out.print(" " + name.charAt(0) + " ");
				}
				else {
					System.out.print(" - ");
				}
			}
			System.out.println();
		}
	}
	private static void move(String name, int rowPos, int colPos) {
		Scanner scanny = new Scanner(System.in);
		boolean isForever = true;
		for (int i = 0; isForever; i++) {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			grid(name, rowPos, colPos);
			String move  = scanny.nextLine();
			if (move.equalsIgnoreCase("w")) {
				rowPos--;
			}
			if (move.equalsIgnoreCase("a")) {
				colPos--;
			}
			if (move.equalsIgnoreCase("s")) {
				rowPos++;
			}
			if (move.equalsIgnoreCase("d")) {
				colPos++;
			}
			else if (move.equalsIgnoreCase("q")) {
				break;
			}

		}
	}
	
}
