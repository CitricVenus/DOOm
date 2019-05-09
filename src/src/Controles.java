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
	public int mX,mY,pX,bala,clickX,clickY,contador,nivelactual;
	public Thread hilo=new Thread(this);
	public HUD Hud;
	public EnemigoCalavera enemigo1;
	public Scope scope;
	public Jugador jugador;
	public ArrayList<EnemigoCalavera> enemigos = new ArrayList<EnemigoCalavera>();


	public Controles () {
		this.setPreferredSize(new Dimension(800,700));
		this.scope=new Scope();
		this.contador=0;
		this.nivelactual=1;
		this.enemigo1=new EnemigoCalavera();
		this.hud=new ImageIcon("Hud.png").getImage();
		this.fondo=new ImageIcon("Fondo.jpg").getImage();
		this.pX=400;
		this.Hud=new HUD();
		this.jugador=new Jugador();
		addMouseMotionListener(this);
		addMouseListener(this);
		addKeyListener(this);
		hilo.start();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.fondo, 0, 0, this.getWidth(),this.getHeight(),this);
		this.jugador.pintaJugador(g);
		g.drawImage(this.hud,1, 610, 800, 90,this );
		g.setFont( new Font( "Tahoma", Font.BOLD, 46 ) );
		this.enemigo1.pintaEnemigo(g);
		this.Hud.pintaHUD(g);
		this.scope.pintaScope(g);
		
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton()== MouseEvent.BUTTON1) {
			this.clickX=e.getX();
			this.clickY=e.getY();
			this.jugador.disparo=true;
			this.repaint();
		}
		if(e.getButton()==MouseEvent.BUTTON3) {
			this.jugador.escudoAct=true;
			this.repaint();
		}
		if((this.clickX>=this.enemigo1.eX)&&(this.clickX<=this.enemigo1.eX+50)
				&&(this.clickY>=this.enemigo1.eY)&&(this.clickY<=this.enemigo1.eY+50)) {
			System.out.println("Area enemigo");
			this.enemigo1.acierto=true;
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
				 
				Thread.sleep(100);
				this.repaint();
			} 
		 }catch (InterruptedException e) {
				e.printStackTrace();
		 }
	}
	public boolean Acierto() {
		return this.scope.getBounds().intersects(this.enemigo1.getBounds());
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
	

