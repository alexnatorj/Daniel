package br.com.daniel.avaliacao.dao.consulta;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import br.com.daniel.avaliacao.dao.DAO;
import br.com.daniel.avaliacao.hibernate.HibernateUtil;
import br.com.daniel.avaliacao.modelo.Processo;
import br.com.daniel.avaliacao.modelo.filtro.ProcessoFiltro;

public class ProcessoDAO extends DAO<Processo>{

	public ProcessoDAO() {
		super(Processo.class);
	
	}

	/**
	 * Realiza pesquisa de um processo por filtro de numero de publicação e/ou requerente.
	 * @param filtro
	 * @return
	 */
	public List<Processo> pesquisarPorFiltro(ProcessoFiltro filtro) {
		
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		Criteria c = s.createCriteria(Processo.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		if (filtro.getNumeroPublicacao() != null) {
			c = c.add(Restrictions.ilike("numeroPub", filtro.getNumeroPublicacao(), MatchMode.ANYWHERE));
		}
		
		if (filtro.getRequerente() != null) {
			c = c.createAlias("requerentes", "r", JoinType.INNER_JOIN).
					add(Restrictions.ilike("r.nome", filtro.getRequerente(),MatchMode.ANYWHERE));
		}
		List<Processo> processos = new ArrayList<>();
		for (Object o : c.list()) {
			processos.add((Processo) o);
		}
		s.close();
		
		return processos;
	}
	
}
