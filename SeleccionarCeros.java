package Grafo;

import javax.swing.JOptionPane;

public class SeleccionarCeros {

	
	private int[][] x;
	private int[][] aux;
	public SeleccionarCeros(int[][] x) {
		super();
		this.x = x;
		
		
	}//end constructor class
	public int [][]  escogerceros() {
		int [][] rr = new int [x.length][x.length];
		 int[][]  m= new int[3][3];
		m [0][0]=1;
		m [0][1]=0;
		m [0][2]=0;
		m [1][0]=0;
		m [1][1]=4;
		m [1][2]=0;
		m [2][0]=0;
		m [2][1]=0;
		m [2][2]=6;
		rr=m;
		JOptionPane.showMessageDialog(null, "funcion");
		  mostrar(rr);
		boolean todavia=true;
			while (todavia)  {
			for (int i=0; i < x.length; i++) {
				  for (int j=0; j < x.length; j++) {
					  if (rr[i][j] ==0)
					  { 	
						  if(masceroscolumna(rr,j,i))
						  	rr[i][j] =111;
						  else
						  {
							  rr=llenar(rr,i,j);
							  mostrar(rr);
						  }
					  }
				 
				}
				  mostrar(rr);

			}
			if(todolleno(rr))
				todavia=false;
		}
			return rr;
	}
	
	
	
	private boolean masceroscolumna(int[][] x, int j, int a) {

		for (int i=0; i < x.length; i++) {
			if(i!=a)
			  {if (x[i][j] ==0)
			  { 
				  if(mascerosfila(x,i,j))
					  return false; 
				  else
					  return true;  
			  }
			  }
		}
		return false;
	}
	
	private boolean mascerosfila(int[][] x, int i, int b) {

		for (int j=0; j < x.length; j++) {
			if(j!=b)
			  {
			  if (x[i][j] ==0)
				  return true;
			  }
		}
		return false;
	}
	
	
	
	private boolean todolleno(int[][] x) {
		int k=0;
		int num=x.length;
		for (int i=0; i < x.length; i++) {
			  for (int j=0; j < x.length; j++) {
				  if (x[i][j] ==1)
					  k++;
			  }}
		if (num <= k)
			return true;
		else
			return false;
	}


	private int[][] llenar(int[][] x, int a, int b) {
		x[a][b]=-1;
		for (int i=0; i < x.length; i++) {
			  if (x[i][b] ==0)
				  x[i][b] =111;			  
		}
		for (int i=0; i < x.length; i++) {
			  if (x[a][i] ==0)
				  x[a][i] =111;
		}
		return x;	
	}	
	
	
	
	public void mostrar(int matrizAdy[][]) {
		int c =matrizAdy.length;
		String[] m= new String[c];
		for(int i = 0;i < c; i++) {
			String v ="";
			for(int j = 0; j < matrizAdy[0].length; j++) {	
				v+= matrizAdy[i][j]+"   ";
			}
			m[i]=v;
		}
		JOptionPane.showMessageDialog (null, m);
	}
}	