package utils;

import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KMeans2
{
	// Fields
	private Set<Cluster> clusterList = new HashSet<>();
	private List<Point> initialCentroids = new ArrayList<>();
	private List<Point> myDataset = new ArrayList<>();// used as my dataset
	private List<Integer> pointIndexList = new ArrayList<>();

	// Constructor
	KMeans2()
	{

	}

	// Constructor
	KMeans2(List<Point> myInitialCents, List<Point> myData)
	{
		initialCentroids = myInitialCents;
		myDataset = myData;
	}

	// Method #1: Algorithm to return the list of Cluster
	// This is the twist of the standard algorithm that each centroid seeking its
	// closest
	// N points from the dataset.
	// In this case, number of centroids * number of its points = total number of
	// points in the dataset
	public List<Cluster> kMeans2(Centroid initialOld, List<Point> myDataset, int nElements)
	{

		// Will return a list of Cluster objects
		List<Cluster> results = new ArrayList<>();
		// Used to output the metrics
		Fitness eval = new Fitness();
		// Need to make a copy of the dataset.
		List<Point> copyDataset = new ArrayList<>(myDataset);

		// Read in initial centroids and assign them into the list of Cluster's Point
		for (Point cPoint : initialOld.getinitialFromPointListOrder())
		{
			Cluster tempC = new Cluster();
			tempC.setMycentroid(cPoint);
			results.add(tempC);
		}

		// Compute the distance from each centroid to all the points in the dataset
		for (Point cPoint : initialOld.getinitialFromPointListOrder())
		{
			// After assigning nearest K points, we have to drop/delete these points from
			// the dataset until dataset is empty.
			if (copyDataset.size() <= 0)
				break;

			// Store the distance in a Map and use the Point as the key since it doesnt have
			// duplicates.
			Map<Point, Double> myDistance = new Hashtable<>();

			// For each point in the dataset, compute the distance from the first centroid
			// Store distance in a map
			for (Point p : copyDataset)
			{
				double distanceTwoP = 0;
				distanceTwoP = cPoint.distance(p);
				myDistance.put(p, distanceTwoP);
			}

			// Sort the map by its value from smallest to highest.
			Map<Point, Double> sorted = myDistance.entrySet().stream().sorted(Map.Entry.comparingByValue())
					.collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));

			// Store the first K smallest points to a list of Point and assign it to the
			// list of Cluster
			List<Point> tempList = storeNpoints(sorted, nElements);
			for (Cluster myC : results)
			{
				if (cPoint.equals(myC.getMyCentroid()))
					myC.setListPoints(tempList);
			}
			removeListPoints(tempList, copyDataset);
		}

		// I want to print it out to see each Cluster object in the list, if needed
//		for (Cluster c : results)
//		{
//			System.out.println(c.toString());
//		}

		// Create a new Centroid object to store the new list of centroids
		Centroid initialNew = new Centroid();
		for (Cluster myC : results)
		{
			Point temp = null;
			temp = myC.computeCentroid1();
			initialNew.getinitialFromPointListOrder().add(temp);
		}

		//initialNew.getinitialFromPointListOrder();

		// Compute distance until it's smaller than a value.
		// I print out the total distance of each movement to see how it converges.
		double n = 0;
		n = computeSumDistance(initialOld.getinitialFromPointListOrder(), initialNew.getinitialFromPointListOrder());
		System.out.println("The total distance of movement of Centroids is: "+n);
		
		// Use Fitness class to output the metrics of the clustering result
		eval.allMetrics(results);
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");

		
		// I set if the total distance is below 1, lets stop the algorithm. 
		// I found that it'll eventually converge but will take much longer time than standard Kmean when dataset is large.
		// When dataset is small, it converges faster but still slower than standard Kmean.
		// When we use 10000 point to test, we can use 10 as the value.
		if (n < 1) 
			return results;
		
		// Use recursive way to call the method.
		return kMeans2(initialNew, myDataset, nElements);
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
		System.out.println("Old size " + oldCentroids.size() + " New size " + newCentroids.size());
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
	// It is used to determine when to stop the algorithm.
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

	// Method #6: Store first N points from a map.
	public List<Point> storeNpoints(Map<Point, Double> sorted, int n)
	{
		List<Point> mylist = new ArrayList<>();
		int count = 0;
		Iterator<Map.Entry<Point, Double>> itr = sorted.entrySet().iterator();
		while (count < n && itr.hasNext())
		{
			Map.Entry<Point, Double> entry = itr.next();
			mylist.add(entry.getKey());
			count++;
		}
		return mylist;
	}

	// Method #7: delete the point list from a dataset.
	public List<Point> removeListPoints(List<Point> centroidList, List<Point> dataset)
	{
		// List<Point> copyDataset = new ArrayList<>(dataset);
		for (Point p : centroidList)
		{
			dataset.remove(dataset.indexOf(p));
		}
		return dataset;
	}

	// ---------------------------------------Below is a lit of getters and
	// setters---------------------------------------------------------------
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

	// ---------------------------------------Below is a list of Show method to see
	// what's inside -----------------------------------------------
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

