package puzzles;

public class GoodNumbersPuzzle implements Puzzle {

	private int numberOne;
	private int numberTwo;
	
	
	public GoodNumbersPuzzle(int numberOne, int numberTwo) {
		this.numberOne = numberOne;
		this.numberTwo = numberTwo;
	}

	public void solve() {
		System.out.println(this.numberOne < 0 && this.numberTwo > 110);
	}

	public void showName() {
		System.out.println("Good Numbers");
	}

}
