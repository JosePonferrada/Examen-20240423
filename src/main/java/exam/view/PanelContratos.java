package exam.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JTextField;

import exam.controladores.ControladorContrato;
import exam.controladores.ControladorUsuario;
import exam.entities.Contrato;
import exam.entities.Usuario;


import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelContratos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfDescripcion;
	private JTextField jtfSaldo;
	private JTextField jtfLimite;
	private JTextField jtfFechaFirma;
	private JButton btnGuardar;
	private JButton btnGestionarUsuario;
	public JComboBox<Usuario> jcbUsuario;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private PanelTabla panelTabla;
	
	private ButtonGroup jbgroup;
	private JRadioButton rdbtCuentaBancaria;
	private JRadioButton rdbtnTarjetaCrdito;
	private JRadioButton rdbtnTarjetaDbito;
	private JRadioButton rdbtnPrstamo;
	

	/**
	 * Create the panel.
	 */
	public PanelContratos() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblGestinDeContratos = new JLabel("Gestión de Contratos");
		GridBagConstraints gbc_lblGestinDeContratos = new GridBagConstraints();
		gbc_lblGestinDeContratos.gridwidth = 5;
		gbc_lblGestinDeContratos.insets = new Insets(0, 0, 5, 0);
		gbc_lblGestinDeContratos.gridx = 0;
		gbc_lblGestinDeContratos.gridy = 0;
		add(lblGestinDeContratos, gbc_lblGestinDeContratos);
		
		JLabel lblId = new JLabel("Id:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		add(lblId, gbc_lblId);
		
		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 3;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		rdbtCuentaBancaria = new JRadioButton("Cuenta bancaria");
		GridBagConstraints gbc_rdbtCuentaBancaria = new GridBagConstraints();
		gbc_rdbtCuentaBancaria.anchor = GridBagConstraints.WEST;
		gbc_rdbtCuentaBancaria.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtCuentaBancaria.gridx = 1;
		gbc_rdbtCuentaBancaria.gridy = 2;
		add(rdbtCuentaBancaria, gbc_rdbtCuentaBancaria);
		
		rdbtnTarjetaCrdito = new JRadioButton("Tarjeta crédito");
		GridBagConstraints gbc_rdbtnTarjetaCrdito = new GridBagConstraints();
		gbc_rdbtnTarjetaCrdito.anchor = GridBagConstraints.WEST;
		gbc_rdbtnTarjetaCrdito.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTarjetaCrdito.gridx = 2;
		gbc_rdbtnTarjetaCrdito.gridy = 2;
		add(rdbtnTarjetaCrdito, gbc_rdbtnTarjetaCrdito);
		
		JLabel lblTipoDeContrato = new JLabel("Tipo de Contrato:");
		GridBagConstraints gbc_lblTipoDeContrato = new GridBagConstraints();
		gbc_lblTipoDeContrato.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoDeContrato.gridx = 0;
		gbc_lblTipoDeContrato.gridy = 3;
		add(lblTipoDeContrato, gbc_lblTipoDeContrato);
		
		rdbtnTarjetaDbito = new JRadioButton("Tarjeta débito");
		GridBagConstraints gbc_rdbtnTarjetaDbito = new GridBagConstraints();
		gbc_rdbtnTarjetaDbito.anchor = GridBagConstraints.WEST;
		gbc_rdbtnTarjetaDbito.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnTarjetaDbito.gridx = 1;
		gbc_rdbtnTarjetaDbito.gridy = 3;
		add(rdbtnTarjetaDbito, gbc_rdbtnTarjetaDbito);
		
		rdbtnPrstamo = new JRadioButton("Préstamo");
		GridBagConstraints gbc_rdbtnPrstamo = new GridBagConstraints();
		gbc_rdbtnPrstamo.anchor = GridBagConstraints.WEST;
		gbc_rdbtnPrstamo.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnPrstamo.gridx = 2;
		gbc_rdbtnPrstamo.gridy = 3;
		add(rdbtnPrstamo, gbc_rdbtnPrstamo);
		
		JLabel lblDescripcin = new JLabel("Descripción:");
		GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
		gbc_lblDescripcin.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcin.gridx = 0;
		gbc_lblDescripcin.gridy = 4;
		add(lblDescripcin, gbc_lblDescripcin);
		
		jtfDescripcion = new JTextField();
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.gridwidth = 3;
		gbc_jtfDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 4;
		add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 5;
		add(lblUsuario, gbc_lblUsuario);
		
		jcbUsuario = new JComboBox<Usuario>();
		GridBagConstraints gbc_jcbUsuario = new GridBagConstraints();
		gbc_jcbUsuario.gridwidth = 2;
		gbc_jcbUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_jcbUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbUsuario.gridx = 1;
		gbc_jcbUsuario.gridy = 5;
		add(jcbUsuario, gbc_jcbUsuario);
		
		btnGestionarUsuario = new JButton("Gestionar Usuario");
		btnGestionarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showJDialogProveedor();
			}
		});
		GridBagConstraints gbc_btnGestionarUsuario = new GridBagConstraints();
		gbc_btnGestionarUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_btnGestionarUsuario.gridx = 3;
		gbc_btnGestionarUsuario.gridy = 5;
		add(btnGestionarUsuario, gbc_btnGestionarUsuario);
		
		JLabel lblSaldo = new JLabel("Saldo(€):");
		GridBagConstraints gbc_lblSaldo = new GridBagConstraints();
		gbc_lblSaldo.anchor = GridBagConstraints.EAST;
		gbc_lblSaldo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaldo.gridx = 0;
		gbc_lblSaldo.gridy = 6;
		add(lblSaldo, gbc_lblSaldo);
		
		jtfSaldo = new JTextField();
		GridBagConstraints gbc_jtfSaldo = new GridBagConstraints();
		gbc_jtfSaldo.gridwidth = 3;
		gbc_jtfSaldo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfSaldo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSaldo.gridx = 1;
		gbc_jtfSaldo.gridy = 6;
		add(jtfSaldo, gbc_jtfSaldo);
		jtfSaldo.setColumns(10);
		
		JLabel lblLmite = new JLabel("Límite(€):");
		GridBagConstraints gbc_lblLmite = new GridBagConstraints();
		gbc_lblLmite.anchor = GridBagConstraints.EAST;
		gbc_lblLmite.insets = new Insets(0, 0, 5, 5);
		gbc_lblLmite.gridx = 0;
		gbc_lblLmite.gridy = 7;
		add(lblLmite, gbc_lblLmite);
		
		jtfLimite = new JTextField();
		GridBagConstraints gbc_jtfLimite = new GridBagConstraints();
		gbc_jtfLimite.gridwidth = 3;
		gbc_jtfLimite.insets = new Insets(0, 0, 5, 0);
		gbc_jtfLimite.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLimite.gridx = 1;
		gbc_jtfLimite.gridy = 7;
		add(jtfLimite, gbc_jtfLimite);
		jtfLimite.setColumns(10);
		
		JLabel lblFechaDeFirma = new JLabel("Fecha de firma:");
		GridBagConstraints gbc_lblFechaDeFirma = new GridBagConstraints();
		gbc_lblFechaDeFirma.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeFirma.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeFirma.gridx = 0;
		gbc_lblFechaDeFirma.gridy = 8;
		add(lblFechaDeFirma, gbc_lblFechaDeFirma);
		
		jtfFechaFirma = new JTextField();
		GridBagConstraints gbc_jtfFechaFirma = new GridBagConstraints();
		gbc_jtfFechaFirma.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFechaFirma.gridwidth = 3;
		gbc_jtfFechaFirma.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFechaFirma.gridx = 1;
		gbc_jtfFechaFirma.gridy = 8;
		add(jtfFechaFirma, gbc_jtfFechaFirma);
		jtfFechaFirma.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridwidth = 4;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 10;
		add(btnGuardar, gbc_btnGuardar);
		
		jbgroup = new ButtonGroup();
		
		jbgroup.add(rdbtCuentaBancaria);
		jbgroup.add(rdbtnPrstamo);
		jbgroup.add(rdbtnTarjetaCrdito);
		jbgroup.add(rdbtnTarjetaDbito);
		
		loadAllUsers();
		
	}
	
	private void guardar() {
		///PROCESO DE GUARDADO///
		Contrato p = new Contrato();
		
		p.setId(Integer.parseInt(this.jtfId.getText()));
		p.setDescripcion(this.jtfDescripcion.getText());
		p.setSaldo( Float.parseFloat(this.jtfSaldo.getText()));
		p.setLimite( Float.parseFloat(this.jtfLimite.getText()));
		p.setIdUsuario((int) this.jcbUsuario.getSelectedItem());
		
		
		String str = this.jtfFechaFirma.getText();
		if (!str.trim().equals("")) {
			try {
				p.setFechaFirma(sdf.parse(this.jtfFechaFirma.getText()));
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null,
						"Error. La fecha de alta debe tener el siguiente formato: dd/MM/yyyy");
				return;
			}
		} else {
			p.setFechaFirma(null);
		}
		
		if (this.rdbtCuentaBancaria.isSelected()) {
			p.setIdTipoContrato(1);
		} else if (this.rdbtnTarjetaDbito.isSelected()) {
			p.setIdTipoContrato(2);
		} else if (this.rdbtnTarjetaCrdito.isSelected()) {
			p.setIdTipoContrato(3);
		} else {
			p.setIdTipoContrato(4);
		}
		
		// Efectuamos el guardado.
		if (descripcionValida(jtfDescripcion)) {
			ControladorContrato.getInstance().updateProveedor(p);
		}
	}
	
	public void loadAllProveedores() {
		
		jcbUsuario.removeAllItems();
		
		List<Usuario> proveedores = (List<Usuario>) ControladorUsuario
				.getInstance().findAll();
		
		for (Usuario proveedor : proveedores) {
			this.jcbUsuario.addItem(proveedor);
		}
	}
	
	private void loadAllUsers() {
		List<Usuario> lista = (List<Usuario>) ControladorUsuario
				.getInstance().findAll();
		for (Usuario ts : lista) {
			this.jcbUsuario.addItem(ts);
		}
	}
	
	public void muestraEnPantalla (Contrato c) {
		
		if (c != null) {
			this.jtfId.setText(c.getId() + "");
			
			switch (c.getIdTipoContrato()) {
			case 1:
				this.rdbtCuentaBancaria.setSelected(true);
				break;
			case 2:
				this.rdbtnTarjetaDbito.setSelected(true);
				break;
			case 3:
				this.rdbtnTarjetaCrdito.setSelected(true);
				break;
			case 4:
				this.rdbtnPrstamo.setSelected(true);
				break;
			}
			
			this.jtfDescripcion.setText(c.getDescripcion());
			
			for (int i = 0; i < this.jcbUsuario.getItemCount(); i++) {
				if (this.jcbUsuario.getItemAt(i).getId() == c.getIdUsuario()) {
					this.jcbUsuario.setSelectedIndex(i);
				}
			}
			
			this.jtfSaldo.setText(c.getSaldo() + "");
			this.jtfLimite.setText(c.getLimite() + "");
			this.jtfFechaFirma.setText(sdf.format(c.getFechaFirma()));
			
		}
		
	}

	public PanelTabla setPanelTabla(PanelTabla panelTabla) {
		return this.panelTabla = panelTabla;
	}
	
	private void showJDialogProveedor() {
		
		JDialog dialogo = new JDialog();
		// El usuario no puede redimensionar el diálogo
		dialogo.setResizable(true);
		// título del díalogo
		dialogo.setTitle("JDialog - Gestión Proveedor");
		// Introducimos el PanelProveedor al JDialog,
		// pasándole como parámetro el PanelArticulo actual. Es decir,
		// estamos pasando una referencia a la instancia actual de
		// PanelArticulo.
		// Además, le pasamos el panelProveedor el propio JDialog, consiguiendo
		// una instancia del mismo para poder realizar la actualización de los
		// datos del jcbProveedores.
		dialogo.setContentPane(new PanelUsuarios(this, dialogo));
		// Empaquetar el di�logo hace que todos los componentes ocupen el espacio que deben y el lugar adecuado
		dialogo.pack();
		// El usuario no puede hacer clic sobre la ventana padre, si el Di�logo es modal
		dialogo.setModal(true);
		// Centro el di�logo en pantalla
		dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - dialogo.getWidth()/2, 
				(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - dialogo.getHeight()/2);
		// Muestro el di�logo en pantalla
		dialogo.setVisible(true);
	}
	
	public static boolean descripcionValida(JTextField jtfDescripcion) {
		
		if(jtfDescripcion.getText().length() >= 4) return true;
		else return false;
	}
	
}
