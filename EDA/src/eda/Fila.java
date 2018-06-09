import java.util.Scanner;

class Fila {
	
	private String[] array;
	private int tail;

	public Fila(int size) {

		this.array = new String[size];
		this.tail = -1;
	}

	public boolean isEmpty(){
		return this.tail == - 1;
	}
	
	public boolean isFull(){
		return this.size() == this.array.length;	
	}

	public int size(){
		return this.tail + 1;
	}

	public void add(String n) {
		if(isFull()) System.out.println("full");
		else this.array[++tail] = n;
	}

	public void element(){
		if (isEmpty()) System.out.println("empty");
		else System.out.println(array[tail]);
	}

	public void remove(){
		if (isEmpty()) System.out.println("empty");
		else {
			shift();
			tail--;
		}	
	}

	private void shift(){
		for (int i = 1; i < size(); i++) {
			array[i -1] = array[i];
		}
	}

	public void print(){
		if (isEmpty()) System.out.println("empty");
		else if (isFull()) System.out.println("full");
		else{
			String out = array[0];
			for (int i = 1; i < size(); i++){
				out += " " + array[i];
			}
			System.out.println(out);
		}
	}

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		Fila fila = new Fila(sc.nextInt());
		String[] comando = sc.nextLine().split(" ");
		
		while (!comando[0].equals("end")){
			switch (comando[0]){
			case "print":
				fila.print();
				break;
			case "add":
				fila.add(comando[1]);
				break;
			case "element":
				fila.element();
				break;
			case "remove":
				fila.remove();
				break;
			}
			comando = sc.nextLine().split(" ");

		}
	}
}
