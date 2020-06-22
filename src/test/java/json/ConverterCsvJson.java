package json;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConverterCsvJson {

	String pathCSV ="./arquivoCSV/TC_001_PaginaPrincipal_02_06_2020_02_08.csv";

	public void gerandoJson() {

		try {
			Scanner sc = new Scanner(new File(pathCSV));
			sc.useDelimiter(",");
			while (sc.hasNext()) {
				System.out.println(sc.next());
			}
			sc.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		ConverterCsvJson c = new ConverterCsvJson();
		c.gerandoJson();
	}
}
