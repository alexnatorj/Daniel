package br.com.daniel.avaliacao.modelo.filtro;

public class ProcessoFiltro {

	
	private String numeroPublicacao;
	
	private String requerente;
	
	public ProcessoFiltro() {

	}

	
	
	public ProcessoFiltro(String numeroPublicacao, String requerente) {
		
		this.numeroPublicacao = numeroPublicacao;
		this.requerente = requerente;
	}



	public String getNumeroPublicacao() {
		return numeroPublicacao;
	}

	public void setNumeroPublicacao(String numeroPublicacao) {
		this.numeroPublicacao = numeroPublicacao;
	}

	public String getRequerente() {
		return requerente;
	}

	public void setRequerente(String requerente) {
		this.requerente = requerente;
	}
	
	
}
