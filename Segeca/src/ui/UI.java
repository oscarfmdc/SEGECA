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
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

import def.Pc.Estado;

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
	public static JTextField textField_PanelMiembro_Permisos;
	public static JTextField textField_PanelMiembro_CCC;
	private static JLabel lblEliminarMiembro;
	private static JLabel label;


	//BajaMiembro
	static JPanel panelBajaMiembro;
	public static JTextField textField_PanelBajaMiembro_Nick;
	public static JTextField textField_PanelBajaMiembro_CCC;


	//Login
	static JPanel panelLogin;
	public static JTextField textField_PanelLogin_User;
	public static JPasswordField passwordField_PanelLogin_Password;


	//Registro
	static JPanel panelRegistro;
	public static JPanel panel_PanelRegistro_Datos;
	public static JTextField textField_PanelRegistro_Usuario;
	public static JPasswordField passwordField_PanelRegistro_Password;
	public static JPasswordField passwordField_PanelRegistro_ConfPassword;
	public static JButton btnCancelar;
	public static JLabel lblNombreDeUsuario;
	public static JLabel lblPassword;
	public static JLabel lblConfirmarPassword;


	//Perfil
	static JPanel panelPerfil;
	public static JTextField textField_PanelPerfil_Nombre;
	public static JTextField textField_PanelPerfil_Telefono;
	public static JTextField textField_PanelPerfil_Email;
	public static JTextArea textArea_PanelPerfil_Nick;
	public static JTextArea textArea_PanelPerfil_CCC;
	public static JTextArea textArea_PanelPerfil_Permisos;
	

	//PanelPC
	static JPanel panelPC;
	private static JLabel lblReunion;
	private static JButton button_PanelPC_AsignarReunion;
	private static JLabel lblEstado;
	private static JButton btnModificar;
	private static JLabel lblNewLabel_3;
	public static JTextField textField_PanelPC_CodPC;
	private static JButton button_PanelPC_AsignarCCC;
	public static JTextField textField_PanelPC_CCC;
	public static JTextField textField_PanelPC_Reunion;
	public static JComboBox<Estado> comboBox_PanelPC_Estado;
	public static JTextArea textArea_PanelPC_Fecha;
	public static JTextArea textArea_PanelPC_Motivo;
	public static JTextArea textArea_PanelPC_Prioridad;
	public static JTextArea textArea_PanelPC_Email;
	public static JTextArea textArea_PanelPC_Documentos;
	public static JTextPane textPane_PanelPC_Descripcion;
	public static JTextPane textPane_PanelPC_Valoracion;
	private static JButton btnNewButton_1;
	
	//PanelPCnueva
	static JPanel panelPCnueva;
	public static JTextField textArea_PanelPCnueva_Prioridad;
	public static JTextField textArea_PanelPCnueva_Fecha;
	public static JTextField textArea_PanelPCnueva_Documentos;
	public static JTextPane textPane_PanelPCnueva_Descripcion;
	public static JTextField textArea_PanelPCnueva_Email;
	public static JTextField textArea_PanelPCnueva_Motivo;
	


	public UI() {
		initialize();
	}

	public static void initialize() {

		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1000, 751);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Panel Actas
		panelActas = new JPanel();
		panelActas.setBounds(0, 44, 994, 620);
		panelActas.setVisible(false);

		//Panel Agendas
		panelAgendas = new JPanel();
		panelAgendas.setBounds(0, 44, 994, 620);
		panelAgendas.setVisible(false);

		//Panel Principal
		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 994, 44);
		panelPrincipal.setBackground(SystemColor.activeCaption);
		panelPrincipal.setVisible(false);

		//Panel CCC
		panelCCC = new JPanel();
		panelCCC.setBounds(0, 44, 994, 620);
		panelCCC.setLayout(null);
		panelCCC.setVisible(false);

		panelNuevoMiembro = new JPanel();
		panelNuevoMiembro.setBounds(0, 44, 994, 620);
		panelNuevoMiembro.setVisible(false);

		panelPerfil = new JPanel();
		panelPerfil.setBounds(0, 44, 994, 620);
		panelPerfil.setVisible(false);

		panelBajaMiembro = new JPanel();
		panelBajaMiembro.setBounds(0, 44, 994, 620);
		panelBajaMiembro.setVisible(false);
		
		panelPCnueva = new JPanel();
		panelPCnueva.setBounds(0, 44, 994, 620);
		panelPCnueva.setVisible(false);
		frame.getContentPane().add(panelPCnueva);
		panelPCnueva.setLayout(null);

		JLabel label_1 = new JLabel("PC");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 34));
		label_1.setBounds(160, 42, 122, 41);
		panelPCnueva.add(label_1);

		JLabel PCMotivo_Label = new JLabel("Motivo");
		PCMotivo_Label.setBounds(160, 233, 72, 14);
		panelPCnueva.add(PCMotivo_Label);

		JLabel lblDescripcion_1 = new JLabel("Descripcion");
		lblDescripcion_1.setBounds(160, 152, 72, 14);
		panelPCnueva.add(lblDescripcion_1);

		JLabel lblPrioridad_1 = new JLabel("Prioridad");
		lblPrioridad_1.setBounds(159, 271, 72, 14);
		panelPCnueva.add(lblPrioridad_1);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(160, 114, 72, 14);
		panelPCnueva.add(lblFecha);

		JLabel lblDocumentos_1 = new JLabel("Documentos");
		lblDocumentos_1.setBounds(160, 341, 72, 14);
		panelPCnueva.add(lblDocumentos_1);

		textArea_PanelPCnueva_Prioridad = new JTextField();
		textArea_PanelPCnueva_Prioridad.setBounds(241, 268, 105, 20);
		panelPCnueva.add(textArea_PanelPCnueva_Prioridad);

		textArea_PanelPCnueva_Fecha = new JTextField();
		textArea_PanelPCnueva_Fecha.setBounds(242, 111, 105, 20);
		panelPCnueva.add(textArea_PanelPCnueva_Fecha);

		textArea_PanelPCnueva_Documentos = new JTextField();
		textArea_PanelPCnueva_Documentos.setBounds(242, 338, 153, 20);
		panelPCnueva.add(textArea_PanelPCnueva_Documentos);

		textPane_PanelPCnueva_Descripcion = new JTextPane();
		textPane_PanelPCnueva_Descripcion.setBounds(241, 152, 360, 60);
		panelPCnueva.add(textPane_PanelPCnueva_Descripcion);

		textArea_PanelPCnueva_Motivo = new JTextField();
		textArea_PanelPCnueva_Motivo.setBounds(242, 230, 303, 20);
		panelPCnueva.add(textArea_PanelPCnueva_Motivo);

		btnNewButton_1 = new JButton("Crear PC");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.altaPC();
			}
		});
		btnNewButton_1.setBounds(514, 398, 87, 20);
		panelPCnueva.add(btnNewButton_1);

		JLabel lblEmail_2 = new JLabel("Email");
		lblEmail_2.setBounds(159, 306, 72, 14);
		panelPCnueva.add(lblEmail_2);

		textArea_PanelPCnueva_Email = new JTextField();
		textArea_PanelPCnueva_Email.setBounds(241, 303, 218, 20);
		panelPCnueva.add(textArea_PanelPCnueva_Email);
		
		JButton btnCancelar_1 = new JButton("Cancelar");
		btnCancelar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelPCnueva.setVisible(false);
				panelPC.setVisible(true);
			}
		});
		btnCancelar_1.setBounds(403, 397, 89, 23);
		panelPCnueva.add(btnCancelar_1);

		panelPC = new JPanel();
		panelPC.setBounds(0, 44, 994, 620);
		panelPC.setVisible(false);
		frame.getContentPane().add(panelPC);
		panelPC.setLayout(null);

		JLabel lblPc = new JLabel("PC");
		lblPc.setBounds(158, 43, 122, 41);
		lblPc.setFont(new Font("Tahoma", Font.PLAIN, 34));
		panelPC.add(lblPc);

		JLabel lblNewLabel_2 = new JLabel("PC Code");
		lblNewLabel_2.setBounds(158, 99, 72, 14);
		panelPC.add(lblNewLabel_2);

		textField_PanelPC_CodPC = new JTextField();
		textField_PanelPC_CodPC.setBounds(240, 97, 72, 20);
		panelPC.add(textField_PanelPC_CodPC);
		textField_PanelPC_CodPC.setColumns(10);

		JButton button_PanelPC_Mostrar = new JButton("Mostrar");
		button_PanelPC_Mostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.pcSelected();
			}
		});
		button_PanelPC_Mostrar.setBounds(342, 96, 89, 23);
		panelPC.add(button_PanelPC_Mostrar);

		JButton button_PanelPC_Nueva = new JButton("Nueva");
		button_PanelPC_Nueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelPCnueva.setVisible(true);
				
				panelPC.setVisible(false);
                panelActas.setVisible(false);
                panelAgendas.setVisible(false);
                panelCCC.setVisible(false);
                panelDatos.setVisible(false);
                panelNuevoMiembro.setVisible(false);
                panelPerfil.setVisible(false);
			}
		});
		button_PanelPC_Nueva.setBounds(454, 95, 89, 23);
		panelPC.add(button_PanelPC_Nueva);

		lblNewLabel_3 = new JLabel("CCC");
		lblNewLabel_3.setBounds(158, 356, 46, 14);
		panelPC.add(lblNewLabel_3);

		textField_PanelPC_CCC = new JTextField();
		textField_PanelPC_CCC.setBounds(240, 353, 144, 20);
		panelPC.add(textField_PanelPC_CCC);
		textField_PanelPC_CCC.setColumns(10);

		button_PanelPC_AsignarCCC = new JButton("Asignar");
		button_PanelPC_AsignarCCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.PCaCCC();
			}
		});
		button_PanelPC_AsignarCCC.setBounds(408, 352, 89, 23);
		panelPC.add(button_PanelPC_AsignarCCC);

		textField_PanelPC_Reunion = new JTextField();
		textField_PanelPC_Reunion.setColumns(10);
		textField_PanelPC_Reunion.setBounds(240, 384, 144, 20);
		panelPC.add(textField_PanelPC_Reunion);

		lblReunion = new JLabel("Agenda");
		lblReunion.setBounds(158, 387, 46, 14);
		panelPC.add(lblReunion);

		button_PanelPC_AsignarReunion = new JButton("Asignar");
		button_PanelPC_AsignarReunion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.PcAgendaCCC();
			}
		});
		button_PanelPC_AsignarReunion.setBounds(410, 383, 89, 23);
		panelPC.add(button_PanelPC_AsignarReunion);

		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(158, 419, 46, 14);
		panelPC.add(lblEstado);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.modEstadoPC();
			}
		});
		btnModificar.setBounds(410, 415, 89, 23);
		panelPC.add(btnModificar);

		comboBox_PanelPC_Estado = new JComboBox<Estado>();
		comboBox_PanelPC_Estado.setModel(new DefaultComboBoxModel<Estado>(Estado.values()));
		comboBox_PanelPC_Estado.setBounds(240, 418, 144, 20);
		panelPC.add(comboBox_PanelPC_Estado);

		JLabel lblValoracion = new JLabel("Valoracion");
		lblValoracion.setBounds(158, 453, 72, 14);
		panelPC.add(lblValoracion);

		JButton button_PanelPC_Valorar = new JButton("Valorar");
		button_PanelPC_Valorar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.valorarPC();
			}
		});
		button_PanelPC_Valorar.setBounds(553, 501, 89, 23);
		panelPC.add(button_PanelPC_Valorar);

		textPane_PanelPC_Valoracion = new JTextPane();
		textPane_PanelPC_Valoracion.setBounds(240, 452, 303, 72);
		panelPC.add(textPane_PanelPC_Valoracion);

		JLabel lblNewLabel_4 = new JLabel("Fecha");
		lblNewLabel_4.setBounds(158, 137, 72, 14);
		panelPC.add(lblNewLabel_4);

		textArea_PanelPC_Fecha = new JTextArea();
		textArea_PanelPC_Fecha.setEditable(false);
		textArea_PanelPC_Fecha.setBounds(240, 132, 105, 20);
		panelPC.add(textArea_PanelPC_Fecha);

		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(158, 167, 79, 14);
		panelPC.add(lblDescripcion);

		textArea_PanelPC_Prioridad = new JTextArea();
		textArea_PanelPC_Prioridad.setEditable(false);
		textArea_PanelPC_Prioridad.setBounds(240, 254, 105, 20);
		panelPC.add(textArea_PanelPC_Prioridad);

		JLabel lblPrioridad = new JLabel("Prioridad");
		lblPrioridad.setBounds(158, 259, 72, 14);
		panelPC.add(lblPrioridad);

		JLabel lblMotivo = new JLabel("Motivo");
		lblMotivo.setBounds(158, 229, 72, 14);
		panelPC.add(lblMotivo);

		textArea_PanelPC_Motivo = new JTextArea();
		textArea_PanelPC_Motivo.setEditable(false);
		textArea_PanelPC_Motivo.setBounds(240, 224, 303, 20);
		panelPC.add(textArea_PanelPC_Motivo);

		JLabel lblDocumentos = new JLabel("Documentos");
		lblDocumentos.setBounds(158, 320, 72, 14);
		panelPC.add(lblDocumentos);

		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setBounds(158, 290, 72, 14);
		panelPC.add(lblEmail_1);

		textArea_PanelPC_Email = new JTextArea();
		textArea_PanelPC_Email.setEditable(false);
		textArea_PanelPC_Email.setBounds(240, 285, 303, 20);
		panelPC.add(textArea_PanelPC_Email);

		textArea_PanelPC_Documentos = new JTextArea();
		textArea_PanelPC_Documentos.setEditable(false);
		textArea_PanelPC_Documentos.setBounds(240, 315, 303, 20);
		panelPC.add(textArea_PanelPC_Documentos);

		textPane_PanelPC_Descripcion = new JTextPane();
		textPane_PanelPC_Descripcion.setEditable(false);
		textPane_PanelPC_Descripcion.setBounds(240, 163, 303, 50);
		panelPC.add(textPane_PanelPC_Descripcion);
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
		frame.getContentPane().add(panelPerfil);
		panelPerfil.setLayout(null);

		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblPerfil.setBounds(158, 43, 439, 60);
		panelPerfil.add(lblPerfil);

		JLabel lblNewLabel_1 = new JLabel("Nick");
		lblNewLabel_1.setBounds(260, 146, 46, 14);
		panelPerfil.add(lblNewLabel_1);

		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(260, 188, 46, 14);
		panelPerfil.add(lblNombre_1);

		textField_PanelPerfil_Nombre = new JTextField();
		textField_PanelPerfil_Nombre.setColumns(10);
		textField_PanelPerfil_Nombre.setBounds(386, 185, 199, 20);
		panelPerfil.add(textField_PanelPerfil_Nombre);

		textField_PanelPerfil_Telefono = new JTextField();
		textField_PanelPerfil_Telefono.setColumns(10);
		textField_PanelPerfil_Telefono.setBounds(386, 271, 199, 20);
		panelPerfil.add(textField_PanelPerfil_Telefono);

		textField_PanelPerfil_Email = new JTextField();
		textField_PanelPerfil_Email.setColumns(10);
		textField_PanelPerfil_Email.setBounds(386, 229, 199, 20);
		panelPerfil.add(textField_PanelPerfil_Email);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(260, 232, 46, 14);
		panelPerfil.add(lblEmail);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(260, 274, 101, 14);
		panelPerfil.add(lblTelefono);

		textArea_PanelPerfil_CCC = new JTextArea();
		textArea_PanelPerfil_CCC.setEditable(false);
		textArea_PanelPerfil_CCC.setBounds(386, 312, 199, 20);
		panelPerfil.add(textArea_PanelPerfil_CCC);

		JLabel lblCcc_3 = new JLabel("CCC");
		lblCcc_3.setBounds(260, 317, 46, 14);
		panelPerfil.add(lblCcc_3);

		textArea_PanelPerfil_Permisos = new JTextArea();
		textArea_PanelPerfil_Permisos.setEditable(false);
		textArea_PanelPerfil_Permisos.setBounds(386, 358, 199, 20);
		panelPerfil.add(textArea_PanelPerfil_Permisos);

		JLabel lblPermisos_1 = new JLabel("Permisos");
		lblPermisos_1.setBounds(260, 363, 75, 14);
		panelPerfil.add(lblPermisos_1);

		textArea_PanelPerfil_Nick = new JTextArea();
		textArea_PanelPerfil_Nick.setEditable(false);
		textArea_PanelPerfil_Nick.setBounds(386, 141, 199, 20);
		panelPerfil.add(textArea_PanelPerfil_Nick);

		JButton button_PanelPerfil_Editar = new JButton("Editar");
		button_PanelPerfil_Editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.modPerfil();
			}
		});
		button_PanelPerfil_Editar.setBounds(523, 426, 89, 23);
		panelPerfil.add(button_PanelPerfil_Editar);

		JButton button_PanelPerfil_Cancelar = new JButton("Cancelar");
		button_PanelPerfil_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelPerfil.setVisible(false);
			}
		});
		button_PanelPerfil_Cancelar.setBounds(398, 426, 89, 23);
		panelPerfil.add(button_PanelPerfil_Cancelar);
		frame.getContentPane().add(panelNuevoMiembro);
		panelNuevoMiembro.setLayout(null);

		lblMiembro = new JLabel("Agregar Miembro");
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

		JLabel lblPermisos = new JLabel("Permisos");
		lblPermisos.setBounds(134, 185, 128, 14);
		panelNuevoMiembro.add(lblPermisos);

		textField_PanelMiembro_Permisos = new JTextField();
		textField_PanelMiembro_Permisos.setColumns(10);
		textField_PanelMiembro_Permisos.setBounds(363, 182, 319, 20);
		panelNuevoMiembro.add(textField_PanelMiembro_Permisos);

		JLabel lblCcc_1 = new JLabel("CCC");
		lblCcc_1.setBounds(134, 232, 128, 14);
		panelNuevoMiembro.add(lblCcc_1);

		textField_PanelMiembro_CCC = new JTextField();
		textField_PanelMiembro_CCC.setColumns(10);
		textField_PanelMiembro_CCC.setBounds(363, 229, 319, 20);
		panelNuevoMiembro.add(textField_PanelMiembro_CCC);

		JButton buttonCancelarMiembro = new JButton("Cancelar");
		buttonCancelarMiembro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelNuevoMiembro.setVisible(false);
				panelDatos.setVisible(true);
				panelCCC.setVisible(true);
			}
		});
		buttonCancelarMiembro.setBounds(382, 286, 103, 20);
		panelNuevoMiembro.add(buttonCancelarMiembro);

		JButton btnAgregar = new JButton("Agregar / Editar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.modMiembrosCCC();
				panelNuevoMiembro.setVisible(false);
				panelCCC.setVisible(true);
				Controller.cccSelected();
				panelDatos.setVisible(true);

			}
		});
		btnAgregar.setBounds(529, 285, 153, 23);
		panelNuevoMiembro.add(btnAgregar);

		JButton button_PanelNuevoMiembro_Mostrar = new JButton("Mostrar");
		button_PanelNuevoMiembro_Mostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.memberSelected();
			}
		});
		button_PanelNuevoMiembro_Mostrar.setBounds(739, 134, 89, 23);
		panelNuevoMiembro.add(button_PanelNuevoMiembro_Mostrar);
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

		JButton buttoNuevoMiembro = new JButton("Agregar");
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
		textPane_PanelCCC_Miembros.setEditable(false);
		textPane_PanelCCC_Miembros.setBounds(201, 160, 252, 20);
		panelDatos.add(textPane_PanelCCC_Miembros);

		textPane_PanelCCC_Agendas = new JTextPane();
		textPane_PanelCCC_Agendas.setEditable(false);
		textPane_PanelCCC_Agendas.setBounds(201, 198, 252, 20);
		panelDatos.add(textPane_PanelCCC_Agendas);

		textPane_PanelCCC_Peticiones = new JTextPane();
		textPane_PanelCCC_Peticiones.setEditable(false);
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
				panelPerfil.setVisible(false);
				panelPC.setVisible(false);
				panelPCnueva.setVisible(false);
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

		JButton buttonLogout = new JButton("Logout");
		buttonLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.logout();
				panelPrincipal.setVisible(false);
				panelOutput.setVisible(false);
				panelActas.setVisible(false);
				panelAgendas.setVisible(false);
				panelCCC.setVisible(false);
				panelDatos.setVisible(false);
				panelNuevoMiembro.setVisible(false);
				panelBajaMiembro.setVisible(false);
				panelPerfil.setVisible(false);
				panelPC.setVisible(false);
				panelPCnueva.setVisible(false);
				
				panelLogin.setVisible(true);
			}
		});
		buttonLogout.setBounds(895, 11, 89, 23);
		panelPrincipal.add(buttonLogout);

		JButton buttonMiPerfil = new JButton("Mi Perfil");
		buttonMiPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.mostrarPerfil();
				panelPerfil.setVisible(true);
				
				panelActas.setVisible(false);
				panelAgendas.setVisible(false);
				panelCCC.setVisible(false);
				panelDatos.setVisible(false);
				panelNuevoMiembro.setVisible(false);
				panelPC.setVisible(false);
				panelPCnueva.setVisible(false);
			}
		});
		buttonMiPerfil.setBounds(783, 11, 89, 23);
		panelPrincipal.add(buttonMiPerfil);
		JButton botonPeticiones = new JButton("Peticiones");
		botonPeticiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPC.setVisible(true);
				
				panelActas.setVisible(false);		
				panelAgendas.setVisible(false);
				panelCCC.setVisible(false);
				panelDatos.setVisible(false);
				panelNuevoMiembro.setVisible(false);
				panelPerfil.setVisible(false);				
				panelPCnueva.setVisible(false);
			}
		});
		botonPeticiones.setBounds(391, 11, 97, 23);
		panelPrincipal.add(botonPeticiones);
		botonActas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelActas.setVisible(true);
				
				panelAgendas.setVisible(false);
				panelCCC.setVisible(false);
				panelDatos.setVisible(false);
				panelNuevoMiembro.setVisible(false);
				panelPerfil.setVisible(false);
				panelPC.setVisible(false);
				panelPCnueva.setVisible(false);
			}
		});
		botonCCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelCCC.setVisible(true);
				panelDatos.setVisible(true);
				
				panelActas.setVisible(false);
				panelAgendas.setVisible(false);				
				panelNuevoMiembro.setVisible(false);
				panelPerfil.setVisible(false);
				panelPC.setVisible(false);
				panelPCnueva.setVisible(false);
			}
		});
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
			}
		});
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

		panelOutput = new JPanel();
		panelOutput.setBounds(0, 666, 994, 54);
		panelOutput.setVisible(false);
		frame.getContentPane().add(panelOutput);
		panelOutput.setBackground(SystemColor.activeCaptionBorder);
		panelOutput.setLayout(null);

		label_PanelOutput_Output = new JLabel("Output");
		label_PanelOutput_Output.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_PanelOutput_Output.setBounds(27, 11, 935, 26);
		panelOutput.add(label_PanelOutput_Output);

		panelLogin = new JPanel();
		panelLogin.setBackground(SystemColor.textHighlight);
		panelLogin.setBounds(0, 0, 994, 720);
		frame.getContentPane().add(panelLogin);
		panelLogin.setLayout(null);

		passwordField_PanelLogin_Password = new JPasswordField();
		passwordField_PanelLogin_Password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
					if(Controller.login()){//Login correcto
						panelLogin.setVisible(false);
						panelPrincipal.setVisible(true);
						panelOutput.setVisible(true);
					}
				}
			}
		});
		passwordField_PanelLogin_Password.setBounds(429, 542, 175, 20);
		panelLogin.add(passwordField_PanelLogin_Password);

		JLabel label_panelLogin_Segeca = new JLabel("");
		label_panelLogin_Segeca.setIcon(new ImageIcon(UI.class.getResource("/resources/Segeca.png")));
		label_panelLogin_Segeca.setBounds(261, 90, 488, 367);
		panelLogin.add(label_panelLogin_Segeca);

		textField_PanelLogin_User = new JTextField();
		textField_PanelLogin_User.setBounds(429, 501, 175, 20);
		panelLogin.add(textField_PanelLogin_User);
		textField_PanelLogin_User.setColumns(10);

		JLabel lblNick_1 = new JLabel("Usuario");
		lblNick_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNick_1.setBounds(300, 501, 106, 14);
		panelLogin.add(lblNick_1);

		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(298, 542, 109, 14);
		panelLogin.add(lblNewLabel);

		JButton button_PanelLogin_Login = new JButton("Login");
		button_PanelLogin_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Controller.login()){//Login correcto
					panelLogin.setVisible(false);
					panelPrincipal.setVisible(true);
					panelOutput.setVisible(true);
				}
			}
		});
		button_PanelLogin_Login.setBounds(635, 500, 89, 23);
		panelLogin.add(button_PanelLogin_Login);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelLogin.setVisible(false);
				panelRegistro.setVisible(true);
			}
		});
		btnRegistrar.setBounds(635, 541, 89, 23);
		panelLogin.add(btnRegistrar);

		panelRegistro = new JPanel();
		panelRegistro.setBackground(SystemColor.textHighlight);
		panelRegistro.setBounds(0, 0, 994, 720);
		panelRegistro.setVisible(false);
		frame.getContentPane().add(panelRegistro);
		panelRegistro.setLayout(null);

		JLabel lblAltaDeUsuario = new JLabel("Registro de usuario");
		lblAltaDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblAltaDeUsuario.setBounds(332, 44, 336, 61);
		panelRegistro.add(lblAltaDeUsuario);

		panel_PanelRegistro_Datos = new JPanel();
		panel_PanelRegistro_Datos.setBackground(UIManager.getColor("info"));
		panel_PanelRegistro_Datos.setBounds(247, 178, 470, 244);
		panelRegistro.add(panel_PanelRegistro_Datos);
		panel_PanelRegistro_Datos.setLayout(null);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelRegistro.setVisible(false);
				panelLogin.setVisible(true);
			}
		});
		btnCancelar.setBounds(207, 195, 89, 23);
		panel_PanelRegistro_Datos.add(btnCancelar);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Controller.registro()){
					panelRegistro.setVisible(false);
					panelLogin.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(339, 195, 89, 23);
		panel_PanelRegistro_Datos.add(btnNewButton);

		passwordField_PanelRegistro_ConfPassword = new JPasswordField();
		passwordField_PanelRegistro_ConfPassword.setBounds(246, 126, 182, 20);
		panel_PanelRegistro_Datos.add(passwordField_PanelRegistro_ConfPassword);

		lblConfirmarPassword = new JLabel("Confirmar password");
		lblConfirmarPassword.setBounds(45, 129, 159, 14);
		panel_PanelRegistro_Datos.add(lblConfirmarPassword);
		lblConfirmarPassword.setFont(new Font("Arial", Font.BOLD, 15));

		lblPassword = new JLabel("Password");
		lblPassword.setBounds(45, 89, 159, 14);
		panel_PanelRegistro_Datos.add(lblPassword);
		lblPassword.setFont(new Font("Arial", Font.BOLD, 15));

		passwordField_PanelRegistro_Password = new JPasswordField();
		passwordField_PanelRegistro_Password.setBounds(246, 86, 182, 20);
		panel_PanelRegistro_Datos.add(passwordField_PanelRegistro_Password);

		textField_PanelRegistro_Usuario = new JTextField();
		textField_PanelRegistro_Usuario.setBounds(246, 44, 182, 20);
		panel_PanelRegistro_Datos.add(textField_PanelRegistro_Usuario);
		textField_PanelRegistro_Usuario.setColumns(10);

		lblNombreDeUsuario = new JLabel("Nombre de usuario");
		lblNombreDeUsuario.setBounds(45, 47, 159, 14);
		panel_PanelRegistro_Datos.add(lblNombreDeUsuario);
		lblNombreDeUsuario.setFont(new Font("Arial", Font.BOLD, 15));

	}
}
