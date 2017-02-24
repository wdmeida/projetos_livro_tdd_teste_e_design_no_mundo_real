package br.capitulo8.test;

import br.capitulo8.controller.GeradorDeNotaFilscal;
import br.capitulo8.model.NotaFiscal;
import br.capitulo8.model.Pedido;

import static org.junit.Assert.*;

import org.junit.Test;

public class GeradorNotaFilacalTest {
	
	@Test
	public void deveGerarNFComValorDeImpostoDescontado(){
		GeradorDeNotaFilscal gerador = new GeradorDeNotaFilscal();
		Pedido pedido = new Pedido("Wagner",1000, 1);
		
		NotaFiscal nf = gerador.gera(pedido);
		
		assertEquals(1000 * 0.94, nf.getValor(), 0.00001);
	}
}
