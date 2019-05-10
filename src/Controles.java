//Autor 1: Erick Alfonso Montán López. A01379766
//Autor 2: Lui Ángel Barriga Chávez. A01633169
//Nombre de la clase: Controles.java
//Fecha: 11/05/2019

import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Controles extends JPanel implements MouseMotionListener, MouseListener,KeyListener,Runnable{
	public Image hud,fondo,lvlscore,cara,balas;
	public boolean cambionivel;
	public int mX,mY,pX,bala,clickX,clickY,nivelactual,menosenemigoscal,scorectrl;
	public Thread hilo=new Thread(this);
	public HUD Hud;
	public EnemigoCalavera enemigos;
	public Scope scope;
	public Jugador jugador;
	public MainMenu menu;
	public EnemigoCalavera []enemigocalav;
	public Ventana play;

	


	public Controles (Ventana play) {
	
		this.play=play;
		this.setPreferredSize(new Dimension(800,700));
		this.scorectrl=0;
		this.scope=new Scope();
		this.menosenemigoscal=4;
		
		this.nivelactual=1;
		this.cambionivel=false;
		this.enemigos=new EnemigoCalavera();
		this.lvlscore=new ImageIcon("lvlscor.png").getImage();
		this.cara=new ImageIcon("cara.png").getImage();
		this.balas=new ImageIcon("balas.png").getImage();
		this.fondo=new ImageIcon("Fondo.jpg").getImage();
		this.pX=400;
		this.Hud=new HUD();
		this.jugador=new Jugador();
		addMouseMotionListener(this);
		addMouseListener(this);
		addKeyListener(this);

		this.enemigocalav=new EnemigoCalavera[4];
		for (int i=0;i<this.enemigocalav.length;i++) {
			this.enemigocalav[i]=new EnemigoCalavera();
		}
		hilo.start();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	
		g.drawImage(this.fondo, 0, 0, this.getWidth(),this.getHeight(),this);
		this.jugador.pintaJugador(g);
		g.drawImage(this.lvlscore,1, 610, 400, 90,this );
		g.drawImage(this.cara,400, 610, 200, 90,this );
		g.drawImage(this.balas,600, 610, 200, 90,this );
		
		
		g.setFont( new Font( "Tahoma", Font.BOLD, 46 ) );
		for(int i=0;i<this.enemigocalav.length;i++) {
			this.enemigocalav[i].pintaEnemigo(g);
			
		}
		this.Hud.pintaHUD(g);
		this.scope.pintaScope(g);
		
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton()== MouseEvent.BUTTON1) {
			this.clickX=e.getX();
			this.clickY=e.getY();
			this.Hud.balas--;
		
		
		for(int i=0;i<this.enemigocalav.length;i++) {
			if((this.clickX>=this.enemigocalav[i].eX)&&(this.clickX<=this.enemigocalav[i].eX+50)
					&&(this.clickY>=this.enemigocalav[i].eY)&&(this.clickY<=this.enemigocalav[i].eY+50)) {
						this.menosenemigoscal--;
						if(!this.enemigocalav[i].acierto) {
							this.Hud.score=this.Hud.score+10;
							this.enemigocalav[i].acierto=true;
					
								
						}
				 
						}
			
			

			}
			if(this.Hud.balas==0 && this.menosenemigoscal>1) {
		
			GameOver gameover=new GameOver(this.play);
			this.play.setPanel(gameover);
				}
		if(this.Hud.balas>=0 && this.menosenemigoscal==0 ){
		
		NIvel2 lvl2=new NIvel2(this.play);
		this.play.setPanel(lvl2);
			}
		}
		
		this.repaint();
	}
	public void mouseMoved(MouseEvent e) {
		this.scope.sX=e.getX()-25;
		this.scope.sY=e.getY()-25;
		this.jugador.disparo=false;
		repaint();
		
	}
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void run() {
		 try {
			 while(true) {
				 this.jugador.escudoAct=true;
				for(int i=0;i<this.enemigocalav.length;i++) {
					this.enemigocalav[i].mueveEnemigo();
					Thread.sleep(2);
					this.repaint();
				}
				this.repaint();
			} 
		 }catch (InterruptedException e) {
				e.printStackTrace();
		 }
	}
	public void siguienteNivel(){
		
	}
	public void gameOver() {
	
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseDragged(MouseEvent e) {}
}
	

