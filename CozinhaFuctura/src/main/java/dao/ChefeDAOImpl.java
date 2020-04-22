package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import entidade.Chefe;
import entidade.Receitas;

public class ChefeDAOImpl implements ChefeDAO {

	private EntityManager ent;

	public ChefeDAOImpl(EntityManager ent) {
		this.ent = ent;
	}

	public boolean inserir (Chefe chefe) {

		try {
			EntityTransaction tx = ent.getTransaction();
			tx.begin();
			ent.persist(chefe);
			tx.commit();
		} catch (Exception e) {

			ent.getTransaction().rollback();
		}
		
		return true;
	}

	public void editarChefe(Chefe chefe) {
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		ent.merge(chefe);
		tx.commit();

	}
	

	public void remover(Chefe chefe) {
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		ent.remove(chefe);
		tx.commit();
	}

	
	public Chefe pesquisar (String nome) {
		Chefe chefe = ent.find(Chefe.class, nome);
		
		return chefe;
	}

	public void editarReceita(Receitas receita) {
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		ent.merge(receita);
		tx.commit();

	}

	public List<Chefe> listarChefes() {
		Query query = ent.createQuery("from Chefe c");
		List<Chefe> chefes = query.getResultList();
		return chefes;
	}

}
