import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class DegreeTest {

	@Test(expected = IllegalArgumentException.class)
	public void constructorThrowsIfGradeListEmpty() {
		new Degree(new ArrayList<Grade>(), new ArrayList<Grade>());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void constructorThrowsIfGradeListNull() {
		new Degree(null, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void constructorThrowsIfGradeListContainsFailGrade() {
		new Degree(
				Arrays.asList(new Grade(1), new Grade(1), new Grade(1), new Grade(1)),
				Arrays.asList(new Grade(1), new Grade(20), new Grade(1), new Grade(1))
		);
	}
	
	@Test
	public void constructorTakesValidLists() {
		Degree degree = new Degree(
				Arrays.asList(new Grade(1), new Grade(2), new Grade(16), new Grade(5)),
				Arrays.asList(new Grade(15), new Grade(14), new Grade(13), new Grade(10))
		);
		
		assertEquals(degree.getClass(), Degree.class);
	}
}
