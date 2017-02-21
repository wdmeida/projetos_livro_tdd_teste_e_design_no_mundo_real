package br.capitulo5.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.capitulo5.model.Item;

public class CarrinhoDeCompras {
	private List<Item> itens;

	public CarrinhoDeCompras() {
		this.itens = new ArrayList<>();
	}
	
	public void adiciona(Item... itens){
		for(Item item : itens) this.itens.add(item);
	}
	
	public List<Item> getItens() {
		return Collections.unmodifiableList(itens);
	}
}//class CarrinhoDeCompras
