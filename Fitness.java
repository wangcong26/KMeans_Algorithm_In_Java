package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fitness
{
	// Field: a list of Cluster
	List<Cluster> testResult = new ArrayList<>();

	// Constructor
	Fitness()
	{

	}

	// Constructor
	Fitness(List<Cluster> result)
	{
		this.testResult = result;

	}

	// Method: to evaluate the result of clustering
	// This is to compute the average distance for each cluster and output a list of
	// distance
	public List<Double> evaluate(List<Cluster> result)
	{
		List<Double> averageDistance = new ArrayList<>();
		for (Cluster c : result)
		{
			double average = 0;
			double sum = 0;
			for (Point point : c.getListPoints())
			{
				double distance = 0;
				distance = c.getMyCentroid().distance(point);
				sum = sum + distance;

			}
			average = sum / c.getNumPoints();
			averageDistance.add(average);
		}
		return averageDistance;
	}

	// Method: compute the average of a list of double
	// This is to compute the average distance across all the clusters
	public double averageCluster(List<Double> listAverage)
	{
		double finalAverage = 0;
		double sum = 0;
		for (Double d : listAverage)
		{
			sum = sum + d;
		}
		finalAverage = sum / listAverage.size();

		return finalAverage;
	}

	// Method: To output the metric for each iteration's result.
	// It will show the average distance across all the clusters, min, max distance
	public void allMetrics(List<Cluster> result)
	{
		List<Double> averageDistance = new ArrayList<>();
		for (Cluster c : result)
		{
			double average = 0;
			double sum = 0;
			for (Point point : c.getListPoints())
			{
				double distance = 0;
				distance = c.getMyCentroid().distance(point);
				sum = sum + distance;

			}
			average = sum / c.getNumPoints();
			averageDistance.add(average);
		}

		double finalAverage = 0;
		double sumF = 0;
		for (Double d : averageDistance)
		{
			sumF = sumF + d;
		}
		finalAverage = sumF / averageDistance.size();

		double max = 0;
		double min = 0;

		max = Collections.max(averageDistance);
		min = Collections.min(averageDistance);

		System.out.println("In this cluster iteration: The average distance of points to its centroid is: "
				+ finalAverage + ", with Max: " + max + " and Min: " + min);

	}

	// -----------------Below is getter and setter--------------
	public List<Cluster> getTestResult()
	{
		return testResult;
	}

	public void setTestResult(List<Cluster> testResult)
	{
		this.testResult = testResult;
	}

}
