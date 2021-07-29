package Final;

import smile.data.DataFrame;
import smile.data.vector.IntVector;


import java.io.IOException;

import static Final.SmileUtils.encodeCategory;


public class WazzufSmile {

	public static void main (String[]args) throws IOException {
		SmileUtils smileUtil = new SmileUtils();
		/* load wazzuf dataset */
		DataFrame wazzufData =smileUtil.readCSV("src/main/resources/Wuzzuf_Jobs.csv");
		/* print the dataset summary */
		System.out.println("The Dataset Summary");
		System.out.println("------------------------------------------------------------");
		smileUtil.getDataSummery(wazzufData);
		System.in.read();
		/* print the dataset structure */
		System.out.println("The Dataset Structure");
		System.out.println("------------------------------------------------------------");
		smileUtil.getDataStructure(wazzufData);
		System.in.read();
		/* omit null rows */
		System.out.println("Clean Null Rows");
		System.out.println("------------------------------------------------------------");
		smileUtil.processNullData(wazzufData);
//		wazzufData = wazzufData.merge(IntVector.of("YearsExp Value",encodeCategory(wazzufData,"YearsExp")));
//		smileUtil.getDataStructure(wazzufData);


}
}