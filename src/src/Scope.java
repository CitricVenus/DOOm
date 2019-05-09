import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Scope {
	public int sX,sY;
	public Image mira,mira2,mira3;

	public Scope() {
	
		this.mira=new ImageIcon("mira.png").getImage();
		this.mira2=new ImageIcon("mira2.png").getImage();
		this.mira3=new ImageIcon("mira3.png").getImage();
	}
	public void pintaScope(Graphics g) {
		g.drawImage(this.mira2,this.sX, this.sY, 50, 50, null);
	}

	public Rectangle getBounds() {
		return new Rectangle(this.sX,this.sY,50,50);
	}
	
}
