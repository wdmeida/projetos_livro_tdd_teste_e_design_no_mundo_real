package br.capitulo4.model;

import br.capitulo4.controller.DezOuVintePorCento;
import br.capitulo4.controller.QuinzeOuVinteCincoPorCento;

public enum Cargo {
	DESENVOLVEDOR(new DezOuVintePorCento()),
	DBA(new QuinzeOuVinteCincoPorCento()),
	TESTADOR(new QuinzeOuVinteCincoPorCento());
	
	private final RegraDeCalculo regra;

	private Cargo(RegraDeCalculo regra) {
		this.regra = regra;
	}
	
	public RegraDeCalculo getRegra() {
		return regra;
	}
}
