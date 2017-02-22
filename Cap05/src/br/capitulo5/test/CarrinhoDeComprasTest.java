package br.capitulo5.test;

import br.capitulo5.controller.CarrinhoDeCompras;
import br.capitulo5.model.Item;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CarrinhoDeComprasTest {
	
	private CarrinhoDeCompras carrinho;
	
	//Instância o objeto antes que cada teste seja executado.
	@Before
	public void inicializa(){
		this.carrinho = new CarrinhoDeCompras();
	}
	
	@Test
	public void deveRetornarZeroSeCarrinhoVazio(){
		assertEquals(0.0, carrinho.maiorValor(), 0.00001);
	}
	
	@Test
	public void deveRetornarValorDoItemSeCarrinhoCom1Elemento(){
		carrinho.adiciona(new Item("Geladeira", 1, 900.00));
	
		assertEquals(900.00, carrinho.maiorValor(), 0.00001);
	}
	
	@Test
	public void deveRetornarMaiorValorSeCarrinhoContemMuitosElementos() {
		carrinho.adiciona(new Item("Geladeira", 1, 900.0));
		carrinho.adiciona(new Item("Fogão", 1, 1500.0));
		carrinho.adiciona(new Item("Máquina de Lavar", 1, 750.0));
		
		assertEquals(1500.00, carrinho.maiorValor(), 0.00001);
	}
}//class MaiorPrecoTest
