package br.casadocodigo.tdd.capitulo2.controller;

import br.casadocodigo.tdd.capitulo2.model.Produto;

public class MaiorEMenor {
	private Produto menor;
	private Produto maior;
	
	public void encontra(CarrinhoDeCompras carrinho) {
		for (Produto produto : carrinho.getProdutos()) {
			if(menor == null || produto.getValor() < menor.getValor()) {
				menor = produto;
			}
			
			if(maior == null || produto.getValor() > maior.getValor()) {
				maior = produto;
			}
		}
	}
	
	public Produto getMenor() {
		return menor;
	}
	
	public Produto getMaior() {
		return maior;
	}
}
