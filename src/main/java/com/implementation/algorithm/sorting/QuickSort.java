package com.implementation.algorithm.sorting;

import java.util.List;

public class QuickSort {
    public static void sort(List<Integer> items, int left, int right) {
        if (left < right) {
            int partition = partition(items, left, right);

            sort(items, left, partition - 1);
            sort(items, partition + 1, right);
        }
    }

    private static int partition(List<Integer> items, int left, int right) {
        int pointer;
        int temp;
        int pivot = items.get(right);

        pointer = left - 1;
        for (int index = left; index < right; index++) {
            if (items.get(index) <= pivot) {
                pointer++;

                // swap elements
                temp = items.get(pointer);
                items.set(pointer, items.get(index));
                items.set(index, temp);
            }
        }
        temp = items.get(pointer + 1);
        items.set(pointer + 1, items.get(right));
        items.set(right, temp);

        return pointer + 1;
    }
}
