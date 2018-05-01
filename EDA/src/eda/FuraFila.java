package eda;

import java.util.Arrays;
import java.util.Scanner;

class FuraFila {
	
	public void furaFila(int[] v, int index) {
		int aux = index;
		for (int i = index; i < v.length; i++) {
			for (int j = i; j > i - aux; j--) {
				troca(v, j, j - 1);
			}
			System.out.println(Arrays.toString(v));
		}
		
	}
	
	private void troca(int[] v, int i, int j) {
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
	}

	public static void main(String[] args) {
		FuraFila f = new FuraFila();
		Scanner sc = new Scanner(System.in);
		
		String[] fila = sc.nextLine().split(" ");
		int index = sc.nextInt();
		
		int[] v = new int[fila.length];
		for(int i = 0; i < fila.length; i++) {
			v[i] = Integer.parseInt(fila[i]);
		}
		
		f.furaFila(v, index);
	}

}
