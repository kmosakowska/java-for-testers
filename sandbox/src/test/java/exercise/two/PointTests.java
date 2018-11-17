package exercise.two;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

	@Test
	public void testDistanceEquals1() {

		Point p1 = new Point(2, 5);
		Point p2 = new Point(5, 9);

		Assert.assertEquals(p1.distance(p2), 5.0);
	}

	@Test
	public void testDistanceEquals2() {
		Point p1 = new Point(2, 1);
		Point p2 = new Point(2, 3);

		Assert.assertEquals(p1.distance(p2), 2.0);
	}
	
	@Test
	public void testDistanceNotEquals() {
		Point p1 = new Point(2, 5);
		Point p2 = new Point(5, 9);

		Assert.assertNotEquals(p1.distance(p2), 4.0);
	}

	@Test
	public void testDistanceType() {
		Point p1 = new Point(2, 1);
		Point p2 = new Point(2, 3);

		Assert.assertNotEquals(p1.distance(p2), 2);
	}
}
