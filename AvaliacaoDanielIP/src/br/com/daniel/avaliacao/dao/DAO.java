package br.com.daniel.avaliacao.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.daniel.avaliacao.hibernate.HibernateUtil;


public class DAO<E> {

	protected Class<E> classe;
	protected Session session;
	protected Transaction transaction;

	private DAO() {
		// nao pode ser usado
	}
	
	public DAO(Class<E> c) {
		this();
		classe = c;
		
	}


	public E salvar(E e) throws Exception {
		
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(e);
		transaction.commit();
		session.close();
		
		return e;
	}


	public void deletar(E e) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(e);
		transaction.commit();
		session.close();
	}


	public E atualizar(E e) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		 session.merge(e);
		transaction.commit();
		session.close();
		return e;
	}
	
	@SuppressWarnings("unchecked")
	public E findById(Integer id) {
		E e = null;
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		e = (E) session.get(classe, id);
		return e;
	}
	
	@SuppressWarnings("unchecked")
	public E pesquisarPorCampo(String campo, Object valor) throws Exception {

		session = HibernateUtil.getSessionFactory().openSession();
		E e = (E) session.createCriteria(classe).add(Restrictions.eq(campo, valor)).uniqueResult();
		session.close();
		return e;
	}	
	
	
	@SuppressWarnings("unchecked")
	public List<E> listarTodos() throws Exception {

		session = HibernateUtil.getSessionFactory().openSession();
		List<E> lista = session.createCriteria(classe).list();
		session.close();
		return lista;
	}

	public Class<E> getClasse() {
		return classe;
	}
	

}
