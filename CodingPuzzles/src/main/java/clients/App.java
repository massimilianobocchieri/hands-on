package clients;

import puzzles.ExpandingCharsPuzzle;
import puzzles.GoodNumbersPuzzle;
import puzzles.Puzzle;
import puzzles.ThreeUpPuzzle;

public class App {

	public static void main(String[] args) {

		Puzzle expandingChars = new ExpandingCharsPuzzle();
		expandingChars.showName();
		expandingChars.solve();

		Puzzle threeUp = new ThreeUpPuzzle("fi");
		threeUp.showName();
		threeUp.solve();

		Puzzle goodNumbers = new GoodNumbersPuzzle(-1,201);
		goodNumbers.showName();
		goodNumbers.solve();

	}

}
