//Autor 1: Erick Alfonso Montán López. A01379766
//Autor 2: Lui Ángel Barriga Chávez. A01633169
//Nombre de la clase: GameOver.java
//Fecha: 11/05/2019

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameOver extends JPanel implements ActionListener {
	public JButton menu;
	public Image gameover;
	public Ventana play;
	public  GameOver(Ventana play) {
		super();
		this.play=play;
		this.setPreferredSize(new Dimension(800,700));
		this.menu= new JButton("Menu");
		this.add(this.menu);
		this.menu.addActionListener(this);
		this.gameover=new ImageIcon("gameover.jpg").getImage();
	
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(this.gameover, 0, 0, this.getWidth(),this.getHeight(),this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.menu) {
			MainMenu menu=new MainMenu(this.play);
			this.play.setPanel(menu);
		}
		
	}

}
