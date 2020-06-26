// Taha Zaryab
// Tic Tac Toe game
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Gameboard {
	
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
	
	public static void printGame(char[][]gameBoard) {
		// method for printing the gameboard
		for(char[] row: gameBoard) {
			for(char c: row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	public static void placeChoice(char[][] gameBoard, int choice, String user) {
		// method for adding the player/cpu choice onto the gameboard
		char symbol = ' ';
		
		//if else statement for changing the space to either 'X' or 'O' based on which player chooses a position
		if(user.equals("Player")){
			symbol = 'X';
			playerPositions.add(choice);
		}
		else {
			symbol = 'O';
			cpuPositions.add(choice);
		}
		
		//switch case statement for changing the space to either 'X' or 'O' based on which player chooses a position
		switch(choice) {
		case 1:
			gameBoard[0][0] = symbol;break;
		case 2:
			gameBoard[0][2] = symbol;break;
		case 3:
			gameBoard[0][4] = symbol;break;
		case 4:
			gameBoard[2][0] = symbol;break;
		case 5:
			gameBoard[2][2] = symbol;break;
		case 6:
			gameBoard[2][4] = symbol;break;
		case 7:
			gameBoard[4][0] = symbol;break;
		case 8:
			gameBoard[4][2] = symbol;break;
		case 9:
			gameBoard[4][4] = symbol;break;
		default:
			break;
	}
	}
	
	public static String winner() {
		
		List topRow = Arrays.asList(1, 2, 3);
		List middleRow = Arrays.asList(4, 5, 6);
		List bottonRow = Arrays.asList(7, 8, 9);
		
		List leftCol = Arrays.asList(1, 4, 7);
		List midCol = Arrays.asList(2, 5, 8);
		List rightCol = Arrays.asList(3, 6, 9);
		
		List diag1 = Arrays.asList(1, 5, 9);
		List diag2 = Arrays.asList(3, 5, 7);
		
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(middleRow);
		winning.add(bottonRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(diag1);
		winning.add(diag2);
		
		for(List l: winning) {
			if(cpuPositions.containsAll(l)) {
				return ("CPU Wins!");
			}
			else if(playerPositions.containsAll(l)) {
				return ("Congratulations, you won!");
			}
			else if(playerPositions.size() + cpuPositions.size()==9) {
				return ("Tie Game!");
			}
		}
			
		return "";
	}

	public static void printPositions(char [][] positions) {
		System.out.println("The positions on the gameboard are numbered as shown. ");
		for(char[] row: positions) {
			for(char c: row) {
				System.out.print(c);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		
		

		char [][] gameBoard = {{' ', '|', ' ', '|', ' '},
								{'-', '+', '-', '+', '-'},
								{' ', '|', ' ', '|', ' '},
								{'-', '+', '-', '+', '-'},
								{' ', '|', ' ', '|', ' '}};
		char [][] positions = {{'1', '|', '2', '|', '3'},
				{'-', '+', '-', '+', '-'},
				{'4', '|', '5', '|', '6'},
				{'-', '+', '-', '+', '-'},
				{'7', '|', '8', '|', '9'}};
		
		
		printPositions(positions);
		printGame(gameBoard);
		
		String result = "";
		
		do {
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your choice (1-9):");
		int choice = input.nextInt();
		
		while(playerPositions.contains(choice) || cpuPositions.contains(choice)) {
			System.out.println("Position taken, please enter a valid position: ");
			choice = input.nextInt();
		}
		
		placeChoice(gameBoard, choice, "Player");
	
		result = winner();
		printGame(gameBoard);
		System.out.println();
		if(result.length()>0) {
			System.out.println(result);
			break;
		}
		
		Random rand = new Random();
		int cpuChoice = rand.nextInt(9)+1;
		while(playerPositions.contains(cpuChoice) || cpuPositions.contains(cpuChoice)) {
			cpuChoice = rand.nextInt(9)+1;
			cpuChoice = input.nextInt();
		}
		
		placeChoice(gameBoard, cpuChoice, "cpu");
		
		printGame(gameBoard);
		
		result = winner();
		if(result.length()>0) {
			System.out.println(result);
			break;
		}
		}while(result.equals(""));
		
		}
	}


