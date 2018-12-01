import java.util.Scanner;
public class PokemonGridGame {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to pokemon, in this game, you will learn how to move up and down a grid");
		System.out.println("Now tell me, what was your name was again");
		String name = scan.nextLine();
		System.out.println("Of course, " + name + ", glad to meet you");
		grid();
		System.out.println("This is the grid, and it's pretty simple to move around it actually\n\nNow i want you to press 'W' 'A' 'S' or 'D' to move in the corresponding direction");

	}

	private static void grid() {
		for (int r = 0; r <= 15; r++) {
			for (int c = 0; c <= 50; c++) {
				System.out.print("0");
			}
			System.out.println();
		}
	}
	private static void move() {
		Scanner scanny = new Scanner(System.in);
		grid();
		for (int i = 0; i <= 25; i++) {
			String move  = scanny.nextLine();
			if (move.equalsIgnoreCase("w")) {
				
			}

		}
	}
	
}


