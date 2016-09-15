package br.com.tdd.capitulo5.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.tdd.capitulo5.controller.CarrinhoDeCompras;
import br.com.tdd.capitulo5.model.Item;

/*
 * Imagine que o programador deva implementar uma funcionalidade que devolva o valor do item de maior
 * valor dentro desse carrinho de compras. Pensando já nos testes, temos os seguintes cenários:
 * 	
 * 	=>Se o carrinho só tiver um item, ele mesmo será o item de maior valor.
 *  =>Se o carrinho tiver muitos itens, o item de maior valor é o que deve ser retornado.
 *  =>Um carrinho sem nenum item deve retornar zero.
 */
public class CarrinhoDeComprasTest {
	
	/*
	 * Seguindo TDD a risca, vamos começar pelo cenário mais simples, que nesse caso é o carrinho vazio. 
	 * Vamos criar um teste para a classe MaiorPreco, responsável por essa tarefa:
	 */
	@Test
	public void deveRetornarZeroSeCarrinhoVazio() {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		
		/*
		 * Parâmetros: 
		 * 		Valor esperado;
		 * 		Valor recebido na execução;
		 * 		Delta, valor de variação máximo para o qual valor esperado e recebido serão considerados iguais.
		 */
		assertEquals(0.0, carrinho.maiorValor(), 0.00001);
	}
	
	//Testa o caso do carrinho conter apenas um produto.
	@Test
	public void deveRetornarValorDoItemSeCarrinhoComUmElemento() {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adiciona(new Item("Geladeira", 1, 900.0));
		
		assertEquals(900.0, carrinho.maiorValor(), 0.0001);
	}
	
	/*
	 * O último teste: é necessário encontrar o item de maior valor caso o carrinho contenha
	 * muitos itens.
	 */
	@Test
	public void deveRetornarMaiorValorSeCarrinhoContemMuitosElementos() {
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adiciona(new Item("Geladeira", 1, 900.0));
		carrinho.adiciona(new Item("Fogão", 1, 1500.0));
		carrinho.adiciona(new Item("Máquina de Lavar", 1, 750.0));
		
		assertEquals(1500.0, carrinho.maiorValor(), 0.0001);
	}
}//class MaiorPrecoTest
