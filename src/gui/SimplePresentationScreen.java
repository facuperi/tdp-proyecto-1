package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/tdp.png")));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		contentPane.add(tabbedPane, BorderLayout.WEST);
		
		JTextField tfSalidaLU = new JTextField();
		tfSalidaLU.setBounds(90, 10, 175, 19);
		this.getContentPane().add(tfSalidaLU);
		tfSalidaLU.setColumns(10);
		tfSalidaLU.setText(Integer.toString(studentData.getId()));

		
		JLabel lblLU = new JLabel("LU");
		lblLU.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLU.setHorizontalAlignment(SwingConstants.LEFT);
		lblLU.setBounds(40, 9, 40, 19);
		this.getContentPane().add(lblLU);
		
		JTextField tfApellido = new JTextField();
		tfApellido.setBounds(90, 42, 175, 19);
		this.getContentPane().add(tfApellido);
		tfApellido.setColumns(10);
		tfApellido.setText(studentData.getLastName());

		
		JTextField tfNombre = new JTextField();
		tfNombre.setBounds(90, 71, 175, 19);
		this.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		tfApellido.setText(studentData.getFirstName());

		
		JTextField tfURL = new JTextField();
		tfURL.setBounds(90, 100, 175, 19);
		this.getContentPane().add(tfURL);
		tfURL.setColumns(10);
		tfApellido.setText(studentData.getGithubURL());

		
		JTextField tfImagen = new JTextField();
		tfImagen.setBounds(90, 129, 175, 19);
		this.getContentPane().add(tfImagen);
		tfImagen.setColumns(10);
		tfApellido.setText(studentData.getPathPhoto());

		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellido.setBounds(35, 38, 45, 23);
		this.getContentPane().add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(35, 72, 45, 16);
		this.getContentPane().add(lblNombre);
		
		JLabel lblURL = new JLabel("URL");
		lblURL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblURL.setBounds(35, 100, 45, 19);
		this.getContentPane().add(lblURL);
		
		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setHorizontalAlignment(SwingConstants.LEFT);
		lblImagen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblImagen.setBounds(28, 126, 52, 24);
		this.getContentPane().add(lblImagen);
		
		JLabel lblFecha = new JLabel("");
		lblFecha.setBounds(35, 153, 371, 13);
		this.getContentPane().add(lblFecha);
		
		LocalDateTime tiempo = LocalDateTime.now();
		int horas  = tiempo.getHour();
		int minutos = tiempo.getMinute();
		int segundos = tiempo.getSecond();
		int dia = tiempo.getDayOfMonth();
		int mes = tiempo.getMonthValue();
		int anio = tiempo.getYear();
		
		lblFecha.setText("Esta ventana fue generada el " + dia + "/" + mes + "/" + anio + " a las: " +  horas  + ":"+ minutos +":"+segundos );
		
		JLabel lblImage = new JLabel("");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		Image imgagen = new ImageIcon(this.getClass().getResource("/images/imagenFacu.jpg")).getImage();
		lblImage.setIcon(new ImageIcon(imgagen.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH)));
		lblImage.setBounds(280, 13, 126, 122);
		this.getContentPane().add(lblImage);	
	}
}
