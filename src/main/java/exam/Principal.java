package exam;

import javax.swing.JFrame;

import exam.utils.Apariencia;
import exam.view.PanelTablaContrato;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Principal instance = null;
	
	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}
	
	/**
	 * Singleton.
	 * @return
	 */
	public static Principal getInstance() {
		if (instance == null) {
			instance = new Principal();
		}
		return instance;
	}
	
	/**
	 * Constructor.
	 */
	public Principal() {
		super("Examen");
		
		this.setBounds(100, 100, 850, 550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		PanelTablaContrato panel = new PanelTablaContrato();
		this.getContentPane().add(panel);
	}

	/**
	 * Método Principal.
	 * @param args
	 */
	public static void main(String[] args) {
		getInstance().setVisible(true);
	}

}
