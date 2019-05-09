import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class EnemigoCalavera {
	public int eX,eY,velocidad;
	public Image enemigo1,blood;
	public boolean acierto;
	public EnemigoCalavera() {
		this.acierto=false;
		this.eX=0;
		this.eY=20;
		this.enemigo1=new ImageIcon("enemigo1.png").getImage();
		this.blood=new ImageIcon("blood.png").getImage();
		
	}
	public void pintaEnemigo(Graphics g) {
		if(acierto) {
			g.drawImage(this.blood, this.eX, this.eY,50,50, null);
		}else {
			g.drawImage(this.enemigo1, this.eX, this.eY, 50, 50, null);
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(this.eX,this.eY,50,50);
	}
	public void mueveEnemigo() {
		
	}
}
