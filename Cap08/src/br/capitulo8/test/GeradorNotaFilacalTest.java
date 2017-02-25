package br.capitulo8.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import br.capitulo8.controller.GeradorDeNotaFilscal;
import br.capitulo8.model.AcaoAposGerarNota;
import br.capitulo8.model.NotaFiscal;
import br.capitulo8.model.Pedido;

public class GeradorNotaFilacalTest {
		
	@Test
	public void deveInvocarAcoesPosteriores(){
		AcaoAposGerarNota acao1 = Mockito.mock(AcaoAposGerarNota.class);
		AcaoAposGerarNota acao2 = Mockito.mock(AcaoAposGerarNota.class);
	
		List<AcaoAposGerarNota> acoes = Arrays.asList(acao1, acao2);
		
		GeradorDeNotaFilscal gerador = new GeradorDeNotaFilscal(acoes);
		Pedido pedido = new Pedido("Wagner", 1000, 1);
		
		NotaFiscal nf = gerador.gera(pedido);
		
		Mockito.verify(acao1).executa(nf);
		Mockito.verify(acao2).executa(nf);
	}
}
