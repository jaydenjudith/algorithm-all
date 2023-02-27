package com.jayden.a1_sort;

import sun.awt.windows.WPrinterJob;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class A2_BubbleSort {

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
//        int[] arr= new int[]{3,-1,-1,-4,1,5,9};
//        bubbleSort(arr);
//        for (int i : arr) {
//            System.out.print(i + " ");
//        }
        int testTime = 5000;
        int maxSize = 10;
        int maxValue = 10;
        boolean succeed = true;
        for (int i = 1; i < testTime; i++) {
            int[] arr1 = generateRandomArr(maxSize, maxValue);
            int[] arr2 = copyArr(arr1);
            bubbleSort(arr1);
            comparator(arr2);
            if (!equal(arr1, arr2)) {
                succeed = false;
                printArr(arr1);
                printArr(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
        int[] arr = generateRandomArr(maxSize, maxValue);
        printArr(arr);
        bubbleSort(arr);
        printArr(arr);

    }

    private static void printArr(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        ;
    }

    private static boolean equal(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    private static int[] copyArr(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] copyArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = arr[i];
        }
        return copyArr;
    }

    private static int[] generateRandomArr(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((Math.random() + 1) * maxSize)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((Math.random() + 1) * maxValue) - (int) ((Math.random() + 1) * maxValue);
        }
        return arr;
    }
}
