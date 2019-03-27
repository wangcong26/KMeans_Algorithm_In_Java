package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KMeans
{
	// Fields
	// Used for storing a list of Cluster objects.
	private List<Cluster> clusterList = new ArrayList<>();
	// Used for storing the dataset when needed.
	private List<Point> myDataset = new ArrayList<>();

	// Constructor
	KMeans()
	{

	}

	// Constructor
	KMeans(List<Point> myData)
	{
		myDataset = myData;
	}

	// Method #1: Algorithm to return the list of Cluster
	// Need to enter a Centroid object and dataset to the method.
	public List<Cluster> kMeans(Centroid initialOld, List<Point> myDataset)
	{
		// I made a list of Cluster object used to return the result.
		List<Cluster> results = new ArrayList<>();
	
		// Used to output the metrics
		Fitness eval = new Fitness();
		
		// Assign the initial centroids to the list of Cluster "result"
		for (Point cPoint : initialOld.getinitialFromPointListOrder())
		{
			Cluster tempC = new Cluster();
			tempC.setMycentroid(cPoint);
			results.add(tempC);
		}

		// Each point seeks its nearest centroid
		for (Point p : myDataset)
		{
			Point closestCentroid = null;
			double minDistance = Double.MAX_VALUE;
			
			for (Point cPoint : initialOld.getinitialFromPointListOrder())
			{
				double currentDistance = 0;
				currentDistance = p.distance(cPoint);
				
				// Find which centroid the point is closest to.
				if (currentDistance < minDistance)
				{
					minDistance = currentDistance;
					closestCentroid = cPoint;
					p.setDistance(minDistance);
				}
			}

			// Store the point from dataset to its corresponding cluster
			for (Cluster myC : results)
			{
				if (closestCentroid.equals(myC.getMyCentroid()))
				{
					myC.getListPoints().add(p);
					myC.setNumPoints(myC.getNumPoints()+1);
				}
				
			}
		}

		// Create a new list of centroid used to compare with the old one.
		Centroid initialNew = new Centroid();
		for (Cluster c : results)
		{
			Point temp = null;
			temp = c.computeCentroid1();
			initialNew.getinitialFromPointListOrder().add(temp);
			
		}
		
		// Compute the total distance of each movement of the centroids. 
		// Standard Kmean algorithm converges fast, so I can ask it to stop when old list is equal to the new list of centroid
		// Print out total distance for each movement to observe how it converges.
		double n = 0;
		n = computeSumDistance(initialOld.getinitialFromPointListOrder(), initialNew.getinitialFromPointListOrder());
		System.out.println("The total distance of movement of Centroids is: "+n);
		
		// Use Fitness class to output the metrics of the clustering result
		eval.allMetrics(results);
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
		
		if (compareCentroids(initialOld.getinitialFromPointListOrder(), initialNew.getinitialFromPointListOrder()))
			return results;
		
		// Use recursive way to call this method itself until it converges.
		return kMeans(initialNew, myDataset);

	}

	// Method #2: Generate dataset
	public List<Point> setDataset(int m, int n)
	{
		// Throw an exception that it cannot be a negative or zero value.
		if (m <= 0 || n <= 0)
			throw new IllegalArgumentException("Both two numbers of blocks have to be greater than 1");

		// Generate the dataset.
		// m, n here is the number of blocks for each side.
		// For example, if it's 9 block by 9 blocks, it will have 10*10=100 Points in the dataset.
		for (int i = 0; i <= m; i++)
		{
			for (int j = 0; j <= n; j++)
			{
				Point myPoint = new Point(i, j);
				myDataset.add(myPoint);
			}
		}
		return myDataset;
	}

	// Method #3: Compute the sum of movement of two sets of centroids.
	// It is used to determine when to stop the algorithm.
	public double computeSumDistance(List<Point> oldCentroids, List<Point> newCentroids)
	{
		// I want to print out the size of old and new list of Centroids. The size should be the same.
		System.out.println("Number of old centroids " + oldCentroids.size() + " Number of new centroids " + newCentroids.size());
		double sumDistance = 0;
		
		// Throw an expection if the size of old and new is different.
		if (oldCentroids.size() != newCentroids.size())
		{
			throw new RuntimeException("No expected exception encoutered!");
		}
		
		// Iterator to iterate every element to compute the distance.
		Iterator<Point> oldIter = oldCentroids.iterator();
		Iterator<Point> newIter = newCentroids.iterator();
		while (oldIter.hasNext() && newIter.hasNext())
		{
			sumDistance = sumDistance + oldIter.next().distance(newIter.next());
		}

		return sumDistance;
	}

	// Method #4: Compare if two sets of centroids (old vs new) are the same.
	// It is used to determine when to stop the algorithm in the standard Kmean.
	public boolean compareCentroids(List<Point> oldCentroids, List<Point> newCentroids)
	{
		if (oldCentroids.size() != newCentroids.size())
		{
			throw new RuntimeException("No expected exception encoutered!");
		}
		Iterator<Point> oldIter = oldCentroids.iterator();
		Iterator<Point> newIter = newCentroids.iterator();
		while (oldIter.hasNext() && newIter.hasNext())
		{
			if (!oldIter.next().equals(newIter.next()))
				return false;
		}
		return true;
	}

	// ---------------------------------------Below is a lit of getters and setters---------------------------------------------------------------
	// Method #5: getter to get myDataset
	public List<Point> getMyDataset()
	{
		return myDataset;
	}

	// Method #6: setter to set myDataset
	public void setMyDataset(List<Point> myDataset)
	{
		this.myDataset = myDataset;
	}

	// ---------------------------------------Below is a list of Show method to see what's inside -----------------------------------------------
	// Method #7: to display point in myDataset
	public void showPoints()
	{
		for (Point mypoint : myDataset)
		{
			System.out.println(mypoint);
		}
		System.out.println("The number of points is: " + myDataset.size());
	}

	// Method #8: to display the list of cluster
	public void showCluster()
	{
		for (Cluster myCluster : clusterList)
		{
			System.out.println(myCluster);
		}
	}
}
