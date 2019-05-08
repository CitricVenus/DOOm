import java.awt.Color;
import java.awt.Graphics;

import javax.swing.RepaintManager;

public class Disparo {
	public int dX,dY;
	public boolean mover;
	public Disparo() {
		this.dX=420;
		this.mover=false;
		this.dY=620;
		
	}
	public void setdisparoDX(int dx) {
		this.dX=dx;
	}
	public void setdisparoDY(int dy) {
		this.dY=dy;
	}
	public int getdisparoDX() {
		return this.dX;
	}
	public int getdisparoDY() {
		return this.dY;
	}
	public void pintaBala(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(this.dX, this.dY, 30, 30);
		
	}
	public void run() {
		try {
		while((this.dY<=0) && (this.dX<=0)&& (this.dY>=700)&&(this.dX>=800)) {
		if(mover) {
			System.out.println("Se activa hilo");
		this.disparo.dX++;
		this.dY=(this.clickY-this.disparo.dY);
		this.setdisparoDX(this.disparo.dX);
		this.setdisparoDY(this.disparo.dY);

			}
			Thread.sleep(20);
			}
		}
		catch (InterruptedException e) {
			System.out.println("No se epudo despertar el hilo");
			}
	
	}
	
	
}
