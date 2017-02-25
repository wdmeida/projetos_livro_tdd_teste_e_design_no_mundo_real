package br.capitulo8.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import br.capitulo8.controller.GeradorDeNotaFilscal;
import br.capitulo8.model.AcaoAposGerarNota;
import br.capitulo8.model.NotaFiscal;
import br.capitulo8.model.Pedido;
import br.capitulo8.model.Tabela;

import static org.junit.Assert.*;

public class GeradorNotaFilacalTest {
		
	@Test
	public void deveInvocarAcoesPosteriores(){
		AcaoAposGerarNota acao1 = Mockito.mock(AcaoAposGerarNota.class);
		AcaoAposGerarNota acao2 = Mockito.mock(AcaoAposGerarNota.class);
		
		Tabela tabela = Mockito.mock(Tabela.class);
		
		List<AcaoAposGerarNota> acoes = Arrays.asList(acao1, acao2);
		
		GeradorDeNotaFilscal gerador = new GeradorDeNotaFilscal(acoes, tabela);
		Pedido pedido = new Pedido("Wagner", 1000, 1);
		
		NotaFiscal nf = gerador.gera(pedido);
		
		Mockito.verify(acao1).executa(nf);
		Mockito.verify(acao2).executa(nf);
	}
	
	@Test
	public void deveConsultarATabelaParaCalcularValor() {
		//mockando uma tabela, que ainda não existe.
		Tabela tabela = Mockito.mock(Tabela.class);
		
		//Definindo o futuro comportamento "paraValor" que
		//deve retornar 0.2 para caso o valor seja 1000.00.
		Mockito.when(tabela.paraValor(1000.0)).thenReturn(0.2);
		
		List<AcaoAposGerarNota> nenhumaAcao = Collections.emptyList();
		GeradorDeNotaFilscal gerador = new GeradorDeNotaFilscal(nenhumaAcao, tabela);
		Pedido pedido = new Pedido("Wagner", 1000, 1);
		
		NotaFiscal nf = gerador.gera(pedido);
		
		//Garantindo que a tabela foi consultada.
		Mockito.verify(tabela).paraValor(1000.0);
		assertEquals(1000 * 0.2, nf.getValor(), 0.00001);
	}
}
