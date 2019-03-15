package Grafo;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TestGrafo {

	public static void main(String[] args) {
		
		JFrame ventana = new JFrame("Grafo");
		GrafoMA grafo1;
		
		String []menu= {"Grafos Normales","Algoritmo de Asignacion"};
		String valor = (String)JOptionPane.showInputDialog(null, "seleccionar opcion", 
				"opciones",JOptionPane.DEFAULT_OPTION, null, menu,menu[0]);	
		switch (valor) {
		case "Grafos Normales":
			int maxNodos = Integer.parseInt(JOptionPane.showInputDialog(null, "Introducir el maximo de Nodos"));
			int respuesta = JOptionPane.showConfirmDialog(null, "Sera Dirigido?", "Grafos",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			boolean isDirigido = (respuesta == 0)?true:false;
			
			grafo1 = new GrafoMA(maxNodos, isDirigido, 0);
			ventana.add(grafo1);
			
			break;
		case "Algoritmo de Asignacion":
			int filas = Integer.parseInt(JOptionPane.showInputDialog(null, "Introducir el maximo de nodos de origen"));
			int columnas = Integer.parseInt(JOptionPane.showInputDialog(null, "Introducir el maximo de nodos de destino"));

			grafo1 = new GrafoMA(filas,columnas, 1);
			ventana.add(grafo1);
			
			break;
		}
				
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(800, 800);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);

	}

}
