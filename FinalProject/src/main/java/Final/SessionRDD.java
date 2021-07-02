package Final;

import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;


public class SessionRDD {
	public static void main(String[]args) {
		final SparkSession sparkSession = SparkSession.builder().appName("WAZZUF").master("local[6]").getOrCreate();
		final DataFrameReader dataFrameReader = sparkSession.read().option("header", true);
		Dataset<Row> wazzufData = dataFrameReader.csv("src\\main\\resources\\Wuzzuf_Jobs.csv");
		wazzufData.printSchema();
	}

}
