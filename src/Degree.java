import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Degree {
	
	private final Profile levelFive;
	
	private final Profile levelSix;
	
	public Degree(List<Grade> year2, List<Grade> year3) {
		this.levelFive = new Profile(year2);
		
		this.levelSix = new Profile(
			Stream
				.concat(year2.stream(), year3.stream())
				.collect(Collectors.toList())
		);
	}

	public Classification classify() {
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
}
