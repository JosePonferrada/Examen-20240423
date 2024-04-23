package exam.controladores;

import exam.entities.TipoContrato;

public class ControladorTipoContrato extends SuperControladorJPA {
	
	public ControladorTipoContrato() {
		super("tipocontrato", TipoContrato.class);
	}

	private static ControladorTipoContrato instance = null;
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorTipoContrato getInstance() {
		if (instance == null) {
			instance = new ControladorTipoContrato();
		}
		return instance;
	}
	
}