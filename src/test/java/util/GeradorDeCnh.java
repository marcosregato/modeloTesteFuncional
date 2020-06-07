package util;

import java.util.Random;

public class GeradorDeCnh{

	/**

	Para validar o CNH, o algoritmo que gera o numero CNH usa o Modulo 11

	Fonte de pesquisa:

	Algoritmos – Validação de CNH
	https://siga0984.wordpress.com/2019/05/01/algoritmos-validacao-de-cnh/

	Solucoes Eletronicas
	https://www.bb.com.br/docs/pub/emp/empl/dwn/Rcb001.pdf


	Calculo do Dígito Verificador para inscricoes estaduais com 8 dígitos:
	http://www.sintegra.gov.br/Cad_Estados/cad_BA.html


	documento que regulamenta o documento de cnh
	http://www.denatran.gov.br/download/Resolucoes/resolucao_192_06.doc


	Calculo do Digito Verificador para CPF e CGC
	http://www.goulart.pro.br/cbasico/Calculo_dv.htm

	 LG - ENG - Dígito verificador 
	https://centraldeatendimento.totvs.com/hc/pt-br/articles/360026092631-LG-ENG-D%C3%ADgito-verificador

livro Guia De Valida��o De Dados Em Java 

	 */

	public String getNumeroCnh(){
		try{
			Random r = new Random();
			int primeiroDigito 		 = r.nextInt(9);//r.nextInt(9);
			int segundoDigito 		 = r.nextInt(9);
			int terceiroDigito 		 = r.nextInt(9);
			int quartoDigito		 = r.nextInt(9);
			int quintoDigito 		 = r.nextInt(9);
			int sextoDigito 		 = r.nextInt(9);
			int setimoDigito 		 = r.nextInt(9);
			int oitavoDigito 		 = r.nextInt(9);
			int nonoDigito 			 = r.nextInt(9);
			int decimoDigito 		 = r.nextInt(9);
			int decimoPrimeiroDigito = r.nextInt(9);

			String numeroGerado = String.valueOf(primeiroDigito)
					+ String.valueOf(segundoDigito) 		
					+ String.valueOf(terceiroDigito) 		
					+ String.valueOf(quartoDigito)		
					+ String.valueOf(quintoDigito) 		
					+ String.valueOf(sextoDigito) 		
					+ String.valueOf(setimoDigito) 		
					+ String.valueOf(oitavoDigito) 		
					+ String.valueOf(nonoDigito) 			
					+ String.valueOf(decimoDigito) 		
					+ String.valueOf(decimoPrimeiroDigito);
			return numeroGerado;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}


	@SuppressWarnings("unused")
	public void validaCNH(String numeroCNH) {
		char char1 = numeroCNH.charAt(0);

		long v = 0, j = 9;

		for (int i = 0; i < 9; ++i, --j) {
			v += ((numeroCNH.charAt(i) - 48) * j);
		}
		boolean status = false;
		while (status !=true) {

			int restoDivisao = (int) (v % 11);
			if(restoDivisao  ==0 || restoDivisao  == 1) {
				System.out.println("DEU CERTO");
				status = true;
			}else {
				System.out.println("DEU MERDA");
				//status = false;
			}
			//int subtrair = 11-restoDivisao;

			//System.out.println(subtrair);
		}


	}
	
	


	public static void main(String[] asdf){
		GeradorDeCnh g = new GeradorDeCnh();
		g.validaCNH(g.getNumeroCnh());
	}
}