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
				Arrays.asList(new Grade(1), new Grade(2), new Grade(15), new Grade(5)),
				Arrays.asList(new Grade(15), new Grade(14), new Grade(13), new Grade(10))
		);
		
		assertEquals(degree.getClass(), Degree.class);
	}
	
	@Test
	public void classifiesProfilesWithSameClassification() {
		Degree degree = new Degree(
				Arrays.asList(new Grade(1), new Grade(2), new Grade(1), new Grade(1)),
				Arrays.asList(new Grade(2), new Grade(1), new Grade(1), new Grade(1))
		);
		
		assertEquals(degree.classify(), Classification.First);
	}
	
	@Test
	public void classifiesProfilesWithThirdYearClearAndSlightlyBetterClassification() {
		Degree degree = new Degree(
				Arrays.asList(new Grade(5), new Grade(5), new Grade(5), new Grade(5)),
				Arrays.asList(new Grade(1), new Grade(1), new Grade(1), new Grade(1))
		);
		
		assertEquals(degree.classify(), Classification.First);
	}
	
	@Test
	public void classifiesProfilesWithThirdYearBorderlineAndSlightlyBetterClassification() {
		Degree degree = new Degree(
				Arrays.asList(new Grade(13), new Grade(5), new Grade(1), new Grade(13)),
				Arrays.asList(new Grade(1), new Grade(1), new Grade(1), new Grade(13))
		);
		
		assertEquals(degree.classify(), Classification.Discretion);
	}
	
	@Test
	public void classifiesProfilesWithSecondYearClearAndSlightlyBetterClassification() {
		Degree degree = new Degree(
				Arrays.asList(new Grade(1), new Grade(1), new Grade(1), new Grade(5)),
				Arrays.asList(new Grade(5), new Grade(5), new Grade(5), new Grade(5))
		);
		
		assertEquals(degree.classify(), Classification.First);
	}
	
	@Test
	public void classifiesProfilesWithSecondYearBorderlineAndSlightlyBetterClassification() {
		Degree degree = new Degree(
				Arrays.asList(new Grade(1), new Grade(1), new Grade(13), new Grade(13)),
				Arrays.asList(new Grade(5), new Grade(5), new Grade(5), new Grade(5))
		);
		
		assertEquals(degree.classify(), Classification.Discretion);
	}
	
	@Test
	public void classifiesProfilesWithVeryDifferentClassifications() {
		Degree degree = new Degree(
				Arrays.asList(new Grade(1), new Grade(1), new Grade(1), new Grade(11)),
				Arrays.asList(new Grade(11), new Grade(11), new Grade(11), new Grade(11))
		);
		
		assertEquals(degree.classify(), Classification.Discretion);
	}
}
