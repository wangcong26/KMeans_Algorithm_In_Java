package utils;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class Test_Cluster extends TestCase
{
	// Test Constructor
	public void testCluster1()
	{
		// Test constructor
		Cluster testCluster = new Cluster();

		// Create a few Point objects and store in a List.
		Point centroid = new Point(1, 1);
		List<Point> listPoint = new ArrayList<>();
		Point myPoint1 = new Point(5, 8);
		Point myPoint2 = new Point(1, 4);
		Point myPoint3 = new Point(2, 2);
		listPoint.add(myPoint1);
		listPoint.add(myPoint2);
		listPoint.add(myPoint3);

	}
	
	// Test setter and getter
	public void testCluster2()
	{
		// Test constructor
		Cluster testCluster = new Cluster();

		// Create a few Point objects and store in a List.
		Point centroid = new Point(1, 1);
		List<Point> listPoint = new ArrayList<>();
		Point myPoint1 = new Point(5, 8);
		Point myPoint2 = new Point(1, 4);
		Point myPoint3 = new Point(2, 2);
		listPoint.add(myPoint1);
		listPoint.add(myPoint2);
		listPoint.add(myPoint3);

		// Test Cluster setter
		// Set a centroid and its list of points
		testCluster.setPList(myPoint1, listPoint);

		// Test Cluster getter
		List<Point> testList = testCluster.getListPoints();
		
		// See what's in the testList
		for (Point p : testList)
		{
			System.out.println(p);
		}
	}
	
	// Test compute centroid method and boundary test
	public void testCluster3()
	{
		// Test constructor
		Cluster testCluster = new Cluster();

		// Create a few Point objects and store in a List.
		Point centroid = new Point(1, 1);
		List<Point> listPoint = new ArrayList<>();
		Point myPoint1 = new Point(5, 8);
		Point myPoint2 = new Point(1, 4);
		Point myPoint3 = new Point(2, 2);
		listPoint.add(myPoint1);
		listPoint.add(myPoint2);
		listPoint.add(myPoint3);

		// Test Cluster setter
		// Set a centroid and its list of points
		testCluster.setPList(myPoint1, listPoint);

		// Test Cluster getter
		List<Point> testList = testCluster.getListPoints();
		
		// See what's in the testList
		for (Point p : testList)
		{
			System.out.println(p);
		}
		

		// Test Cluster computing centroid method
		testCluster.computeCentroid1();
		testCluster.showCentroid();
		System.out.println(testCluster);

		// Test boundary, if it's empty, then it cannot compute centroid
		Cluster testEmptyCluster = new Cluster();
		Exception error = null;
		try
		{
			testEmptyCluster.computeCentroid1();
		} catch (Exception e)
		{
			error = e;
		}
		assertTrue(error != null);
	}

}
