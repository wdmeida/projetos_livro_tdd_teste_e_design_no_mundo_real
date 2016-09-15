package br.com.tdd.capitulo3.controller;

import java.util.HashMap;

public class ConversorDeNumeroRomano {
	
	@SuppressWarnings("serial")
	private HashMap<Character, Integer> tabela = new HashMap<Character, Integer>(){{
																				put('I', 1);
																				put('V', 5);
																				put('X', 10);
																				put('L', 50);
																				put('C', 100);
																				put('D', 500);
																				put('M', 1000);
																			}};
	
	/*
	 * Para fazer o teste passar, introduziremos uma segunda regra: O código escrito deve ser sempre o mais simples
	 * possível.
	 * Com essa regra em mente, o código mais simples que fará o teste passar é fazer simplesmente o método converte()
	 * retornar o número valor do teste.
	 */
	public int converte(String numeroEmRomano) {
		int acumulador = 0;
		int ultimoVizinhoDaDireita = 0;
		
		for(int i = numeroEmRomano.length() - 1; i >= 0; i--){
			
			//pega o inteiro referente ao simbolo atual.
			int atual = tabela.get(numeroEmRomano.charAt(i));
			
			//Se o da direita for menor, o multiplicaremos por -1 para torná-lo negativo.
			int multiplicador = 1;
			if(atual < ultimoVizinhoDaDireita) multiplicador = -1;
			
			acumulador += atual * multiplicador;
			
			//atualiza o vizinho da direita.
			ultimoVizinhoDaDireita = atual;
		}
		return acumulador;
	}
}
