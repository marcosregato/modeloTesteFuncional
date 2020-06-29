package json;

import static io.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.restassured.RestAssured;
import relatorio.ManipularCsv;
import util.Utilidade;


public class ConverterCsvJson {

	String pathCSV ="../modeloTesteFuncional/FERRAMENTA_TESTE/TC_001_PaginaPrincipal_25_06_2020_16_24.csv";
	private Utilidade util = new Utilidade();
	ManipularCsv manipularCsv = new ManipularCsv(); 
	
	/***
	 * 
	 * @throws IOException
	 */
	public void postApiQACliente() throws Exception {
		FileInputStream arquivoJson = new FileInputStream(new File(util.pathDiretorioArquivo("arquivoJSON")+"arquivo.json"));
		RestAssured.baseURI="http://localhost:8080/api/clientes";
		given()
			.header("Content-Type","application/json")
			.and()
			.body(IOUtils.toString(arquivoJson,"UTF_8"))
		.when()
			.post("/post")
		.then()
			.statusCode(201);
	}
	
	public JSONObject  getArquivoJson(String status, String hora,String nomeMetodo,String data){
		JSONObject person = new JSONObject();
		person .put("Status", status);
		person .put("Hora", hora);
		person .put("Nome Metodo", nomeMetodo);
		person .put("data", data);
		return person ;
	} 

	public void criarJson() {

		BufferedReader br = null;
		String line = "";

		try {
			//manipularCsv.getUltimoArquivoCsv()
			br = new BufferedReader(new FileReader(manipularCsv.getUltimoArquivoCsv()));
			JSONObject jsonObject = new JSONObject();
			JSONArray jsonArray = new JSONArray();
			while ((line = br.readLine()) != null) {

				String[] cell = line.split(",");
				jsonArray.put(getArquivoJson(cell[0],cell[1],cell[2],cell[3]));
			}
		    
			String json = String.valueOf(jsonObject.put("clinete", jsonArray));
			FileWriter fileWriter = new FileWriter(util.pathDiretorioArquivo("arquivoJSON")+"arquivo.json");
			fileWriter.write(json);
			fileWriter.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

	public static void main(String... asd) {
		ConverterCsvJson c  = new ConverterCsvJson();
		c.criarJson();
	}
}