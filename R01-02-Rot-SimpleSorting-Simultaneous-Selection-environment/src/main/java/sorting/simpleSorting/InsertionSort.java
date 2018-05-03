package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int j;
		T aux;
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			aux = array[i];
			j = i;
			while ((j > 0) && (array[j-1].compareTo(aux) > 1)) {
				array[j] = array[j-1];
				j--;
			}
			if(array[j].compareTo(aux) != 0) {
				array[j] = aux;
			}
		}
	}
}
