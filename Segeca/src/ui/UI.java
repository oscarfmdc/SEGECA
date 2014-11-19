package ui;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
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
	static private JTextField textFieldNombre;
	static private JTextField textFieldFecha;
	static private JTextField textFieldLugar;
	static private JTextField textFieldProposito;
	static private JTextField textFieldParticipantes;
	static private JTextField textFieldHoraInicio;
	static private JTextField textFieldHoraFin;
	static private JTextField textFieldCCC;
	private JPanel panel;

	//Agendas
	static private JPanel panelAgendas;
	static private JButton buttonOkAgendas;
	static private JButton buttonCancelarAgendas;
	static private JTextField textFieldNombreAgenda;
	static private JTextField textFieldFechaAgenda;
	static private JTextField textFieldLugarAgenda;
	static private JTextField textFieldPropositoAgenda;
	static private JTextField textFieldParticipantesAgenda;
	static private JTextField textFieldHoraInicioAgenda;
	static private JTextField textFieldHoraFinAgenda;
	static private JTextField textFieldCCCAgenda;


	public UI() {
		initialize();
	}

	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		panelActas = new JPanel();
		panelActas.setBounds(0, 0, 994, 772);
		panelActas.setVisible(false);


		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 994, 772);
		frame.getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panel = new JPanel();
		panelPrincipal.add(panel);

		botonActas = new JButton("Actas");
		panelPrincipal.add(botonActas);
		botonActas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelActas.setVisible(true);
				panelPrincipal.setVisible(false);
			}
		});		
		botonAgendas = new JButton("Agendas");
		panelPrincipal.add(botonAgendas);

		botonCCC = new JButton("CCC");
		panelPrincipal.add(botonCCC);

		//Panel Actas
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

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(340, 98, 393, 20);
		panelActas.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(340, 142, 393, 20);
		panelActas.add(textFieldFecha);

		textFieldLugar = new JTextField();
		textFieldLugar.setColumns(10);
		textFieldLugar.setBounds(340, 189, 393, 20);
		panelActas.add(textFieldLugar);

		textFieldProposito = new JTextField();
		textFieldProposito.setColumns(10);
		textFieldProposito.setBounds(340, 236, 393, 20);
		panelActas.add(textFieldProposito);

		textFieldParticipantes = new JTextField();
		textFieldParticipantes.setColumns(10);
		textFieldParticipantes.setBounds(340, 283, 393, 20);
		panelActas.add(textFieldParticipantes);

		textFieldHoraInicio = new JTextField();
		textFieldHoraInicio.setColumns(10);
		textFieldHoraInicio.setBounds(340, 330, 393, 20);
		panelActas.add(textFieldHoraInicio);

		textFieldHoraFin = new JTextField();
		textFieldHoraFin.setColumns(10);
		textFieldHoraFin.setBounds(340, 377, 393, 20);
		panelActas.add(textFieldHoraFin);

		textFieldCCC = new JTextField();
		textFieldCCC.setColumns(10);
		textFieldCCC.setBounds(340, 424, 393, 20);
		panelActas.add(textFieldCCC);

		buttonOkActas = new JButton("OK");
		buttonOkActas.setBounds(636, 494, 97, 37);
		panelActas.add(buttonOkActas);
		buttonOkActas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.prepararAgenda();
				panelActas.setVisible(false);
				panelPrincipal.setVisible(true);
			}
		});	

		buttonCancelarActas = new JButton("Cancelar");
		buttonCancelarActas.setBounds(340, 494, 103, 37);
		panelActas.add(buttonCancelarActas);
		buttonCancelarActas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelActas.setVisible(false);
				panelPrincipal.setVisible(true);
			}
		});	


	}

	public JFrame getFrame() {
		return frame;
	}
}
