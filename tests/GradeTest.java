import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GradeTest {

	@Test(expected = IllegalArgumentException.class)
	public void constructorThrowsIfPointsNotInUpperBound() {
		new Grade(21);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void constructorThrowsIfPointsNotInLowerBound() {
		new Grade(0);
	}
	
	@Test
	public void constructsNewGradeWithPoints() {
		assertEquals(new Grade(1).getPoints(), 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void fromPercentageThrowsIfValueNotInUpperBound() {
		Grade.fromPercentage(101);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void fromPercentageThrowsIfValueNotInLowerBound() {
		Grade.fromPercentage(-2);
	}
	
	@Test
	public void fromPercentageUpperBoundConvertsToGrade() {
		assertEquals(Grade.fromPercentage(100).getPoints(), 1);
	}
	
	@Test
	public void fromPercentageLowerBoundConvertsToGrade() {
		assertEquals(Grade.fromPercentage(79).getPoints(), 1);
	}
	
	@Test
	public void fromPercentageConvertsToGrade() {
		// It's counterproductive to create one test per one grade band.
		// This way it's much clearer and if something fails,
		// we can see the band which has incorrect bound settings anyway.
		assertEquals(Grade.fromPercentage(90).getPoints(), 1);
		assertEquals(Grade.fromPercentage(78).getPoints(), 2);
		assertEquals(Grade.fromPercentage(73).getPoints(), 3);
		assertEquals(Grade.fromPercentage(71).getPoints(), 4);
		assertEquals(Grade.fromPercentage(67).getPoints(), 5);
		assertEquals(Grade.fromPercentage(65).getPoints(), 6);
		assertEquals(Grade.fromPercentage(62).getPoints(), 7);
		assertEquals(Grade.fromPercentage(60).getPoints(), 8);
		assertEquals(Grade.fromPercentage(57).getPoints(), 9);
		assertEquals(Grade.fromPercentage(55).getPoints(), 10);
		assertEquals(Grade.fromPercentage(54).getPoints(), 11);
		assertEquals(Grade.fromPercentage(50).getPoints(), 12);
		assertEquals(Grade.fromPercentage(49).getPoints(), 13);
		assertEquals(Grade.fromPercentage(45).getPoints(), 14);
		assertEquals(Grade.fromPercentage(43).getPoints(), 15);
		assertEquals(Grade.fromPercentage(41).getPoints(), 16);
		assertEquals(Grade.fromPercentage(35).getPoints(), 17);
		assertEquals(Grade.fromPercentage(30).getPoints(), 18);
		assertEquals(Grade.fromPercentage(0).getPoints(), 19);
		assertEquals(Grade.fromPercentage(-1).getPoints(), 20);
	}
	
	@Test
	public void classifiesFirst() {
		assertEquals(new Grade(1).classify(), Classification.First);
	}
	
	@Test
	public void classifiesUpperSecond() {
		assertEquals(new Grade(5).classify(), Classification.UpperSecond);
	}
	
	@Test
	public void classifiesLowerSecond() {
		assertEquals(new Grade(12).classify(), Classification.LowerSecond);
	}
	
	@Test
	public void classifiesThird() {
		assertEquals(new Grade(13).classify(), Classification.Third);
	}
	
	@Test
	public void classifiesFail() {
		assertEquals(new Grade(20).classify(), Classification.Fail);
	}
}
