package br.capitulo5.test;

import br.capitulo5.controller.CarrinhoDeCompras;
import br.capitulo5.controller.MaiorPreco;
import br.capitulo5.model.Item;

import static org.junit.Assert.*;

import org.junit.Test;


public class MaiorPrecoTest {
	
	@Test
	public void deveRetornarZeroSeCarrinhoVazio(){
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		
		MaiorPreco algoritmo = new MaiorPreco();
		double valor = algoritmo.encontra(carrinho);
		
		assertEquals(0.0, valor, 0.00001);
	}
	
	@Test
	public void deveRetornarValorDoItemSeCarrinhoCom1Elemento(){
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adiciona(new Item("Geladeira", 1, 900.00));
		
		MaiorPreco algoritmo = new MaiorPreco();
		double valor = algoritmo.encontra(carrinho);
	
		assertEquals(900.00, valor, 0.00001);
	}
	
	@Test
	public void deveRetornarMaiorValorSeCarrinhoContemMuitosElementos() {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		
		carrinho.adiciona(new Item("Geladeira", 1, 900.0));
		carrinho.adiciona(new Item("Fogão", 1, 1500.0));
		carrinho.adiciona(new Item("Máquina de Lavar", 1, 750.0));
	
		MaiorPreco algoritmo = new MaiorPreco();
		double valor = algoritmo.encontra(carrinho);
		
		assertEquals(1500.00, valor, 0.00001);
	}
}//class MaiorPrecoTest
