package puzzles;

public class ThreeUpPuzzle implements Puzzle {

	private String input;
		
	public ThreeUpPuzzle(String input) {
		this.input = input;
	}

	public void solve() {
		String result = input.toUpperCase();
		if (input.length() >= 3)
			result = result.substring(result.length() - 3).toUpperCase();

		System.out.println(result);
	}

	public void showName() {
		System.out.println("Three Up");
	}

}
