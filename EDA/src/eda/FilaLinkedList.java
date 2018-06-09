
import java.util.Scanner;

class FilaLinkedList {
	
	private Node list;
	
	public FilaLinkedList() {
		list = new Node();
	}
	
	public void add(String element) {
		list.add(element);
	}
	
	public String element() {
		return list.getData();
	}
	
	public void remove() {
		list.removeFirst();
	}
	
	public int search(String element) {
		return list.search(element);
	}
	
	public void print() {
		System.out.println(list.toString());
	}

	
	public static void main(String[] args) {
		FilaLinkedList fila = new FilaLinkedList();
		
		Scanner sc = new Scanner(System.in);
		String[] comando = sc.nextLine().split(" ");
		
		while(!comando[0].equals("end")) {
			
			switch(comando[0]) {
			case "print":
				fila.print();;
				break;
			case "add":
				fila.add(comando[1]);;
				break;
			case "element":
				System.out.println(fila.element());
				break;
			case "remove":
				fila.remove();
				break;
			case "search":
				System.out.println(fila.search(comando[1]));
			}
			
			comando = sc.nextLine().split(" ");
		}
		

	}

}

class Node{
	private String data;
	private Node next;
	private Node previous;
	
	public Node() {
		
	}
	
	public Node(String data, Node next, Node previous) {
		this.data = data;
		this.next = next;
		this.previous = previous;
	}
	
	public boolean isEmpty() {
		return this.data == null;
	}
	
	public void add(String element) {
		if (isEmpty()) {
			this.data = element;
			this.next = new Node(null, null, this);
			this.previous = new Node(null, this, null);
		} else {
			this.next.insert(element);
		}

	}
	
	private void insert(String element) {
		if (isEmpty()) {
			this.data = element;
			this.next = new Node(null, null, this);
		} else {
			this.next.insert(element);
		}
	}
	
	public void removeFirst() {
		if (!isEmpty()) {
			if (this.previous.isEmpty()) {
				if (this.next.isEmpty()) {
					this.data = null;
					this.previous = new Node(null, this, null);
				} else {
					this.data = this.next.data;
					this.next = this.next.next;
					this.next.previous = this;
				}
			} else {
				this.previous.removeFirst();
			}
		} else {
			System.out.println("empty");
		}
	}
	
	public int search(String element) {
		int index = -1;
		if (!isEmpty()) {
			if (this.previous.isEmpty()) {
				index =  search(0, element);
			} else {
				this.previous.search(element);
			}
		} 
		return index;
	}
	
	private int search(int c, String element) {
		if (isEmpty()){
			return -1;
		} 
		if (this.data.equals(element)) return c;
		return this.next.search(c + 1, element);
		
	}
	
	@Override
	public String toString() {
		if (!isEmpty()) {
			if (this.previous.isEmpty()) {
				return this.data + this.next.toStringRecursive();
			} else {
				this.previous.toString();
			}
		}
		return "empty";
	}
	
	
	private String toStringRecursive() {
		if (isEmpty()) return "";
		return " " + this.data + this.next.toStringRecursive();
	}
	
	public String getData() {
		if (!isEmpty) return this.data;
		else return "empty";
	}
	
	
}
