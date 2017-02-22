package br.capitulo4.controller;

import br.capitulo4.model.Funcionario;
import br.capitulo4.model.RegraDeCalculo;

public class DezOuVintePorCento implements RegraDeCalculo {

	@Override
	public double calcula(Funcionario funcionario) {
		if (funcionario.getSalario() > 3000)
			return funcionario.getSalario() * 0.8;
		return funcionario.getSalario() * 0.9;
	}

}
