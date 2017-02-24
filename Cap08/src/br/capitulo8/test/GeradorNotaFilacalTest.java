package br.capitulo8.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.capitulo8.controller.GeradorDeNotaFilscal;
import br.capitulo8.controller.SAP;
import br.capitulo8.dao.NFDao;
import br.capitulo8.model.NotaFiscal;
import br.capitulo8.model.Pedido;

public class GeradorNotaFilacalTest {
	private NFDao dao;
	private SAP sap;
	
	@Before
	public void instanciaDependencias(){
		dao = Mockito.mock(NFDao.class);
		sap = Mockito.mock(SAP.class);
	}
	
	@Test
	public void deveGerarNFComValorDeImpostoDescontado(){
		GeradorDeNotaFilscal gerador = new GeradorDeNotaFilscal(dao, sap);
		Pedido pedido = new Pedido("Wagner",1000, 1);
		
		NotaFiscal nf = gerador.gera(pedido);
		
		assertEquals(1000 * 0.94, nf.getValor(), 0.00001);
	}
	
	@Test
	public void devePersistirNFGerada() {
		// Criando o objeto mock.
		NFDao dao = Mockito.mock(NFDao.class);
		
		GeradorDeNotaFilscal gerador = new GeradorDeNotaFilscal(dao, sap);
		Pedido pedido = new Pedido("Wagner", 1000, 1);
		
		NotaFiscal nf = gerador.gera(pedido);
		
		//Verificando que o método foi invocado.
		Mockito.verify(dao).persiste(nf);
	}
	
	@Test
	public void deveEnviarNFGeradaParaSAP() {		
		GeradorDeNotaFilscal gerador = new GeradorDeNotaFilscal(dao, sap);
		Pedido pedido = new Pedido("Wagner", 1000, 1);
		
		NotaFiscal nf = gerador.gera(pedido);
		
		Mockito.verify(sap).envia(nf);
	}
}
