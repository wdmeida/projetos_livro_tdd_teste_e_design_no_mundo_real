package br.capitulo8.controller;

import java.util.Calendar;

import br.capitulo8.dao.NFDao;
import br.capitulo8.model.NotaFiscal;
import br.capitulo8.model.Pedido;

public class GeradorDeNotaFilscal {
	private NFDao dao;
	private final SAP sap;
	
	public GeradorDeNotaFilscal(NFDao dao, SAP sap) {
		this.dao = dao;
		this.sap = sap;
	}
	
	public NotaFiscal gera(Pedido pedido) {
		NotaFiscal nf = new NotaFiscal(pedido.getCliente(),
				pedido.getValorTotal() * 0.94, 
				Calendar.getInstance());
		
		dao.persiste(nf);
		sap.envia(nf);
		
		return nf;
	}
}
