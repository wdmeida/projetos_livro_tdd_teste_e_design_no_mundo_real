package br.capitulo4.controller;

import br.capitulo4.model.Funcionario;
import br.capitulo4.model.RegraDeCalculo;

public class QuinzeOuVinteCincoPorCento implements RegraDeCalculo {

	public double calcula(Funcionario funcionario) {
		if (funcionario.getSalario() > 2500)
			return funcionario.getSalario() * 0.75;
		return funcionario.getSalario() * 0.85;
	}
}
