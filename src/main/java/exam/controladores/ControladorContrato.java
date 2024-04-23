package exam.controladores;

import javax.persistence.EntityManager;

import exam.entities.Contrato;

public class ControladorContrato extends SuperControladorJPA{

	public ControladorContrato() {
		super("contrato", Contrato.class);
	}

	private static ControladorContrato instance = null;
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorContrato getInstance() {
		if (instance == null) {
			instance = new ControladorContrato();
		}
		return instance;
	}
	
	/**
	 * 
	 * @param e
	 */
	public void insertEstudiante(Contrato e) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	
	/**
	 * 
	 * @param e
	 */
	public void updateProveedor(Contrato p) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}
	
}
