package json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ConverterCsvJson {

	String pathCSV ="../modeloTesteFuncional/FERRAMENTA_TESTE/TC_001_PaginaPrincipal_25_06_2020_02_58.csv";
	
	/***
	 * 
	 * @throws IOException
	 */
	/*public void postApiQACliente() throws Exception {
		FileImageInputStream arquivoJson = new FileImageInputStream(new File(""));
		RestAssured.baseURI="http://localhost:8080/api/clientes";
		given()
			.header("Content-Type","application/json")
		.and()
		.	body(IOUtils.toString(arquivoJson,"UTF-8"))
		.whew()
		.	post("/post")
		.then()
			.statusCode(201);
	}*/
	
	public JSONObject  getPerson(String status, String hora,String nomeMetodo,String data,String id){
		JSONObject person = new JSONObject();
		person .put("Status", status);
		person .put("Hora", hora);
		person .put("Nome Metodo", nomeMetodo);
		person .put("data", data);
		person .put("id", id);
		return person ;
	} 

	@SuppressWarnings("resource")
	public String criarJson() {

		BufferedReader br = null;
		String line = "";

		try {
			
			br = new BufferedReader(new FileReader(pathCSV));
			JSONObject jsonObject = new JSONObject();
			JSONArray jsonArray = new JSONArray();
			while ((line = br.readLine()) != null) {

				String[] cell = line.split(",");
				
				jsonArray.put(getPerson(cell[0],cell[1],cell[2],cell[3],cell[4]));
			    
				//jo.put("ID", cell[0].trim());
				//jo.put("Status", cell[1].trim());
				//jo.put("Data", cell[2].trim());
				//jo.put("Hora", cell[3].trim());
				//jo.put("Nome Metodo", cell[4]);

			}
		    return String.valueOf(jsonObject.put("clinete", jsonArray));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void main(String... asd) {
		ConverterCsvJson c  = new ConverterCsvJson();
		System.out.println(c.criarJson());
	}
}