
package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;
	private int tail;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
		tail = -1;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		
		try {
			transport(stack2, stack1);
			stack1.push(element);
			tail++;
			transport(stack1, stack2);
			
		} catch (StackOverflowException e) {
			throw new QueueOverflowException();
		} catch (StackUnderflowException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void transport(Stack orig, Stack dest) throws StackOverflowException, StackUnderflowException {
		for (int i = 0; i <= tail; i++) {
			dest.push(orig.pop());
		}
	}
	

	
	@Override
	public T dequeue() throws QueueUnderflowException {
		try {
			return stack2.pop();
		} catch (StackUnderflowException e) {
			throw new QueueUnderflowException();
		}
	}

	@Override
	public T head() {
		return stack2.top();
	}

	@Override
	public boolean isEmpty() {
		return stack2.isEmpty();
	}

	@Override
	public boolean isFull() {
		return stack2.isFull();
	}

}
