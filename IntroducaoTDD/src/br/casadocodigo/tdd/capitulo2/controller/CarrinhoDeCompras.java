package br.casadocodigo.tdd.capitulo2.controller;

import java.util.ArrayList;
import java.util.List;

import br.casadocodigo.tdd.capitulo2.model.Produto;

public class CarrinhoDeCompras {
	private List<Produto> carrinho = new ArrayList<>();
	
	public void addProduto(Produto produto){
		carrinho.add(produto);
	}
	
	public List<Produto> getProdutos(){
		return carrinho;
	}
}
