package exam.controladores;

import javax.persistence.EntityManager;

import exam.entities.Usuario;


public class ControladorUsuario extends SuperControladorJPA{

	public ControladorUsuario() {
		super("usuario", Usuario.class);
	}

	private static ControladorUsuario instance = null;
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorUsuario getInstance() {
		if (instance == null) {
			instance = new ControladorUsuario();
		}
		return instance;
	}
	
	/**
	 * 
	 * @param e
	 */
	public void insertEstudiante(Usuario e) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	
	/**
	 * 
	 * @param e
	 */
	public void updateProveedor(Usuario p) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}
	
}
