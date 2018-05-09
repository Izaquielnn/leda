package eda;

import java.util.Arrays;
import java.util.Scanner;

class MoveImpostor {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] seq = sc.nextLine().split(" ");
		int[]  array = new int[seq.length];
		for(int i = 0; i < seq.length; i++) {
			array[i] = Integer.parseInt(seq[i]);
		}
		
		moveImpostor(array);
		System.out.println(Arrays.toString(array));
			
		
	}
	
	public static void moveImpostor(int[] array) {
		if(array != null && array.length > 0) {	
			
			boolean achouImpostor = false;	
			int index_impostor = 0;
			while (index_impostor < array.length && !achouImpostor) {
				index_impostor++;
				if (array[index_impostor - 1] > array[index_impostor]) {
					achouImpostor = true;
				}
			}
			
			if(achouImpostor) {
				moveOrdenado(array, index_impostor);
			}
		}		
	}
	
	private static void moveOrdenado(int[] array, int i) {
		while (i > 0 && array[i] < array[i - 1]) {
			int aux = array[i];
			array[i] = array[i - 1];
			array[i - 1] = aux;
			i--;
		}
	}

}
