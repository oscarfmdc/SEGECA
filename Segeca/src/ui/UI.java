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
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
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
	static private JComboBox comboBox;
	private JLabel label;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	String[] listaCCC = {"CC1","CC2","CCC3"};
	
	//CCCDatos
	static private JPanel panelCCCDatos;

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
		
		panelCCCDatos = new JPanel();
		panelCCCDatos.setBounds(0, 44, 994, 728);
		panelCCCDatos.setVisible(false);
		
				//Panel CCC
				
				panelCCC = new JPanel();
				panelCCC.setBounds(0, 44, 994, 728);
				panelCCC.setLayout(null);
				panelCCC.setVisible(false);
				frame.getContentPane().add(panelCCC);
				
				JLabel lblCcc = new JLabel("CCC");
				lblCcc.setBounds(118, 27, 257, 37);
				lblCcc.setFont(new Font("Tahoma", Font.PLAIN, 32));
				panelCCC.add(lblCcc);
				comboBox = new JComboBox(listaCCC);
				comboBox.setBounds(118, 85, 142, 20);
				panelCCC.add(comboBox);
				
				JButton btnEditar = new JButton("Editar");
				btnEditar.setBounds(296, 84, 89, 23);
				panelCCC.add(btnEditar);
				
				JButton btnBaja = new JButton("Dar de baja");
				btnBaja.setBounds(423, 84, 117, 23);
				panelCCC.add(btnBaja);
				
				JButton btnNuevoCcc = new JButton("Nuevo CCC");
				btnNuevoCcc.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						panelCCC.setVisible(false);
						panelCCCDatos.setVisible(true);
					}
				});
				btnNuevoCcc.setBounds(118, 129, 109, 23);
				panelCCC.add(btnNuevoCcc);
		frame.getContentPane().add(panelCCCDatos);
		panelCCCDatos.setLayout(null);
		
		label = new JLabel("CCC");
		label.setBounds(118, 27, 161, 39);
		label.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panelCCCDatos.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(346, 158, 393, 20);
		panelCCCDatos.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(346, 206, 393, 20);
		panelCCCDatos.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(346, 252, 393, 20);
		panelCCCDatos.add(textField_2);
		
		JLabel lblNombrePresidente = new JLabel("Nombre Presidente");
		lblNombrePresidente.setToolTipText("nombre del acta");
		lblNombrePresidente.setBounds(118, 157, 171, 14);
		panelCCCDatos.add(lblNombrePresidente);
		
		JLabel lblNombreSecretario = new JLabel("Nombre Secretario");
		lblNombreSecretario.setToolTipText("nombre del acta");
		lblNombreSecretario.setBounds(118, 209, 171, 14);
		panelCCCDatos.add(lblNombreSecretario);
		
		JLabel lblNombreAdministrador = new JLabel("Nombre Administrador");
		lblNombreAdministrador.setToolTipText("nombre del acta");
		lblNombreAdministrador.setBounds(118, 255, 171, 14);
		panelCCCDatos.add(lblNombreAdministrador);
		
		JButton btnCrearCcc = new JButton("Crear CCC");
		btnCrearCcc.setBounds(640, 302, 99, 23);
		panelCCCDatos.add(btnCrearCcc);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelCCC.setVisible(true);
				panelCCCDatos.setVisible(false);
			}
		});
		btnCancelar.setBounds(505, 302, 89, 23);
		panelCCCDatos.add(btnCancelar);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(346, 112, 393, 20);
		panelCCCDatos.add(textField_3);
		
		JLabel lblNombreCcc = new JLabel("Nombre CCC");
		lblNombreCcc.setToolTipText("nombre del acta");
		lblNombreCcc.setBounds(118, 111, 171, 14);
		panelCCCDatos.add(lblNombreCcc);
								
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
				panelCCCDatos.setVisible(false);
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
				panelCCCDatos.setVisible(false);
			}
		});		
		botonCCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelActas.setVisible(false);
				panelAgendas.setVisible(false);
				panelCCC.setVisible(true);
				panelCCCDatos.setVisible(false);
			}
		});


	}

	public JFrame getFrame() {
		return frame;
	}
}
