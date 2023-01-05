import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.csv.*;

public class MyCSVConverter {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		// Read
		Reader in = new FileReader("sample_items2.csv");
		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);

		// Write
		FileWriter out = new FileWriter("answer.csv");
		CSVPrinter printer = new CSVPrinter(out, CSVFormat.EXCEL);

		for (CSVRecord record : records) {

			for (int i = 0; i < 35; i++) {
				if(i == 4) {
					printer.print(record.get(5));
				} else if (i == 5) {
					printer.print(record.get(4));
				}else {
					printer.print(record.get(i));
				}
			}
			//換行
			printer.println();
		}
		printer.flush();
		printer.close();
	}
}
