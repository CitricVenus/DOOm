import java.awt.Color;
import java.awt.Graphics;

import javax.swing.RepaintManager;

public class Disparo {
	public int dX,dY;
	public Disparo() {
		this.dX=400;
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
	
	
}
