import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class EnemigoCalavera {
	public int eX,eY,velocidad,moveX,moveY;
	public Image enemigo1,blood;
	public boolean acierto,move;
	public Random rX,rY;
	
	public EnemigoCalavera() {
		this.acierto=false;
		this.eX= (int) (Math.random()*750);
		this.eY=(int) (Math.random()*350);
		this.velocidad=3;
		this.move=false;
		this.moveX=0;
		this.moveY=0;
		this.enemigo1=new ImageIcon("enemigo1.png").getImage();
		this.blood=new ImageIcon("blood.png").getImage();
		
		
	}
	public void pintaEnemigo(Graphics g) {
		if(this.acierto) {
			g.drawImage(this.blood, this.eX, this.eY,50,50, null);
		}else {
			g.drawImage(this.enemigo1, this.eX, this.eY, 50, 50, null);
		}
	}
	public void defineRuta() {
		this.moveX=randomicer(randomicer(10));
		this.moveY=randomicer(randomicer(10));
	}
	public int randomicer() {
		return randomicer(10);
	}
	public int randomicer(int cantidad) {
		Random ran=new Random();
		return ran.nextInt(cantidad);
	}
	public void mueveEnemigo() {
		if(!this.acierto) {
			if(randomicer()==2) {
				if(this.moveX!=0) {
				if(this.eX+1<750) this.eX+=2;
				if(this.eY+1<350)this.eY+=2;
				this.moveX--;
				}
			}else if(randomicer()==5) {
				if(this.eX-1>0) this.eX-=2;
				if(this.eY-1>0)this.eY-=2;
			}else if(randomicer()==4) {
				if(this.eX-1>0) this.eX+=2;
				if(this.eY-1>0)this.eY-=2;
			}
			else if(randomicer()==6) {
				if(this.eX-1>0) this.eX-=2;
				if(this.eY-1>0)this.eY+=2;
			}
			
		}
	}
}
