import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class HUD {
	public int vida,score,nivel,vidas,balas;
	public HUD() {
		this.vida=100;
		this.score=0;
		this.nivel=1;
		this.vidas=3;
		this.balas=5;
	}
	public void pintaHUD(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawString(""+this.nivel, 50, 687);
		g.drawString(""+this.score, 200, 687);
		g.drawString(""+this.vidas, 425, 687);
		g.drawString(this.vida+" ", 660, 687);
		g.drawString("Balas:"+this.balas, 0, 600);
		
	}
	public void sinMunicion() {
		if(this.balas==0) {
		System.out.println("Game Over");
		}
	}
	public void cambiaNivel() {
		
	}
	
	public void Score() {
		
	}
	public void Vidas() {
		
	}
	
	public void Vida() {
		
	}
}
