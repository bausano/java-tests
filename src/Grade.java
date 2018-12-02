
public class Grade {
	
	/**
	 * Holds the percentage bounds of each grade.
	 */
	private static final int[] bounds = {
			79, 76, 73, 70, 67, 65, 62, 60, 57, 55,
			52, 50, 47, 45, 42, 40, 35, 30, 0, -1
	};
	
	private final int points;

	public int getPoints() {
		return points;
	}

	public Grade(int points) throws IllegalArgumentException {
		if (points > 20 || points < 1) {
			throw new IllegalArgumentException();
		}
			
		this.points = points;
	}

	/**
	 * @return According classification for grade.
	 */
	public Classification classify() {
		if (points < 5) return Classification.First;
		
		if (points < 9) return Classification.UpperSecond;
		
		if (points < 13) return Classification.LowerSecond;
	
		if (points < 17) return Classification.Third;
		
		return Classification.Fail;
	}
	
	/**
	 * Converts a percentage to a Grade.
	 * 
	 * @param g Percentage from -1 to 100 inclusive.
	 * @return New Grade instance.
	 * @throws IllegalArgumentException
	 */
	public static Grade fromPercentage(int g) throws IllegalArgumentException {
		if (g > 100 || g < -1) {
			throw new IllegalArgumentException();
		}

		int band;

		for (band = 0; band < bounds.length; band++) {
			// If the percentage is greater than next bound, break the cycle.
			if (g >= bounds[band]) {
				break;
			}
		}
		
		// We start at index 0, but the grades are from 1 to 20,
		// hence we have to increment it.
		return new Grade(band + 1);
	}
}
