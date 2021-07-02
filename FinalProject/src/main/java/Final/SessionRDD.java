package Final;

import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.ml.feature.VectorAssembler;
import org.apache.spark.ml.regression.LinearRegression;
import org.apache.spark.ml.regression.LinearRegressionModel;
import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SessionRDD {
	public static void main(String[]args) {
		final SparkSession sparkSession = SparkSession.builder().appName("WAZZUF").master("local[6]").getOrCreate();
		final DataFrameReader dataFrameReader = sparkSession.read().option("header", true);
		Dataset<Row> wazzufData = dataFrameReader.csv("C:\\ITI\\Java\\FINAL PROJECT\\Wuzzuf_Jobs.csv");
		wazzufData.printSchema();
	}

}
