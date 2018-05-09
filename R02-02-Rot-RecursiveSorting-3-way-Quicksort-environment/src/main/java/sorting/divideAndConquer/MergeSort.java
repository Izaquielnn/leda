package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		boolean valid = (leftIndex < rightIndex)    &&
						 (array != null)            &&
						 (leftIndex >= 0)            &&
						 (rightIndex < array.length) &&
						 (array.length > 0);
		
		if ( valid ) {
			int mid = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, mid);
			sort(array, mid + 1, rightIndex);
			merge(array, leftIndex, mid, rightIndex);
		}
	}

	private void merge(T[] array, int leftIndex, int mid, int rightIndex) {
		T[] aux = (T[]) new Comparable[array.length];  
		for (int i = leftIndex; i <= rightIndex; i++) {
			aux[i] = array[i];
		}
		
		int i = leftIndex;
		int j = mid + 1;
		int k = leftIndex;
		
		while (i <= mid && j <= rightIndex) {
			if (aux[i].compareTo(aux[j]) < 0) {
				array[k] = aux[i];
				i += 1;
			}else {
				array[k] = aux[j];
				j += 1;
			}
			
			k += 1;
		}
		
		while (i <= mid) {
			array[k] = aux[i];
			i += 1;
			k += 1;
		}
		
		while (j <= rightIndex) {
			array[k] = aux[j];
			j += 1;
			k += 1;
		}
		
	}
}
