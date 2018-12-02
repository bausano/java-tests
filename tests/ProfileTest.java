import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class ProfileTest {

	@Test(expected = IllegalArgumentException.class)
	public void constructorThrowsIfGradeListEmpty() {
		new Profile(new ArrayList<Grade>());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void constructorThrowsIfGradeListNull() {
		new Profile(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void constructorThrowsIfGradeListContainsFailGrade() {
		new Profile(
				Arrays.asList(new Grade(10), new Grade(20), new Grade(10), new Grade(10))
		);
	}
	
	@Test
	public void constructorTakesValidLists() {
		Profile profile = new Profile(
				Arrays.asList(new Grade(15), new Grade(14), new Grade(13), new Grade(10))
		);
		
		assertEquals(profile.getClass(), Profile.class);
	}
	
	@Test
	public void classifiesAsClearFirst() {
		Profile profile = new Profile(
				Arrays.asList(new Grade(1), new Grade(1), new Grade(1), new Grade(1))
		);

		assertEquals(profile.classify(), Classification.First);
		assertTrue(profile.isClear());
	}
	
	@Test
	public void classifiesAsBorderlineFirst() {
		Profile profile = new Profile(
				Arrays.asList(new Grade(15), new Grade(15), new Grade(1), new Grade(1))
		);

		assertEquals(profile.classify(), Classification.First);
		assertFalse(profile.isClear());
	}
	
	@Test
	public void classifiesAsClearUpperSecond() {
		Profile profile = new Profile(
				Arrays.asList(new Grade(5), new Grade(5), new Grade(5), new Grade(5))
		);

		assertEquals(profile.classify(), Classification.UpperSecond);
		assertTrue(profile.isClear());
	}
	
	@Test
	public void classifiesAsBorderlineUpperSecond() {
		Profile profile = new Profile(
				Arrays.asList(new Grade(15), new Grade(15), new Grade(5), new Grade(5))
		);

		assertEquals(profile.classify(), Classification.UpperSecond);
		assertFalse(profile.isClear());
	}

	@Test
	public void classifiesAsLowerSecond() {
		Profile profile = new Profile(
				Arrays.asList(new Grade(9), new Grade(9), new Grade(9), new Grade(9))
		);

		assertEquals(profile.classify(), Classification.LowerSecond);
		assertTrue(profile.isClear());
	}
	
	@Test
	public void classifiesAsThird() {
		Profile profile = new Profile(
				Arrays.asList(new Grade(13), new Grade(13), new Grade(13), new Grade(13))
		);

		assertEquals(profile.classify(), Classification.Third);
		assertTrue(profile.isClear());
	}
	
	@Test
	public void isClearCanBeCalledBeforeClassify() {
		Profile profile = new Profile(
				Arrays.asList(new Grade(1), new Grade(1), new Grade(1), new Grade(1))
		);
		
		assertTrue(profile.isClear());
		assertEquals(profile.classify(), Classification.First);
	}
}
