package Final;

import org.apache.spark.api.java.JavaRDD;
import smile.data.DataFrame;
import tech.tablesaw.api.Table;

import javax.annotation.processing.SupportedSourceVersion;
import java.io.IOException;
import java.util.List;

public class WazzufSmile {


/*	public static void main (String[] args){
		Utilities util = new Utilities();
		SmileUtils smileUtils = new SmileUtils();
		try {
			// Load the dataset
			Table wazzufData =smileUtils.loadDataFromCVS("C:\\ITI\\Java\\FINAL PROJECT\\Wuzzuf_Jobs.csv");
			// Print the data structure
			String structure =smileUtils.getDataInfoStructure(wazzufData);
			System.out.println(structure);
			System.in.read ();
			// Print the summary
			String summary = smileUtils.getDataSummary(wazzufData);
			System.out.println(summary);
			System.in.read ();
			// Remove duplicates
			wazzufData.stream().distinct();
			System.out.println(wazzufData.stream().count());
		}catch (Exception e ){
			e.printStackTrace();
		}
	}
}
*/
public static void main (String[]args) throws IOException {
	SmileUtils smileUtil = new SmileUtils();
	/* load wazzuf dataset */
	DataFrame wazzufData =smileUtil.readCSV("C:\\ITI\\Java\\FINAL PROJECT\\Wuzzuf_Jobs.csv");
	/* print the dataset summary */
	smileUtil.getDataSummery(wazzufData);
	/* print the dataset structure */
	smileUtil.getDataStructure(wazzufData);
	/* omit null rows */
	smileUtil.processNullData(wazzufData);



}
}