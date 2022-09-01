package gui;
import javax.swing.JFrame;


import java.awt.Dimension;
import java.awt.Image;
import java.time.LocalDateTime;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField tfLU,tfApellido,tfNombre,tfMail,tfURL;
	private JLabel lblLU,lblApellido,lblNombre,lblMail,lblURL,lblFecha,lblImagen;
	
	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 280));
		setResizable(false);
		setContentPane(contentPane);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 203);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 240));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);
		
		
		tfLU = new JTextField();
		tfLU.setBounds(80, 10, 332, 19);
		tabInformation.add(tfLU);
		tfLU.setColumns(10);
		tfLU.setText(Integer.toString(studentData.getId()));
		
		lblLU = new JLabel("LU");
		lblLU.setBounds(10, 13, 63, 13);
		tabInformation.add(lblLU);
		
		tfApellido = new JTextField();
		tfApellido.setBounds(80, 39, 315, 19);
		tfApellido.setColumns(10);
		tabInformation.add(tfApellido);
		tfApellido.setText(studentData.getLastName());
		
		tfNombre = new JTextField();
		tfNombre.setBounds(80, 68, 315, 19);
		tfNombre.setColumns(10);
		tabInformation.add(tfNombre);
		tfNombre.setText(studentData.getFirstName());
		
		tfMail = new JTextField();
		tfMail.setBounds(80, 97, 315, 19);
		tfMail.setColumns(10);
		tabInformation.add(tfMail);
		tfMail.setText(studentData.getMail());
		
		tfURL = new JTextField();
		tfURL.setBounds(80, 126, 315, 19);
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
		lblFecha.setBounds(20, 220, 430, 25);
		contentPane.add(lblFecha);
	
		LocalDateTime tiempo = LocalDateTime.now();
		int horas  = tiempo.getHour();
		int minutos = tiempo.getMinute();
		int segundos = tiempo.getSecond();
		int dia = tiempo.getDayOfMonth();
		int mes = tiempo.getMonthValue();
		int año = tiempo.getYear();
		lblFecha.setText("Esta ventana fue generada el " + dia + "/" + mes + "/" + año + " a las: " +  horas  + ":"+ minutos +":"+segundos );
		
		lblImagen = new JLabel("");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource(studentData.getPathPhoto())).getImage();
		lblImagen.setIcon(new ImageIcon(img.getScaledInstance(275, 155,  java.awt.Image.SCALE_SMOOTH)));
		lblImagen.setBounds(420, 26, 130, 140);
		contentPane.add(lblImagen);
	
	}
}