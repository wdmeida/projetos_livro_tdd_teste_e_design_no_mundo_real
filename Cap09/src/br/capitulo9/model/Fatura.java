package br.capitulo9.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wagner
 *
 */
public class Fatura {
	private String cliente;
	private List<Pagamento> pagamentos;
	
	public Fatura(String cliente, double valor) {
		this.cliente = cliente;
		pagamentos = new ArrayList<>();
		pagamentos.add(new Pagamento(valor, MeioDePagamento.BOLETO));
	}

	public String getCliente() {
		return cliente;
	}
	
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}
}
