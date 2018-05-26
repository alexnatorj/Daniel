package br.com.daniel.avaliacao.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.daniel.avaliacao.util.Util;

@Entity
@Table(name="PROCESSO")
public class Processo implements Serializable {

	
	private static final long serialVersionUID = -5660077825089860014L;
	
	@Id
	@Column(name="id_processo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_processo")
	@SequenceGenerator(name="seq_processo", sequenceName="seq_processo", allocationSize=1)
	private Integer idProcesso;
	
	@Column(name="numero_pub")
	private String numeroPub;
	
	@Column(name="numero_pedido_intl")
	private String numeroPedidoIntl;
	
	@Column(name="titulo")
	private String titulo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_publicacao")
	private Date dataPublicacao;
	
	@OneToMany(mappedBy= "processo", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.EAGER)
	private Set<Requerente> requerentes;
	
	public Processo() {
		requerentes = new HashSet<>();
	}

	public Integer getIdProcesso() {
		return idProcesso;
	}

	public void setIdProcesso(Integer idProcesso) {
		this.idProcesso = idProcesso;
	}

	public String getNumeroPub() {
		return numeroPub;
	}

	public void setNumeroPub(String numeroPub) {
		this.numeroPub = numeroPub;
	}

	public String getNumeroPedidoIntl() {
		return numeroPedidoIntl;
	}

	public void setNumeroPedidoIntl(String numeroPedidoIntl) {
		this.numeroPedidoIntl = numeroPedidoIntl;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Set<Requerente> getRequerentes() {
		return requerentes;
	}

	public void setRequerentes(Set<Requerente> requerentes) {
		this.requerentes = requerentes;
	}

	public String getDataString() {
		return Util.formataDataToString(getDataPublicacao());
	}
	
	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
	/**
	 * Agrupa os nomes dos requerentes em uma só String.
	 * @return nomes dos requerentes.
	 */
	public String getNomesRequerentes() {
		StringBuilder sb = new StringBuilder();
		int index = 0;
		int size = getRequerentes().size()-1;
		for (Requerente r : getRequerentes()) {
			sb.append(r.getNome());
			if (index < size) {
				sb.append(";");
			}
			
			index++;
		}
		return sb.toString();
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idProcesso == null) ? 0 : idProcesso.hashCode());
		result = prime
				* result
				+ ((numeroPedidoIntl == null) ? 0 : numeroPedidoIntl.hashCode());
		result = prime * result
				+ ((numeroPub == null) ? 0 : numeroPub.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Processo other = (Processo) obj;
		if (idProcesso == null) {
			if (other.idProcesso != null)
				return false;
		} else if (!idProcesso.equals(other.idProcesso))
			return false;
		if (numeroPedidoIntl == null) {
			if (other.numeroPedidoIntl != null)
				return false;
		} else if (!numeroPedidoIntl.equals(other.numeroPedidoIntl))
			return false;
		if (numeroPub == null) {
			if (other.numeroPub != null)
				return false;
		} else if (!numeroPub.equals(other.numeroPub))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Processo [idProcesso=" + idProcesso + ", numeroPub="
				+ numeroPub + ", numeroPedidoIntl=" + numeroPedidoIntl
				+ ", titulo=" + titulo + "]";
	}
	
	
}
