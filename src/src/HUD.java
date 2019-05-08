import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class HUD {
	private String vida,score,nivel,vidas;
	public HUD() {
		this.vida="100";
		this.score="0";
		this.nivel="1";
		this.vidas="3";
		
		
	}
	public void pintaHUD(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawString(this.nivel, 50, 687);
		g.drawString(this.score, 300, 687);
		g.drawString(this.vidas, 425, 687);
		g.drawString(this.vida, 660, 687);
		
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
