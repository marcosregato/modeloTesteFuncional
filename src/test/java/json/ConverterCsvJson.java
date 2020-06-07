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
		
		
		/*

		JSONObject jsonObject = new JSONObject();
		//Inserting key-value pairs into the json object
		jsonObject.put("ID", "1");
		jsonObject.put("First_Name", "Shikhar");
		jsonObject.put("Last_Name", "Dhawan");
		jsonObject.put("Date_Of_Birth", "1981-12-05");
		jsonObject.put("Place_Of_Birth", "Delhi");
		jsonObject.put("Country", "India");
		try {
			FileWriter file = new FileWriter("./arquivoJSON/output.json");
			file.write(jsonObject.toJSONString());
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("JSON file created: "+jsonObject);
		*/
	}







public static void main(String[] args) throws Exception {

	ConverterCsvJson c = new ConverterCsvJson();
	c.gerandoJson();

	// File input = new File("./arquivoCSV/TC_001_PaginaPrincipal_29_05_2020_02_07.csv");
	//       File output = new File("./arquivoJSON/TC_001_PaginaPrincipal_29_05_2020_02_07.json");
	/*
        try {
            CsvSchema csv = CsvSchema.emptySchema().withHeader();
            CsvMapper csvMapper = new CsvMapper();
            MappingIterator<Map<?, ?>> mappingIterator =  csvMapper.reader().forType(Map.class).with(csv).readValues(input);
            List<Map<?, ?>> list = mappingIterator.readAll();
           System.out.println(list);
         } catch(Exception e) {
            e.printStackTrace();
         }
	 */

}

}
