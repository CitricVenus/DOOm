import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenu extends JPanel implements ActionListener {
	public JButton iniciar;
	public Image titulo;
	public Ventana play;
	public  MainMenu(Ventana play) {
		super();
		this.play=play;
		this.setPreferredSize(new Dimension(800,700));
		this.iniciar= new JButton("Iniciar");
		this.add(this.iniciar);
		this.iniciar.addActionListener(this);
		this.titulo=new ImageIcon("Titulo.jpg").getImage();
	
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(this.titulo, 0, 0, this.getWidth(),this.getHeight(),this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.iniciar) {
			Controles playing=new Controles(this.play);
			this.play.setPanel(playing);
		}
		
	}

}
