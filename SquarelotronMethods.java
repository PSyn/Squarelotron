package squarelotron;

public interface SquarelotronMethods {
	/*
	 * converts a 2D Squarelotron to a 1D array
	 */
	public int[] numbers();
	/*
	 * flips the selected ring from top to bottom
	 */
	public Squarelotron upsideDownFlip(int ring);
	/*
	 * flips the selected ring from left to right
	 */
	public Squarelotron leftRightFlip(int ring);
	/*
	 * flips the selected ring along the inverse diagonal
	 */
	public Squarelotron inverseDiagonalFlip(int ring);
	/*
	 * flips the selected ring along the main diagonal
	 */
	public Squarelotron mainDiagonalFlip(int ring);
	/*
	 * flips the side-most rows or columns with the opposite sides (2)
	 */
	public Squarelotron sideFlip(String side);
	/*
	 * rotates the /Squarelotron by # of turns clockwise (+) or counter-clockwise (-) with each turn being 90 degrees
	 */
	public void rotateRight(int numberOfTurns);
	/*
	 * creates new equal method to test two squarelotrons
	 */
	@Override public boolean equals(Object object);
	/*
	 * outputs a Squarelotron as a text
	 */
	@Override public String toString();

}
