import java.util.Scanner;
class Hanoi {
	public void move(int n, String origem, String aux, String destino){
		if (n >= 1){
			move(n - 1, origem, destino, aux);
			//desempilha da origem e empilha no destino
			System.out.printf("Move o disco %d da haste %s para haste %s\n", 
								n, origem, destino); 
			move(n - 1, aux, origem, destino);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Hanoi hanoi = new Hanoi();
		int n = sc.nextInt();
		hanoi.move(n, "A", "B", "C");
	}
}