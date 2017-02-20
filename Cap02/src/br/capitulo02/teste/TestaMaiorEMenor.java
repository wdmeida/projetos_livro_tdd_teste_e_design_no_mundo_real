package br.capitulo02.teste;

import org.junit.Assert;
import org.junit.Test;

import br.capitulo02.controller.CarrinhoDeCompras;
import br.capitulo02.controller.MaiorEMenor;
import br.capitulo02.model.Produto;

public class TestaMaiorEMenor {
	
	@Test
	public void ordermDecrescente() {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		Produto produtos[] = {new Produto("Geladeira", "Muito boa", 450.0),
							  new Produto("Liquidificador", "Muito bom", 250.0),
							  new Produto("Jogo de pratos", "Duvidoso", 70.0)};
		carrinho.add(produtos);
		
		MaiorEMenor algoritmo = new MaiorEMenor();
		algoritmo.encontra(carrinho);
			
		Assert.assertEquals("Jogo de pratos", algoritmo.getMenor().getNome());
		Assert.assertEquals("Geladeira", algoritmo.getMaior().getNome());

	}
	
	@Test
	public void apenasUmProduto(){
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.add(new Produto("Geladeira", "Muito boa", 450.0));
		
		MaiorEMenor algoritmo = new MaiorEMenor();
		algoritmo.encontra(carrinho);
		
		Assert.assertEquals("Geladeira", algoritmo.getMenor().getNome());
		Assert.assertEquals("Geladeira", algoritmo.getMaior().getNome());
	}
	
	@Test
	public void ordemCrescente(){
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		Produto produtos[] = { new Produto("Jogo de pratos", "Duvidoso", 70.0),
							   new Produto("Liquidificador", "Muito bom", 250.0),
							   new Produto("Geladeira", "Muito boa", 450.0)};
		carrinho.add(produtos);
		
		MaiorEMenor algoritmo = new MaiorEMenor();
		algoritmo.encontra(carrinho);
			
		Assert.assertEquals("Jogo de pratos", algoritmo.getMenor().getNome());
		Assert.assertEquals("Geladeira", algoritmo.getMaior().getNome());
	}
}
