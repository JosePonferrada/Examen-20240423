package exam.view;

import java.util.List;

import exam.controladores.ControladorContrato;
import exam.controladores.ControladorTipoContrato;
import exam.controladores.ControladorUsuario;
import exam.entities.Contrato;
import exam.entities.TipoContrato;
import exam.entities.Usuario;

public class DatosDeTabla {

	/** 
	 * 
	 * @return
	 */
	public static String[] getTitulosColumnas() {
		return new String[] {"Id", "Descripción", "Saldo(€)", "Límite(€)", 
				"idTipoContrato", "idUsuario", "Fecha de firma"};
	}

	/**
	 * 
	 * @return
	 */
	public static Object[][] getDatosDeTabla() {
		// Obtengo todos los estudiantes.
		List<Contrato> contratos = (List<Contrato>) ControladorContrato
				.getInstance().findAll();
		
		List<Usuario> usuarios = (List<Usuario>) ControladorUsuario
				.getInstance().findAll();
		
		// Obtengo todas las tipologias sexo.
		List<TipoContrato> l = (List<TipoContrato>) ControladorTipoContrato
				.getInstance().findAll();
		
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[contratos.size()][9];
		// Cargo los datos de la lista de estudiantes en la matriz de los datos
		for (int i = 0; i < contratos.size(); i++) {
			Contrato est = contratos.get(i);
			datos[i][0] = est.getId();
			datos[i][1] = est.getDescripcion();
			datos[i][2] = est.getSaldo();
			datos[i][3] = est.getLimite();
			
			// Si coinciden los id, guardo el nombre de tipologiaSexo.
			for (TipoContrato o : l) {
				if (o.getId() == est.getIdTipoContrato()) {
					datos[i][4] = o.getDescripcion();
				}
			}
			for (Usuario o : usuarios) {
				if (o.getId() == est.getIdUsuario()) {
					datos[i][5] = o.getNombreUsuario();
				}
			}
			 
			datos[i][6] = est.getFechaFirma();
			
		}
		
		return datos;
	}
	
	
}
