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
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + grid.toString());
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

	//from: https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	public static final String RESET = "\u001B[0m";
	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";
	private static final String tallGrass = CYAN + " | " + RESET;
	private static final String noWalk = RED + " O " + RESET;
	private static final String pokemon = BLUE + "Poke" + RESET;
	private static final String GRASS = GREEN + " - " + RESET;
	String[][] grid = new String[rows][cols];

	Grid(int x, int y, char ch) {
		for (int r  = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				int random = (int) (Math.random() * 101);
				if (random >= 0 && random <= 60) {
					grid[r][c] = GRASS;
				}
				else if (random >= 61 && random <= 90) {
					grid[r][c] = tallGrass;
				}
				else if (random >= 91 && random <= 100) {
					grid[r][c] = noWalk;
				}
				
			}
		}
		grid[x][y] = " " + ch + " ";
		this.playerRow = x;
		this.playerColumn = y;
	}

	void movePlayer(String move, String name) {
		String player = name;
		grid[playerRow][playerColumn] = GRASS;
		if (move.equalsIgnoreCase("w")) {
			if (grid[playerRow - 1][playerColumn].equals(noWalk)) {

			}
			else {
				this.playerRow--;
			}
		}
		if (move.equalsIgnoreCase("a")) {
			if (grid[playerRow][playerColumn - 1].equals(noWalk)) {

			}
			else {
				this.playerColumn--;
			}
			
		}
		if (move.equalsIgnoreCase("s")) {
			if (grid[playerRow + 1][playerColumn].equals(noWalk)) {

			}
			else {
				this.playerRow++;
			}
		}
		if (move.equalsIgnoreCase("d")) {
			if (grid[playerRow][playerColumn + 1].equals(noWalk)) {

			}
			else {
				this.playerColumn++;
			}
		}
		else if (move.equalsIgnoreCase("q")) {
			PokemonGridGame.stopMove = 0;
		}
		if (grid[playerRow][playerColumn].equals(tallGrass)) {
			player += CYAN;
		}
		else {
			player += RESET;
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
