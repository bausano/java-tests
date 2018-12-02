import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClassificationTest {
	
	@Test
	public void hasFirst() {
		assertEquals(Classification.valueOf("First").ordinal(), 5);
	}
	
	@Test
	public void hasUpperSecond() {
		assertEquals(Classification.valueOf("UpperSecond").ordinal(), 4);
	}
	
	@Test
	public void hasLowerSecond() {
		assertEquals(Classification.valueOf("LowerSecond").ordinal(), 3);
	}
	
	@Test
	public void hasThird() {
		assertEquals(Classification.valueOf("Third").ordinal(), 2);
	}
	
	@Test
	public void hasFail() {
		Classification.valueOf("Third");
	}
	
	@Test
	public void hasDiscretion() {
		Classification.valueOf("Discretion");
	}
}
