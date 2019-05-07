import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.security.Key;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Controles extends JPanel implements MouseMotionListener, MouseListener,KeyListener, Runnable{
	private Image mira,mira2,mira3,player;
	private int mX,mY,rX,rY,pX,bala,clickX,clickY;
	private Thread hilo;
	private Disparo disparo;
	private boolean mover;

	public Controles () {
		this.setPreferredSize(new Dimension(800,700));
		this.mira=new ImageIcon("mira.png").getImage();
		this.mira2=new ImageIcon("mira2.png").getImage();
		this.mira3=new ImageIcon("mira3.png").getImage();
		this.player=new ImageIcon("player.gif").getImage();
		this.mX=0;
		this.mY=0;
		this.pX=400;
		this.disparo=new Disparo();
		addMouseMotionListener(this);
		addMouseListener(this);
		addKeyListener(this);
		this.hilo=new Thread();
		this.hilo.start();
		this.mover=false;
			


		
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(this.mira2,this.mX, this.mY, 50, 50,this );
		g.drawImage(this.player,this.pX, 630, 70, 70,this );
		this.disparo.pintaBala(g);
			
		this.setBackground(Color.GREEN);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.clickX=e.getX();
		this.clickY=e.getY();
		System.out.println("------clickx"+this.clickX);
		System.out.println("------clicky"+this.clickY);
		this.mover=true;
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
		this.rX=e.getX();
		this.rY=e.getY();
		this.mX=this.rX-25;
		this.mY=this.rY-25;
		System.out.println(this.rY);
		System.out.println(this.rX);
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
	@Override
	public void run() {
			try {
			while((this.disparo.dY<=0) && (this.disparo.dX<=0)&& (this.disparo.dY>=700)&&(this.disparo.dX>=800)) {
			if(mover) {
				System.out.println("Se activa hilo");
			this.disparo.dX=(this.clickX-this.disparo.dX);
			this.disparo.dY=(this.clickY-this.disparo.dY);
			repaint();
				}
				Thread.sleep(20);
				}
			}
			catch (InterruptedException e) {
				System.out.println("No se epudo despertar el hilo");
				}
		
		}
		
	}
	

