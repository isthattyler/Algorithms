package com.implementation.algorithm.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
  public static void sort(List<Integer> items, int leftIndex, int rightIndex) {
    if (rightIndex > leftIndex) {
      int midPoint = findMidPoint(leftIndex, rightIndex);

      sort(items, leftIndex, midPoint);
      sort(items, midPoint + 1, rightIndex);

      merge(items, leftIndex, midPoint, rightIndex);
    }
  }

  private static int findMidPoint(int leftIndex, int rightIndex) {
    return leftIndex + (rightIndex - leftIndex) / 2;
  }

  private static void merge(List<Integer> items, int leftIndex, int midPoint, int rightIndex) {
    int leftHalfSize = midPoint + 1 - leftIndex;
    int rightHalfSize = rightIndex - midPoint;
    int leftIndx;
    int rightIndx;

    List<Integer> leftItems = new ArrayList<>(leftHalfSize);
    List<Integer> rightItems = new ArrayList<>(rightHalfSize);
    for (leftIndx = 0; leftIndx < leftHalfSize; leftIndx++) {
      leftItems.add(items.get(leftIndex + leftIndx));
    }
    for (rightIndx = 0; rightIndx < rightHalfSize; rightIndx++) {
      rightItems.add(items.get(midPoint + 1 + rightIndx));
    }

    leftIndx = 0;
    rightIndx = 0;

    int finalArrayIndex = leftIndex;
    while (leftIndx < leftHalfSize && rightIndx < rightHalfSize) {
      if (leftItems.get(leftIndx) <= rightItems.get(rightIndx)) {
        items.set(finalArrayIndex++, leftItems.get(leftIndx++));
      } else {
        items.set(finalArrayIndex++, rightItems.get(rightIndx++));
      }
    }
    while (leftIndx < leftHalfSize) {
      items.set(finalArrayIndex++, leftItems.get(leftIndx++));
    }
    while (rightIndx < rightHalfSize) {
      items.set(finalArrayIndex++, rightItems.get(rightIndx++));
    }
  }
}
