package eda;

import java.util.Scanner;

class ImprimeArrayCircular {
	
	private String arrayCircular(int[] array, int n) {
		String saida = array[0] + "";
		int j;
		
		for (int i = 1; i < n; i++) {
			j = i;
			while (j >= array.length) {
				j -= array.length;
			}
			saida += " " + array[j];
		}
		
		return saida;
	}
	
	public static void main(String[] args) {
		ImprimeArrayCircular imp = new ImprimeArrayCircular();
		Scanner sc = new Scanner(System.in);
		
		String[] lista = sc.nextLine().split(" ");
		int n = sc.nextInt();
		
		int[] v = new int[lista.length];
		for(int i = 0; i < lista.length; i++) {
			v[i] = Integer.parseInt(lista[i]);
		}
		
		System.out.println(imp.arrayCircular(v, n));
		
	}

}
