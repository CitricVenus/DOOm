import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Jugador {
	public int pX;
	public Image player,playergif,shoot;
	public int eX,eY;
	
	public boolean disparo,escudo;
	public boolean escudoAct;
	public int contadorEsc;
	public Jugador() {
		this.eX=320;
		this.eY=450;
		this.disparo=false;
		this.escudoAct=true;
		this.pX=400;
		this.contadorEsc=0;
		this.playergif=new ImageIcon("player.gif").getImage();
		this.player=new ImageIcon("normal.png").getImage();
		this.shoot=new ImageIcon("shoot.png").getImage();
		
	}
	public void pintaJugador(Graphics g) {
		if(disparo) {
			g.drawImage(this.player,this.pX-45, 500, 120, 120,null);
			g.drawImage(this.shoot,this.pX-40, 430, 110, 110,null); 
			this.disparo=false;	
		}
		else {
			g.drawImage(this.player,this.pX-45, 500, 150, 120,null);
		}
	}
	public Rectangle getBounds() {
		return new Rectangle(this.pX-35,500,50,50);
	}
	


}
