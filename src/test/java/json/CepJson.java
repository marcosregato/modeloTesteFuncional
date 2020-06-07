package json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class CepJson {
	
	public void getCepJson(String numetoCEP) throws ClientProtocolException, IOException{

		try {
			String jsonS = "";
			URL url = new URL("https://viacep.com.br/ws/"+numetoCEP+"/json/");
			URLConnection conn = url.openConnection();
			conn.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;

			while((inputLine = in.readLine()) != null) {
				jsonS+=inputLine;
			}

			Gson gson = new Gson();
			JsonObject jsonObject= gson.fromJson(jsonS, JsonObject.class);
			String cep = jsonObject.get("cep").getAsString();
			String logradouro = jsonObject.get("logradouro").getAsString();
			String complemento = jsonObject.get("complemento").getAsString();
			String bairro = jsonObject.get("bairro").getAsString();
			String localidade = jsonObject.get("localidade").getAsString();
			String uf = jsonObject.get("uf").getAsString();
			String unidade = jsonObject.get("unidade").getAsString();
			String gia = jsonObject.get("gia").getAsString();

			System.out.println(cep+" "+logradouro+" "+complemento+" "+bairro+" "+localidade+" "+uf+" "+unidade+" "+gia+" "+cep);

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}