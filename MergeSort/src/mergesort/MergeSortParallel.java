/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

import java.util.Arrays;
import java.util.concurrent.*;
 
public class MergeSortParallel extends RecursiveAction {

        //Default THRESHOLD
        private int SORT_THRESHOLD = 1;

        private final int[] array;
        private final int min;
        private final int max;

        public void setSORT_THRESHOLD(int SORT_THRESHOLD) {
            this.SORT_THRESHOLD = SORT_THRESHOLD;
        }

        public MergeSortParallel(int[] array) {
            this(array, 0, array.length-1);
        }

        public MergeSortParallel(int[] array, int min, int max) {
            this.array = array;
            this.min = min;
            this.max = max;
        }

        public void sort() {
            compute();
        }

        @Override
        protected void compute() {
            if (min < max) {
                int size = max - min;
                if (size <= SORT_THRESHOLD) {
                    //RecursiveMergeSort.mergeSort(array);
                    //QuickSort.quickSort(array);
                    insertionSort();
                } else {
                    int middle = min + Math.floorDiv(size, 2);
                    invokeAll(new MergeSortParallel(array, min, middle),
                              new MergeSortParallel(array, middle + 1, max));
                    merge(middle);
                }
            }
        }


        private void merge(int mid) {
            int[] left = Arrays.copyOfRange(array, min, mid+1);
            int[] right = Arrays.copyOfRange(array, mid+1, max+1);
            int f = min;

            int li = 0, ri = 0;
            while (li < left.length && ri < right.length) {
                if (left[li] <= right[ri]) {
                    array[f++] = left[li++];
                } else {
                    array[f++] = right[ri++];
                }
            }

            while (li < left.length) {
                array[f++] = left[li++];
            }

            while (ri < right.length) {
                array[f++] = right[ri++];
            }
        }

        private void insertionSort() {
            for (int i = min+1; i <= max; ++i) {
                int current = array[i];
                int j = i-1;
                while (min <= j && current < array[j]) {
                    array[j+1] = array[j--];
                }
                array[j+1] = current;
            }
        }
    
    
}

