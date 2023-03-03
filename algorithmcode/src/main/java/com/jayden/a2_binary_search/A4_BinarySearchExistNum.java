package com.jayden.a2_binary_search;

import java.util.Arrays;

/**
 * 二分查找一个数
 * <p>
 * 条件: 有序数组
 */
public class A4_BinarySearchExistNum {

    // 存在就返回目标索引,不存在返回-1
    public static boolean binarySearchExistNum(int[] sortedArr, int num) {
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                R = mid - 1;
            } else if (sortedArr[mid] < num) {
                L = mid + 1;
            }
        }
        return false;
    }



    public static void main(String[] args) {
//        int[] arr = new int[]{1,3,5,7,7,9,11,12,14};
//        boolean succeed = binarySearchExistNum(arr, 11);
//        System.out.println(succeed);

        int testTime = 5000;
        int maxSize = 10;
        int maxValue = 10;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArr(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((Math.random() + 1) * maxValue) - (int) ((Math.random() + 1) * maxValue);
            if (binarySearchExistNum(arr, value) != comparator(arr, value)) {
                succeed = false;
                printArr(arr);
                System.out.println("value: " + value);
                System.out.println("binary search answer: " + binarySearchExistNum(arr, value));
                System.out.println("comparator answer: " + comparator(arr, value));
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
        if (succeed) {
            int[] arr = generateRandomArr(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((Math.random() + 1) * maxValue) - (int) ((Math.random() + 1) * maxValue);
            printArr(arr);
            System.out.println("value is: " + value);
            System.out.println("binary search answer: " + binarySearchExistNum(arr, value));
            System.out.println("comparator answer: "+comparator(arr,value));
        }
    }

    private static void printArr(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static boolean comparator(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    private static int[] generateRandomArr(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() + 1) * maxSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((Math.random() + 1) * maxValue) - (int) ((Math.random() + 1) * maxValue);
        }
        return arr;
    }
}
