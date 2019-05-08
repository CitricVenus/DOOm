import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.security.Key;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Controles extends JPanel implements MouseMotionListener, MouseListener,KeyListener{
	private Image hud,fondo;
	private int mX,mY,pX,bala,clickX,clickY;
	private Thread hilo;
	private Disparo disparo;
	private HUD Hud;
	private Scope scope;
	private Jugador jugador;
	private boolean mover,disparargif;

	public Controles () {
		this.setPreferredSize(new Dimension(800,700));
		this.scope=new Scope();
		this.hud=new ImageIcon("Hud.png").getImage();
		this.fondo=new ImageIcon("Fondo.jpg").getImage();
		this.disparargif=false;
		this.pX=400;
		this.Hud=new HUD();
		this.jugador=new Jugador();
		this.disparo=new Disparo();
		addMouseMotionListener(this);
		addMouseListener(this);
		addKeyListener(this);
	
		this.mover=false;
			


		
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	

		g.drawImage(this.fondo, 0, 0, this.getWidth(),this.getHeight(),this);
		this.jugador.pintaJugador(g);
		g.drawImage(this.hud,1, 610, 800, 90,this );
		
		g.setFont( new Font( "Tahoma", Font.BOLD, 46 ) );
		this.Hud.pintaHUD(g);
		
		this.scope.pintaScope(g);
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		this.clickX=e.getX();
		this.clickY=e.getY();
		System.out.println("------clickx"+this.clickX);
		System.out.println("------clicky"+this.clickY);
		this.mover=true;
		this.disparargif=true;
		System.out.println("Mueve");
		repaint();
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {

		
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.scope.sX=e.getX()-25;
		this.scope.sY=e.getY()-25;
		repaint();
		
	}
	
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_D) {
			System.out.println("Presion right");
			this.pX+=10;
			if(this.pX>=750) {
				this.pX=750;
			}
			repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_A) {
			System.out.println("Presion left");
			this.pX-=10;
			if(this.pX<=50) {
				this.pX=800;
			}
			repaint();
			
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	


	
}
	

