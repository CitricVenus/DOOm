//Autor 1: Erick Alfonso Montán López. A01379766
//Autor 2: Lui Ángel Barriga Chávez. A01633169
//Nombre de la clase: HUD.java
//Fecha: 11/05/2019

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class HUD {
	public Controles controles;
	public NIvel2 lvl2;
	public int vida,score,nivel,vidas,balas;
	public HUD() {
		this.score=0;
		this.nivel=1;

		this.balas=7;

	}
	public void pintaHUD(Graphics g) {

		g.setColor(Color.WHITE);
		g.drawString(""+this.score, 200, 687);
		g.drawString(""+this.balas, 700, 687);
		g.drawString(""+this.nivel, 50, 687);
	}
	
	
	
}
