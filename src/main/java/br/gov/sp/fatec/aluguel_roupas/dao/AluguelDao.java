package br.gov.sp.fatec.aluguel_roupas.dao;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import br.gov.sp.fatec.aluguel_roupas.entity.Aluguel;


public class AluguelDao {
	
	private EntityManager manager;

	public AluguelDao(EntityManager manager) {
		this.manager = manager;
	}

	public AluguelDao() {
		super();
	}
	
	public void save(Aluguel aluguel) throws RollbackException {
		try {
			manager.getTransaction().begin();
			manager.flush();
			saveWithoutCommit(aluguel);
			manager.getTransaction().commit();
		}catch(RollbackException e) {
			manager.getTransaction().rollback();
			throw e;
		}
	}
	
	public void saveWithoutCommit(Aluguel aluguel) {
		if(aluguel.getId() == null) {
			manager.persist(aluguel);		
		}else {
			manager.merge(aluguel);
		}
	}
	
	public Aluguel searchAluByClienteAndVendedor() {
		String consulta = "select a from Aluguel a"
				+ "inner join a.vendedor v where v.usu_id = a.usu_id";
		TypedQuery<Aluguel> query = manager.createQuery(consulta, Aluguel.class);
		return query.getSingleResult();
	}
	
}
