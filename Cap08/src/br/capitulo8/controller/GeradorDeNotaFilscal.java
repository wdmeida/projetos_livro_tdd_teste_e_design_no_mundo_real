package br.capitulo8.controller;

import java.util.Calendar;

import br.capitulo8.dao.NFDao;
import br.capitulo8.model.NotaFiscal;
import br.capitulo8.model.Pedido;

public class GeradorDeNotaFilscal {
	public NotaFiscal gera(Pedido pedido) {
		NotaFiscal nf = new NotaFiscal(pedido.getCliente(),
				pedido.getValorTotal() * 0.94, 
				Calendar.getInstance());
		
		new NFDao().persiste(nf);
		
		return nf;
	}
}
