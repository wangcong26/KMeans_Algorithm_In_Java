package utils;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class Test_KMeans extends TestCase
{
	public void testKMeans1()
	{
		// Create a list of Point to store the dataset
		// Note: I set up the number of blocks as the parameter.
		// For example, if we have 5 block by 5 blocks, it will have actually 36 points.
		KMeans kmeans = new KMeans();
		List<Point> myData = new ArrayList<>();
		myData = kmeans.setDataset(5, 5);
	}
	
	public void testKMeans2()
	{
		// Create a list of Point to store the dataset
		// Note: I set up the number of blocks as the parameter.
		// For example, if we have 5 block by 5 blocks, it will have actually 36 points.
		KMeans kmeans = new KMeans();
		List<Point> myData = new ArrayList<>();
		myData = kmeans.setDataset(5, 5);
		
		
		// Check boundary m, n cannot be negative.
		// Test boundary: it cannot be 1 or lower. Throw an exception if n<=1
		Exception error = null;
		try
		{
			kmeans.setDataset(5, -5);
		} catch (Exception e)
		{
			error = e;
		}
		assertTrue(error != null);
	}
	
	public void testKMeans3()
	{
		// Create a list of Point to store the dataset
		// Note: I set up the number of blocks as the parameter.
		// For example, if we have 5 block by 5 blocks, it will have actually 36 points.
		KMeans kmeans = new KMeans();
		List<Point> myData = new ArrayList<>();
		myData = kmeans.setDataset(5, 5);
		
		
		// Check boundary m, n cannot be negative.
		// Test boundary: it cannot be 1 or lower. Throw an exception if n<=1
		Exception error = null;
		try
		{
			kmeans.setDataset(5, -5);
		} catch (Exception e)
		{
			error = e;
		}
		assertTrue(error != null);
		
		
		// Check if the dataset can be generated correctly.
		for (Point p : myData)
		{
			System.out.println(p);
		}
		System.out.println("Number of points in dataset: " + myData.size());

		// Created a Centroid object. The parameter needs to be the same as how we set up the dataset.
		Centroid myInitialCents = new Centroid(5, 5);
		
	}
	
	public void testKMeans4()
	{
		// Create a list of Point to store the dataset
		// Note: I set up the number of blocks as the parameter.
		// For example, if we have 5 block by 5 blocks, it will have actually 36 points.
		KMeans kmeans = new KMeans();
		List<Point> myData = new ArrayList<>();
		myData = kmeans.setDataset(5, 5);
		
		
		// Check boundary m, n cannot be negative.
		// Test boundary: it cannot be 1 or lower. Throw an exception if n<=1
		Exception error = null;
		try
		{
			kmeans.setDataset(5, -5);
		} catch (Exception e)
		{
			error = e;
		}
		assertTrue(error != null);
		
		
		// Check if the dataset can be generated correctly.
		for (Point p : myData)
		{
			System.out.println(p);
		}
		System.out.println("Number of points in dataset: " + myData.size());

		// Created a Centroid object. The parameter needs to be the same as how we set up the dataset.
		Centroid myInitialCents = new Centroid(5, 5);
		
		// Select N number of points from dataset as the initial centroids.
		// There are about 4 ways of initialization method:
		// 1) Forgy. I'm using Forgy initialization in this test. So the initial Centroids are from dataset and thus all integer points.
		// 2) Random. I also wrote code to generate random data points within the dataset.
		myInitialCents.SetFromPointListOrder(myData, 6);
		myInitialCents.ShowCentroidsPointListOrder(); // Show the initial centroids
		
		// Test the Kmean result. I store the result in a list of Cluster objects.
		List<Cluster> showMe = new ArrayList<>();
		showMe = kmeans.kMeans(myInitialCents, myData);
		for (Cluster c : showMe)
		{
			System.out.println(c.toString());
		}
	}

}
