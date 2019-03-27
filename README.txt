# KMeans Algorithm project
# To develop and implement KMean and KMean2 algorithm to solve toy problem.

#1. How to run the code:
I developed this project in the Eclipse. In this submission (after unzip), you will see two folders: 
	1) src. Under this file, it has another folder called "utils" which is the package name. Under "utils", it has 9 Java files (or 9 Classes); two of these 9 files are main functions that are used to run the 	two algoritms, respectively. I will explain which Class is for what purpose later.
	2) junit. Under this file, it has another folder called "utils" which is the package name. Under "utils", it also 7 Java files. These are Junit test for the corresponding 7 Classes from the "src" folder.

After importing these source files to Eclipse, you can run the two Main Classes under "src", respectively. They are called "Main_KMean" and "Main_KMean2". And I showed my evaluation of the solution in these two files as well.



#2. Explanation of the Classes:

In this project, I wrote 7 Classes as below. For each method within the Class, please see my comments in the Java file. 

1) Centroid: 
This Class is mainly used to generate the initial list of Centroid points.

2) Cluster: 
This Class include one integer which indicates how many Points it has in this cluster. 
Also it has a list of Points, stored as List<Point>. The solution of the algorithm would be a list of Cluster objects.

3) Fitness: 
This Class includes a few metrics to evaluate the quality of solution and initial state. It has methods to compute the average distance of all the points to their centroid. Also, it shows the average distance across a list of clusters. And I use this to compare the standard solution of toy problem to see if the algorithm does a good job.

4) GenerateDataset:
This Class can be used to generate the dataset which has a list of points for the toy problem.

5) KMeans:
This Class is the main algorithm of standard KMean.

6) KMeans2:
This Class is the main algorithm of twist of the standard KMean.

7) Point:
This Class is the Point Class used to represent each point. Each point has two coordinates: x and y.

There are two additional Class under "src" folder, They are called "Main_KMean" and "Main_KMean2". They are just the main functions used to run the algorithms and I wrote my analysis/conclusion in the commentary area.



#3. Explanation of the Junit Test.
For each of the 1) to 7) in #2, I wrote corresponding unit test under the folder "junit". There are 7 unit tests. I explain the details and what tests I did in each of these Java files.
	



