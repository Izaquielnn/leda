package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	public RecursiveSingleLinkedListImpl(T data,
			RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public int size() {
		if (this.isEmpty()) return 0;
		return 1 + this.getNext().size();
	}

	@Override
	public T search(T element) {
		T out = null;
		if (!this.isEmpty()) {
			if (this.getData().equals(element)) {
				out = this.getData();
			} else {
			return this.getNext().search(element);
			}
		}
		return out;
	}

	@Override
	public void insert(T element) {
		if (this.isEmpty()) {
			this.setData(element);
			this.setNext(new RecursiveSingleLinkedListImpl<>());
		} else {
			this.getNext().insert(element);
		}
	}
	
	@Override
	public void remove(T element) {
		if (!this.isEmpty()) {
			if (this.getData().equals(element)) {
				this.setData(this.getNext().getData());
				this.setNext(this.getNext().getNext());
			} else {
				this.getNext().remove(element);
			}
		}
		
	}
	
	

	@Override
	public T[] toArray() {
		T[] out = (T[]) new Object[this.size()];
		this.toArray(0, out);
		return out;
	}
	
	protected void toArray(int index, T[] array) {
		if (!this.isEmpty()) {
			array[index] = this.getData();
			this.getNext().toArray( index + 1, array);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
