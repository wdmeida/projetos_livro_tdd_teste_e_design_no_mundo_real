package br.capitulo9.controller;

import java.util.List;

import br.capitulo9.model.Boleto;
import br.capitulo9.model.Fatura;
import br.capitulo9.model.MeioDePagamento;
import br.capitulo9.model.Pagamento;

public class ProcessadorDeBoletos {
	
	public void processa(List<Boleto> boletos, Fatura fatura) {
		Boleto boleto = boletos.get(0);
		Pagamento pagamento =  new Pagamento(boleto.getValor(), MeioDePagamento.BOLETO);
		fatura.getPagamentos().add(pagamento);
	}
}
