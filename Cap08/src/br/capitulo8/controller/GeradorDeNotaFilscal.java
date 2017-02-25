package br.capitulo8.controller;

import java.util.List;

import br.capitulo8.model.AcaoAposGerarNota;
import br.capitulo8.model.NotaFiscal;
import br.capitulo8.model.Pedido;
import br.capitulo8.model.Relogio;
import br.capitulo8.model.RelogioDoSistema;

/*
 * Após a modificação, a classe GeradorDeNotaFiscal não está mais fortemente
 * acoplada a uma ação concreta, mas sim a uma lista qualquer de ações. A chance
 * dela sofrer uma alteração propagada por uma dependência é bem menor. Além do mais,
 * a evolução dessa classe passa a ser natural: basta passar mais itens na lista de
 * ações, que ela as executará. Não há mais a necessidade de alterar a classe para
 * adicionar um novo comportamento. Em orientação a objetoes, a ideia de estendermos
 * o comportamento de uma classe sem alterar seu código é conhecido como Princípio do
 * Aberto-Fechado, ou OCP (Open-Closed Principle).
 */
public class GeradorDeNotaFilscal {
	private final List<AcaoAposGerarNota> acoes;
	private final Relogio relogio;

	public GeradorDeNotaFilscal(List<AcaoAposGerarNota> acoes, Relogio relogio) {
		this.acoes = acoes;
		this.relogio = relogio;
	}
	
	public GeradorDeNotaFilscal(List<AcaoAposGerarNota> acoes){
		this(acoes, new RelogioDoSistema());
	}
	
	public NotaFiscal gera(Pedido pedido) {
		NotaFiscal nf = new NotaFiscal(pedido.getCliente(),
				pedido.getValorTotal() * 0.94, 
				relogio.hoje());
		
		//Executa todas as ações com a nota fiscal gerada.
		acoes.forEach( acao -> {  acao.executa(nf); });
		
		return nf;
	}
}
