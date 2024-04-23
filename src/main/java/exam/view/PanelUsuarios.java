package exam.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.JTextField;

import exam.controladores.ControladorUsuario;
import exam.entities.Usuario;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;

public class PanelUsuarios extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfUsuario;
	private JPasswordField jpwfPassword;
	private JTextField jtfEmail;
	private JComboBox jcbColorPreferido;
	private JButton btnGuardar;
	public PanelContratos panelContratos;
	public JDialog dialogo;

	/**
	 * Create the panel.
	 * @param dialogo 
	 * @param panelContratos 
	 */
	public PanelUsuarios(PanelContratos panelContratos, JDialog dialogo) {
		
		this.panelContratos = panelContratos;
		this.dialogo = dialogo;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblGestinDeUsuarios = new JLabel("Gestión de usuarios");
		GridBagConstraints gbc_lblGestinDeUsuarios = new GridBagConstraints();
		gbc_lblGestinDeUsuarios.gridwidth = 3;
		gbc_lblGestinDeUsuarios.insets = new Insets(0, 0, 5, 5);
		gbc_lblGestinDeUsuarios.gridx = 0;
		gbc_lblGestinDeUsuarios.gridy = 0;
		add(lblGestinDeUsuarios, gbc_lblGestinDeUsuarios);
		
		JLabel lblId = new JLabel("Id:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		add(lblId, gbc_lblId);
		
		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 2;
		add(lblUsuario, gbc_lblUsuario);
		
		jtfUsuario = new JTextField();
		GridBagConstraints gbc_jtfUsuario = new GridBagConstraints();
		gbc_jtfUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_jtfUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUsuario.gridx = 1;
		gbc_jtfUsuario.gridy = 2;
		add(jtfUsuario, gbc_jtfUsuario);
		jtfUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 0;
		gbc_lblContrasea.gridy = 3;
		add(lblContrasea, gbc_lblContrasea);
		
		jpwfPassword = new JPasswordField();
		GridBagConstraints gbc_jpwfPassword = new GridBagConstraints();
		gbc_jpwfPassword.insets = new Insets(0, 0, 5, 0);
		gbc_jpwfPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_jpwfPassword.gridx = 1;
		gbc_jpwfPassword.gridy = 3;
		add(jpwfPassword, gbc_jpwfPassword);
		
		JLabel lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 4;
		add(lblEmail, gbc_lblEmail);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 4;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblColorPreferido = new JLabel("Color preferido:");
		GridBagConstraints gbc_lblColorPreferido = new GridBagConstraints();
		gbc_lblColorPreferido.anchor = GridBagConstraints.EAST;
		gbc_lblColorPreferido.insets = new Insets(0, 0, 5, 5);
		gbc_lblColorPreferido.gridx = 0;
		gbc_lblColorPreferido.gridy = 5;
		add(lblColorPreferido, gbc_lblColorPreferido);
		
		jcbColorPreferido = new JComboBox();
		GridBagConstraints gbc_jcbColorPreferido = new GridBagConstraints();
		gbc_jcbColorPreferido.insets = new Insets(0, 0, 5, 0);
		gbc_jcbColorPreferido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbColorPreferido.gridx = 1;
		gbc_jcbColorPreferido.gridy = 5;
		add(jcbColorPreferido, gbc_jcbColorPreferido);
		
		btnGuardar = new JButton("Guardar");
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 6;
		add(btnGuardar, gbc_btnGuardar);
		
		loadColores();
		
		showProveedor();

	}
	
	private void guardar() {
		///PROCESO DE GUARDADO///
		Usuario p = new Usuario();
		
		p.setId(Integer.parseInt(this.jtfId.getText()));
		p.setNombreUsuario(this.jtfUsuario.getText());
		p.setColorPreferido((String) this.jcbColorPreferido.getSelectedItem());
		p.setEmail(this.jtfEmail.getText());
		p.setPassword(this.jpwfPassword.getText());
		
		
		// Efectuamos el guardado.
		if (emailValido() && userValid() && passValid()) {
			ControladorUsuario.getInstance().updateProveedor(p);

		}
	}
	
	public boolean emailValido() {
		return this.jtfEmail.getText().matches(".+[@].+[.].+");
	}
	
	public boolean userValid() {
		if(this.jtfUsuario.getText().equals("")) {
			return false;
		}
		return true;
	}
	
	public boolean passValid() {
		if(this.jpwfPassword.getText().equals("")) {
			return false;
		}
		return true;
	}

	private void showProveedor() {
		
		Usuario p = (Usuario) this.panelContratos.jcbUsuario
				.getSelectedItem();
		
		if (p != null) {
			this.jtfId.setText("" + p.getId());
			this.jtfUsuario.setText(p.getNombreUsuario());
			this.jpwfPassword.setText(p.getPassword());
			this.jtfEmail.setText(p.getEmail());
			
			
			for (int i = 0; i < this.jcbColorPreferido.getItemCount(); i++) {
				if (this.jcbColorPreferido.getItemAt(i).equals(p.getColorPreferido())) {
					this.jcbColorPreferido.setSelectedIndex(i);
				}
			}
			
			try {
				if (p.getColorPreferido() != null) {
					Color color = Color.decode(p.getColorPreferido());
					this.setColor(color);
				} else {
					this.setColor(null);
				}
			} catch (NumberFormatException e) {
				this.setColor(null);
				
			}
			
		}
	}
	
	public void setColor(Color color) {
		this.setBackground(color);
	}
	
	
	private void loadColores() {
		this.jcbColorPreferido.addItem("#FF00FF");
		this.jcbColorPreferido.addItem("#9890A5");
		this.jcbColorPreferido.addItem("#765456");
		this.jcbColorPreferido.addItem("#879876");
		this.jcbColorPreferido.setSelectedIndex(0);
	}
	
}
