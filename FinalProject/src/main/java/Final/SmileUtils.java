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
	public static int[] encodeCategory(DataFrame df , String columnName) {
		String[] values = df.stringVector(columnName).distinct().toArray(new String[]{});
		int[] yearsEXP = df.stringVector(columnName).factorize(new NominalScale(values)).toIntArray();
		return yearsEXP;
	}

}
