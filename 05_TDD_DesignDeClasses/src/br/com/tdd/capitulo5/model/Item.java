package br.com.tdd.capitulo5.model;

public class Item {
	private String descricao;
	private int quantidade;
	private double valorUnitario;
	
	public Item(String descricao, int quantidade, double valorUnitario) {
		super();
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}
}