package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import entities.Student;

public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField tfLU,tfApellido,tfNombre,tfMail,tfURL;
	private JLabel lblLU,lblApellido,lblNombre,lblMail,lblURL,lblFecha,lblImagen;

	/**
	 * Create the frame.
	 */
	public SimplePresentationScreen(Student studData) {
		studentData = studData;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 203);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 240));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);
		
		
		tfLU = new JTextField();
		tfLU.setBounds(80, 10, 284, 19);
		tabInformation.add(tfLU);
		tfLU.setColumns(10);
		tfLU.setText(Integer.toString(studentData.getId()));
		
		lblLU = new JLabel("LU");
		lblLU.setBounds(10, 13, 63, 13);
		tabInformation.add(lblLU);
		
		tfApellido = new JTextField();
		tfApellido.setBounds(80, 39, 284, 19);
		tfApellido.setColumns(10);
		tabInformation.add(tfApellido);
		tfApellido.setText(studentData.getLastName());
		
		tfNombre = new JTextField();
		tfNombre.setBounds(80, 68, 284, 19);
		tfNombre.setColumns(10);
		tabInformation.add(tfNombre);
		tfNombre.setText(studentData.getFirstName());
		
		tfMail = new JTextField();
		tfMail.setBounds(80, 97, 284, 19);
		tfMail.setColumns(10);
		tabInformation.add(tfMail);
		tfMail.setText(studentData.getMail());
		
		tfURL = new JTextField();
		tfURL.setBounds(80, 126, 284, 19);
		tfURL.setColumns(10);
		tabInformation.add(tfURL);
		tfURL.setText(studentData.getGithubURL());
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 42, 60, 15);
		tabInformation.add(lblApellido);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 71, 35, 15);
		tabInformation.add(lblNombre);
		
		lblMail = new JLabel("mail");
		lblMail.setBounds(10, 100, 50, 15);
		tabInformation.add(lblMail);
		
		lblURL = new JLabel("URL");
		lblURL.setBounds(10, 129, 71, 15);
		tabInformation.add(lblURL);
		contentPane.add(tabbedPane);
		
		lblFecha = new JLabel("");
		lblFecha.setBounds(20, 228, 430, 25);
		contentPane.add(lblFecha);
	
		LocalDateTime tiempo = LocalDateTime.now();
		int horas,minutos,segundos,dia,mes,anio;
		horas  = tiempo.getHour(); minutos = tiempo.getMinute(); segundos = tiempo.getSecond();
		dia = tiempo.getDayOfMonth(); mes = tiempo.getMonthValue(); anio = tiempo.getYear();
		lblFecha.setText("Esta ventana fue generada el " + dia + "/" + mes + "/" + anio + " a las: " +  horas  + ":"+ minutos +":"+segundos );
		
		lblImagen = new JLabel("");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource(studentData.getPathPhoto())).getImage();
		lblImagen.setIcon(new ImageIcon(img.getScaledInstance(275, 155,  java.awt.Image.SCALE_SMOOTH)));
		lblImagen.setBounds(445, 27, 130, 181);
		contentPane.add(lblImagen);
	
	}
}
