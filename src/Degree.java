import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Degree {
	
	private final List<Grade> levelFiveGrades;
	
	private final List<Grade> levelSixGrades;
	
	public Degree(List<Grade> year2, List<Grade> year3) {
		if (!isValidGradeList(year2) || !isValidGradeList(year3)) {
			throw new IllegalArgumentException();
		}

		this.levelFiveGrades = year2;
		
		this.levelSixGrades = Stream
				.concat(year2.stream(), year3.stream())
                .collect(Collectors.toList());
	}

	public Classification classify() {
		Profile levelFive = new Profile(this.levelFiveGrades);
		
		Profile levelSix = new Profile(this.levelSixGrades);
		
		int diff = levelFive.classify().ordinal() - levelSix.classify().ordinal();
		
		if (levelFive.classify() == levelSix.classify()) {
			return levelFive.classify();
		}
		
		if (diff == 1 && levelFive.isClear()) {
			return levelFive.classify();
		}
		
		if (diff == -1 && levelSix.isClear()) {
			return levelSix.classify();
		}
		
		return Classification.Discretion;
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
