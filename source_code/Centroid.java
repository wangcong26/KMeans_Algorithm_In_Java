package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/*
 * In this Class, I wrote two types of method to generate initial centroids
 * 1) Random. Within the range of dataset (e.g., 10000 points), randomly generate N points. X, Y doesn't need to be integer
 * 2) Forgy. From the dataset (e.g., 1000 points), randomly select N points. X, Y would be integer.
 */

public class Centroid
{
	// Fields:
	private int rows; // This is number of blocks of one side.
	private int cols; // This is number of blocks of the other side.

	// Centroids with random value for Point, within dataset range.
	private List<Point> initialRandomCentroids = new ArrayList<>();
	private List<Point> initialFromPointListOrder = new ArrayList<>(); // Centroids from dataset, integer for x,y.

	// Constructor
	public Centroid()
	{

	}

	// Constructor
	public Centroid(int rows, int cols)
	{
		this.rows = rows;
		this.cols = cols;
	}

	// Constructor
	public Centroid(List<Point> initialCentroids)
	{
		this.initialFromPointListOrder = initialCentroids;
		this.initialRandomCentroids = initialCentroids;

	}

	// Method #1 Set n random points with both x and y are double. x, y cannot be greater than rows or cols.
	// x,y can be with decimal place
	public int SetInitialCentroids(int n)
	{
		// Throw an exception that it cannot be a negative or zero
		if (n <= 1)
			throw new IllegalArgumentException("The number needs to be greater than 1");

		// Use randome Class.
		Random randomCoordinate = new Random();
		while (initialRandomCentroids.size() < n)
		{
			double x = randomCoordinate.nextDouble() * rows; // make sure the x value wont be greater than rows.
			double y = randomCoordinate.nextDouble() * cols; // make sure the y value wont be greater than cols.
			Point p = new Point(x, y);
			initialRandomCentroids.add(p);
		}

		return initialRandomCentroids.size();
	}


	// Method #2: Generate inital centroids from the dataset. Point coordinates are
	// integers
	public int SetFromPointListOrder(List<Point> listPoints, int pickNumberPoints)
	{
		// The number of points we pick must be less or equal to the number of points in
		// the dataset.
		if (pickNumberPoints > listPoints.size())
		{
			throw new IndexOutOfBoundsException("Number of Points picked cannot be greater than the size of dataset");
		}

		// Randomly pick n points from the dataset and make sure they are unique!
		// If randomly pick two duplicates, we need to pick another one until it has
		// pickNumberPoints in the centroid set.
		Random randomPointIndex = new Random();
		List<Point> randomPointList = new ArrayList<>();
		HashSet<Integer> randomNumbers = new HashSet<Integer>();

		while (initialFromPointListOrder.size() < pickNumberPoints)
		{
			Point pickPoint = null;
			int pickIndex = randomPointIndex.nextInt(listPoints.size());
			if (!initialFromPointListOrder.contains(listPoints.get(pickIndex))) // Make sure they are unique!
			{
				initialFromPointListOrder.add(listPoints.get(pickIndex));
			}
		}

		return initialFromPointListOrder.size();
	}

	//--------------Below is a list of Show method-------------------------------------
	// Method #3: show the list of centroids
	public void ShowRandomCentroids()
	{
		for (Point mypoint : initialRandomCentroids)
		{
			System.out.println(mypoint);
		}
	}
	
	// Method #4: show the list of centroids
	public void ShowCentroidsPointListOrder()
	{
		for (Point mypoint : initialFromPointListOrder)
		{
			System.out.println(mypoint);
		}
	}

	//--------------Below is a list of getter and setters-------------------------------------
	// return a list to control order
	public List<Point> getinitialFromPointListOrder()
	{
		return initialFromPointListOrder;
	}
	
	public List<Point> getRandomCentroids()
	{
		return initialRandomCentroids;
	}
}
