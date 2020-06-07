package relatorio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import config.ConfigProperties;

public class ManipularCsv {

	String sistemaOperacional = System.getProperty("os.name");
	String nomeUsuario = System.getProperty("user.name");

	static String path = System.getProperty("user.dir");

	//private String pathArquivoWind = "C:\\FERRAMENTA_TESTE\\logsCSV\\";
	private String pathArquivoWind = "C:\\Users\\"+nomeUsuario+"\\Documents\\FERRAMENTA_TESTE\\logsCSV\\";
	private String pathArquivoLinux = "/home/"+nomeUsuario+"/FERRAMENTA_TESTE/logsCSV/";

	Process proc;
	public void criarDiretorio() {
		try {
			if(sistemaOperacional.contains("Windows")) {
				Runtime rt = Runtime.getRuntime();
				proc = rt.exec("cmd.exe /c "+path+ConfigProperties.getProperty("estrutura.diretorio.windows"));
			}else {
				Runtime rt = Runtime.getRuntime();
				proc = rt.exec(path+ConfigProperties.getProperty("estrutura.diretorio.linux"));
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void criarRelatorioCsv(String nomeClass) {
		try {
			Date dataHoraAtual = new Date();
			String data = new SimpleDateFormat("dd_MM_yyyy").format(dataHoraAtual);
			String horario = new SimpleDateFormat("HH_mm").format(dataHoraAtual);
			if(sistemaOperacional.contains("Windows")) {
				BufferedWriter pw = new BufferedWriter(new FileWriter(pathArquivoWind+ nomeClass + "_" + "" + data + "_"+horario+".csv"));
				String array = "Status,Data,Hora,Nome Metodo, Mensagem Erro";
				pw.append(array);
				pw.append("\n");
				pw.close();
			}else {
				BufferedWriter pw = new BufferedWriter(new FileWriter(pathArquivoLinux+ nomeClass + "_" + "" + data + "_"+horario+".csv"));
				String array = "Status,Data,Hora,Nome Metodo, Mensagem Erro";
				pw.append(array);
				pw.append("\n");	
				pw.close();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void escreverCsv(String nomeMetodo, String status) {
		try {
			Date dataHoraAtual = new Date();
			String data = new SimpleDateFormat("dd-MM-yyyy").format(dataHoraAtual);
			String hora = new SimpleDateFormat("HH:mm").format(dataHoraAtual);

			File arquivoWindows = new File(pathArquivoWind+getUltimoArquivoCsv());
			File arquivoLinux = new File(pathArquivoLinux+getUltimoArquivoCsv());
			String linha = status + "," + data + "," + hora + "," + nomeMetodo;
			
			PrintWriter csvWriter;
			if (sistemaOperacional.contains("Windows")) {
				csvWriter = new  PrintWriter(new FileWriter(arquivoWindows,true));
				csvWriter.println(linha);
				csvWriter.close();
			} else {
				csvWriter = new  PrintWriter(new FileWriter(arquivoLinux,true));
				csvWriter.println(linha);
				csvWriter.close();
			}
			
		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>>>>>> escreverCsv <<<<<<<<<<<<<<<<<< \n");
			e.printStackTrace();
		}
	}


	/**
	 * @param nomeClass
	 * @param nomeMetodo
	 * @param status
	 * @param mensagemErro
	 */
	public void escreverCsv(String nomeMetodo, String status, String mensagemErro) {
		try {
			Date dataHoraAtual = new Date();
			String data = new SimpleDateFormat("dd-MM-yyyy").format(dataHoraAtual);
			String hora = new SimpleDateFormat("HH:mm").format(dataHoraAtual);

			File arquivoWindows = new File(pathArquivoWind+getUltimoArquivoCsv());
			File arquivoLinux = new File(pathArquivoLinux+getUltimoArquivoCsv());

			String linha = status + "," + data + "," + hora + "," + nomeMetodo+","+mensagemErro;
			PrintWriter csvWriter;
			if (sistemaOperacional.contains("Windows")) {
				csvWriter = new  PrintWriter(new FileWriter(arquivoWindows,true));
				csvWriter.println(linha);
				csvWriter.close();
			} else {
				csvWriter = new  PrintWriter(new FileWriter(arquivoLinux,true));
				csvWriter.println(linha);
				csvWriter.close();
			}
			
			
		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>>>>>> escreverCsv <<<<<<<<<<<<<<<<<< \n");
			e.printStackTrace();
		}
	}


	@SuppressWarnings("unused")
	public String getUltimoArquivoCsv(){//String nomeArquivo) {
		try {
			File arquivoLinux = new File(pathArquivoLinux);
			File arquivoWindows = new File(pathArquivoWind);

			String ultimoArquivo = null;
			List<String> list = new ArrayList<String>();

			if(arquivoWindows.exists()) {
				File listFile[] = arquivoWindows.listFiles();
				for (int x = 0; x < listFile.length; x++) {
					if (listFile[x].getName().endsWith(".csv")) {
						list.add(listFile[x].getName());
					}
				}
				Collections.sort(list);

				for (int x = 0; x <= list.size(); x++) {
					ultimoArquivo = list.get(list.size() - 1);
					break;
				}
				return ultimoArquivo;	
			}else {
				File listFile[] = arquivoLinux.listFiles();
				for (int x = 0; x < listFile.length; x++) {
					if (listFile[x].getName().endsWith(".csv")) {
						list.add(listFile[x].getName());
					}
				}
				Collections.sort(list);

				for (int x = 0; x <= list.size(); x++) {
					ultimoArquivo = list.get(list.size() - 1);
					break;
				}
				return ultimoArquivo;
			}

		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>>>>>>>>> getUltimoArquivoCsv <<<<<<<<<<<<<<<<<<<<<< \n");
			e.printStackTrace();
		}
		return null;
	}

	public void fecharArquivoFechar() {

	}
}
