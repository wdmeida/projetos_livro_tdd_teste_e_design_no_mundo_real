package br.com.tdd.capitulo5.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.tdd.capitulo5.model.Item;

public class CarrinhoDeCompras {
	private List<Item> itens;

	public CarrinhoDeCompras() {
		this.itens = new ArrayList<>();
	}
	
	public void adiciona(Item item) {
		this.itens.add(item);
	}
	
	public List<Item> getItens() {
		/*
		 * O método estático unmodifiableList retorna um objeto apenas de leitura. Em caso de tentativa de
		 * escrita, será lançada a exceção UnsupportedOperationException. 
		 */
		return Collections.unmodifiableList(itens);
	}
	
	public double maiorValor(){
		if(itens.size() == 0) return 0;
		
		double maior = itens.get(0).getValorUnitario();
		for(Item item : itens) {
			if(maior < item.getValorUnitario()){
				maior = item.getValorUnitario();
			}
		}
		return maior;
	}
}
