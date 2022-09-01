package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student facu = new Student (130943, "peri", "facundo", "facuelperi@gmail.com", "https://github.com/facuperi/tdp-proyecto-1","/images/imagenFacu.jpg");
            	SimplePresentationScreen screen = new SimplePresentationScreen(facu);
            	screen.setVisible(true);
            }
        });
    }
}