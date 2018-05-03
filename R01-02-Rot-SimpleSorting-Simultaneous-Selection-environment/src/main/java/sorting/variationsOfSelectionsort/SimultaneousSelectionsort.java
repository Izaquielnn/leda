package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This algorithm applies two selection sorts simultaneously. In a same
 * iteration, a selection sort pushes the greatest elements to the right and
 * another selection sort pushes the smallest elements to the left. At the end
 * of the first iteration, the smallest element is in the first position (index
 * 0) and the greatest element is the last position (index N-1). The next
 * iteration does the same from index 1 to index N-2. And so on. The execution
 * continues until the array is completely ordered.
 */
public class SimultaneousSelectionsort<T extends Comparable<T>> extends
		AbstractSorting<T> {
	
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int posMenor, posMaior;
		for (int i = leftIndex; i <= (rightIndex + leftIndex) / 2; i++) {
			posMenor = i;
			posMaior = i;
			for (int j = i + 1; j <= rightIndex; j++) {
				if (array[j].compareTo(array[posMenor]) < 0) {
					posMenor = j;
				}
				if (array[j].compareTo(array[posMenor]) > 0) {
					posMaior = j;
				}
			}
			if (array[i].compareTo(array[posMenor]) != 0) {
				Util.swap(array, i, posMenor);
			}
			if (array[rightIndex -  i].compareTo(array[posMaior]) != 0) {
				Util.swap(array, rightIndex - i, posMaior);
			}
		}
	}
}
