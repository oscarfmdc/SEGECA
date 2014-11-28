package ui;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JComboBox;
import javax.swing.JTextPane;

public class UI {

	static JFrame frame;

	//Panel ppal
	static JPanel panelPrincipal;
	static JButton botonActas;
	static JButton botonAgendas;
	static JButton botonCCC;
	
	//Panel output
	static JPanel panelOutput;
	static JLabel label_PanelOutput_Output;

	//Actas
	static JPanel panelActas;
	static JButton buttonOkActas;
	static JButton buttonCancelarActas;
	public static JTextField textFieldAusencias;
	public static JTextField textFieldResultados;

	//Agendas
	static JPanel panelAgendas;
	static JButton buttonOkAgendas;
	static JButton buttonCancelarAgendas;
	public static JTextField textFieldFechaAgendas;
	public static JTextField textFieldLugarAgendas;
	public static JTextField textFieldPropositoAgendas;
	public static JTextField textFieldParticipantesAgendas;
	public static JTextField textFieldHoraInicioAgendas;
	public static JTextField textFieldHoraFinAgendas;
	public static JTextField textFieldCCCAgendas;

	//CCC
	static JPanel panelCCC;
	static JComboBox<String> comboBoxCCC;
	public static JTextField textFieldNombreCCC;
	public static JTextField textFieldPresidente;
	public static JTextField textFieldSecretario;
	public static JTextField textFieldAdministrador;
	private static JLabel lblAdministrador;
	private static JLabel lblMiembros;
	private static JLabel lblPeticiones;
	private static JLabel lblAgendas;
	///CCC Datos
	static JPanel panelDatos;
	private static JLabel lblMiembro;
	public static JTextField textFieldAgenda;
	public static JTextPane textPane_PanelCCC_Miembros;
	public static JTextPane textPane_PanelCCC_Agendas;
	public static JTextPane textPane_PanelCCC_Peticiones;

	//Miembro
	static JPanel panelNuevoMiembro;
	private static JLabel lblNick;
	public static JTextField textField_PanelMiembro_Nick;
	public static JTextField textField_PanelMiembro_Nombre;
	public static JTextField textField_PanelMiembro_Email;
	public static JTextField textField_PanelMiembro_Telefono;
	public static JTextField textField_PanelMiembro_Permisos;
	public static JTextField textField_PanelMiembro_CCC;
	private static JLabel lblEliminarMiembro;
	private static JLabel label;


	//BajaMiembro
	static JPanel panelBajaMiembro;
	public static JTextField textField_PanelBajaMiembro_Nick;
	public static JTextField textField_PanelBajaMiembro_CCC;

	public UI() {
		initialize();
	}

