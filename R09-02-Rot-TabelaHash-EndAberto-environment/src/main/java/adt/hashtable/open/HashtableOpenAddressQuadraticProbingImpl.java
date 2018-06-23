package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (this.isFull()) {
			throw new HashtableOverflowException();
		}
		int prob = 0;
		int index = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, prob);
		int origIndex = index;
		
		while (table[index] != null && !table[index].equals(new DELETED()) && index != origIndex ) {
			index = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, ++prob);
			this.COLLISIONS++;
		}
		table[index] = element;
		this.elements++;
	}

	@Override
	public void remove(T element) {
		if (!this.isEmpty()) {
			int prob = 0;
			int index = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, prob);
			int origIndex = index;
			
			while (table[index] != null  && !table[index].equals(element) && index != origIndex) {
				index = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, ++prob);
			}
			
			if (table[index] != null && table[index].equals(element)) {
				table[index] = new DELETED();
				this.elements--;
			}
		}
	}

	@Override
	public T search(T element) {
		T out = null;
		int prob = 0;
		int index = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, prob);
		int origIndex = index;
		while (table[index] != null  && !table[index].equals(element) && index != origIndex) {
			index = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, ++prob);
		}
		if (table[index] != null && table[index].equals(element)) {
			out = (T) table[index];
		}
		return out;
	}

	@Override
	public int indexOf(T element) {
		int out = -1;
		int prob = 0;
		int index = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, prob);
		
		while (table[index] != null && !table[index].equals(element) ) {
			index = ((HashFunctionQuadraticProbing<T>) hashFunction).hash(element, ++prob);
		}
		if (table[index] != null && table[index].equals(element)) {
			out = index;
		}
		return out;
	}
	
}
