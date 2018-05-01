package eda;

import java.util.Scanner;

public class ElementoSobrando {
	
	public int elementoSobrando(int[] vecOriginal, int[] vecElementoSobrando) {
		boolean possui;
		for (int i = 0; i < vecElementoSobrando.length; i++) {
			possui = false;
			for (int j = 0; j < vecOriginal.length; j++) {
				if (vecElementoSobrando[i] == vecOriginal[j]) {
					possui = true;
				}
			}
			if (!possui) return vecElementoSobrando[i];
		}
		return -1;
	}
	

	public static void main(String[] args) {
		ElementoSobrando e = new ElementoSobrando();
		Scanner sc = new Scanner(System.in);
		
		String[] array1 = sc.nextLine().split(" ");
		int[]  arrayOriginal = new int[array1.length];
		for(int i = 0; i < array1.length; i++) {
			arrayOriginal[i] = Integer.parseInt(array1[i]);
		}
		
		String[] array2 = sc.nextLine().split(" ");
		int[]  arrayElemenSobrando = new int[array2.length];
		for(int i = 0; i < array2.length; i++) {
			arrayElemenSobrando[i] = Integer.parseInt(array2[i]);
		}
		
		int elementoSobrando = e.elementoSobrando(arrayOriginal, arrayElemenSobrando);
		System.out.println(elementoSobrando);
		
	}
}
