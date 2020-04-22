package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Chefe;
import util.JpaUtil;

public class ChefeDAOImpl implements ChefeDAO {

	EntityManager ent;
	EntityTransaction tx = ent.getTransaction();
	
	public ChefeDAOImpl() {

	}
	
	public boolean inserirChefe(Chefe chefe) {
		try {
			this.ent = JpaUtil.getEntityManager();
			tx = ent.getTransaction();
			tx.begin();
			ent.persist(chefe);
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


	public boolean editarChefe(Chefe chefe) {
		try {
			this.ent = JpaUtil.getEntityManager();
			tx = ent.getTransaction();
			tx.begin();
			ent.merge(chefe);
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


	public boolean removerChefe(Chefe chefe) {
		try {
			this.ent = JpaUtil.getEntityManager();
			tx = ent.getTransaction();
			tx.begin();
			ent.remove(chefe);
			tx.commit();
			return true;
		}catch(Exception e) {
			if(ent.isOpen()) {
				ent.close();	
				}
		}
		return false;
	}


	public List<Chefe> listarChefes() {
		Query query = ent.createQuery("from Chefe c");
		List<Chefe> chefes = query.getResultList();
		return chefes;
	}


	
	public Chefe pesquisar(String login) {
		// TODO Auto-generated method stub
		return null;
	}

}
