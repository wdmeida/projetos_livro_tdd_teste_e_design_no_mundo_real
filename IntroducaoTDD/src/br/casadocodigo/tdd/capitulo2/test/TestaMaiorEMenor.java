package br.casadocodigo.tdd.capitulo2.test;

import org.junit.Assert;
import org.junit.Test;

import br.casadocodigo.tdd.capitulo2.controller.CarrinhoDeCompras;
import br.casadocodigo.tdd.capitulo2.controller.MaiorEMenor;
import br.casadocodigo.tdd.capitulo2.model.Produto;

public class TestaMaiorEMenor {
	
	@Test
	public void ordemDecrescente() {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.addProduto(new Produto("Geladeira", 450.0));
		carrinho.addProduto(new Produto("Liquidificador", 250.0));
		carrinho.addProduto(new Produto("Jogo de pratos", 70.0));
		
		MaiorEMenor algoritmo = new MaiorEMenor();
		algoritmo.encontra(carrinho);
		
		/*Realiza a validação do teste, está parte não é feita 100% pela máquina,
		por isso a necessidade de realiza-la através do método 
		Assert.assertEquals().*/	
		Assert.assertEquals("Jogo de pratos", algoritmo.getMenor().getNome());
		Assert.assertEquals("Geladeira", algoritmo.getMaior().getNome());
	}
	
	@Test
	public void apenasUmProduto() {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.addProduto(new Produto("Geladeira", 450.0));
		
		MaiorEMenor algotitmo = new MaiorEMenor();
		algotitmo.encontra(carrinho);
		
		/*
		 * Ao invés de comparar apenas o nome do produto, você poderia comparar o objeto
		 * inteiro: Assert.assertEquals(produto, algoritmo.getMenor()); por exemplo. Mas
		 * para isso, o método equals() deve estar implementado na classe Produto.
		 * Em certos casos, essa solução pode ser mais interessante, afinal você comparará
		 * o objeto inteiro e não apenas um atributo.
		 */
		Assert.assertEquals("Geladeira", algotitmo.getMenor().getNome());
		Assert.assertEquals("Geladeira", algotitmo.getMaior().getNome());
	}
}
