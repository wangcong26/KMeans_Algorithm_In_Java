package utils;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* 
 * Cluster Class used to store one centroid with its corresponding points
 */
public class Cluster
{

	double xValue = 0;
	double yValue = 0;
	private Point myCentroid = new Point();
	private List<Point> listPoints = new ArrayList<>();
	private List<Cluster> listOfCluster = new ArrayList<>();
	private int numPoints = 0;

	// Constructor
	public Cluster()
	{

	}

	// Construtor
	public Cluster(Point centroid, List<Point> listOfPoints)
	{
		this.myCentroid.setX(centroid.getX());
		this.myCentroid.setY(centroid.getY());
		numPoints = listOfPoints.size();
		this.listPoints = listOfPoints;
	}

	// Method: Compute centroid
	public Point computeCentroid1()
	{
		// If the cluster's list of points is empty, it cannot compute centroid.
		if (listPoints.size() <= 0)
		{
			throw new RuntimeException("List doesn't have points");
		}
		double myX = 0;
		double myY = 0;
		double sumx = 0;
		double sumy = 0;

		for (int i = 0; i < listPoints.size(); i++)
		{
			sumx += listPoints.get(i).getX();
			sumy += listPoints.get(i).getY();
		}
		myX = sumx / listPoints.size();
		myY = sumy / listPoints.size();
		this.myCentroid = new Point(myX, myY);

		return myCentroid;
	}

	// --------------------------------------------------------------------------------------
	// Below is list of getters and setters
	public int getNumPoints()
	{
		return numPoints;
	}

	public void setNumPoints(int numPoints)
	{
		this.numPoints = numPoints;
	}

	public void setPList(Point p, List<Point> listP)
	{
		this.myCentroid = p;
		this.listPoints = listP;
		this.numPoints = listP.size();
	}

	public Point getMyCentroid()
	{
		return myCentroid;
	}

	public void setMycentroid(Point mycentroid)
	{
		this.myCentroid = mycentroid;
	}

	public List<Point> getListPoints()
	{
		return listPoints;
	}

	public void setListPoints(List<Point> listPoints)
	{
		this.listPoints = listPoints;
		this.numPoints = listPoints.size();
	}

	public List<Cluster> getListOfCluster()
	{
		return listOfCluster;
	}

	public void setListOfCluster(List<Cluster> listOfCluster)
	{
		this.listOfCluster = listOfCluster;
	}

	// ----------------------------------------------------------------
	// Below is a list of Show method
	// Method: Show Centroid point
	public void showCentroid()
	{
		System.out.println(myCentroid);
	}

	public void showListP()
	{
		for (Point p : listPoints)
		{
			System.out.println(p);
		}
	}

	// -------------------------------------------------------------------------------------
	// Method: see if two clusters are the same
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cluster other = (Cluster) obj;
		if (myCentroid == null)
		{
			if (other.myCentroid != null)
				return false;
		} else if (!myCentroid.equals(other.myCentroid))
			return false;
		return true;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((myCentroid == null) ? 0 : myCentroid.hashCode());
		return result;
	}

	@Override
	public String toString()
	{
		return "Cluster [numPoints=" + numPoints + ", myCentroid=" + myCentroid + ", listPoints=" + listPoints + "]";
	}
}
