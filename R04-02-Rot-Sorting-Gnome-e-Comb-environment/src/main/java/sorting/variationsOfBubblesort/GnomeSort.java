package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * The implementation of the algorithm must be in-place!
 */
public class GnomeSort<T extends Comparable<T>> extends AbstractSorting<T> {
	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean valid = (leftIndex < rightIndex) && (array != null) && (leftIndex >= 0) && (rightIndex < array.length)
	            && (array.length > 0);
		if (valid) {
			int pivot = leftIndex + 1;
			
			while (pivot < rightIndex) {
				if (array[pivot].compareTo(array[pivot + 1]) > 0) {
					Util.swap(array, pivot, pivot +1);
					if (pivot > 0) {
						pivot--;
					}
				}else {
					pivot++;
				}
			}
		}
		
	}
}
