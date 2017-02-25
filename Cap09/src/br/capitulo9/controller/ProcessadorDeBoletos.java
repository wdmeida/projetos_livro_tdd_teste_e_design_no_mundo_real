package br.capitulo9.controller;

import java.util.List;

import br.capitulo9.model.Boleto;
import br.capitulo9.model.Fatura;
import br.capitulo9.model.MeioDePagamento;
import br.capitulo9.model.Pagamento;

public class ProcessadorDeBoletos {
	
	public void processa(List<Boleto> boletos, Fatura fatura) {
		double valorTotal = 0;
		
		for (Boleto boleto : boletos) {
			Pagamento pagamento = new Pagamento(boleto.getValor(), MeioDePagamento.BOLETO);
			fatura.getPagamentos().add(pagamento);
			
			valorTotal += boleto.getValor();
		}
		
		if (valorTotal >= fatura.getValorTotal())
			fatura.setPago(true);
	}
}
