package br.capitulo02.controller;

import java.util.ArrayList;
import java.util.List;

import br.capitulo02.model.Produto;

public class CarrinhoDeCompras {
	private List<Produto> produtos = new ArrayList<>();

	public void add(Produto... itens){
		for (Produto produto : itens) produtos.add(produto);
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
}
