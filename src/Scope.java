//Autor 1: Erick Alfonso Montán López. A01379766
//Autor 2: Lui Ángel Barriga Chávez. A01633169
//Nombre de la clase: Scope.java
//Fecha: 11/05/2019

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Scope {
	public int sX,sY;
	public Image mira,mira2,mira3;

	public Scope() {

		this.mira2=new ImageIcon("mira2.png").getImage();
		
	}
	public void pintaScope(Graphics g) {
		g.drawImage(this.mira2,this.sX, this.sY, 50, 50, null);
	}

	
}
