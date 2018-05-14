package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

   @Override
   public void sort(Integer[] array, int leftIndex, int rightIndex) {
      boolean valid = (leftIndex < rightIndex) && (array != null) && (leftIndex >= 0) && (rightIndex < array.length)
            && (array.length > 0);

      if (valid) {

         int maior = array[leftIndex];
         boolean soPositivos = true;
         for (int i = leftIndex + 1; i <= rightIndex; i++) {
            if (array[i] > maior) {
               maior = array[i];
            }
            if (array[i] <= 0) {
               soPositivos = false;
            }
         }

         if (soPositivos) {

            int[] c = new int[maior];
            for (int i = leftIndex; i <= rightIndex; i++) {
               c[array[i] - 1] += 1;
            }

            for (int i = 1; i < maior; i++) {
               c[i] += c[i - 1];
            }

            int[] b = new int[rightIndex + 1];
            for (int i = leftIndex; i < b.length; i++) {
               b[c[array[i] - 1] - 1] = array[i];
               c[array[i] - 1]--;
            }

            for (int i = leftIndex; i <= rightIndex; i++) {
               array[i] = b[i];
            }
         }
      }
   }

}
