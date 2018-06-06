package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> aux = head;
		while (aux != null && !aux.isNIL()) {
			size++;
			aux = aux.getNext();
		}
		return size;
		
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> node = head;
		while (node != null && !node.isNIL() && !node.getData().equals(element)) {
			node = node.getNext();
		}
		if (node != null) {
			return node.getData();
		}
		return null;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			SingleLinkedListNode<T> auxHead = head;
			if (head.isNIL()) {
				SingleLinkedListNode<T> newHead = new SingleLinkedListNode<>(element, head);
				head = newHead;
			}else {
				while (!auxHead.getNext().isNIL()) {
					auxHead = auxHead.getNext();
				}
				SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>(element, auxHead.getNext());
				auxHead.setNext(newNode);
				
			}
		}
	}

	@Override
	public void remove(T element) {
		if (getHead().equals(element)) {
			head = head.getNext();
		} else {
			SingleLinkedListNode<T> aux = head;
			SingleLinkedListNode<T> previous = null;
			while (!aux.isNIL() && !aux.getData().equals(element)) {
				previous = aux;
				aux = aux.getNext();
			}
			if(!aux.isNIL()) {
				previous.setNext(aux.getNext());
			}
		}
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[size()];
		SingleLinkedListNode<T> aux = head;
		int i = 0;
		while (aux != null && !aux.isNIL()) {
			result[i++] =aux.getData();
			aux = aux.getNext();
		}
		return result;
		
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
