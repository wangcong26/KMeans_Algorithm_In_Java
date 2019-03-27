package utils;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import utils.GenerateDataset;
import utils.Point;

public class Test_GenerateDataset extends TestCase
{
	public void testGenerateDataset()
	{
		//#1. Create a object of GenerateDataset by entering the number of blocks.
		GenerateDataset myDataset = new GenerateDataset();
		List<Point> mydata = new ArrayList<>();
		mydata = myDataset.setDataset(4, 4);

		//#2. Test if 99 blocks by 99 blocks generates 10000 points.
		assertTrue(mydata.size() == 25);

		//#3. Test when entering negtive number of blocks.
		// It throws an illegal exception that the number cannot be less than 1.
		Exception error = null;
		try
		{
			myDataset.setDataset(-4, 1);
		} catch (Exception e)
		{
			error = e;
		}
		assertTrue(error != null);

		//#4. Print out the points in the dataset
		myDataset.showPoints();
	}

}
