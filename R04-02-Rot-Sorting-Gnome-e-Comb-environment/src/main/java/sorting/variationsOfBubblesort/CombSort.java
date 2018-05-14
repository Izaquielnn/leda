package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * The combsort algoritm.
 */
public class CombSort<T extends Comparable<T>> extends AbstractSorting<T> {
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean valid = (leftIndex < rightIndex) && (array != null) && (leftIndex >= 0) && (rightIndex < array.length)
	            && (array.length > 0);
		if (valid) {
			final double FATOR = 1.25;
			int gap = (int) ((	rightIndex + 1	)/ FATOR);
			int i = 0;
			
			while (gap > 0 && i < rightIndex) {
				i = 0;
				while ((i + gap) <= rightIndex) {
					if (array[i].compareTo(array[i + gap]) > 0){
						Util.swap(array, i, i + gap);
					}
					i++;
				}
				gap = (int) (gap / FATOR);
			}
		}			
	}
}
