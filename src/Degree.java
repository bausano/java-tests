import java.util.List;

public class Degree {
	private final List<Grade> year2;
	
	private final List<Grade> year3;
	
	public Degree(List<Grade> year2, List<Grade> year3) {
		if (!isValidGradeList(year2) || !isValidGradeList(year3)) {
			throw new IllegalArgumentException();
		}

		this.year2 = year2;
		
		this.year3 = year3;
	}

	public Classification classify() {
		return Classification.Third;
	}
	
	/**
	 * Checks if a given list is valid.
	 * 
	 * @param list
	 * @return
	 */
	private boolean isValidGradeList(List<Grade> list) {
		if (list == null || list.size() != 4) {
			return false;
		}

		return list.stream().allMatch(grade -> grade.classify() != Classification.Fail);
	}
}
