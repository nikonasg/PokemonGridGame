//TODO use full screen mode so that we don't have to keep printng the board in terminal (just like less or vim)



import java.util.Scanner;
public class PokemonGridGame {
	private static final int ROWS = 15;
	private static final int COLS = 50;
	static int stopMove = 1;
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

		Grid grid = new Grid(3,5,name.charAt(0));
		while (stopMove > 0) {
			String move = scan.next();
			scan.nextLine();
			grid.movePlayer(move, name.substring(0, 1));
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + grid.toString());
		}
	}
	
}

class Grid {
	int rows = 15;
	int cols = 50;
	int rowPos = rows / 2;
	int colPos = cols / 2;
	int playerRow = 0;
	int playerColumn = 0;
	String grass = " - ";
	String tallGrass = " | ";
	String noWalk = " O ";
	String pokemon = "Poke";
	String[][] grid = new String[rows][cols];

	Grid(int x, int y, char ch) {
		for (int r  = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				grid[r][c] = " - ";
			}
		}
		grid[x][y] = " " + ch + " ";
		this.playerRow = x;
		this.playerColumn = y;
	}

	void movePlayer(String move, String name) {
		String player = name;
		
		if (move.equalsIgnoreCase("w")) {
			this.playerRow--;
		}
		if (move.equalsIgnoreCase("a")) {
			this.playerColumn--;
		}
		if (move.equalsIgnoreCase("s")) {
			this.playerRow++;
		}
		if (move.equalsIgnoreCase("d")) {
			this.playerColumn++;
		}
		else if (move.equalsIgnoreCase("q")) {
			PokemonGridGame.stopMove = 0;
		}
		grid[playerRow][playerColumn] = " " + player + " ";
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int r  = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				sb.append(grid[r][c]);
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	//TODO make a default constructor that makes a blank grid

	//change r3 c4 from - to N
}