	static void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 751);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//Panel Actas
		panelActas = new JPanel();
		panelActas.setBounds(0, 44, 994, 620);
		panelActas.setVisible(false);

		panelNuevoMiembro = new JPanel();
		panelNuevoMiembro.setBounds(0, 44, 994, 620);
		panelNuevoMiembro.setVisible(false);

		//Panel CCC
		panelCCC = new JPanel();
		panelCCC.setBounds(0, 44, 994, 620);
		panelCCC.setLayout(null);
		panelCCC.setVisible(false);

		//Panel Agendas
		panelAgendas = new JPanel();
		panelAgendas.setBounds(0, 44, 994, 620);
		panelAgendas.setVisible(false);
		panelAgendas.setLayout(null);
		frame.getContentPane().add(panelAgendas);

		JLabel labelAgendas = new JLabel("AGENDAS");
		labelAgendas.setFont(new Font("Tahoma", Font.PLAIN, 32));
		labelAgendas.setBounds(118, 27, 257, 37);
		panelAgendas.add(labelAgendas);

		JLabel labelFechaAgendas = new JLabel("Fecha");
		labelFechaAgendas.setBounds(118, 119, 97, 14);
		panelAgendas.add(labelFechaAgendas);

		JLabel lblLugarAgendas = new JLabel("Lugar");
		lblLugarAgendas.setBounds(118, 166, 97, 14);
		panelAgendas.add(lblLugarAgendas);

		JLabel lblPropositoAgendas = new JLabel("Proposito");
		lblPropositoAgendas.setBounds(118, 213, 97, 14);
		panelAgendas.add(lblPropositoAgendas);

		JLabel lblParticipantesAgendas = new JLabel("Participantes");
		lblParticipantesAgendas.setBounds(118, 260, 97, 14);
		panelAgendas.add(lblParticipantesAgendas);

		JLabel lblHoraInicioAgendas = new JLabel("Hora Inicio");
		lblHoraInicioAgendas.setBounds(118, 307, 97, 14);
		panelAgendas.add(lblHoraInicioAgendas);

		JLabel lblHoraFinAgendas = new JLabel("Hora Fin");
		lblHoraFinAgendas.setBounds(118, 354, 97, 14);
		panelAgendas.add(lblHoraFinAgendas);

		JLabel lblCCCAgendas = new JLabel("CCC");
		lblCCCAgendas.setBounds(118, 401, 97, 14);
		panelAgendas.add(lblCCCAgendas);

		textFieldFechaAgendas = new JTextField();
		textFieldFechaAgendas.setColumns(10);
		textFieldFechaAgendas.setBounds(340, 113, 393, 20);
		panelAgendas.add(textFieldFechaAgendas);

		textFieldLugarAgendas = new JTextField();
		textFieldLugarAgendas.setColumns(10);
		textFieldLugarAgendas.setBounds(340, 160, 393, 20);
		panelAgendas.add(textFieldLugarAgendas);

		textFieldPropositoAgendas = new JTextField();
		textFieldPropositoAgendas.setColumns(10);
		textFieldPropositoAgendas.setBounds(340, 207, 393, 20);
		panelAgendas.add(textFieldPropositoAgendas);

		textFieldParticipantesAgendas = new JTextField();
		textFieldParticipantesAgendas.setColumns(10);
		textFieldParticipantesAgendas.setBounds(340, 254, 393, 20);
		panelAgendas.add(textFieldParticipantesAgendas);

		textFieldHoraInicioAgendas = new JTextField();
		textFieldHoraInicioAgendas.setColumns(10);
		textFieldHoraInicioAgendas.setBounds(340, 301, 393, 20);
		panelAgendas.add(textFieldHoraInicioAgendas);

		textFieldHoraFinAgendas = new JTextField();
		textFieldHoraFinAgendas.setColumns(10);
		textFieldHoraFinAgendas.setBounds(340, 348, 393, 20);
		panelAgendas.add(textFieldHoraFinAgendas);

		textFieldCCCAgendas = new JTextField();
		textFieldCCCAgendas.setColumns(10);
		textFieldCCCAgendas.setBounds(340, 395, 393, 20);
		panelAgendas.add(textFieldCCCAgendas);

		buttonOkAgendas = new JButton("OK");
		buttonOkAgendas.setBounds(636, 465, 97, 37);
		panelAgendas.add(buttonOkAgendas);
		buttonOkAgendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.prepararAgenda();
				panelAgendas.setVisible(false);
				panelPrincipal.setVisible(true);
			}
		});

		buttonCancelarAgendas = new JButton("Cancelar");
		buttonCancelarAgendas.setBounds(340, 465, 103, 37);
		panelAgendas.add(buttonCancelarAgendas);
		buttonCancelarAgendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelAgendas.setVisible(false);
				panelPrincipal.setVisible(true);
			}
		});
		frame.getContentPane().add(panelCCC);

		JLabel lblCcc = new JLabel("CCC");
		lblCcc.setBounds(118, 27, 257, 37);
		lblCcc.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panelCCC.add(lblCcc);
		panelCCC.add(comboBoxCCC);

		JButton buttonEditarCCC = new JButton("Editar");
		buttonEditarCCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//EditarCCC
			}
		});
		buttonEditarCCC.setBounds(286, 445, 89, 23);
		panelCCC.add(buttonEditarCCC);

		JButton buttonBajaCCC = new JButton("Dar de baja");
		buttonBajaCCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.bajaCCC();
			}
		});
		buttonBajaCCC.setBounds(413, 445, 117, 23);
		panelCCC.add(buttonBajaCCC);

		JButton buttonNuevoCCC = new JButton("Crear CCC");
		buttonNuevoCCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.altaCCC();
			}
		});
		buttonNuevoCCC.setBounds(564, 445, 109, 23);
		panelCCC.add(buttonNuevoCCC);

		//CCCDatos
		panelDatos = new JPanel();
		panelDatos.setBounds(118, 136, 806, 290);
		panelCCC.add(panelDatos);
		panelDatos.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(20, 11, 111, 14);
		panelDatos.add(lblNombre);

		textFieldNombreCCC = new JTextField();
		textFieldNombreCCC.setBounds(201, 11, 252, 20);
		panelDatos.add(textFieldNombreCCC);
		textFieldNombreCCC.setColumns(10);

		textFieldPresidente = new JTextField();
		textFieldPresidente.setColumns(10);
		textFieldPresidente.setBounds(201, 49, 252, 20);
		panelDatos.add(textFieldPresidente);

		JLabel lblPresidente = new JLabel("Presidente");
		lblPresidente.setBounds(20, 49, 111, 14);
		panelDatos.add(lblPresidente);

		textFieldSecretario = new JTextField();
		textFieldSecretario.setColumns(10);
		textFieldSecretario.setBounds(201, 87, 252, 20);
		panelDatos.add(textFieldSecretario);

		JLabel lblSecretario = new JLabel("Secretario");
		lblSecretario.setBounds(20, 90, 111, 14);
		panelDatos.add(lblSecretario);

		textFieldAdministrador = new JTextField();
		textFieldAdministrador.setColumns(10);
		textFieldAdministrador.setBounds(201, 125, 252, 20);
		panelDatos.add(textFieldAdministrador);

		lblAdministrador = new JLabel("Administrador");
		lblAdministrador.setBounds(20, 128, 111, 14);
		panelDatos.add(lblAdministrador);

		lblMiembros = new JLabel("Miembros");
		lblMiembros.setBounds(20, 166, 111, 14);
		panelDatos.add(lblMiembros);

		lblPeticiones = new JLabel("Peticiones");
		lblPeticiones.setBounds(20, 242, 111, 14);
		panelDatos.add(lblPeticiones);

		lblAgendas = new JLabel("Agendas");
		lblAgendas.setBounds(20, 204, 111, 14);
		panelDatos.add(lblAgendas);

		JButton button_PanelCCC_BajaMiembro = new JButton("Dar de baja");
		button_PanelCCC_BajaMiembro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBajaMiembro.setVisible(true);
				panelCCC.setVisible(false);
				panelDatos.setVisible(false);
			}
		});
		button_PanelCCC_BajaMiembro.setBounds(515, 160, 117, 23);
		panelDatos.add(button_PanelCCC_BajaMiembro);

		JButton buttoNuevoMiembro = new JButton("Editar/Crear");
		buttoNuevoMiembro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelNuevoMiembro.setVisible(true);
				panelCCC.setVisible(false);
				panelDatos.setVisible(false);
			}
		});
		buttoNuevoMiembro.setBounds(642, 160, 131, 23);
		panelDatos.add(buttoNuevoMiembro);

		JButton buttonMostrarAgendas = new JButton("Detalles");
		buttonMostrarAgendas.setBounds(515, 200, 89, 23);
		panelDatos.add(buttonMostrarAgendas);

		JButton buttonMostrarPeticiones = new JButton("Detalles");
		buttonMostrarPeticiones.setBounds(515, 238, 89, 23);
		panelDatos.add(buttonMostrarPeticiones);

		textPane_PanelCCC_Miembros = new JTextPane();
		textPane_PanelCCC_Miembros.setBounds(201, 160, 252, 20);
		panelDatos.add(textPane_PanelCCC_Miembros);

		textPane_PanelCCC_Agendas = new JTextPane();
		textPane_PanelCCC_Agendas.setBounds(201, 198, 252, 20);
		panelDatos.add(textPane_PanelCCC_Agendas);

		textPane_PanelCCC_Peticiones = new JTextPane();
		textPane_PanelCCC_Peticiones.setBounds(201, 236, 252, 20);
		panelDatos.add(textPane_PanelCCC_Peticiones);

		JButton buttonMostrarCCC = new JButton("Mostrar");
		buttonMostrarCCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.cccSelected();
			}
		});
		buttonMostrarCCC.setBounds(318, 88, 89, 23);
		panelCCC.add(buttonMostrarCCC);
		frame.getContentPane().add(panelNuevoMiembro);
		panelNuevoMiembro.setLayout(null);

		lblMiembro = new JLabel("Miembro");
		lblMiembro.setBounds(113, 32, 403, 39);
		lblMiembro.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panelNuevoMiembro.add(lblMiembro);

		lblNick = new JLabel("Nick");
		lblNick.setBounds(134, 138, 128, 14);
		panelNuevoMiembro.add(lblNick);

		textField_PanelMiembro_Nick = new JTextField();
		textField_PanelMiembro_Nick.setBounds(363, 135, 319, 20);
		textField_PanelMiembro_Nick.setColumns(10);
		panelNuevoMiembro.add(textField_PanelMiembro_Nick);

		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(134, 190, 128, 14);
		panelNuevoMiembro.add(lblNombre_1);

		textField_PanelMiembro_Nombre = new JTextField();
		textField_PanelMiembro_Nombre.setColumns(10);
		textField_PanelMiembro_Nombre.setBounds(363, 187, 319, 20);
		panelNuevoMiembro.add(textField_PanelMiembro_Nombre);

		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setBounds(134, 240, 128, 14);
		panelNuevoMiembro.add(lblEmail);

		textField_PanelMiembro_Email = new JTextField();
		textField_PanelMiembro_Email.setColumns(10);
		textField_PanelMiembro_Email.setBounds(363, 237, 319, 20);
		panelNuevoMiembro.add(textField_PanelMiembro_Email);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(134, 291, 128, 14);
		panelNuevoMiembro.add(lblTelefono);

		textField_PanelMiembro_Telefono = new JTextField();
		textField_PanelMiembro_Telefono.setColumns(10);
		textField_PanelMiembro_Telefono.setBounds(363, 288, 319, 20);
		panelNuevoMiembro.add(textField_PanelMiembro_Telefono);

		JLabel lblPermisos = new JLabel("Permisos");
		lblPermisos.setBounds(134, 341, 128, 14);
		panelNuevoMiembro.add(lblPermisos);

		textField_PanelMiembro_Permisos = new JTextField();
		textField_PanelMiembro_Permisos.setColumns(10);
		textField_PanelMiembro_Permisos.setBounds(363, 338, 319, 20);
		panelNuevoMiembro.add(textField_PanelMiembro_Permisos);

		JLabel lblCcc_1 = new JLabel("CCC");
		lblCcc_1.setBounds(134, 388, 128, 14);
		panelNuevoMiembro.add(lblCcc_1);

		textField_PanelMiembro_CCC = new JTextField();
		textField_PanelMiembro_CCC.setColumns(10);
		textField_PanelMiembro_CCC.setBounds(363, 385, 319, 20);
		panelNuevoMiembro.add(textField_PanelMiembro_CCC);

		JButton button_PanelMiembro_Crear = new JButton("Crear");
		button_PanelMiembro_Crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.altaPersonaCCC();
				panelNuevoMiembro.setVisible(false);
				panelCCC.setVisible(true);
				Controller.cccSelected();
				panelDatos.setVisible(true);
			}
		});
		button_PanelMiembro_Crear.setBounds(684, 494, 95, 20);
		panelNuevoMiembro.add(button_PanelMiembro_Crear);

		JButton buttonCancelarMiembro = new JButton("Cancelar");
		buttonCancelarMiembro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelNuevoMiembro.setVisible(false);
				panelDatos.setVisible(true);
				panelCCC.setVisible(true);
			}
		});
		buttonCancelarMiembro.setBounds(441, 494, 103, 20);
		panelNuevoMiembro.add(buttonCancelarMiembro);

		JButton button_PanelMiembro_Mostrar = new JButton("Mostrar");
		button_PanelMiembro_Mostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.memberSelected();
			}
		});
		button_PanelMiembro_Mostrar.setBounds(718, 134, 89, 23);
		panelNuevoMiembro.add(button_PanelMiembro_Mostrar);

		JButton button_PanelMiembro_Editar = new JButton("Editar");
		button_PanelMiembro_Editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.modMiembrosCCC();
				panelNuevoMiembro.setVisible(false);
				panelCCC.setVisible(true);
				Controller.cccSelected();
				panelDatos.setVisible(true);

			}
		});
		button_PanelMiembro_Editar.setBounds(570, 493, 89, 23);
		panelNuevoMiembro.add(button_PanelMiembro_Editar);

		panelBajaMiembro = new JPanel();
		panelBajaMiembro.setBounds(0, 44, 994, 620);
		panelBajaMiembro.setVisible(false);
		frame.getContentPane().add(panelBajaMiembro);
		panelBajaMiembro.setLayout(null);

		lblEliminarMiembro = new JLabel("Eliminar Miembro");
		lblEliminarMiembro.setBounds(113, 32, 352, 39);
		lblEliminarMiembro.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panelBajaMiembro.add(lblEliminarMiembro);

		label = new JLabel("Nick");
		label.setBounds(140, 140, 128, 14);
		panelBajaMiembro.add(label);

		textField_PanelBajaMiembro_Nick = new JTextField();
		textField_PanelBajaMiembro_Nick.setColumns(10);
		textField_PanelBajaMiembro_Nick.setBounds(320, 137, 319, 20);
		panelBajaMiembro.add(textField_PanelBajaMiembro_Nick);

		textField_PanelBajaMiembro_CCC = new JTextField();
		textField_PanelBajaMiembro_CCC.setColumns(10);
		textField_PanelBajaMiembro_CCC.setBounds(321, 177, 319, 20);
		panelBajaMiembro.add(textField_PanelBajaMiembro_CCC);

		JLabel lblCcc_2 = new JLabel("CCC");
		lblCcc_2.setBounds(141, 180, 128, 14);
		panelBajaMiembro.add(lblCcc_2);

		JButton button_PanelBajaMiembro_EliminarMiembro = new JButton("Eliminar");
		button_PanelBajaMiembro_EliminarMiembro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.bajaPersonaCCC();
				panelBajaMiembro.setVisible(false);
				panelCCC.setVisible(true);
				Controller.cccSelected();
				panelDatos.setVisible(true);

			}
		});
		button_PanelBajaMiembro_EliminarMiembro.setBounds(552, 219, 89, 23);
		panelBajaMiembro.add(button_PanelBajaMiembro_EliminarMiembro);

		JButton button_PanelBajaMiembro_Cancelar = new JButton("Cancelar");
		button_PanelBajaMiembro_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelBajaMiembro.setVisible(false);
				panelCCC.setVisible(true);
				panelDatos.setVisible(true);
			}
		});
		button_PanelBajaMiembro_Cancelar.setBounds(433, 219, 89, 23);
		panelBajaMiembro.add(button_PanelBajaMiembro_Cancelar);
		comboBoxCCC.setBounds(118, 91, 142, 20);
		frame.getContentPane().add(panelActas);
		panelActas.setLayout(null);

		JLabel labelActas = new JLabel("ACTAS");
		labelActas.setFont(new Font("Tahoma", Font.PLAIN, 32));
		labelActas.setBounds(118, 27, 257, 37);
		panelActas.add(labelActas);

		JLabel labelAgenda = new JLabel("Agenda");
		labelAgenda.setToolTipText("nombre del acta");
		labelAgenda.setBounds(118, 101, 97, 14);
		panelActas.add(labelAgenda);

		JLabel labelAusencias = new JLabel("Ausencias");
		labelAusencias.setBounds(118, 148, 97, 14);
		panelActas.add(labelAusencias);

		JLabel lblResultados = new JLabel("Resultados");
		lblResultados.setBounds(118, 195, 97, 14);
		panelActas.add(lblResultados);

		textFieldAusencias = new JTextField();
		textFieldAusencias.setColumns(10);
		textFieldAusencias.setBounds(340, 142, 393, 20);
		panelActas.add(textFieldAusencias);

		textFieldResultados = new JTextField();
		textFieldResultados.setColumns(10);
		textFieldResultados.setBounds(340, 189, 393, 20);
		panelActas.add(textFieldResultados);

		buttonOkActas = new JButton("OK");
		buttonOkActas.setBounds(636, 255, 97, 20);
		panelActas.add(buttonOkActas);
		buttonOkActas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.prepararActa();
				panelActas.setVisible(false);
			}
		});

		buttonCancelarActas = new JButton("Cancelar");
		buttonCancelarActas.setBounds(492, 255, 103, 20);
		panelActas.add(buttonCancelarActas);

		textFieldAgenda = new JTextField();
		textFieldAgenda.setColumns(10);
		textFieldAgenda.setBounds(340, 98, 393, 20);
		panelActas.add(textFieldAgenda);
		buttonCancelarActas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelActas.setVisible(false);
			}
		});

		//Panel Principal
		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 994, 44);
		panelPrincipal.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);
		botonAgendas = new JButton("Agendas");
		botonAgendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelAgendas.setVisible(true);
				panelActas.setVisible(false);
				panelCCC.setVisible(false);
				panelDatos.setVisible(false);
				panelNuevoMiembro.setVisible(false);
			}
		});
		botonAgendas.setBounds(25, 11, 87, 23);
		panelPrincipal.add(botonAgendas);

		botonCCC = new JButton("CCC");
		botonCCC.setBounds(272, 11, 80, 23);
		panelPrincipal.add(botonCCC);

		botonActas = new JButton("Actas");
		botonActas.setBounds(154, 11, 79, 23);
		panelPrincipal.add(botonActas);

		panelOutput = new JPanel();
		panelOutput.setBounds(0, 666, 994, 54);
		frame.getContentPane().add(panelOutput);
		panelOutput.setBackground(SystemColor.activeCaptionBorder);
		panelOutput.setLayout(null);

		label_PanelOutput_Output = new JLabel("Output");
		label_PanelOutput_Output.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_PanelOutput_Output.setBounds(27, 11, 935, 26);
		panelOutput.add(label_PanelOutput_Output);
		botonActas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelActas.setVisible(true);
				panelAgendas.setVisible(false);
				panelCCC.setVisible(false);
				panelDatos.setVisible(false);
				panelNuevoMiembro.setVisible(false);
			}
		});
		botonCCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelActas.setVisible(false);
				panelAgendas.setVisible(false);
				panelCCC.setVisible(true);
				panelDatos.setVisible(true);
				panelNuevoMiembro.setVisible(false);
			}
		});

	}
}
