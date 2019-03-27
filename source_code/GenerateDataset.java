package utils;

import java.util.ArrayList;
import java.util.List;

// Generate the Toy problem dataset.
// It can be kept in the project, although I include this method in the two algorithms KMeans as well
public class GenerateDataset
{
	// Field: need an arraylist to store a list of Points
	private List<Point> myDataset = new ArrayList<>();

	// Method: return a list of Points as our dataset. Coordinate is integer.
	// Also, m, n are number of blocks. For example, 9 x 9 blocks would be 10*10=100
	// points
	public List<Point> setDataset(int m, int n)
	{
		// Throw an exception that it cannot be a negative or zero value.
		if (m <= 0 || n <= 0)
			throw new IllegalArgumentException("Both two numbers of blocks have to be greater than 1");

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

	// Getter and setter
	public List<Point> getMyDataset()
	{
		return myDataset;
	}

	public void setMyDataset(List<Point> myDataset)
	{
		this.myDataset = myDataset;
	}

	// Show method
	public void showPoints()
	{
		for (Point mypoint : myDataset)
		{
			System.out.println(mypoint);
		}
		System.out.println("The number of points is: " + myDataset.size());
	}
}
