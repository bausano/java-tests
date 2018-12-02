import java.util.Arrays;
import java.util.List;

public class Profile {

	private final List<Grade> grades;
	
	private Classification cls = null;
	
	public Profile(List<Grade> grades) {
		if (!isValidGradeList(grades)) {
			throw new IllegalArgumentException();
		}

		this.grades = grades;
	}
	
	public Classification classify() {
		if (cls != null) {
			return cls;
		}
		
		double[] percentages = calcPercentages();
		
		if (percentages[0] >= 50d) {
			return cls = Classification.First;
		}
		
		if (percentages[0] + percentages[1] >= 50d) {
			return cls = Classification.UpperSecond;
		}
		
		if (percentages[0] + percentages[1] + percentages[2] >= 50d) {
			return cls = Classification.LowerSecond;
		}
		
		return cls = Classification.Third;
	}

	public boolean isClear() {
		if (cls == null) {
			this.classify();
		}
		
		if (cls == Classification.LowerSecond || cls == Classification.Third) {
			return true;
		}
		
		return calcPercentages()[3] <= 25;
	}
	
	/**
	 * Checks if a given list is valid.
	 * 
	 * @param list
	 * @return
	 */
	private boolean isValidGradeList(List<Grade> list) {
		if (list == null || (list.size() != 4 && list.size() != 8)) {
			return false;
		}

		return list.stream().allMatch(grade -> grade.classify() != Classification.Fail);
	}
	
	/**
	 * Calculates percentages for each grade.
	 * TODO: Preferably use HashMap with Classification as key and Integer as value.
	 * 
	 * @return Array of 4 doubles where 1st element is First, ...
	 */
	private double[] calcPercentages() {
		double[] counts = new double[4];
		
		int size = grades.size();
		
		grades.stream().forEach(grade -> counts[5 - grade.classify().ordinal()]++);

		return Arrays.stream(counts).map(i -> i / size * 100).toArray();
	}
}
