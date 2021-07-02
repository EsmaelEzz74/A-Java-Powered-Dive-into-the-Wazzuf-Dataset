package Final;

import org.apache.spark.SparkConf;

import java.awt.*;
import java.io.IOException;
import java.util.Map;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.knowm.xchart.*;

public class Wazzuf {

	public static void main(String[] args) throws IOException {
		Logger.getLogger("org").setLevel(Level.ERROR);
		// CREATE SPARK CONTEXT
		SparkConf conf = new SparkConf().setAppName("WAZZUF").setMaster("local[3]");
		JavaSparkContext sparkContext = new JavaSparkContext(conf);
		// LOAD DATASET
		JavaRDD<String> jobs = sparkContext.textFile("src\\main\\resources\\Wuzzuf_Jobs.csv");
//		/* 3- Cleaning the data */
////		Utilities.processDistinctRows(jobs);
		/* 4- Count the Job of each Company  */
		System.out.println("Count the Job of each Company");
		System.out.println("------------------------------------------------------------------------------------");
		Utilities.companyCount(jobs);
		System.in.read();
		/* 6- the Most Popular Job Title */
		System.out.println("The Most Popular Job Title");
		System.out.println("------------------------------------------------------------------------------------");
		Utilities.titleCount(jobs);
		System.in.read();
		/* 8- the Most Popular Areas */
		System.out.println("The Most Popular Areas");
		System.out.println("------------------------------------------------------------------------------------");
		Utilities.locationCount(jobs);
		System.in.read();
		/* 10- the Most Important Skills Required   */
		System.out.println("The Most Important Skills Required");
		System.out.println("------------------------------------------------------------------------------------");
		Utilities.skillsCount(jobs);
		System.in.read();
		JavaRDD<String> title = Utilities.extractTitleColumn(jobs);
		JavaRDD<String> location = Utilities.extractLocationColumn(jobs);
		Utilities.columnBarChart(title,"Jobs Title","Title","Count","Company Title");
		System.in.read();
		Utilities.columnBarChart(location,"Jobs Location","Location","Count","Company Location");
		System.in.read();
		Utilities.companyPieChart(jobs);

	}


}
