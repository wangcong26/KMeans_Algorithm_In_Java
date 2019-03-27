package utils;

import junit.framework.TestCase;
import utils.Point;

public class Test_Point extends TestCase
{
	public void testPoint()
	{
		// Test default constructor (0,0).
		Point myPoint4 = new Point();
		System.out.println("Point 4 is:" + myPoint4.toString());

		// Test constructor
		Point myPoint1 = new Point(5, 8);
		System.out.println("Point 1 is:" + myPoint1.toString());

		// Creater point3
		Point myPoint3 = new Point(2, 4);
	}
	
	
	// Test copy constructor, compareTo Method, and equal method
	public void test2()
	{
		// constructor (0,0).
		Point myPoint4 = new Point();
		System.out.println("Point 4 is:" + myPoint4.toString());

		// Test constructor
		Point myPoint1 = new Point(5, 8);
		System.out.println("Point 1 is:" + myPoint1.toString());

		// Creater point3
		Point myPoint3 = new Point(2, 4);

		// Test copy constructor and compareTo method.
		Point myPoint2 = new Point(myPoint1);
		assertTrue(myPoint1.compareTo(myPoint2) == 0);
		assertTrue(myPoint1.compareTo(myPoint3) == 1); // point1 > point3

		// Test equal method to see if point3==point1.
		assertFalse(myPoint1.equals(myPoint3)); // point1 > point3
		assertTrue(myPoint1.equals(myPoint2)); // point1=point2
	}
	
	
	// Test the distance and toString method.
	public void test3()
	{
		// Test default constructor (0,0).
		Point myPoint4 = new Point();
		System.out.println("Point 4 is:" + myPoint4.toString());

		// Test constructor
		Point myPoint1 = new Point(5, 8);
		System.out.println("Point 1 is:" + myPoint1.toString());

		// Creater point3
		Point myPoint3 = new Point(2, 4);

		// Test copy constructor and compareTo method.
		Point myPoint2 = new Point(myPoint1);
		assertTrue(myPoint1.compareTo(myPoint2) == 0);
		assertTrue(myPoint1.compareTo(myPoint3) == 1); // point1 > point3

		// Test equal method to see if point3==point1.
		assertFalse(myPoint1.equals(myPoint3)); // point1 > point3
		assertTrue(myPoint1.equals(myPoint2)); // point1=point2

		// Test distance method
		assertTrue(myPoint1.distance(myPoint3) == 5);

		// Test toString to display point object.
		myPoint1.toString();
		System.out.println("Distance between " + myPoint1.toString() + " and " + myPoint3.toString() + " is: "
				+ myPoint1.distance(myPoint3));
	}

}
