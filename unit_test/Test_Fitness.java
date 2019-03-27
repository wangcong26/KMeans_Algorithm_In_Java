package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import junit.framework.TestCase;

public class Test_Fitness extends TestCase
{
	// Construct dataset and Test method: evaluate
	public void testFitness1()
	{
		// Test #1: get result of the following clustering
		KMeans kmeans = new KMeans();
		List<Point> myData = new ArrayList<>();
		myData = kmeans.setDataset(3, 3);

		// Create initial centroid
		Centroid myInitialCents = new Centroid(3, 3);
		myInitialCents.SetFromPointListOrder(myData, 4);
		myInitialCents.ShowCentroidsPointListOrder();

		// Ouput the result to showMe
		List<Cluster> showMe = new ArrayList<>();
		showMe = kmeans.kMeans(myInitialCents, myData);

		// Test 1: Evaluate its fitness by computing the average distance of all the
		// clusters.
		List<Double> test = new ArrayList<>();
		Fitness eval = new Fitness();

		// Test2 the method: evaluate
		// I manually computed min, max, average with a small dataset, and it looks
		// correct
		test = eval.evaluate(showMe);
		for (Double d : test)
		{
			System.out.println(d);
		}

	}

	// Test averageCluster and allMetrics
	public void testFitness2()
	{
		// Test #1: get result of the following clustering
		KMeans kmeans = new KMeans();
		List<Point> myData = new ArrayList<>();
		myData = kmeans.setDataset(3, 3);

		// Create initial centroid
		Centroid myInitialCents = new Centroid(3, 3);
		myInitialCents.SetFromPointListOrder(myData, 4);
		myInitialCents.ShowCentroidsPointListOrder();

		// Ouput the result to showMe
		List<Cluster> showMe = new ArrayList<>();
		showMe = kmeans.kMeans(myInitialCents, myData);

		// Test 1: Evaluate its fitness by computing the average distance of all the
		// clusters.
		List<Double> test = new ArrayList<>();
		Fitness eval = new Fitness();

		// Test2 the method: evaluate
		// I manually computed min, max, average with a small dataset, and it looks
		// correct
		test = eval.evaluate(showMe);
		for (Double d : test)
		{
			System.out.println(d);
		}

		double max = 0;
		double min = 0;
		double mean = 0;
		max = Collections.max(test);
		min = Collections.min(test);

		// Test3 method averageCluster
		mean = eval.averageCluster(test);

		// Output the result
		System.out.println("Standard Kmean: The average distance of points to its centroid is: " + mean + ", with Max: "
				+ max + " and Min: " + min);

		// Test4 method: allMetrics
		eval.allMetrics(showMe);

	}

}
