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
public class UI {

	static JFrame frame;

	//Panel ppal
	static JPanel panelPrincipal;
	static JButton botonActas;
	static JButton botonAgendas;
	static JButton botonCCC;

	//Actas
	static JPanel panelActas;
	static JButton buttonOkActas;
	static JButton buttonCancelarActas;
	static JTextField textFieldNombreActas;
	static JTextField textFieldFechaActas;
	static JTextField textFieldLugarActas;
	static JTextField textFieldPropositoActas;
	static JTextField textFieldParticipantesActas;
	static JTextField textFieldHoraInicioActas;
	static JTextField textFieldHoraFinActas;
	static JTextField textFieldCCCActas;

	//Agendas
	static JPanel panelAgendas;
	static JButton buttonOkAgendas;
	static JButton buttonCancelarAgendas;
	static JTextField textFieldNombreAgendas;
	static JTextField textFieldFechaAgendas;
	static JTextField textFieldLugarAgendas;
	static JTextField textFieldPropositoAgendas;
	static JTextField textFieldParticipantesAgendas;
	static JTextField textFieldHoraInicioAgendas;
	static JTextField textFieldHoraFinAgendas;
	static JTextField textFieldCCCAgendas;

	//CCC
	static JPanel panelCCC;
	static JComboBox<?> comboBox;
	static String[] listaCCC = {"Nuevo","CC1","CC2","CCC3"};
	static JTextField textField_4;
	static JTextField textField_5;
	static JTextField textField_6;
	static JTextField textField_7;
	static JLabel lblAdministrador;
	static JLabel lblMiembros;
	static JLabel lblPeticiones;
	static JLabel lblAgendas;
	///CCC Datos
	static JPanel panelDatos;
	static JLabel lblMiembro;
	

	public UI() {
		initialize();
	}

