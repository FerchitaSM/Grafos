package Grafo;

import java.awt.Color;
import java.awt.Graphics;

public class Nodo {
	private int x, y;
	public static final int D = 50;
	private String nombre;
	private int position;
	private boolean color;
	
	public Nodo(int x, int y, String nombre, int position, boolean color) {
		super();
		this.x = x;
		this.y = y;
		this.nombre = nombre;
		this.position = position;
		this.color=color;

	}
	
	
	public int getX() {return x;}
	public void setX(int x) {this.x = x;}
	public int getY() {return y;}
	public void setY(int y) {this.y = y;}
	public static int getD() {return D;}
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public int getPosition() {return position;}
	public void setPosition(int position) {this.position = position;}


	public void paint(Graphics g) {
		if (color)
			g.setColor(Color.ORANGE);
		else
			g.setColor(Color.PINK);
		g.fillOval(this.x - (D/2),this.y- (D/2), D, D);
		g.setColor(Color.black);
		g.drawString(String.valueOf(nombre), x, y);
	}	
}
