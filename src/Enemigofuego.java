//Autor 1: Erick Alfonso Montán López. A01379766
//Autor 2: Lui Ángel Barriga Chávez. A01633169
//Nombre de la clase: EnemigoFuego.java
//Fecha: 11/05/2019

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Enemigofuego {
	public int efX,efY,velocidadf,movefX,movefY;
	public Image enemigo1f,bloodf;
	public boolean aciertof,movef;
	public Random rfX,rfY;
	
	public Enemigofuego() {
		this.aciertof=false;
		this.efX= (int) (Math.random()*750);
		this.efY=(int) (Math.random()*350);
		this.velocidadf=11;
		this.movef=false;
		this.movefX=0;
		this.movefX=0;
		this.enemigo1f=new ImageIcon("enemigo3.png").getImage();
		this.bloodf=new ImageIcon("blood.png").getImage();
		
		
	}
	public void pintaEnemigof(Graphics g) {
		if(this.aciertof) {
			g.drawImage(this.bloodf, this.efX, this.efY,50,50, null);
		}else {
			g.drawImage(this.enemigo1f, this.efX, this.efY, 50, 50, null);
		}
	}
	public void defineRuta() {
		this.movefX=randomicer(randomicer(10));
		this.movefX=randomicer(randomicer(10));
	}
	public int randomicer() {
		return randomicer(10);
	}
	public int randomicer(int cantidad) {
		Random ran=new Random();
		return ran.nextInt(cantidad);
	}
	public void mueveEnemigof() {
		if(!this.aciertof) {
			if(randomicer()==2) {
				if(this.movefX!=0) {
				if(this.efX+1<750) this.efX+=2;
				if(this.efY+1<350)this.efY+=2;
				this.movefX--;
				}
			}else if(randomicer()==5) {
				if(this.efX-1>0) this.efX-=2;
				if(this.efY-1>0)this.efY-=2;
			}else if(randomicer()==4) {
				if(this.efX-1>0) this.efX+=2;
				if(this.efY-1>0)this.efY-=2;
			}
			else if(randomicer()==6) {
				if(this.efX-1>0) this.efX-=2;
				if(this.efY-1>0)this.efY+=2;
			}
			
		}
	}
}
