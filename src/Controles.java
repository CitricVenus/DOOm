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

public class Controles extends JPanel implements MouseMotionListener, MouseListener,KeyListener,Runnable{
	public Image hud,fondo;
	public boolean cambionivel;
	public int mX,mY,pX,bala,clickX,clickY,nivelactual,menosenemigos,scorectrl;
	public Thread hilo=new Thread(this);
	public HUD Hud;
	public EnemigoCalavera enemigos;
	public Scope scope;
	public Jugador jugador;
	public EnemigoCalavera []enemigocalav;
	public Ventana play;


	public Controles (Ventana play) {
		this.play=play;
		this.setPreferredSize(new Dimension(800,700));
		this.scorectrl=0;
		this.scope=new Scope();
		this.menosenemigos=4;
		this.nivelactual=1;
		this.cambionivel=false;
		this.enemigos=new EnemigoCalavera();
		this.hud=new ImageIcon("Hud.png").getImage();
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
		this.Hud.score=+this.Hud.score;

		g.drawImage(this.fondo, 0, 0, this.getWidth(),this.getHeight(),this);
		this.jugador.pintaJugador(g);
		g.drawImage(this.hud,1, 610, 800, 90,this );
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
			this.jugador.disparo=true;
			this.Hud.balas--;
			this.repaint();
			System.out.println(this.menosenemigos);
		}

		for(int i=0;i<this.enemigocalav.length;i++) {
			if((this.clickX>=this.enemigocalav[i].eX)&&(this.clickX<=this.enemigocalav[i].eX+50)
					&&(this.clickY>=this.enemigocalav[i].eY)&&(this.clickY<=this.enemigocalav[i].eY+50)) {
					this.menosenemigos--;
						if(this.Hud.balas==0 && this.menosenemigos>=1) {
							System.out.println("Game Over");
						}
						else if(this.Hud.balas>=0 && this.menosenemigos==0 ){
						System.out.println("Siguiente nivel");
						this.cambionivel=true;
						System.out.println(this.cambionivel);
						NIvel2 lvl2=new NIvel2(this.play);
						this.play.setPanel(lvl2);
						}
					
				if(!this.enemigocalav[i].acierto) {
					this.Hud.score=this.Hud.score+10;
					
					this.enemigocalav[i].acierto=true;
					
				}
				
				this.repaint();
				 
			}
			else {
				
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
	

