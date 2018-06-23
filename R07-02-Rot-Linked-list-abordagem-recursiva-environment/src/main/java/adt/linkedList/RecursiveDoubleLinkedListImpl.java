package adt.linkedList;


public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {
		super();
	}

	public RecursiveDoubleLinkedListImpl(T data,
			RecursiveDoubleLinkedListImpl<T> next,
			RecursiveDoubleLinkedListImpl<T> previous) {
		super(data, next);
		this.previous = previous;
	}


	@Override
	public int size() {
		if (this.isEmpty()) return 0;
		return this.sizeBack() + ((RecursiveDoubleLinkedListImpl<T>) this.getNext()).sizeF(); 
	}
	
	public int sizeBack() {
		if (this.isEmpty()) return 0;
		return 1 + this.getPrevious().sizeBack();
	}
	
	public int sizeF() {
		if (this.isEmpty()) return 0;
		return 1 + ((RecursiveDoubleLinkedListImpl<T>) this.getNext()).sizeF();
	}
	
	
	@Override
	public void insert(T element) {
		if (this.isEmpty()) {
			this.setData(element);
			this.setNext(new RecursiveDoubleLinkedListImpl<>(null, null, this));
			this.setPrevious(new RecursiveDoubleLinkedListImpl<>(null, this, null));
		} else {
			((RecursiveDoubleLinkedListImpl<T>)this.getNext()).insertRecursive(element);
		}
	}
	
	private void insertRecursive(T element) {
		if (this.isEmpty()) {
			this.setData(element);
			this.setNext(new RecursiveDoubleLinkedListImpl<>(null, null, this));
		} else {
			((RecursiveDoubleLinkedListImpl<T>) this.getNext()).insertRecursive(element);
		}
		
	}

	@Override
	public void insertFirst(T element) {
		if (this.isEmpty()) {
			this.setData(element);
			this.setPrevious(new RecursiveDoubleLinkedListImpl<>(null, this, null));
			this.setNext(new RecursiveDoubleLinkedListImpl<>(null, null, this));
		} else {
			this.getPrevious().insertFirstRescursive(element);
		}
	}
	
	private void insertFirstRescursive(T element) {
		if (this.isEmpty()) {
			this.setData(element);
			this.setPrevious(new RecursiveDoubleLinkedListImpl<>(null, this, null));
		} else {
			this.getPrevious().insertFirstRescursive(element);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		
		T[] out = (T[]) new Object[this.size()];
		this.toArray(out);
		return out;
	}
	
	
	
	private void toArray(T[] out) {
		if (!this.isEmpty()) {
			if (this.getPrevious().isEmpty()) {
				super.toArray(0, out);
			} else {
				this.getPrevious().toArray(out);
			}
		}
		
	}


	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {
			if (this.getPrevious().isEmpty()) {
				if (this.getNext().isEmpty()) {
					this.setData(null);
					this.setPrevious(new RecursiveDoubleLinkedListImpl<T>(null, this, null));
				}else {
					this.setData(this.getNext().getData());
					this.setNext(this.getNext().getNext());
					((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);
				}
			} else {
				this.getPrevious().removeFirst();
			}
		}
	}


	@Override
	public void removeLast() {
		if (!this.isEmpty()) {
			if (this.getNext().isEmpty()) {
				if (this.getPrevious().isEmpty()) {
					this.setData(null);
					this.setNext(new RecursiveDoubleLinkedListImpl<T>(null, null, this));
				} else {
					this.setData(this.getPrevious().getData());
					this.setPrevious(this.getPrevious().getPrevious());
					this.getPrevious().setNext(this);
				}
			} else {
				((RecursiveDoubleLinkedListImpl<T>)this.getNext()).removeLast();
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
