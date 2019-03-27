package utils;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import utils.Centroid;

public class Test_Centroid extends TestCase
{
	// #1 Test: Generate 5 random points from the dataset
	public void test1()
	{
		// #1 Test: Generate 5 random points from the dataset
		// Create a list of Point for dataset
		List<Point> listPoints = new ArrayList<>();
		GenerateDataset mydataset = new GenerateDataset();
		listPoints = mydataset.setDataset(4, 4);
		System.out.print("Dataset has " + listPoints.size() + " points.\n");

	}

	// #2 Initialize the same rows and cols as the dataset.
	public void test2()
	{
		// #1 Test: Generate 5 random points from the dataset
		// Create a list of Point for dataset
		List<Point> listPoints = new ArrayList<>();
		GenerateDataset mydataset = new GenerateDataset();
		listPoints = mydataset.setDataset(4, 4);
		System.out.print("Dataset has " + listPoints.size() + " points.\n");

		// #2 Initialize the same rows and cols as the dataset.
		// So the randome points are in range
		Centroid testCentroid = new Centroid(4, 4);
		testCentroid.SetInitialCentroids(5);
		testCentroid.ShowRandomCentroids(); // Show it
	}

	// #3 Select points from the dataset. All points have integer coordinates
	public void test3()
	{
		// #1 Test: Generate 5 random points from the dataset
		// Create a list of Point for dataset
		List<Point> listPoints = new ArrayList<>();
		GenerateDataset mydataset = new GenerateDataset();
		listPoints = mydataset.setDataset(4, 4);
		System.out.print("Dataset has " + listPoints.size() + " points.\n");

		// #2 Initialize the same rows and cols as the dataset.
		// So the randome points are in range
		Centroid testCentroid = new Centroid(4, 4);
		testCentroid.SetInitialCentroids(5);
		testCentroid.ShowRandomCentroids(); // Show it

		// #3 Select points from the dataset. All points have integer coordinates
		Centroid initial = new Centroid();
		initial.SetFromPointListOrder(listPoints, 5);
		initial.ShowCentroidsPointListOrder();

	}

	// #4 Test Centroid constructor and boundary
	public void test4()
	{
		// #1 Test: Generate 5 random points from the dataset
		// Create a list of Point for dataset
		List<Point> listPoints = new ArrayList<>();
		GenerateDataset mydataset = new GenerateDataset();
		listPoints = mydataset.setDataset(4, 4);
		System.out.print("Dataset has " + listPoints.size() + " points.\n");

		// #2 Initialize the same rows and cols as the dataset.
		// So the randome points are in range
		Centroid testCentroid = new Centroid(4, 4);
		testCentroid.SetInitialCentroids(5);
		testCentroid.ShowRandomCentroids(); // Show it

		// #3 Select points from the dataset. All points have integer coordinates
		Centroid initial = new Centroid();
		initial.SetFromPointListOrder(listPoints, 5);
		initial.ShowCentroidsPointListOrder();

		// #4 Test Centroid constructor and boundary
		Centroid myInitialCents = new Centroid(4, 4);
		// Test boundary: it cannot be 1 or lower. Throw an exception if n<=1
		Exception error = null;
		try
		{
			myInitialCents.SetInitialCentroids(1);
		} catch (Exception e)
		{
			error = e;
		}
		assertTrue(error != null);

	}
	
	// #5 Test boundary: it cannot select more than the number of the points in the dataset
	public void test5()
	{
		// #1 Test: Generate 5 random points from the dataset
		// Create a list of Point for dataset
		List<Point> listPoints = new ArrayList<>();
		GenerateDataset mydataset = new GenerateDataset();
		listPoints = mydataset.setDataset(4, 4);
		System.out.print("Dataset has " + listPoints.size() + " points.\n");

		// #2 Initialize the same rows and cols as the dataset.
		// So the randome points are in range
		Centroid testCentroid = new Centroid(4, 4);
		testCentroid.SetInitialCentroids(5);
		testCentroid.ShowRandomCentroids(); // Show it

		// #3 Select points from the dataset. All points have integer coordinates
		Centroid initial = new Centroid();
		initial.SetFromPointListOrder(listPoints, 5);
		initial.ShowCentroidsPointListOrder();

		// #4 Test Centroid constructor and boundary
		Centroid myInitialCents = new Centroid(4, 4);
		// Test boundary: it cannot be 1 or lower. Throw an exception if n<=1
		Exception error = null;
		try
		{
			myInitialCents.SetInitialCentroids(1);
		} catch (Exception e)
		{
			error = e;
		}
		assertTrue(error != null);

		// #5 Test boundary: it cannot select more than the number of the points in the
		// dataset
		Centroid myInitialCents2 = new Centroid(4, 4);
		Exception error2 = null;
		try
		{
			myInitialCents2.SetFromPointListOrder(listPoints, 26); // cannot be more than 25
		} catch (Exception e)
		{
			error2 = e;
		}
		assertTrue(error2 != null);

	}


}
