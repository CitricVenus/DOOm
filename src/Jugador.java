import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Jugador {
	public int pX;
	public Image[] jugadorDisp;
	public Image jugador;
	private int eX,eY;
	public boolean disparo,escudo;
	public boolean escudoAct;
	private int contadorEsc,tiempo;
	public Jugador() {
		this.eX=320;
		this.eY=450;
		this.disparo=false;
		this.escudoAct=false;
		this.pX=400;
		this.contadorEsc=0;
		this.tiempo=0;
		this.jugadorDisp = new Image[2];
		this.jugadorDisp[0] = new ImageIcon("normal.png").getImage();
		this.jugadorDisp[1] = new ImageIcon("shoot.png").getImage();
		this.jugador = new ImageIcon("shoot.png").getImage();
		
		
	}
	public void pintaJugador(Graphics g) {
		if(this.disparo) {
			if(this.tiempo==2)this.tiempo=0;
			g.drawImage(this.jugadorDisp[this.tiempo], this.pX-45, 500, 120, 120,null);
		}else {
			g.drawImage(this.jugador,this.pX-45, 500, 150, 120,null);	
		}
		if(this.escudoAct) {
			g.setColor(Color.GREEN);
			g.fillRect(this.eX, this.eY, 220, 25);
		}
	}
	

	public Rectangle getBounds() {
		return new Rectangle(this.pX-35,500,50,50);
	}
	public void tiempos() {
		this.tiempo++;
		
	}
	public void contEscudo() {
		System.out.println("Hola");
		if(this.escudoAct) {
			this.contadorEsc++;
			if(contadorEsc>=5) {
				this.escudoAct=false;
				this.contadorEsc=0;
			}
		}
	}
}
