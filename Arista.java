package Grafo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JOptionPane;

public class Arista  {
	private int x0, y0, x1, y1;
	private int peso;
	private final static int tamFlecha = 7;
	
	public Arista(int x0, int y0, int x1, int y1, int peso) {
		super();
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
		this.peso = peso;
	}//end class'constructor 
	
	//getters and setters
	public int getPeso() {return peso;}
	public void setPeso(int peso) {this.peso = peso;}

	public void paint(Graphics g) {
		 int xa = 0, xb=0,ya=0,yb=0;
		 if(x0==x1 && y0==y1) {
				g.setColor(Color.black);
				g.drawArc(x0-((Nodo.D)/2), y0-40-(Nodo.D/2), 40, 40, -50, 310);
				drawArrowP(g, x1-20, y1-50, x0+10, y0-26,"00"); 
				g.drawString(String.valueOf(peso), (x0-(Nodo.D/2)+20),(y0-40-(Nodo.D/2)));
			}  else {
			g.setColor(Color.black);
		//	g.drawPolygon(triangulo);
			g.setColor(Color.BLACK);
			//g.drawLine(x0, y0, x1, y1);
			
			 int radio = 100;
			float angulo = 360/10;
			 angulo = (float) Math.toRadians(angulo);
			   		     
			if(x1>x0)
			{	xa=x0+(Nodo.D/3); xb=x1-(Nodo.D/3); }
			else	
			{	xa=x0-(Nodo.D/3);xb=x1+(Nodo.D/3); }
			if(y0>y1)
			{	ya= y0-(Nodo.D/3);yb=y1+(Nodo.D/3); }
			else
			{	ya= y0+(Nodo.D/3);yb=y1-(Nodo.D/3); }
	
			drawArrow(g, xa, ya,xb, yb); 
			g.setColor(Color.black);
			g.drawString(String.valueOf(peso), ((x0+x1)/2),((y0+y1)/2));
			
		}//end if else 
	}//end class's methods 
	
	private void drawArrow(Graphics g1, int x1, int y1, int x2, int y2) { 
	       Graphics2D g = (Graphics2D) g1.create(); 
	       double dx = x2 - x1, dy = y2 - y1; 
	       double angle = Math.atan2(dy, dx); 
	       int len = (int) Math.sqrt(dx*dx + dy*dy); 
	       AffineTransform at = AffineTransform.getTranslateInstance(x1, y1); 
	       at.concatenate(AffineTransform.getRotateInstance(angle)); 
	       g.transform(at); 

	       // Draw horizontal arrow starting in (0, 0) 
	       g.drawLine(0, 0, len, 0); 
	       g.fillPolygon(new int[] {len, len-tamFlecha, len-tamFlecha, len}, 
		           new int[] {0, -tamFlecha, tamFlecha, 0}, 4);
	}//end methods class
	private void drawArrowP(Graphics g1, int x1, int y1, int x2, int y2, String r) { 
	       Graphics2D g = (Graphics2D) g1.create(); 
	       double dx = x2 - x1, dy = y2 - y1; 
	       double angle = Math.atan2(dy, dx); 
	       int len = (int) Math.sqrt(dx*dx + dy*dy); 
	       AffineTransform at = AffineTransform.getTranslateInstance(x1, y1); 
	       at.concatenate(AffineTransform.getRotateInstance(angle)); 
	       g.transform(at); 
	       // Draw horizontal arrow starting in (0, 0) 
	       if(r=="flecha")
	    	    g.drawLine(0, 0, len, 0); 
	       g.fillPolygon(new int[] {len, len-tamFlecha, len-tamFlecha, len}, 
		           new int[] {0, -tamFlecha, tamFlecha, 0}, 4);
	}
	
}//class's end
