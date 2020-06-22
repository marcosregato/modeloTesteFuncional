package util;

import java.util.Random;

public class GeradorDeCnh{

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
		}
	}
}