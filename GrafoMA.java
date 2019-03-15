package Grafo;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class GrafoMA extends JPanel implements Grafo, MouseListener {
	
	private JButton btnMatriz, camino;

	private boolean dirigido; // Indica si es dirigido o no. 
	private int maxNodos; // Tamaño máximo de la tabla.
	private int numNodos; // Número de vértices del grafo. 
	private int  matrizAdy [][]; // Matriz de adyacencias del grafo. 
	private int opcion;
	
	private int  matrizCostos [][];
	private int fi; // Tamaño máximo de la tabla. 
	private int co; // Tamaño máximo de la tabla. 
	private String name [][];
	private Vector<Nodo> nodos;
	private Vector<Arista> aristas;
	private Point p1, p2;
	private boolean color=true;

	private int inicio;
	private int c;
	
	public GrafoMA (boolean d) {
		maxNodos = numNodos = c = 0;
		dirigido = d;
		ejecutar();
	}
	public GrafoMA (int n, boolean d, int opcion) {
		dirigido = d;
		maxNodos = n;
		numNodos = 0;
		this.opcion = opcion;
		matrizAdy = new int[n][n];
		ejecutar();
	}
	public GrafoMA (int f, int c, int opcion) {
		this.fi = f;
		this.co = c;
		this.opcion = opcion;
		matrizCostos = new int[f][c];
		ejecutar();
		
	}
	
	private void ejecutar() {
		setLayout(new BorderLayout());
		nodos = new Vector<Nodo>();
		aristas = new Vector<Arista>();
		JPanel a = new JPanel();
		btnMatriz = new JButton("Ver Matriz de Adyacentes");
		a.add(btnMatriz);
		addMouseListener(this);
		add(a, BorderLayout.SOUTH);
		camino = new JButton("Algoritmo de asignacion");
		a.add(camino);
		
		btnMatriz.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				imprimirMatriz(matrizCostos);
				/*JFrame ventanaMatriz = new JFrame("Matriz de Adyacentes");
				ventanaMatriz.setSize(500, 300);
				JTextArea matriz  = new JTextArea(imprimirMatrizAdyString());
				ventanaMatriz.add(new JScrollPane(matriz), BorderLayout.CENTER);
				ventanaMatriz.setVisible(true);
				ventanaMatriz.setLocationRelativeTo(null);
				*/
			}
		});
		camino.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String []menu= {"Maximo","Minimo"};
				int optimo[][] = null;
				String valor = (String)JOptionPane.showInputDialog(null, "seleccionar opcion", "opciones",JOptionPane.DEFAULT_OPTION, null, menu,menu[0]);	
				if (valor.equalsIgnoreCase ("Maximo")) {
						/*CaminoCorto cc= new CaminoCorto(matrizAdy, false);
						cc.camino();		*/	
						
					AlgoritmoAsignacion cc = new AlgoritmoAsignacion (matrizCostos, true);
					cc.efectuarAlgoritmo();
					optimo = cc.getMatrizOptimo();
				}
				 if (valor.equalsIgnoreCase ("Minimo")) {
					AlgoritmoAsignacion cc = new AlgoritmoAsignacion (matrizCostos, false);
					cc.efectuarAlgoritmo();
					optimo = cc.getMatrizOptimo();
				}
				// imprimirMatriz(optimo);	 
				 mostrarres(optimo);
				 /*JFrame ventanaMatriz = new JFrame("Matriz de Adyacentes");
					ventanaMatriz.setSize(500, 300);
					JTextArea matriz  = new JTextArea(imprimirMatrizAdyString(optimo));
					ventanaMatriz.add(new JScrollPane(matriz), BorderLayout.CENTER);
					ventanaMatriz.setVisible(true);
					ventanaMatriz.setLocationRelativeTo(null);
				 */
				 
			}
		});
		
	}
	
	@Override
	public void insertaNodo(int n) {
		for (int i=0; i < numNodos + n; i++) { 
			for (int j = numNodos; j < numNodos + n; j++) 
				matrizAdy [i] [j] = matrizAdy [j] [i] = 0; 
		} 
		numNodos = numNodos + n; 
	}
	@Override
	public void eliminarNodo(int v) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insertaArista(int i, int j, int peso) {
		switch (opcion) {
		case 0:
			matrizAdy [i] [j] = peso; 
			if (!dirigido) 
				matrizAdy [j] [i] = matrizAdy [i] [j] = peso;
			break;
		case 1:
			matrizCostos [i] [j] = peso;
			break;

		default:
			break;
		}
		
	}
	@Override
	public void eliminarArista(int i, int j) {
			/*matrizAdy [i] [j] = false; 
		if (!dirigido) 
			matrizAdy [j] [i] = false;*/
		
	}
	@Override
	public boolean esVacio(Grafo g) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean existeArista(int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int gradoIn(int j) {
		/*int gIn = 0; 
		for (int i = 0; i < numNodos; i++) //recorrido por filas 
			if (matrizAdy [i] [j]) gIn++; //manteniendo la posición de la columna en [j] */
		return 0;
	}
	@Override
	public int gradoOut(int i) {
		/*int gOut = 0; 
		for (int j= 0; j < numNodos; j++) 
			if (matrizAdy [i][j]) gOut++; // manteniendo la posición de la fila en [i] */
		return 0;
	}
	@Override
	public int incidencia(int i) {
		if (!dirigido) 
			return gradoIn (i); 
		else 
			return gradoIn (i) + gradoOut (i);
	}
	@Override
	public int tamano() {
		/*int tm = 0; 
		for (int i = 0; i < numNodos; i++) 
			for (int j=0; j < numNodos; j++) 
				if (matrizAdy [i] [j]) tm++; 
		if (dirigido) 
			return tm; 
		else */
			//return tm/2;
		return 0;
	}
	public boolean isDirigido() {
		boolean dir = true; 
		for (int i = 0; i < numNodos; i++) 
			for (int j = 0; j < numNodos; j++) 
				if (matrizAdy [i] [j] != matrizAdy [j] [i])
					dir = false; 
		return dir;
	}
	public void setMaxNodos(int maxNodos) {this.maxNodos = maxNodos;}
	public void setDirigido(boolean dirigido) {this.dirigido = dirigido;}	
	public int getMaxNodos() {return maxNodos;}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		for(Nodo i : nodos) {
			i.paint(g);
		}
		for(Arista i : aristas) {
			i.paint(g);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {	
		String nombre=null;
		if(e.getButton() == MouseEvent.BUTTON1) {
			
			switch (opcion) {
			case 0:

				if(nodos.size() >= maxNodos) {
					JOptionPane.showMessageDialog(null, "Error, se supera el número de nodos máximo", 
							"Error", JOptionPane.ERROR_MESSAGE);			
				} else {				
					nombre = JOptionPane.showInputDialog("Introduce nombre para el Nodo");
					if(!existeOtroIgual(nombre)) {
						insertaNodo(1);
						nodos.add(new Nodo(e.getX(), e.getY(), nombre, c, color ));			
						repaint();
						c++;
					} else {
						JOptionPane.showMessageDialog(null, "Cambie de Nombre", 
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				break;
			case 1:
				if(nodos.size() >= fi+co) 
					JOptionPane.showMessageDialog(null, "Error, se supera el número de nodos máximo", 
							"Error", JOptionPane.ERROR_MESSAGE);
				 else {	
					 if(nodos.size() == fi) 
					 {	JOptionPane.showMessageDialog(null, "Supera el número de origenes máximo. Se empezaran a llenar los destinos", 
									"Error", JOptionPane.INFORMATION_MESSAGE);	
					 	color=false;
					 }				
					String nombre1 = JOptionPane.showInputDialog("Introduce nombre para el Nodo");
					if(!existeOtroIgual(nombre1)) {
					//	insertaNodo(1);
						nodos.add(new Nodo(e.getX(), e.getY(), nombre1, c,color));			
						repaint();
						c++;
					} else {
						JOptionPane.showMessageDialog(null, "Cambie de Nombre", 
								"Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				break;
			}
			
		}//event node's ends  
		
		if(e.getButton() == MouseEvent.BUTTON3) {
			switch (opcion) {
			case 0:
				for(Nodo i : nodos) {
					System.out.println("indice "+i.getPosition());
					if(new Rectangle(i.getX() - Nodo.getD()/2, i.getY() - Nodo.getD()/2, 
							Nodo.getD(), Nodo.getD()).contains(e.getPoint())) {					
						if(p1 == null) {
							p1 = new Point(i.getX(), i.getY());
							//inicio = i.getNombre();
							inicio = i.getPosition();
						} else {
							p2 = new Point(i.getX(), i.getY());
							int peso = Integer.parseInt(JOptionPane.showInputDialog("Introduce valor para el Arista"));
							Arista a = new Arista(p1.x, p1.y, p2.x, p2.y, peso);
							aristas.add(a);
							insertaArista(inicio, i.getPosition(), a.getPeso());
							repaint();
							p1 = null;
							p2 = null;						
						}
					}
				}
				
				break;
			case 1:
				int pi=0, si=0;
				
				for(Nodo i : nodos) {
					//System.out.println("indice "+i.getPosition());
					if(new Rectangle(i.getX() - Nodo.getD()/2, i.getY() - Nodo.getD()/2, 
							Nodo.getD(), Nodo.getD()).contains(e.getPoint())) {	
						System.out.println("Primer "+i.getPosition());
						if(p1 == null ) {
							p1 = new Point(i.getX(), i.getY());
							inicio = i.getPosition();
							pi=i.getPosition();
							if(fi-1< pi )
							{	JOptionPane.showMessageDialog(null, "Un destino no puede ser origen", 
										"Error", JOptionPane.ERROR_MESSAGE);
							p1 = null; break;
							}
						} else {
							p2 = new Point(i.getX(), i.getY());
							si=i.getPosition();
							if(si< fi )
							{	JOptionPane.showMessageDialog(null, "Un origen no puede ser detino", 
										"Error", JOptionPane.ERROR_MESSAGE);
							p1 = null; p2=null; break;
							}
							int peso = Integer.parseInt(JOptionPane.showInputDialog("Introduce valor para el Arista"));
							Arista a = new Arista(p1.x, p1.y, p2.x, p2.y, peso);
							aristas.add(a);
							System.out.println("Segundo indice "+i.getPosition());
							insertaArista(inicio, i.getPosition()-fi, a.getPeso());
							repaint();
							p1 = null;
							p2 = null;						
						}
					}
				}				
				break;
			}
		}//event aristas's ends		
	}
	private boolean existeOtroIgual(String nombre) {
		boolean flag = false;
		for(Nodo i : nodos) {
			if((nombre.equals(i.getNombre()))){
				flag = true;
			}
				
		}
		return flag;
	}

	
	public String imprimirMatrizAdyString() {
		String m = "";
		for(int i = 0;i < matrizAdy.length; i++) {
			m = m.concat("\n");
			for(int j = 0; j < matrizAdy[0].length; j++) {				
				m = m.concat(String.valueOf(matrizAdy[i][j])).concat("    ");
			}
		}
		return m;
	}
	
	
	public void imprimirMatriz(int am[][]) {
		String[] m= new String[fi];
		for(int i = 0;i < fi; i++) {
			String v ="";
			for(int j = 0; j < co; j++) {	
				v+= am[i][j]+"   ";
			}
			m[i]=v;
		}
		JOptionPane.showMessageDialog (null, m);
   }

	public void mostrarres(int r[][]) {
		int c =r.length;
		String[] m= new String[c];
		int sum=0;
		for(int i = 0;i < c; i++) {
			
			String v ="";
			for(int j = 0; j < c; j++) {	
				if (r[i][j] ==0)
					{
					sum=sum+matrizCostos[i][j];
					for(Nodo x : nodos) {
						if(i==x.getPosition()){
							v+=x.getNombre() +" --> ";
						}
					}
					for(Nodo x : nodos) {
						if(fi+j==x.getPosition()){
							v+=x.getNombre();
						}
					}
				//	JOptionPane.showMessageDialog (null, m,"Solucion", JOptionPane.INFORMATION_MESSAGE);
					}
			if(i+1==c)
				m[i]=v+"\n El total es de "+sum;
			else
				m[i]=v;
		}}
		JOptionPane.showMessageDialog (null, m,"Solucion", JOptionPane.INFORMATION_MESSAGE);
   }
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	
}	