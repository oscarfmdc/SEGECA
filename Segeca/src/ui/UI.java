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
public class UI {

	static private JFrame frame;

	//Panel ppal
	static private JPanel panelPrincipal;
	static private JButton botonActas;
	static private JButton botonAgendas;
	static private JButton botonCCC;

	//Actas
	static private JPanel panelActas;
	static private JButton buttonOkActas;
	static private JButton buttonCancelarActas;
	static private JTextField textFieldNombreActas;
	static private JTextField textFieldFechaActas;
	static private JTextField textFieldLugarActas;
	static private JTextField textFieldPropositoActas;
	static private JTextField textFieldParticipantesActas;
	static private JTextField textFieldHoraInicioActas;
	static private JTextField textFieldHoraFinActas;
	static private JTextField textFieldCCCActas;

	//Agendas
	static private JPanel panelAgendas;
	static private JButton buttonOkAgendas;
	static private JButton buttonCancelarAgendas;
	static private JTextField textFieldNombreAgendas;
	static private JTextField textFieldFechaAgendas;
	static private JTextField textFieldLugarAgendas;
	static private JTextField textFieldPropositoAgendas;
	static private JTextField textFieldParticipantesAgendas;
	static private JTextField textFieldHoraInicioAgendas;
	static private JTextField textFieldHoraFinAgendas;
	static private JTextField textFieldCCCAgendas;
	
	//CCC
	static private JPanel panelCCC;


	public UI() {
		initialize();
	}

	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);


		//Panel Agendas
		
		panelAgendas = new JPanel();
		panelAgendas.setBounds(0, 44, 994, 728);
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
		panelActas.setBounds(0, 44, 994, 728);
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
				//Controller.prepararActa();
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

		//Panel CCC
		
		panelCCC = new JPanel();
		panelCCC.setBounds(0, 44, 994, 728);
		panelCCC.setVisible(false);
		panelCCC.setLayout(null);
		frame.getContentPane().add(panelCCC);
		
		JLabel lblCcc = new JLabel("CCC");
		lblCcc.setBounds(118, 27, 257, 37);
		lblCcc.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panelCCC.add(lblCcc);
		
		//Panel Principal
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(SystemColor.activeCaption);
		panelPrincipal.setBounds(0, 0, 994, 44);
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

	public JFrame getFrame() {
		return frame;
	}
}
