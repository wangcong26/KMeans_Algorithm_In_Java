package utils;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class Test_KMeans2 extends TestCase
{
	public void testKMeans1()
	{
		// Create a dataset
		List<Point> myData = new ArrayList<>();
		KMeans2 kmeans2 = new KMeans2();
		myData = kmeans2.setDataset(9, 9);

		// I want to see the dataset
		for (Point p : myData)
		{
			System.out.println(p);
		}
		System.out.println("Number of points in dataset: " + myData.size());
	}

	public void testKMeans2()
	{
		// Create a dataset
		List<Point> myData = new ArrayList<>();
		KMeans2 kmeans2 = new KMeans2();
		myData = kmeans2.setDataset(9, 9);

		// I want to see the dataset
		for (Point p : myData)
		{
			System.out.println(p);
		}
		System.out.println("Number of points in dataset: " + myData.size());

		// Check boundary m, n cannot be negative.
		// Test boundary: it cannot be 1 or lower. Throw an exception if n<=1
		Exception error = null;
		try
		{
			kmeans2.setDataset(5, -5);
		} catch (Exception e)
		{
			error = e;
		}
		assertTrue(error != null);

	}

	public void testKMeans3()
	{
		// Create a dataset
		List<Point> myData = new ArrayList<>();
		KMeans2 kmeans2 = new KMeans2();
		myData = kmeans2.setDataset(9, 9);

		// I want to see the dataset
		for (Point p : myData)
		{
			System.out.println(p);
		}
		System.out.println("Number of points in dataset: " + myData.size());

		// Check boundary m, n cannot be negative.
		// Test boundary: it cannot be 1 or lower. Throw an exception if n<=1
		Exception error = null;
		try
		{
			kmeans2.setDataset(5, -5);
		} catch (Exception e)
		{
			error = e;
		}
		assertTrue(error != null);

		// Check boundary. We cannot pick a number of centroids that is more than the
		// number of the dataset
		Centroid myInitialCents = new Centroid(9, 9);
		myInitialCents.SetFromPointListOrder(myData, 2);
		myInitialCents.ShowCentroidsPointListOrder();
		Exception error2 = null;
		try
		{
			myInitialCents.SetFromPointListOrder(myData, 200);
		} catch (Exception e)
		{
			error = e;
		}
		assertTrue(error != null);
	}

	public void testKMeans4()
	{
		// Create a dataset
		List<Point> myData = new ArrayList<>();
		KMeans2 kmeans2 = new KMeans2();
		myData = kmeans2.setDataset(9, 9);

		// I want to see the dataset
		for (Point p : myData)
		{
			System.out.println(p);
		}
		System.out.println("Number of points in dataset: " + myData.size());

		// Check boundary m, n cannot be negative.
		// Test boundary: it cannot be 1 or lower. Throw an exception if n<=1
		Exception error = null;
		try
		{
			kmeans2.setDataset(5, -5);
		} catch (Exception e)
		{
			error = e;
		}
		assertTrue(error != null);

		// Check boundary. We cannot pick a number of centroids that is more than the
		// number of the dataset
		Centroid myInitialCents = new Centroid(9, 9);
		myInitialCents.SetFromPointListOrder(myData, 2);
		myInitialCents.ShowCentroidsPointListOrder();
		Exception error2 = null;
		try
		{
			myInitialCents.SetFromPointListOrder(myData, 200);
		} catch (Exception e)
		{
			error = e;
		}
		assertTrue(error != null);

		// Output the result to a list of Cluster objects
		List<Cluster> showMe = new ArrayList<>();
		showMe = kmeans2.kMeans2(myInitialCents, myData, 10);

		// Print it out to see the result.
		for (Cluster c : showMe)
		{
			System.out.println(c.toString());
		}
	}
}
