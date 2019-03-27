package utils;

import java.lang.Math;
import java.util.List;


// Create a Point class that will be used in this project
// It has two coordinates: x and y.
public class Point implements Comparable<Point>
{
	// Field: I include a distance that can be used to show distance between point to centroid.
	double x;
	double y;
	double distance;

	// default constructor
	Point()
	{
		x = 0.0;
		y = 0.0;
	}

	// Constructor
	public Point(double xVal, double yVal)
	{
		x = xVal;
		y = yVal;
	}

	// Copy constructor
	Point(Point oldPoint)
	{
		x = oldPoint.x;
		y = oldPoint.y;
	}

	// Setter for distance
	public void setDistance(double distance)
	{
		this.distance = distance;
	}

	// Compare two points to see if they are the same points
	public int compareTo(Point newP)
	{
		if (x < newP.x)
			return -1;
		else if ((x == newP.x) && (y < newP.y))
			return -1;
		else if ((x == newP.x) && (y == newP.y))
			return 0;
		else
			return 1;
	}

	// hashCode
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	// Modified the equals method's precision to be 0.0001.
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (Math.abs(x - other.x) > 0.0001)
			return false;
		if (Math.abs(y - other.y) > 0.0001)
			return false;

		/*
		 * Modify the following code if (Double.doubleToLongBits(x) !=
		 * Double.doubleToLongBits(other.x)) return false; if
		 * (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y)) return
		 * false;
		 */

		return true;
	}

	// Compute distance from another point
	double distance(final Point aPoint)
	{
		return Math.sqrt(Math.pow(x - aPoint.x, 2) + Math.pow(y - aPoint.y, 2));
	}

	// Getter and setters
	public double getX()
	{
		return x;
	}

	public void setX(double x)
	{
		this.x = x;
	}

	public double getY()
	{
		return y;
	}

	public void setY(double y)
	{
		this.y = y;
	}

	// To show the point
	public String toString()
	{
		// I could choose to show the distance when computing Kmean. The distance from point to centroids
		return ("(" + String.valueOf(x) + ", " + String.valueOf(y) + ")");// ", " + distance +
	}

}