	static void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 751);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Panel CCC

		panelCCC = new JPanel();
		panelCCC.setBounds(0, 44, 994, 620);
		panelCCC.setLayout(null);
		panelCCC.setVisible(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panelPersona = new JPanel();
		panelPersona.setBounds(0, 44, 994, 620);
		panelPersona.setVisible(false);
		frame.getContentPane().add(panelPersona);
		
		lblMiembro = new JLabel("Miembro");
		lblMiembro.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panelPersona.add(lblMiembro);
		frame.getContentPane().add(panelCCC);

		JLabel lblCcc = new JLabel("CCC");
		lblCcc.setBounds(118, 27, 257, 37);
		lblCcc.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panelCCC.add(lblCcc);
		comboBox = new JComboBox(listaCCC);
		comboBox.setBounds(118, 91, 142, 20);
		panelCCC.add(comboBox);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(296, 90, 89, 23);
		panelCCC.add(btnEditar);

		JButton btnBaja = new JButton("Dar de baja");
		btnBaja.setBounds(423, 90, 117, 23);
		panelCCC.add(btnBaja);

		JButton btnNuevoCcc = new JButton("Crear CCC");
		btnNuevoCcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelCCC.setVisible(false);
			}
		});
		btnNuevoCcc.setBounds(574, 90, 109, 23);
		panelCCC.add(btnNuevoCcc);

		//CCCDatos
		panelDatos = new JPanel();
		panelDatos.setBounds(118, 136, 806, 290);
		panelCCC.add(panelDatos);
		panelDatos.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(20, 11, 111, 14);
		panelDatos.add(lblNombre);

		textField_4 = new JTextField();
		textField_4.setBounds(201, 11, 252, 20);
		panelDatos.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(201, 49, 252, 20);
		panelDatos.add(textField_5);

		JLabel lblPresidente = new JLabel("Presidente");
		lblPresidente.setBounds(20, 49, 111, 14);
		panelDatos.add(lblPresidente);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(201, 87, 252, 20);
		panelDatos.add(textField_6);

		JLabel lblSecretario = new JLabel("Secretario");
		lblSecretario.setBounds(20, 90, 111, 14);
		panelDatos.add(lblSecretario);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(201, 125, 252, 20);
		panelDatos.add(textField_7);

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

		JComboBox comboBox_1 = new JComboBox(new Object[]{});
		comboBox_1.setBounds(201, 163, 193, 20);
		panelDatos.add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox(new Object[]{});
		comboBox_2.setBounds(201, 201, 193, 20);
		panelDatos.add(comboBox_2);

		JComboBox comboBox_3 = new JComboBox(new Object[]{});
		comboBox_3.setBounds(201, 239, 193, 20);
		panelDatos.add(comboBox_3);

		JButton button = new JButton("Editar");
		button.setBounds(416, 160, 89, 23);
		panelDatos.add(button);

		JButton button_1 = new JButton("Dar de baja");
		button_1.setBounds(515, 160, 117, 23);
		panelDatos.add(button_1);

		JButton btnNuevo = new JButton("Nuevo Miembro");
		btnNuevo.setBounds(642, 160, 135, 23);
		panelDatos.add(btnNuevo);

		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setBounds(416, 200, 89, 23);
		panelDatos.add(btnMostrar);

		JButton btnMostrar_1 = new JButton("Mostrar");
		btnMostrar_1.setBounds(416, 238, 89, 23);
		panelDatos.add(btnMostrar_1);

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

		JLabel labelNombreAgendas = new JLabel("Nombre");
		labelNombreAgendas.setToolTipText("nombre del acta");
		labelNombreAgendas.setBounds(118, 101, 97, 14);
		panelAgendas.add(labelNombreAgendas);

		JLabel labelFechaAgendas = new JLabel("Fecha");
		labelFechaAgendas.setBounds(118, 148, 97, 14);
		panelAgendas.add(labelFechaAgendas);

		JLabel lblLugarAgendas = new JLabel("Lugar");
		lblLugarAgendas.setBounds(118, 195, 97, 14);
		panelAgendas.add(lblLugarAgendas);

		JLabel lblPropositoAgendas = new JLabel("Proposito");
		lblPropositoAgendas.setBounds(118, 242, 97, 14);
		panelAgendas.add(lblPropositoAgendas);

		JLabel lblParticipantesAgendas = new JLabel("Participantes");
		lblParticipantesAgendas.setBounds(118, 289, 97, 14);
		panelAgendas.add(lblParticipantesAgendas);

		JLabel lblHoraInicioAgendas = new JLabel("Hora Inicio");
		lblHoraInicioAgendas.setBounds(118, 336, 97, 14);
		panelAgendas.add(lblHoraInicioAgendas);

		JLabel lblHoraFinAgendas = new JLabel("Hora Fin");
		lblHoraFinAgendas.setBounds(118, 383, 97, 14);
		panelAgendas.add(lblHoraFinAgendas);

		JLabel lblCCCAgendas = new JLabel("CCC");
		lblCCCAgendas.setBounds(118, 430, 97, 14);
		panelAgendas.add(lblCCCAgendas);

		textFieldNombreAgendas = new JTextField();
		textFieldNombreAgendas.setBounds(340, 98, 393, 20);
		panelAgendas.add(textFieldNombreAgendas);
		textFieldNombreAgendas.setColumns(10);

		textFieldFechaAgendas = new JTextField();
		textFieldFechaAgendas.setColumns(10);
		textFieldFechaAgendas.setBounds(340, 142, 393, 20);
		panelAgendas.add(textFieldFechaAgendas);

		textFieldLugarAgendas = new JTextField();
		textFieldLugarAgendas.setColumns(10);
		textFieldLugarAgendas.setBounds(340, 189, 393, 20);
		panelAgendas.add(textFieldLugarAgendas);

		textFieldPropositoAgendas = new JTextField();
		textFieldPropositoAgendas.setColumns(10);
		textFieldPropositoAgendas.setBounds(340, 236, 393, 20);
		panelAgendas.add(textFieldPropositoAgendas);

		textFieldParticipantesAgendas = new JTextField();
		textFieldParticipantesAgendas.setColumns(10);
		textFieldParticipantesAgendas.setBounds(340, 283, 393, 20);
		panelAgendas.add(textFieldParticipantesAgendas);

		textFieldHoraInicioAgendas = new JTextField();
		textFieldHoraInicioAgendas.setColumns(10);
		textFieldHoraInicioAgendas.setBounds(340, 330, 393, 20);
		panelAgendas.add(textFieldHoraInicioAgendas);

		textFieldHoraFinAgendas = new JTextField();
		textFieldHoraFinAgendas.setColumns(10);
		textFieldHoraFinAgendas.setBounds(340, 377, 393, 20);
		panelAgendas.add(textFieldHoraFinAgendas);

		textFieldCCCAgendas = new JTextField();
		textFieldCCCAgendas.setColumns(10);
		textFieldCCCAgendas.setBounds(340, 424, 393, 20);
		panelAgendas.add(textFieldCCCAgendas);

		buttonOkAgendas = new JButton("OK");
		buttonOkAgendas.setBounds(636, 494, 97, 37);
		panelAgendas.add(buttonOkAgendas);
		buttonOkAgendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.prepararAgenda();
				panelAgendas.setVisible(false);
				panelPrincipal.setVisible(true);
			}
		});	

		buttonCancelarAgendas = new JButton("Cancelar");
		buttonCancelarAgendas.setBounds(340, 494, 103, 37);
		panelAgendas.add(buttonCancelarAgendas);
		buttonCancelarAgendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelAgendas.setVisible(false);
				panelPrincipal.setVisible(true);
			}
		});	




		//Panel Actas

		panelActas = new JPanel();
		panelActas.setBounds(0, 44, 994, 620);
		panelActas.setVisible(false);
		frame.getContentPane().add(panelActas);
		panelActas.setLayout(null);

		JLabel labelActas = new JLabel("ACTAS");
		labelActas.setFont(new Font("Tahoma", Font.PLAIN, 32));
		labelActas.setBounds(118, 27, 257, 37);
		panelActas.add(labelActas);

		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setToolTipText("nombre del acta");
		labelNombre.setBounds(118, 101, 97, 14);
		panelActas.add(labelNombre);

		JLabel labelFecha = new JLabel("Fecha");
		labelFecha.setBounds(118, 148, 97, 14);
		panelActas.add(labelFecha);

		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(118, 195, 97, 14);
		panelActas.add(lblLugar);

		JLabel lblProposito = new JLabel("Proposito");
		lblProposito.setBounds(118, 242, 97, 14);
		panelActas.add(lblProposito);

		JLabel lblParticipantes = new JLabel("Participantes");
		lblParticipantes.setBounds(118, 289, 97, 14);
		panelActas.add(lblParticipantes);

		JLabel lblHoraInicio = new JLabel("Hora Inicio");
		lblHoraInicio.setBounds(118, 336, 97, 14);
		panelActas.add(lblHoraInicio);

		JLabel lblHoraFin = new JLabel("Hora Fin");
		lblHoraFin.setBounds(118, 383, 97, 14);
		panelActas.add(lblHoraFin);

		JLabel lblCCC = new JLabel("CCC");
		lblCCC.setBounds(118, 430, 97, 14);
		panelActas.add(lblCCC);

		textFieldNombreActas = new JTextField();
		textFieldNombreActas.setBounds(340, 98, 393, 20);
		panelActas.add(textFieldNombreActas);
		textFieldNombreActas.setColumns(10);

		textFieldFechaActas = new JTextField();
		textFieldFechaActas.setColumns(10);
		textFieldFechaActas.setBounds(340, 142, 393, 20);
		panelActas.add(textFieldFechaActas);

		textFieldLugarActas = new JTextField();
		textFieldLugarActas.setColumns(10);
		textFieldLugarActas.setBounds(340, 189, 393, 20);
		panelActas.add(textFieldLugarActas);

		textFieldPropositoActas = new JTextField();
		textFieldPropositoActas.setColumns(10);
		textFieldPropositoActas.setBounds(340, 236, 393, 20);
		panelActas.add(textFieldPropositoActas);

		textFieldParticipantesActas = new JTextField();
		textFieldParticipantesActas.setColumns(10);
		textFieldParticipantesActas.setBounds(340, 283, 393, 20);
		panelActas.add(textFieldParticipantesActas);

		textFieldHoraInicioActas = new JTextField();
		textFieldHoraInicioActas.setColumns(10);
		textFieldHoraInicioActas.setBounds(340, 330, 393, 20);
		panelActas.add(textFieldHoraInicioActas);

		textFieldHoraFinActas = new JTextField();
		textFieldHoraFinActas.setColumns(10);
		textFieldHoraFinActas.setBounds(340, 377, 393, 20);
		panelActas.add(textFieldHoraFinActas);

		textFieldCCCActas = new JTextField();
		textFieldCCCActas.setColumns(10);
		textFieldCCCActas.setBounds(340, 424, 393, 20);
		panelActas.add(textFieldCCCActas);

		buttonOkActas = new JButton("OK");
		buttonOkActas.setBounds(636, 494, 97, 37);
		panelActas.add(buttonOkActas);
		buttonOkActas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.prepararActa();
				panelActas.setVisible(false);
			}
		});	

		buttonCancelarActas = new JButton("Cancelar");
		buttonCancelarActas.setBounds(340, 494, 103, 37);
		panelActas.add(buttonCancelarActas);
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
			}
		});
		botonAgendas.setBounds(134, 11, 87, 23);
		panelPrincipal.add(botonAgendas);

		botonCCC = new JButton("CCC");
		botonCCC.setBounds(272, 11, 80, 23);
		panelPrincipal.add(botonCCC);

		botonActas = new JButton("Actas");
		botonActas.setBounds(10, 11, 79, 23);
		panelPrincipal.add(botonActas);
		
		JPanel panelOutput = new JPanel();
		panelOutput.setBounds(0, 666, 994, 54);
		frame.getContentPane().add(panelOutput);
		panelOutput.setBackground(SystemColor.activeCaptionBorder);
		panelOutput.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Output");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(27, 11, 935, 26);
		panelOutput.add(lblNewLabel);
		botonActas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelActas.setVisible(true);
				panelAgendas.setVisible(false);
				panelCCC.setVisible(false);
			}
		});		
		botonCCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelActas.setVisible(false);
				panelAgendas.setVisible(false);
				panelCCC.setVisible(true);
			}
		});


	}

	public static JFrame getFrame() {
		return frame;
	}
}
