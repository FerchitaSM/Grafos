package Grafo;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AlgoritmoAsignacion {
	
	private int[][] matrizAdyacente;
	private int[][] matrizAlgoritmo;
	private boolean opcion;//maximo = true o minimo = false
	
	private int[][] alfa;
	private int[][] resta1;
	private int[][] gama;
	private int[][] resta2;
	
	private int[][] matrizOptimo;
	
	public AlgoritmoAsignacion(int[][] matrizAdyacente, boolean opcion) {
		super();
		this.matrizAdyacente = matrizAdyacente;
		this.opcion = opcion;
		
	}//end constructor class

	public int[][] getMatrizAdyacente() {return matrizAdyacente;}
	public void setMatrizAdyacente(int[][] matrizAdyacente) {this.matrizAdyacente = matrizAdyacente;}	
	public int[][] getMatrizOptimo() {return matrizOptimo;}
	public void setMatrizOptimo(int[][] matrizOptimo) {this.matrizOptimo = matrizOptimo;}

	public void efectuarAlgoritmo() {	
		 int[][]  m= new int[3][3];
		m [0][0]=1;
		m [0][1]=1;
		m [0][2]=1;
		m [1][0]=1;
		m [1][1]=7;
		m [1][2]=5;
		m [2][0]=1;
		m [2][1]=2;
		m [2][2]=3;
		matrizAdyacente=m;
		mostrar(matrizAdyacente);
		gama = getMinOMax2(matrizAdyacente);
		resta2 = restarMatriz(matrizAdyacente, gama);		
		alfa = getMinOMax(resta2);
		resta1 = restarMatriz(resta2, alfa);
		//mostrar(resta1);
		matrizAlgoritmo = escogerCeros(resta1);
	//	mostrar(matrizAlgoritmo);
		
		
	}
	
	private int[][] getMinOMax(int[][] m){
		int [][] matrizC = new int[m.length][m[0].length];
		for(int i = 0; i < matrizC[0].length; i++) {
			if(opcion) {
				int maximo = getMaximo(m, i, false);
				for(int j = 0 ;j < matrizC.length; j++) {
					matrizC[j][i] = maximo;
				}
			} else {
				int minimo = getMinimo(m, i, false);
				for(int j = 0 ;j < matrizC.length; j++) {
					matrizC[j][i] = minimo;
				}
			}			
		
		
		}
		return matrizC;		
	}
	private int[][] getMinOMax2(int[][] m){
		int [][] matrizC = new int[m.length][m[0].length];
		for(int i = 0; i < matrizC.length; i++) {
			if(opcion) {
				int maximo = getMaximo(m, i, true);
				for(int j = 0 ;j < matrizC[0].length; j++) {
					matrizC[i][j] = maximo;
				}
			} else {
				int minimo = getMinimo(m, i, true);
				for(int j = 0 ;j < matrizC[0].length; j++) {
					matrizC[i][j] = minimo;
				}
			}			
		}
		return matrizC;		
	}
	private int getMaximo(int[][] m, int indice, boolean estado) {
		int maximo;
		if(estado) {
			maximo = m[indice][0];
			for(int i = 0; i < m[0].length; i++)
				maximo = Math.max(m[indice][i], maximo);
		} else {
			maximo = m[0][indice];
			for(int i = 0; i < m.length; i++) 
				maximo = Math.max(m[i][indice], maximo);
		}
		
		return maximo;	
	}
	private int getMinimo(int[][] m, int indice, boolean estado) {
		int minimo;
		if(estado) {
			minimo = m[indice][0];
			for(int i = 0; i < m[0].length; i++) 
				minimo = Math.min(m[indice][i], minimo);
		} else {
			minimo = m[0][indice];
			for(int i = 0; i < m.length; i++) 
				minimo = Math.min(m[i][indice], minimo);
		}
		return minimo;	
	}
	private int[][] restarMatriz(int[][] matrizA, int[][] matrizB) {
		int[][] matrizRes = new int[matrizA.length][matrizA[0].length];
		for(int i=0;i<matrizA.length;i++){
	        for(int j=0;j<matrizA[0].length;j++){
	                matrizRes[i][j]=matrizA[i][j]-matrizB[i][j]; 
	        }
		}
		return matrizRes;
	}
	
	private int[][] escogerCeros(int[][] m) {
		int aux[][];
		int [][] h = new int[m.length][m[0].length];
		boolean flag = true;
		aux = m;

		mostrar(aux);
		JOptionPane.showMessageDialog(null, "itacion joder");
		aux = iterar(aux);
		mostrar(aux);
		//mostrar(aux);
		JOptionPane.showMessageDialog(null, "eliminando ceros");
		eliminaCeros(aux);
		mostrar(aux);
		matrizOptimo = aux;

		
	/*	while(flag);
		{
		 if (contarCeros(h)==h.length);
		 	flag=false;
		}*/
		/*do {
			aux = iterar(aux);
			JOptionPane.showMessageDialog(null, "itacion joder");
			mostrar(aux);
			eliminaCeros(aux);
			mostrar(aux);
			
			/*if(existeCeros(aux)) {
				JOptionPane.showMessageDialog(null, "LLEGUE aQUI "+existeCeros(aux));
				flag = false;
			} /*else {
				JOptionPane.showMessageDialog(null, "LLEGUE aQUI "+existeCeros(aux));
				mostrar(aux);
				aux = restarMatriz(resta1, gama);
				mostrar(aux);
				JOptionPane.showMessageDialog(null, "LLEGUE aQUI ITERACION");
				/*int[][] matriz = {
						{80,  0, 30, 120, 0},
						{80,  0, 30, 120, 0},
						{60, 60,  1,  80, 0},
						{60, 60,  1,  80, 0},
						{ 0, 90,  0,   0, 5}};
				/*int[][] matriz = {
						{80,  0,  0, 120, 0},
						{80,  0,  0, 120, 0},
						{60, 60,  1,  80, 0},
						{60, 60,  1,  80, 0},
						{ 0, 90,  0,   0, 5}};*/
				/*int[][] matriz = {
						{3,  2,  0, 2},
						{0,  5,  1, 1},
						{0,  2,  4, 6},
						{3,  0,  2, 0},};
				//aux = iterar(matriz);								
				
			//}
			
		} while(flag);
		 if (contarCeros(h)==h.length);
		 	flag=false;
		} while(flag);*/
		
		return h;
		
	}
	/*private boolean ajustarCeros(int[][] jj) {
		int[][]aux = jj;
		boolean flag = true;
		for(int i = 0; i < aux.length; i++) {
			for(int j = 0; j < aux[0].length; j++) {					
				if(aux[i][j] == 0) {						
					eliminaCeros(aux);					
					if(existeCeros(aux)) {
						//mostrar(aux);	 
						flag = false;
					} else {								
						aux = restarMatriz(resta2, alfa);
						aux[i][j] = 4;
						mostrar(aux);
					}//fin del if else interno						
				}//fin del if 					
			}//for j	
		}//for i
		return flag;
	} */
	private int[][] iterar(int [][] g) {
		int[][] v = g;
		int[][] lineasOficiales = getLineas(g);
		int [] filas = lineasOficiales[0];
		int [] columnas = lineasOficiales[1];
		//mostrar(lineasOficiales);
		
		int menor = getMenorOficial(filas, columnas, v);		
		
		
		for(int i1 : filas) {
			for(int i2 : columnas) {
				if(i1 != -1 && i2 != -1) {
					v[i1][i2] += menor;				
				}
			}
		}
		
		for(int i = 0; i < v.length; i++) {
			for(int j = 0; j < v[0].length; j++) {
				if(esDiferente(i, filas) && esDiferente(j, columnas)) {
					v[i][j] -= menor;
				}
			}			
		}
		return v;		
	}
	private int getMenorOficial(int[] j1, int[] j2, int[][] g) {
		int menor = 100;
		for(int i = 0; i < g.length; i++) {
			for(int j = 0; j < g[0].length; j++) {
				if(esDiferente(i, j1) && esDiferente(j, j2)) {
					if(g[i][j] < menor)
						menor = g[i][j];
				}
			}			
		}
		return menor;
	}
	private boolean esDiferente(int i, int[] c) {
		boolean flag = true;
		for(int x : c) {
			if(x == i)
				flag = false;
		}
		return flag;		
	}
	private int[][] getLineas(int[][] f) {
		int[] lineasColumnas = new int[f[0].length], lineasFilas= new int[f.length];
		int[][] lineasTod = new int[2][f[0].length];		
		int cf, cc;
				
		//para las filas
		for(int i = 0; i < f.length; i++) {
			cf = 0;
			int vacio = -1;
			for(int j = 0; j < f[0].length; j++) {				
				if(f[i][j] == 0) {
					cf++;					
				}				
			}
			if(cf > 1)
				vacio = i;
			lineasFilas[i] = vacio;
		}
		
		//para las columnas
		for(int i = 0; i < f.length; i++) {
			cc = 0;			
			int vacio = -1;
			for(int j = 0; j < f[0].length; j++) {				
				if(f[j][i] == 0) {
					cc++;
				}
			}
			if(cc > 1)
				vacio = i;
			lineasColumnas[i] = vacio;
		}
		
		for(int i = 0; i < f.length; i++) {			
			lineasTod[0][i] = lineasFilas[i];
			lineasTod[1][i] = lineasColumnas[i];			
		}
		
	//	mostrar(lineasTod);
		lineasTod = minimizarLineas(f, lineasTod);				
		
		
		return lineasTod;		
	}
	private int[][] minimizarLineas(int[][] f, int[][] lineasTod) {
		//int c;
		int  aux = 0;
		ArrayList<Point> pointsCeros = new ArrayList<>();
		//pointsCeros = contarCerosArray(f);
		//para las columnas
		for(int ii = 0; ii < lineasTod.length; ii++) {
			for(int jj = 0; jj < lineasTod[0].length; jj++) {
				//c = 0;				
				pointsCeros.clear();				
				aux = jj;
				lineasTod[ii][jj] = -1;
				//mostrar(lineasTod);
				
				//algoritmo de prueba
				for(int i = 0; i < lineasTod.length; i++) {
					for(int j = 0; j < lineasTod[0].length; j++) {
						if(lineasTod[i][j] != -1) {
							Point puntoBlanco;
							if(i == 0) {
								for(int k = 0; k < lineasTod[0].length; k++) {
									puntoBlanco = new Point(lineasTod[i][j], k);
									if(f[lineasTod[i][j]][k] == 0 && !existePunto(pointsCeros, puntoBlanco)) {
										//c++;
										pointsCeros.add(puntoBlanco);
									}
								}																
							} else {									
								for(int k = 0; k < lineasTod[0].length; k++) {
									puntoBlanco = new Point(k, lineasTod[i][j]);
									if(f[k][lineasTod[i][j]] == 0 && !existePunto(pointsCeros, puntoBlanco)) {
										//c++;
										pointsCeros.add(puntoBlanco);
									}
								}																
							}							
						}												
					}
				}
				
				//JOptionPane.showMessageDialog(null, "pointsCeros = "+(pointsCeros.size()));
				//JOptionPane.showMessageDialog(null, "contarCeros = "+(contarCeros(f)));
				if(pointsCeros.size() != contarCeros(f)) 
					lineasTod[ii][jj] = aux;			
			}
		}		
		return lineasTod;
	}
	private boolean existePunto(ArrayList<Point> pointsCeros, Point p) {
		boolean flag = false;
		for(Point point : pointsCeros) {
			if( point.getX() == p.getX() && point.getY() == p.getY()) {
				flag = true;
			}
		}
		return flag;
	}
	private int contarCeros(int[][] f) {
		int c = 0;
		for(int[] j : f) {
			for(int i : j) {
				if(i == 0)
					c++;
			}
		}
		return c;		
	}

	/*private boolean existeCeros(int[][] x) {
		boolean[] flag = new boolean[x.length];
		boolean flag1 = true;
		int c = 0;
		for(int i = 0; i < x.length; i++) {
			for(int j = 0; j < x[0].length; j++) {
				if(x[i][j] == 0 && c <= 1) {					
					c++;
					flag[i] = true;
				} else {
					flag[i] = false;
					c = 0;
					break;
				}
			}			
		}
		for(boolean i : flag) {
			if(!i)
				flag1 = false;
		}
		return flag1;
	}*/
	private void eliminaCeros(int[][] m) {
		
		mostrar(m);
		SeleccionarCeros x= new SeleccionarCeros(m);
		mostrar(x.escogerceros());
		
/*
		for(int i : array ) {
			for(int j = 0; j < m[0].length; j++) {				
				if(m[i][j] == 0) {	

					for(int c = 0; c < m.length; c++) {
						if(m[i][c] == 0 && c != j) {
							m[i][c] = -1;
						}
					}
					for(int c = 0; c < m.length; c++) {
						if(m[c][j] == 0 && c != i) {
							m[c][j] = -1;
						}
					}				
					
				}//fin del if		 			
			}
		}
		
		for(int i = 0; i < m.length; i++) {			
			for(int j = 0; j < m[0].length; j++) {				
				if(m[i][j] == 0) {		
					for(int c = 0; c < m.length; c++) {
						if(m[i][c] == 0 && c != j) {
							m[i][c] = -1;
						}
					}
					for(int c = 0; c < m.length; c++) {
						if(m[c][j] == 0 && c != i) {
							m[c][j] = -1;
						}
					}				
					
				}//fin del if		 			
			}									
		}*/
	}
	
	private int[][] borrarceroscolumna(int[][] m, int i) {
		int fila[][] = null;
		for (int j=0; j <= m.length; j++) {
			if (m[i][j] ==0 )
			{	i=j;
				break;
			}
		}


		for (int j=0; j < m.length; j++) {
		    if (m[j][i] ==0 )
		    {
		    	m[j][i]=-1;
		    	mostrar(m);
		    }
		}
		return fila;
	}

	private boolean validador(int m[][]) {
		boolean flag = true;
		boolean []f=new boolean [m.length];
		int k=0;
		for (int i=0; i < m.length; i++) {
			k =0;
			for (int j=0; j < m.length; j++) {
				
				if(m[i][j] == 0) {
					k++;
				}
			}
			if(k <= 1)
				f[i] = true;
			else
				f[i] = false;
		}
		for(boolean t : f) {
			if(t == false)
				flag = false;
		}
		return flag;
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
	
	private int filadeceros(int[][] x) {
		int fila=0;
		for (int i=0; i < x.length; i++) {
		    if (x[i][0] ==0 )
		    	return i;  
		}
		return fila;
	}

	private int columnadeceros(int[][] x) {
		int col=0;
		for (int i=0; i < x[0].length; i++) {
		    if (x[0][i] ==0 )
		    	return i;  
		}
		return col;
	}
}
		
	
