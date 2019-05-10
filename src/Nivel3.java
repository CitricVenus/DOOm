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

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Nivel3 extends JPanel implements MouseMotionListener, MouseListener,KeyListener,Runnable{
	public Image hud,map3;
	public int mX,mY,pX,bala,clickX,clickY,contador,nivelactual,menosenemigosdem;
	public Thread hilo=new Thread(this);
	public HUD Hud;
	public Controles ctrl;
	public Enemigofuego enemigof;
	public Scope scope;
	public Jugador jugador;
	public Enemigofuego []enemigosf;
	public Ventana play;



	public Nivel3 (Ventana play) {
		this.play=play;
		this.setPreferredSize(new Dimension(800,700));
		this.scope=new Scope();
		this.menosenemigosdem=11;
		this.nivelactual=3;
		this.enemigof=new Enemigofuego();
		this.hud=new ImageIcon("Hud.png").getImage();
		this.map3=new ImageIcon("map3.jpg").getImage();
		this.pX=400;
		this.Hud=new HUD();
		this.jugador=new Jugador();
		addMouseMotionListener(this);
		addMouseListener(this);
		addKeyListener(this);

		this.enemigosf=new Enemigofuego[12];
		for (int i=0;i<this.enemigosf.length;i++) {
			this.enemigosf[i]=new Enemigofuego();
		}
		hilo.start();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.Hud.nivel=3;
		this.Hud.score=+this.Hud.score;
		g.drawImage(this.map3, 0, 0, this.getWidth(),this.getHeight(),this);
		this.jugador.pintaJugador(g);
		g.drawImage(this.hud,1, 610, 800, 90,this );
		g.setFont( new Font( "Tahoma", Font.BOLD, 46 ) );
		for(int i=0;i<this.enemigosf.length;i++) {
			this.enemigosf[i].pintaEnemigof(g);
			
		}
		this.Hud.pintaHUD(g);
		this.scope.pintaScope(g);
		
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton()== MouseEvent.BUTTON1) {
			this.clickX=e.getX();
			this.clickY=e.getY();
			this.jugador.disparo=true;
			this.Hud.balas--;
			this.repaint();
			System.out.println(this.menosenemigosdem);
		}
		for(int i=0;i<this.enemigosf.length;i++) {
			if((this.clickX>=this.enemigosf[i].efX)&&(this.clickX<=this.enemigosf[i].efX+50)
					&&(this.clickY>=this.enemigosf[i].efY)&&(this.clickY<=this.enemigosf[i].efY+50)) {
					this.menosenemigosdem--;
						if(this.Hud.balas<=0 && this.menosenemigosdem>=1) {
						System.out.println("Game Over");
						}
						 if(this.Hud.balas>=0 && this.menosenemigosdem==0){
						System.out.println("Siguiente nivel");
							}
				if(!this.enemigosf[i].aciertof) {
					
					this.Hud.score=40+this.Hud.score+15;
					this.enemigosf[i].aciertof=true;
					
				}
				this.repaint();
				
			}
		}
		
		
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
				for(int i=0;i<this.enemigosf.length;i++) {
					this.enemigosf[i].mueveEnemigof();
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
	