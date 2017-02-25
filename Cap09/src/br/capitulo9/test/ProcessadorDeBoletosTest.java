package br.capitulo9.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.capitulo9.controller.ProcessadorDeBoletos;
import br.capitulo9.model.Boleto;
import br.capitulo9.model.Fatura;

import static org.junit.Assert.*;

public class ProcessadorDeBoletosTest {
	
	@Test
	public void deveProcessarPagamentoViaBoletoUnico() {
		ProcessadorDeBoletos processador = new ProcessadorDeBoletos();
		
		Fatura fatura = new Fatura("Wagner", 150.0);
		Boleto b1 = new Boleto(150.0);
		List<Boleto> boletos = Arrays.asList(b1);
		
		processador.processa(boletos, fatura);
		
		assertEquals(1, fatura.getPagamentos().size());
		assertEquals(150.0, fatura.getPagamentos().get(0).getValor(), 0.00001);
	}
	
	@Test
	public void deveProcessarPagementoViaMuitosBoletos() {
		ProcessadorDeBoletos processador = new ProcessadorDeBoletos();
		
		Fatura fatura = new Fatura("Wagner", 300.00);
		Boleto b1 = new Boleto(100.00);
		Boleto b2 = new Boleto(200.00);
		List<Boleto> boletos = Arrays.asList(b1, b2);
		
		processador.processa(boletos, fatura);
		
		assertEquals(2, fatura.getPagamentos().size());
		assertEquals(100.00, fatura.getPagamentos().get(0).getValor(), 0.00001);
		assertEquals(200.00, fatura.getPagamentos().get(1).getValor(), 0.00001);
	}
	
	@Test
	public void deveMarcarFaturaComoPagaCasoBoletoUnicoPagueTudo() {
		ProcessadorDeBoletos processador = new ProcessadorDeBoletos();
		
		Fatura fatura = new Fatura("Wagner", 150.00);
		Boleto b1 = new Boleto(150.00);
		List<Boleto> boletos = Arrays.asList(b1);
		
		processador.processa(boletos, fatura);
		
		assertTrue(fatura.isPago());
	}
	
	@Test
	public void deveMarcarFaturaComoNaoPagaCasoBoletoUnicoNaoPagueTudo() {
		ProcessadorDeBoletos processador = new ProcessadorDeBoletos();
		
		Fatura fatura = new Fatura("Wagner", 150.00);
		Boleto b1 = new Boleto(100.00);
		List<Boleto> boletos = Arrays.asList(b1);
		
		processador.processa(boletos, fatura);
		
		assertFalse(fatura.isPago());
	}
}
