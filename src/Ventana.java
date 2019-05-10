import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Ventana extends JFrame{
	private Container contenedorGame=getContentPane();
	public Ventana() {
		super("Juego");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		MainMenu menu=new MainMenu(this);
		this.setPanel(menu);
		this.pack();
		
		
	}
	public void actualizarPantalla() {
		SwingUtilities.updateComponentTreeUI(this);
	}
	public void setPanel(JPanel panel) {
		this.getContentPane().removeAll();
		this.contenedorGame.add(panel);
		this.actualizarPantalla();
		
	}
	public static void main (String []args) {
		Ventana play=new Ventana();

	}

}
 