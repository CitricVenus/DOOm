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

public class NIvel2 extends JPanel implements MouseMotionListener, MouseListener,KeyListener,Runnable{
	public Image hud,map2;
	public int mX,mY,pX,bala,clickX,clickY,contador,nivelactual,menosenemigosdem;
	public Thread hilo=new Thread(this);
	public HUD Hud;
	public Controles ctrl;
	public EnemigoDemonio enemigodem;
	public Scope scope;
	public Nivel3 lvl3;
	public Jugador jugador;
	public EnemigoDemonio []enemigosdem;
	public Ventana play;



	public NIvel2 (Ventana play) {
		this.play=play;
		this.setPreferredSize(new Dimension(800,700));
		this.scope=new Scope();
		this.menosenemigosdem=6;
		this.nivelactual=2;
		this.enemigodem=new EnemigoDemonio();
		this.hud=new ImageIcon("Hud.png").getImage();
		this.map2=new ImageIcon("map2.jpg").getImage();
		this.pX=400;
		this.Hud=new HUD();
		this.jugador=new Jugador();
		addMouseMotionListener(this);
		addMouseListener(this);
		addKeyListener(this);

		this.enemigosdem=new EnemigoDemonio[6];
		for (int i=0;i<this.enemigosdem.length;i++) {
			this.enemigosdem[i]=new EnemigoDemonio();
		}
		hilo.start();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.Hud.score=+this.Hud.score;
		this.Hud.nivel=2;
		g.drawImage(this.map2, 0, 0, this.getWidth(),this.getHeight(),this);
		this.jugador.pintaJugador(g);
		g.drawImage(this.hud,1, 610, 800, 90,this );
		g.setFont( new Font( "Tahoma", Font.BOLD, 46 ) );
		for(int i=0;i<this.enemigosdem.length;i++) {
			this.enemigosdem[i].pintaEnemigoDem(g);
			
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
		for(int i=0;i<this.enemigosdem.length;i++) {
			if((this.clickX>=this.enemigosdem[i].demX)&&(this.clickX<=this.enemigosdem[i].demX+50)
					&&(this.clickY>=this.enemigosdem[i].demY)&&(this.clickY<=this.enemigosdem[i].demY+50)) {
					this.menosenemigosdem--;
						if(this.Hud.balas<=0 && this.menosenemigosdem>=1) {
						System.out.println("Game Over");
						}
						 if(this.Hud.balas>=0 && this.menosenemigosdem==0){
						System.out.println("Siguiente nivel");
						Nivel3 lvl3=new Nivel3(this.play);
						this.play.setPanel(lvl3);
							}
				if(!this.enemigosdem[i].aciertodem) {
					
					this.Hud.score=40+this.Hud.score+15;
					this.enemigosdem[i].aciertodem=true;
					
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
				for(int i=0;i<this.enemigosdem.length;i++) {
					this.enemigosdem[i].mueveEnemigoDEM();
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
	
