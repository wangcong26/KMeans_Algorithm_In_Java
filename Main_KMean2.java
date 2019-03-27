package utils;

import java.util.ArrayList;
import java.util.List;

public class Main_KMean2
{
	/*
	 * I'm running Twist algo here to solve the toy problem. The output includes the
	 * metrics where it shows average distance to centroid across all the clusters.
	 * 
	 * In the homework assignment, it shows that the solution to toy problem is the
	 * center of a square with side length 100/sqrt(500) = ~ 4.5. So the centroid to
	 * the vertix would be 4.5/2*sqrt(2)=3.182.
	 * 
	 * Some thoughts on this algo: 
	 * 1) Given some dataset, it definitely takes manymore iterations to finally converge. 
	 * 2) Although the average distance issmaller than 3.182, 
	 * but it has much bigger standard deviations than standard KMean algorithm, with max exceeding 3.182
	 * 3) Although it's slow, it does seem to converge in the end. And we can see the total distance of movement 
	 * from initial state is getting smaller and smaller. So it this algo does improve the original quality of cluster.
	 */

	public static void main(String[] args)
	{
		// 1. Create a list of Point to store the dataset.
		// Note: the parameter is number of blocks. 99 * 99 blocks would generate
		// 100*100=10000 points.
		List<Point> myData = new ArrayList<>();
		KMeans2 kmeans2 = new KMeans2();
		myData = kmeans2.setDataset(99, 99);

		// 2. Created a Centroid object. The parameter needs to be the same as how we
		// set
		// up the dataset above.
		Centroid myInitialCents = new Centroid(99, 99);

		// 3. Select N number of points from dataset as the initial centroids.
		// We cannot pick a number of centroids that is more than the number of the
		// dataset.
		myInitialCents.SetFromPointListOrder(myData, 500);
		// myInitialCents.ShowCentroidsPointListOrder();

		// 4. Test the Kmean result. I store the result in a list of Cluster objects.
		// Note: need to specify number of point in each cluster.
		List<Cluster> showMe = new ArrayList<>();
		showMe = kmeans2.kMeans2(myInitialCents, myData, 20);

	}

}
