package com.implementation.algorithm.sorting;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuickSortTest {

  @Test
  public void performQuickSort() {
    List<Integer> items = Arrays.asList(5, 3, 1, 2, 0, 6, 4);
    List<Integer> expectedItems = Arrays.asList(0, 1, 2, 3, 4, 5, 6);
    QuickSort.sort(items, 0, items.size() - 1);
    System.out.println(items);
    Assertions.assertEquals(expectedItems, items);
  }
}
