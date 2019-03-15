package Grafo;

public class TestAlgoritmo {

	public static void main(String[] args) {
		int[][] matriz = {
				{1, 2, 7, 3, 0},
				{3, 4, 1, 0, 2},
				{2, 3, 6, 0, 0},
				{0, 6, 1, 1, 0},
				{2, 0, 0, 4, 5}
		};
		/*int[][] matriz = {
				{80,  0, 30, 120, 0},
				{80,  0, 30, 120, 0},
				{60, 60,  1,  80, 0},
				{60, 60,  1,  80, 0},
				{ 0, 90,  0,   0, 5}};
		/**/
		/*int[][] matriz = {
				{54, 54, 51, 53},
				{51, 57, 52, 52},
				{50, 53, 54, 56},
				{56, 54, 55, 53}
		};
		/*int[][] matriz = {
				{0, 1, 6, 3, 0},
				{2, 3, 0, 0, 2},
				{1, 2, 5, 0, 0},
				{0, 6, 1, 1, 0},
				{2, 0, 0, 4, 5}
		};
		/*int[][] matriz = {
				{10, 10, 10 },
				{10, 30, 40 },
				{10, 30, 20 }
		};	*/
		
		AlgoritmoAsignacion m = new AlgoritmoAsignacion(matriz, false);
		m.efectuarAlgoritmo();

	}

}
