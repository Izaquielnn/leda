package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		if (isEmpty()) {
			return null;
		}
		return array[top];
	}

	public int size() {
		return (top + 1);
	}
	
	@Override
	public boolean isEmpty() {
		return (top < 0);
	}

	@Override
	public boolean isFull() {
		return (size() == array.length);
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException();
		}
		array[++top] = element;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		T element = array[top];
		array[top--] = null;
		return element;
	}

}
