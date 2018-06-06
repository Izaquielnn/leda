package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		super();
		last = new DoubleLinkedListNode<>();
		head = new DoubleLinkedListNode<>();
	}
	
	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<>(element, (DoubleLinkedListNode<T>) head, null);
		((DoubleLinkedListNode<T>) head).setPrevious(newHead);
		if(head.isNIL()) {
			last = newHead;
		}
		head = newHead;
	}
	
	@Override
	public void insert(T element) {
		DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<>(element, null, last);
		last.setNext(newLast);
		if (last.isNIL()) {
			head = newLast;
		}
		last = newLast;
		
	}

	@Override
	public void removeFirst() {
		if (head != null) {
			head = head.getNext();
			if (head.isNIL()) {
				last = (DoubleLinkedListNode<T>) head;
			}
			((DoubleLinkedListNode<T>) head).setPrevious(null);
		}
	}

	@Override
	public void removeLast() {
		if (!last.isNIL()) {
			last = last.getPrevious();
			if (last.isNIL()) {
				head = last;
			}
			last.setNext(null);
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}
	

}
