package gameOfLife;
import java.util.Arrays;
import java.util.HashSet;

public class MainG {
	public static void main(String[] args) throws InterruptedException {
		GameBoard initial = new GameBoard(
				new HashSet<>(Arrays.asList(new Cell(1, 2), new Cell(2, 3),
						new Cell(3, 1), new Cell(3, 2), new Cell(3, 3))));
		while (true) {
			System.out.println(initial);
			initial = GameStep.next(initial);
			Thread.sleep(2000);
		}
	}
}
