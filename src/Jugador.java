import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Jugador {
	public int pX;
	private Image player,playergif;
	public Jugador() {
		this.pX=400;
		this.player=new ImageIcon("player.gif").getImage();
		this.playergif=new ImageIcon("player.png").getImage();
		
	}
	public void pintaJugador(Graphics g) {
		g.drawImage(this.player,this.pX-35, 500, 120, 120,null);
	
	}

}
