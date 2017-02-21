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
	
	public double maiorValor() {
		if(this.itens.size() == 0) return 0;
		
		double maior = this.itens.get(0).getValorTotal();
		
		for (Item item : this.itens)
			if(maior < item.getValorTotal())
				maior = item.getValorTotal();
		
		return maior;
	}
}//class CarrinhoDeCompras
