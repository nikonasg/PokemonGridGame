   //TODO use full screen mode so that we don't have to keep printng the board in terminal (just like less or vim)
import java.io.IOException;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;


import java.util.Scanner;
public class PokemonGridGame {
	private static final int ROWS = 15;
	private static final int COLS = 50;
	static int stopMove = 1;

	public static void main(String[] args) {
		try {
			run();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void run() throws IOException, InterruptedException {
		Terminal terminal = new DefaultTerminalFactory().createTerminal();
		Screen screen = new TerminalScreen(terminal);
		TextGraphics tGraphics = screen.newTextGraphics();

		screen.startScreen();
		screen.clear();
		int i = 0;
		for (String col : Grid.grid[i]) {
			if (col != null) {
				tGraphics.putString(10, i++, col);
				i++;
			}
			
		}
		screen.refresh();



		int rowPos = ROWS / 2;
		int colPos = COLS / 2;
		Scanner scan = new Scanner(System.in);
		tGraphics.putString(0, 1,("Welcome to pokemon, in this game, you will learn how to move up and down a grid"));
		tGraphics.putString(0, 2,("Now tell me, what was your name was again"));
		screen.refresh();
		String name = scan.next();
		scan.nextLine();
		tGraphics.putString(0, 3, ("Of course, " + name + ", glad to meet you"));
		tGraphics.putString(0, 4, ("This is the grid, and it's pretty simple to move around it actually"));
		tGraphics.putString(0, 5, ("Now i want you to press 'W' 'A' 'S' or 'D' to move in the corresponding direction"));
		screen.refresh();

		Grid grid = new Grid(3,5,name.charAt(0));
		String[] gridArray = grid.gridStringArray();
		while (stopMove > 0) {
			String move = scan.next();
			scan.nextLine();
			grid.movePlayer(move, name.substring(0, 1));
			screen.clear();
			scan.nextLine();
			int j = 0;
			for (String s : gridArray) {
				tGraphics.putString(0, 10 + j, s);
				j++;
			}
			screen.refresh();
		}
		screen.clear();
	}
	
}

class Grid {
	static int rows = 15;
	static int cols = 50;
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
	private static final String tallGrass = " | ";
	private static final String noWalk = " O ";
	private static final String pokemon = "Poke";
	private static final String GRASS = " - ";
	static String[][] grid = new String[rows][cols];

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
		// if (grid[playerRow][playerColumn].equals(tallGrass)) {
		// 	player += CYAN;
		// }
		// else {
		// 	player += RESET;
		// }
		grid[playerRow][playerColumn] = " " + player + " ";
	}

	String[] gridStringArray() {
		return this.toString().split("\n");
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
