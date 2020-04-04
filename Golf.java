/**
 * 2 Dim Arrays 
 * Complete the following program.
 */
public class Golf {
//Each row stores rounds of golf for a particular player
	public int[][] scores;

	/**
	 * Constructor for objects of class Golf
	 */
	public Golf() {
		int[][] myScores = { { 67, 73, 79 }, { 71, 70, 68 }, { 78, 76, 75 } }; //double brackets to define a 2d Array

		scores = myScores;
	}

	/**
	 * Constructor for objects of class Golf
	 */
	public Golf(int[][] myScores2) {
		scores = myScores2;
	}

	/**
	 * displays the scores in columnar form. Golfer # is the header for each column
	 */
	public void displayColumns() {
		System.out.println("SCORES");
		System.out.println("0\t1\t2\t3\t4\t5"); // \t will space to the next tab
		for(int i = 0; i<scores[0].length;i++) {
			for(int c = 0; c<scores.length;c++) {
				System.out.printf(scores[c][i] +"\t");
			}
			System.out.println();
		}

// marker (for formatting)

		System.out.println("-\t-\t-\t-\t-\t-");
	}

	/**
	 * returns the total score of a particular player (0 - n)
	 */
	public int getScore(int player) {
		int total = 0;
		for(int i = 0; i<scores[0].length; i++) {
			total+=scores[player][i];
		}
		return total;
	}

	/**
	 * returns the index # of the winner. That is the golfer with the lowest sum of
	 * the rounds
	 */
	public int findWinner() {
		int minimum = 500;
		int index = 0; 
		for(int i = 0; i<scores.length;i++) {
			int x = getScore(i);
			if(x<minimum) {
				minimum = x;
				index = i; 
			}
		}
		return index; 
	}

	/**
	 * returns the average round of all of the golfers
	 *
	 */
	public double averageRound() {
		int total = 0; 
		for(int i = 0; i<scores.length; i++) {
			total+=getScore(i);
		}
		return (double)total/(scores.length*scores[0].length)*1.0;
	}

	public static void main(String args[]) {
		Golf masters = new Golf();
		System.out.println("MASTERS1");
		masters.displayColumns();
		System.out.println();
		System.out.println("Player 2's Score is: " + masters.getScore(2));
		System.out.println("Player " + masters.findWinner() + " is the winner"); 
		System.out.println("The average score for all of the rounds is : " + masters.averageRound());
		System.out.println();
		System.out.println("MASTERS2");
		int[][] scores2 = { { 73, 72, 71, 70 }, { 67, 76, 67, 74 }, { 72, 70, 74, 70 }, { 72, 72, 72, 72 },
				{ 71, 67, 70, 78 }, { 68, 70, 72, 77 } };
		Golf masters2 = new Golf(scores2);
		masters2.displayColumns();
		System.out.println();
		System.out.println("Player 3's Score is: " + masters2.getScore(3));
		System.out.println("Player " + masters2.findWinner() + " is the winner");
		System.out.println("The average score for all of the rounds is : " + masters2.averageRound());
	}
}
