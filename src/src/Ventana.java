import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Ventana extends JFrame{
	public Ventana() {
		super("Juego");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Controles ctrl= new Controles();
		this.add(ctrl);
		this.pack();
		this.setVisible(true);
		this.setResizable(false);
		
		
		
	}
	public static void main (String []args) {
		Ventana vtn=new Ventana();

	}
}
 