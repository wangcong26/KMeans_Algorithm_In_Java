package utils;

import java.util.ArrayList;
import java.util.List;

public class Main_KMean
{
	/*
	 * I'm running standard Kmean algo here to solve the toy problem. The output
	 * includes the metrics where it shows average distance to centroid across all
	 * the clusters.
	 * 
	 * In the homework assignment, it shows that the solution to toy problem is the
	 * center of a square with side length 100/sqrt(500) = ~ 4.5. So the 
	 * centroid to the vertix would be 4.5/2*sqrt(2)=3.182.
	 * 
	 * 
	 * Some thoughts on this algo: 
	 * 1) Given some dataset, it definitely converges fast. 
	 * 2) In my output, we can see that the max distance from point to centroid is smaller than 3.182.
	 * And the max is smaller than 3.182. So it looks pretty good.
	 * 3) And we can see the total distance of movement 
	 * from initial state is getting smaller and smaller. 
	 * So it this algo does improve the original quality of cluster.
	 */

	public static void main(String[] args)
	{
		// 1. Create a list of Point to store the dataset.
		// Note: the parameter is number of blocks. 99 * 99 blocks would generate
		// 100*100=10000 points.
		KMeans kmeans = new KMeans();
		List<Point> myData = new ArrayList<>();
		myData = kmeans.setDataset(99, 99);

		// 2. Created a Centroid object. The parameter needs to be the same as how we
		// set
		// up the dataset above.
		Centroid myInitialCents = new Centroid(99, 99);

		// 3. Select N number of points from dataset as the initial centroids.
		myInitialCents.SetFromPointListOrder(myData, 500);
		myInitialCents.ShowCentroidsPointListOrder(); // Show the initial centroids

		// 4. Test the Kmean result. I store the result in a list of Cluster objects.
		List<Cluster> showMe = new ArrayList<>();
		showMe = kmeans.kMeans(myInitialCents, myData);

		// Show the final cluster result if needed.
//		for (Cluster c : showMe)
//		{
//			System.out.println(c.toString());
//		}

	}

}
