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
    static JTextField textFieldAusencias;
    static JTextField textFieldResultados;

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
    static JComboBox<?> comboBoxCCC;
    static String[] listaCCC = {"Nuevo", "CCC1", "CCC2", "CCC3"};
    static JTextField textFieldNombreCCC;
    static JTextField textFieldPresidente;
    static JTextField textFieldSecretario;
    static JTextField textFieldAdministrador;
    static JLabel lblAdministrador;
    static JLabel lblMiembros;
    static JLabel lblPeticiones;
    static JLabel lblAgendas;
    ///CCC Datos
    static JPanel panelDatos;
    static JLabel lblMiembro;
    static JTextField textFieldAgenda;

    //Miembro
    static JPanel panelMiembro;
    static JLabel lblNick;
    static JTextField textFieldNick;
    static JTextField textFieldNombreMiembro;
    static JTextField textFieldEmail;
    static JTextField textFieldTelefono;
    static JTextField textFieldPermisos;
    static JTextField textFieldCCCMiembro;

    public UI() {
        initialize();
    }

    static void initialize() {

        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 751);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

		//Panel Agendas
        panelAgendas = new JPanel();
        panelAgendas.setBounds(0, 44, 994, 620);
        panelAgendas.setVisible(false);

								//Panel Actas
        panelActas = new JPanel();
        panelActas.setBounds(0, 44, 994, 620);
        panelActas.setVisible(false);

		//Panel CCC
        panelCCC = new JPanel();
        panelCCC.setBounds(0, 44, 994, 620);
        panelCCC.setLayout(null);
        panelCCC.setVisible(false);

        panelMiembro = new JPanel();
        panelMiembro.setBounds(0, 44, 994, 620);
        panelMiembro.setVisible(false);
        frame.getContentPane().add(panelMiembro);
        panelMiembro.setLayout(null);

        lblMiembro = new JLabel("Miembro");
        lblMiembro.setBounds(113, 32, 123, 39);
        lblMiembro.setFont(new Font("Tahoma", Font.PLAIN, 32));
        panelMiembro.add(lblMiembro);

        lblNick = new JLabel("Nick");
        lblNick.setBounds(134, 138, 128, 14);
        panelMiembro.add(lblNick);

        textFieldNick = new JTextField();
        textFieldNick.setBounds(363, 135, 319, 20);
        textFieldNick.setColumns(10);
        panelMiembro.add(textFieldNick);

        JLabel lblNombre_1 = new JLabel("Nombre");
        lblNombre_1.setBounds(134, 190, 128, 14);
        panelMiembro.add(lblNombre_1);

        textFieldNombreMiembro = new JTextField();
        textFieldNombreMiembro.setColumns(10);
        textFieldNombreMiembro.setBounds(363, 187, 319, 20);
        panelMiembro.add(textFieldNombreMiembro);

        JLabel lblEmail = new JLabel("E-Mail");
        lblEmail.setBounds(134, 240, 128, 14);
        panelMiembro.add(lblEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setColumns(10);
        textFieldEmail.setBounds(363, 237, 319, 20);
        panelMiembro.add(textFieldEmail);

        JLabel lblTelefono = new JLabel("Telefono");
        lblTelefono.setBounds(134, 291, 128, 14);
        panelMiembro.add(lblTelefono);

        textFieldTelefono = new JTextField();
        textFieldTelefono.setColumns(10);
        textFieldTelefono.setBounds(363, 288, 319, 20);
        panelMiembro.add(textFieldTelefono);

        JLabel lblPermisos = new JLabel("Permisos");
        lblPermisos.setBounds(134, 341, 128, 14);
        panelMiembro.add(lblPermisos);

        textFieldPermisos = new JTextField();
        textFieldPermisos.setColumns(10);
        textFieldPermisos.setBounds(363, 338, 319, 20);
        panelMiembro.add(textFieldPermisos);

        JLabel lblCcc_1 = new JLabel("CCC");
        lblCcc_1.setBounds(134, 388, 128, 14);
        panelMiembro.add(lblCcc_1);

        textFieldCCCMiembro = new JTextField();
        textFieldCCCMiembro.setColumns(10);
        textFieldCCCMiembro.setBounds(363, 385, 319, 20);
        panelMiembro.add(textFieldCCCMiembro);

        JButton buttonOkMiembro = new JButton("OK");
        buttonOkMiembro.setBounds(585, 494, 97, 20);
        panelMiembro.add(buttonOkMiembro);

        JButton buttonCancelarMiembro = new JButton("Cancelar");
        buttonCancelarMiembro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panelMiembro.setVisible(false);
                panelDatos.setVisible(true);
                panelCCC.setVisible(true);
            }
        });
        buttonCancelarMiembro.setBounds(441, 494, 103, 20);
        panelMiembro.add(buttonCancelarMiembro);
        frame.getContentPane().add(panelCCC);

        JLabel lblCcc = new JLabel("CCC");
        lblCcc.setBounds(118, 27, 257, 37);
        lblCcc.setFont(new Font("Tahoma", Font.PLAIN, 32));
        panelCCC.add(lblCcc);
        comboBoxCCC = new JComboBox(listaCCC);
        comboBoxCCC.setBounds(118, 91, 142, 20);
        panelCCC.add(comboBoxCCC);

        JButton buttonEditarCCC = new JButton("Editar");
        buttonEditarCCC.setBounds(296, 90, 89, 23);
        panelCCC.add(buttonEditarCCC);

        JButton buttonBajaCCC = new JButton("Dar de baja");
        buttonBajaCCC.setBounds(423, 90, 117, 23);
        panelCCC.add(buttonBajaCCC);

        JButton buttonNuevoCCC = new JButton("Crear CCC");
        buttonNuevoCCC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panelCCC.setVisible(false);
            }
        });
        buttonNuevoCCC.setBounds(574, 90, 109, 23);
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

        JComboBox comboBoxMiembros = new JComboBox(new Object[]{});
        comboBoxMiembros.setBounds(201, 163, 193, 20);
        panelDatos.add(comboBoxMiembros);

        JComboBox comboBoxAgendas = new JComboBox(new Object[]{});
        comboBoxAgendas.setBounds(201, 201, 193, 20);
        panelDatos.add(comboBoxAgendas);

        JComboBox comboBoxPeticiones = new JComboBox(new Object[]{});
        comboBoxPeticiones.setBounds(201, 239, 193, 20);
        panelDatos.add(comboBoxPeticiones);

        JButton buttonEditarMiembro = new JButton("Editar");
        buttonEditarMiembro.setBounds(416, 160, 89, 23);
        panelDatos.add(buttonEditarMiembro);

        JButton buttonBajaMiembro = new JButton("Dar de baja");
        buttonBajaMiembro.setBounds(515, 160, 117, 23);
        panelDatos.add(buttonBajaMiembro);

        JButton buttoNuevoMiembro = new JButton("Nuevo Miembro");
        buttoNuevoMiembro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	panelMiembro.setVisible(true);
                panelCCC.setVisible(false);
                panelDatos.setVisible(false);
            }
        });
        buttoNuevoMiembro.setBounds(642, 160, 135, 23);
        panelDatos.add(buttoNuevoMiembro);

        JButton buttonMostrarAgendas = new JButton("Mostrar");
        buttonMostrarAgendas.setBounds(416, 200, 89, 23);
        panelDatos.add(buttonMostrarAgendas);

        JButton buttonMostrarPeticiones = new JButton("Mostrar");
        buttonMostrarPeticiones.setBounds(416, 238, 89, 23);
        panelDatos.add(buttonMostrarPeticiones);
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
                panelMiembro.setVisible(false);
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
                panelDatos.setVisible(false);
                panelMiembro.setVisible(false);
            }
        });
        botonCCC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panelActas.setVisible(false);
                panelAgendas.setVisible(false);
                panelCCC.setVisible(true);
                panelDatos.setVisible(true);
                panelMiembro.setVisible(false);
            }
        });

    }

    public static JFrame getFrame() {
        return frame;
    }
}
