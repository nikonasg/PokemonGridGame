//TODO use full screen mode so that we don't have to keep printng the board in terminal (just like less or vim)



import java.util.Scanner;
public class PokemonGridGame {
	private static final int ROWS = 15;
	private static final int COLS = 50;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to pokemon, in this game, you will learn how to move up and down a grid");
		System.out.println("Now tell me, what was your name was again");
		String name = scan.next();
		scan.nextLine();
		System.out.println("Of course, " + name + ", glad to meet you");
		grid(name);
		System.out.println("This is the grid, and it's pretty simple to move around it actually\n\nNow i want you to press 'W' 'A' 'S' or 'D' to move in the corresponding direction");
		move(name);
	}

	private static void grid(String name) {
		for (int r = 0; r <= ROWS; r++) {
			for (int c = 0; c <= COLS; c++) {
				if (r == (ROWS / 2) && c == (COLS / 2)) {
					System.out.print(name.charAt(0));
				}
				else {
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}
	private static void move(String name) {
		Scanner scanny = new Scanner(System.in);
		grid(name);
		for (int i = 0; i <= 25; i++) {
			String move  = scanny.nextLine();
			if (move.equalsIgnoreCase("w")) {
				
			}
			if (move.equalsIgnoreCase("a")) {

			}
			if (move.equalsIgnoreCase("s")) {

			}
			if (move.equalsIgnoreCase("d")) {

			}
			else if (move.equalsIgnoreCase("q")) {
				break;
			}

		}
	}
	
}
