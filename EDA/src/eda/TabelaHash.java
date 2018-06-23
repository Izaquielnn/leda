import java.util.*;

class TabelaHash{

	private Pair[] table;
	private int elements;
	private int size;
	
	public TabelaHash(int size){
		if (size <= 0){
			this.size = 0;
		} else {
			this.size = size;
		}
		this.elements = 0;
		table = new Pair[size];
	}

	public boolean isFull(){
		return this.elements == this.size;
	}

	public boolean isEmpty(){
		return elements == 0;
	}

	public void put(int key, String value){
		
			int prob = 0;
			int index = Hash(key, prob);
			int originalIndex = index;
			boolean atualizouValor = false;
			while (table[index] != null && !table[index].equals(new Pair(-1, "DELETED"))) {
				
				if ( table[index].getKey() == key){
					table[index] = new Pair(key, value);
					atualizouValor = true;
					break;
				}
				index = Hash(key, ++prob);
				if (index == originalIndex){
					break;
				} 
				
			}

			if (!atualizouValor && !isFull()){
				table[index] = new Pair(key, value);
				elements += 1;
			}


		printTable();

	}

	public void remove(int key){
		if (!isEmpty()){
			if (this.size == 1){
				if (table[0] != null){
					if (table[0].getKey() == key){
						table[0] = new Pair(-1, "DELETED");
						this.elements -= 1;
					}
				}
			} else {

			int prob = 0;
			int index = Hash(key, prob);
			while (table[index] != null && table[index].getKey() != key) {
					index = Hash(key, ++prob);
			}

			if (table[index] != null){
				if (table[index].getKey() == key){
					table[index] = new Pair(-1, "DELETED");
					this.elements -= 1;
				}
			}
		}
		
	}
		printTable();

	}

	private void printTable(){

		if (this.size > 0){

		String out = "[";
		if (table[0] != null){
			if (table[0].equals(new Pair(-1, "DELETED"))){
				out += "null";
			} else {
				out += table[0];
			}
		} else {
			out += table[0];
		}

		for (int i = 1; i < size; i++){
			if (table[i] != null) {
				if (table[i].equals(new Pair(-1, "DELETED"))){
					out += ", null";
				} else {
					out += ", " + table[i];
				}
			} else {
				out += ", " + table[i];
			}
		}
		out += "]";
		System.out.println(out);
	} else {
		System.out.println("[]");
	}

	}

	public void keys(){
		ArrayList<Integer> keys = new ArrayList<>();
		for (int i = 0; i < size; i++){
			if (table[i] != null){
				if (!table[i].equals(new Pair(-1, "DELETED"))){
					keys.add(table[i].getKey());
					
				}
			}
		}

		Collections.sort(keys);
		System.out.println(keys);
	}

	public void values(){
		ArrayList<String> values = new ArrayList<>();
		for (int i = 0; i < size; i++){
			if (table[i] != null){
				if (!table[i].equals(new Pair(-1, "DELETED"))){
					values.add(table[i].getValue());
					
				}
			}
		}

		Collections.sort(values);
		System.out.println(values);
	}

	private int Hash(int key, int prob){
		return (key + prob) % this.size;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TabelaHash table = new TabelaHash(sc.nextInt());
		String[] comando = sc.nextLine().split(" ");
		
		while(!comando[0].equals("end")) {
			
			switch(comando[0]) {
			case "put":
				table.put(Integer.parseInt(comando[1]), comando[2]);
				break;
			case "remove":
				table.remove(Integer.parseInt(comando[1]));
				break;
			case "keys":
				table.keys();
				break;
			case "values":
				table.values();
				break;
			}
			
			comando = sc.nextLine().split(" ");
		}

	}

}


class Pair{

	private int key;
	private String value;

	public Pair(int key, String value){
		this.key = key;
		this.value = value;
	}

	public int getKey(){
		return this.key;
	}

	public String getValue(){
		return this.value;
	}

	@Override
	public String toString(){
		return "<" + this.key + ", " + this.value + ">";
	}

	@Override
	public boolean equals(Object obj){
		if (obj != null && obj instanceof Pair){
			Pair element = (Pair) obj;
			if (element.getValue().equals(this.getValue()) && 
				element.getKey() == this.getKey() ){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}