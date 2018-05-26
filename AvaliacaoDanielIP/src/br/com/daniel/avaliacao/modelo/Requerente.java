package br.com.daniel.avaliacao.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="REQUERENTE")
public class Requerente implements Serializable {

	
	private static final long serialVersionUID = -1121366226686540788L;

	@Id
	@Column(name="id_requerente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_requerente")
	@SequenceGenerator(name="seq_requerente", sequenceName="seq_requerente", allocationSize=1)
	private Integer idRequerente;
	
	@Column
	private String nome;
	

	@ManyToOne
	@JoinColumn(name="processo", referencedColumnName="id_processo")
	private Processo processo;
		
	public Requerente() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdRequerente() {
		return idRequerente;
	}

	public void setIdRequerente(Integer idRequerente) {
		this.idRequerente = idRequerente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idRequerente == null) ? 0 : idRequerente.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((processo == null) ? 0 : processo.hashCode());
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
		Requerente other = (Requerente) obj;
		if (idRequerente == null) {
			if (other.idRequerente != null)
				return false;
		} else if (!idRequerente.equals(other.idRequerente))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (processo == null) {
			if (other.processo != null)
				return false;
		} else if (!processo.equals(other.processo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Requerente [nome=" + nome + "]";
	}
	
	
	
}
