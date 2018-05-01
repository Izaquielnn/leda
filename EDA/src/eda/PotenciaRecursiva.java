package eda;

import java.util.Scanner;

class PotenciaRecursiva {
	static int potencia(int i, int j) {
		if (j == 0) return 1;
		return i * potencia(i, j -1 );
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		int j = sc.nextInt();
		System.out.println(PotenciaRecursiva.potencia(i, j));
	}
}