import java.util.Arrays;
import java.util.Scanner;

public class GameOfLifeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("What are your dimensions?");
		int dimensions = s.nextInt();
		s.nextLine();
		System.out.println("Enter the coordinates of the living cells. Use a pipe to separate coordinates; hit enter to finish.");
		String line = s.nextLine();
		
		boolean[][] matrix = new boolean[dimensions][dimensions];
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				matrix[x][y] = false;
			}
		}
		
		String[] lines = line.split("x ");
		for (int i = 0; i < lines.length; i++) {
			String[] numbers = lines[i].split(" ");
			int x = Integer.parseInt(numbers[0]);
			int y = Integer.parseInt(numbers[1]);
			matrix[x][y] = true;
		}
			
		GameOfLife go = new GameOfLife(matrix, dimensions);
		go.display();
		
		System.out.println("How many generations do you want it to go?");
		int generations = s.nextInt();
		for (int i = 0; i < generations; i++) {
			go.NextGen();
			go.display();
		}
	}

}
