package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

   @Override
   public void sort(Integer[] array, int leftIndex, int rightIndex) {
      boolean valid = (leftIndex < rightIndex) && (array != null) && (leftIndex >= 0) && (rightIndex < array.length)
            && (array.length > 0);

      if (valid) {

         int maior = 0;
         int menor = -1;
         for (int i = leftIndex + 1; i <= rightIndex; i++) {
            if (array[i] > maior) {
               maior = array[i];
            }
            if (array[i] < menor) {
               menor = array[i];
            }
         }

         int[] c = new int[maior - menor + 1];
         for (int i = leftIndex; i <= rightIndex; i++) {
            c[array[i] - menor] += 1;
         }

         for (int i = 1; i < maior - menor + 1; i++) {
            c[i] += c[i - 1];
         }

         int[] b = new int[rightIndex + 1];
         for (int i = leftIndex; i < b.length; i++) {
            b[c[array[i] - menor] - 1] = array[i];
            c[array[i] - menor]--;
         }

         for (int i = leftIndex; i <= rightIndex; i++) {
            array[i] = b[i];
         }

      }
   }

}
