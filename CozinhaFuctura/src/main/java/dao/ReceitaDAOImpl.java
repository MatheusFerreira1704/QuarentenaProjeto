package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Receitas;
import util.JpaUtil;

public class ReceitaDAOImpl implements ReceitaDAO {

	EntityManager ent;
	EntityTransaction tx = ent.getTransaction();
	
	public ReceitaDAOImpl() {
		
	}
	
	public boolean inserirReceita(Receitas receita) {
		try {
			this.ent = JpaUtil.getEntityManager();
			tx = ent.getTransaction();
			tx.begin();
			ent.persist(receita);
			tx.commit();
			return true;
		}catch(Exception e) {
			if(ent.isOpen()) {
				tx.rollback();
			}
		}finally {
			if(ent.isOpen()) {
			ent.close();	
			}
		}	
		return false;
	}


	public boolean editarReceita(Receitas receita) {
		try {
			this.ent = JpaUtil.getEntityManager();
			tx = ent.getTransaction();
			tx.begin();
			ent.merge(receita);
			tx.commit();
			return true;
		}catch(Exception e) {
			if(ent.isOpen()) {
				tx.rollback();
			}
		}finally {
			if(ent.isOpen()) {
			ent.close();	
			}
		}
		return false;
	}


	public boolean removerReceita(Receitas receita) {
		try {
			this.ent = JpaUtil.getEntityManager();
			tx = ent.getTransaction();
			tx.begin();
			ent.remove(receita);
			tx.commit();
			return true;
		}catch(Exception e) {
			if(ent.isOpen()) {
				ent.close();	
				}
		}
		return false;
	}


	public List<Receitas> listaReceita(String coluna, String valor) {
		Query query = ent.createQuery("FROM Receita r WHERE" +coluna+ "= :valor");
		query.setParameter("valor", valor);
		
		List<Receitas> receitas = query.getResultList();
		return receitas;
	}


	
	
	
	

}
