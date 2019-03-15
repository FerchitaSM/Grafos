package Grafo;

public interface Grafo { 
	public void insertaNodo(int n);
	/** Inserta un vértice en el grafo siempre que no se supere el número máximo de nodos permitidos **/ 
	public void eliminarNodo(int v); 
	/** Elimina un vértice del grafo **/ 
	public void insertaArista(int i, int j, int peso); 
	/** Inserta una arista entre los vértices i y j **/ 
	public void eliminarArista(int i, int j); 
	/** Elimina la arista entre los vértices i y j **/ 
	public boolean esVacio(Grafo g); 
	/** Devuelve true si el grafo no contiene ningún vértice **/ 
	public boolean existeArista(int i, int j); 
	/** Devuelve true si existe una arista que una los vértices i y j. **/
	public int gradoIn(int i) ; 
	/** Devuelve el grado de entrada del vértice i **/ 
	public int gradoOut(int i); 
	/** Devuelve el grado de salida del vértice i **/ 
	public int incidencia (int i);
	/** Devuelve la incidencia del vértice i **/ 
	public int tamano();
	/** Devuelve el tamaño (número de aristas) del grafo **/
	public boolean isDirigido() ; 
	/** Devuelve true si el grafo g es dirigido **/ 
	public void setMaxNodos(int maxNodos); 
	/** Asigna el número máximo de nodos o vértices permitidos en el grafo**/ 
	public void setDirigido(boolean dirigido); 
	/** Determina si es un grafo dirigido o no dirigido **/ 
}
