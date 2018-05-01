package eda;

import java.util.Scanner;

class DoisSomam {
	
	public String doisSoman(int[] array, int soma) {
		for(int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if((array[i] + array[j]) == soma) {
					return array[i] + " " + array[j];
				}
			}
		}
		
		return "-1";
	}
	
	public static void main(String[] args) {
		DoisSomam d = new DoisSomam();
		Scanner sc = new Scanner(System.in);
		
		String[] lista = sc.nextLine().split(" ");
		int soma = sc.nextInt();
		
		int[] v = new int[lista.length];
		for(int i = 0; i < lista.length; i++) {
			v[i] = Integer.parseInt(lista[i]);
		}
		
		System.out.println(d.doisSoman(v, soma));
	}

}
