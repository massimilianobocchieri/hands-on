package puzzles;

public class ExpandingCharsPuzzle implements Puzzle {

	private String input = "Hello";

	public void solve() {
		for (int i=0; i<= this.input.length(); i++)
			System.out.print(this.input.substring(0, i));
		System.out.println();
	}

	public void showName() {
		System.out.println("Expanding Chars");
	}

}
