package Final;

import org.apache.commons.lang3.StringUtils;
import org.apache.spark.api.java.JavaRDD;
import smile.data.DataFrame;
import smile.data.measure.NominalScale;
import smile.io.Read;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SmileUtils {
	private static final String COMMA_DELIMITER = ",";

	public DataFrame readCSV(String path) {
		DataFrame df = null;
		try {
			df = Read.csv(path);
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		return df;
	}

	public void getDataSummery(DataFrame data) {
		DataFrame summary = data.summary();
		System.out.println(summary);
		System.out.println(data.slice(0, 5));
	}

	public void getDataStructure(DataFrame data) {
		DataFrame structure = data.structure();
		System.out.println(structure);
	}

	public void processNullData(DataFrame data) {
		System.out.println("Number of Dataset rows is : " + data.nrows());
		DataFrame nonNullData = data.omitNullRows();
		System.out.println("Number of non Null rows is : " + nonNullData.nrows());
	}
	public static String extractCompany(String Column ) {
		try {
			return Column.split (COMMA_DELIMITER)[1];
		} catch (ArrayIndexOutOfBoundsException e) {
			return "";
		}
	}
	public void companiesJobsCount(JavaRDD<String> jobs){
		// Extract the Skills Column
		JavaRDD<String> skills = jobs.map(SmileUtils::extractCompany).filter(StringUtils::isNotBlank);
		/*  1- Transform the Skills to a list
			2- Convert the Words to Lower Case
			3- Remove the Pre and Post Spaces
			4- Replace every Punctuation to ""
			5- Split with the ""
			6- List Iterator
		* */
		JavaRDD<String> words = skills.flatMap(word -> Arrays.asList( word
				.toLowerCase()
				.trim()
				.split (",")).iterator ());
		System.out.println(words.toString ());
		// Count every word
		Map<String, Long> wordCounts = words.countByValue ();
		// map every word by its value
		List<Map.Entry> sorted = wordCounts.entrySet ().stream ()
				.sorted (Map.Entry.comparingByValue ()).collect (Collectors.toList ());
		// print the map
		for (Map.Entry entry : sorted) {
			System.out.println (entry.getKey () + " : " + entry.getValue ());
		}

	}




















	/* //////////////////////////////////////////////////////////////////////////////
	public Table loadDataFromCVS(String path) throws IOException {
		tech.tablesaw.api.Table wazzufData = tech.tablesaw.api.Table.read ().csv (path);
		return wazzufData;
	}
	public String getDataInfoStructure(tech.tablesaw.api.Table data) {
		tech.tablesaw.api.Table dataStructure = data.structure ();
		return dataStructure.toString ();
	}
	public String getDataSummary(tech.tablesaw.api.Table data) {
		Table summary = data.summary ();
		return summary.toString ();
	}
	*/


}
