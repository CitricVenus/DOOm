import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class EnemigoCalavera {
	public int eX,eY,velocidad;
	public Image enemigo1,blood;
	public boolean acierto,move;
	public Random rX,rY;
	
	public EnemigoCalavera() {
		this.acierto=false;
		this.eX= (int) (Math.random()*800);
		this.eY=(int) (Math.random()*350);
		this.velocidad=3;
		this.move=false;
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
		if(this.move) {
			while((this.eX>=0)&&(this.eX<=890)&&(this.eY>=0)&&(this.eX<=350)) {
				this.eX++;
				this.eY++;
			}
		}
	}
}
