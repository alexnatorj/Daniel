package br.com.daniel.avaliacao.controle;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.daniel.avaliacao.dao.consulta.ProcessoDAO;
import br.com.daniel.avaliacao.modelo.Processo;
import br.com.daniel.avaliacao.modelo.Requerente;
import br.com.daniel.avaliacao.modelo.filtro.ProcessoFiltro;
import br.com.daniel.avaliacao.util.Util;

public class ControleProcesso implements Serializable {

	private static final long serialVersionUID = -2241262815964725965L;

	private ProcessoDAO dao;
	
	public ControleProcesso() {
		dao = new ProcessoDAO();
	}
	
	public Processo consultarPorProcesso(String numeroPub) throws Exception {
		Processo p =  dao.pesquisarPorCampo("numeroPub", numeroPub);
		return p;
	}
	
	
	public void salvarProcesso(String numProc, String numPedidoIntl, String data, String requerentes, String titulo) throws Exception {
		Processo p = new Processo();
		p.setNumeroPub(numProc.replace("/", ""));
		p.setNumeroPedidoIntl(numPedidoIntl.replace("/", ""));		
		p.setRequerentes(gerarRequerentes(p, requerentes));
		p.setDataPublicacao(Util.formataStringToData(data));
		p.setTitulo(titulo);
		dao.salvar(p);
	}
	
	private Set<Requerente> gerarRequerentes(Processo p, String reqs) {
		Set<Requerente>  requerentes = new HashSet<>();
		
		String[] arrayReqs = reqs.split(";");
		
		for (String r : arrayReqs) {
			Requerente requerente = new Requerente();
			requerente.setNome(r);
			requerente.setProcesso(p);
			requerentes.add(requerente);
		}
		
		return requerentes;
	}
	
	public List<Processo> pesquisarPorFiltro(ProcessoFiltro filtro) {
		return dao.pesquisarPorFiltro(filtro);
	}
	
	
}
 