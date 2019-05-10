//Autor 1: Erick Alfonso Montán López. A01379766
//Autor 2: Lui Ángel Barriga Chávez. A01633169
//Nombre de la clase: EnemigoDemonio.java
//Fecha: 11/05/2019

import java.awt.Graphics;
	import java.awt.Image;
	import java.awt.Rectangle;
	import java.util.Random;
	import javax.swing.ImageIcon;
public class EnemigoDemonio {

		public int demX,demY,velocidadem,moveXdem,moveYdem;
		public Image enemigo2,blooddem;
		public boolean aciertodem,movedem;
		public Random rXdem,rYdem;
		
		public EnemigoDemonio() {
			this.aciertodem=false;
			this.demX= (int) (Math.random()*750);
			this.demY=(int) (Math.random()*350);
			this.velocidadem=8;
			this.movedem=false;
			this.moveXdem=0;
			this.moveYdem=0;
			this.enemigo2=new ImageIcon("enemigo2.png").getImage();
			this.blooddem=new ImageIcon("blood.png").getImage();
			
			
		}
		public void pintaEnemigoDem(Graphics g) {
			if(this.aciertodem) {
				g.drawImage(this.blooddem, this.demX, this.demY,50,50, null);
			}else {
				g.drawImage(this.enemigo2, this.demX, this.demY, 50, 50, null);
			}
		}
		public void defineRutaDem() {
			this.moveXdem=randomicerDem(randomicerDem(10));
			this.moveYdem=randomicerDem(randomicerDem(10));
		}

		public int randomicerDem() {
			return randomicerDem(10);
		}
		public int randomicerDem(int cantidad) {
			Random ran=new Random();
			return ran.nextInt(cantidad);
		}
		public void mueveEnemigoDEM() {
			if(!this.aciertodem) {
				if(randomicerDem()==2) {
					if(this.moveXdem!=0) {
					if(this.demX+1<750) this.demX+=2;
					if(this.demY+1<350)this.demY+=2;
					this.moveXdem--;
					}
				}else if(randomicerDem()==5) {
					if(this.demX-1>0) this.demX-=2;
					if(this.demY-1>0)this.demY-=2;
				}else if(randomicerDem()==4) {
					if(this.demX-1>0) this.demX+=2;
					if(this.demY-1>0)this.demY-=2;
				}
				else if(randomicerDem()==6) {
					if(this.demX-1>0) this.demX-=2;
					if(this.demY-1>0)this.demY+=2;
				}
				
			}
		}
	}

