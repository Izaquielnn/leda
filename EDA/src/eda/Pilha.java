package eda;
import java.util.Scanner;

public class Pilha {
	private int top;
	private String[] pilha;
	private int capacidade;
	
	public Pilha(int capacidade) {
		this.capacidade = capacidade;
		pilha = new String[capacidade];
		top = -1;
	}
	
	public int size() {
		return top + 1;
	}
	
	public boolean isEmpty(){
		return (top < 0);
	}
	
	public boolean isFull() {
		return (size() == capacidade);
	}
	
	public void push(String el) {
		if (isFull()) {
			System.out.println("full");
		}else {
			pilha[++top] = el;
		}
	}
	public String peek() {
		if(isEmpty()) {
			return "empty";
		}
		return pilha[top];
	}
	
	public void pop() {
		if (isEmpty()) {
			System.out.println("empty");
		}else {
			top--;
		}
	}
	
	public String toString() {
		if (isEmpty()) {
			return "empty";
		}
		String saida = pilha[0];
		for (int i = 1; i < size(); i++) {
			saida += " " + pilha[i];
		}
		return saida;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Pilha pilha = new Pilha(sc.nextInt());
		String[] comando = sc.nextLine().split(" ");
		
		while(!comando[0].equals("end")) {
			
			switch(comando[0]) {
			case "print":
				System.out.println(pilha);
				break;
			case "push":
				pilha.push(comando[1]);
				break;
			case "peek":
				System.out.println(pilha.peek());
				break;
			case "pop":
				pilha.pop();
				break;
			}
			
			comando = sc.nextLine().split(" ");
		}

	}

}
