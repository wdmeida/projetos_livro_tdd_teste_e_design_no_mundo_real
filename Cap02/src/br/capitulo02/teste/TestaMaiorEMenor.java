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
			
		Assert.assertEquals("Jogo de pratos" + algoritmo.getMenor().getNome(), algoritmo);
		Assert.assertEquals("Geladeira" + algoritmo.getMaior().getNome(), algoritmo);

	}

}
