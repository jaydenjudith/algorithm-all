package com.jayden.a2_binary_search;

import java.util.Arrays;

/**
 * 找到<=某个数最右边的位置
 * <p>
 * 条件: 有序数组
 * <p>
 * 例子: arr{1,3,5,7,7,9,11,12,14}   value: 7
 * 答案: 4
 */
public class A5_BinarySearchNearRight {

    public static int nearRight(int[] arr, int value) {
        int L = 0;
        int R = arr.length - 1;
        int index = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] <= value) {
                L = mid + 1;
                index = mid;
            } else {
                R = mid - 1;
            }
        }
        return index;
    }


    public static void main(String[] args) {
//        int[] arr = new int[]{1,3,5,7,7,9,11,12,14};
//        int i = nearLeftIndex(arr, 7);
//        System.out.println(i);
        int testTime = 5000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArr(maxSize, maxValue);
            int value = (int) ((Math.random() + 1) * maxValue) - (int) ((Math.random() + 1) * maxValue);
            Arrays.sort(arr);
            if (nearRight(arr, value) != comparator(arr, value)) {
                succeed = false;
                printArr(arr);
                System.out.println("value is: " + value);
                System.out.println("nearLeftIndex answer is: " + nearRight(arr, value));
                System.out.println("comparator answer is: " + comparator(arr, value));
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
        if (succeed) {
            int[] arr = generateRandomArr(maxSize, maxValue);
            int value = (int) ((Math.random() + 1) * maxValue) - (int) ((Math.random() + 1) * maxValue);
            Arrays.sort(arr);
            printArr(arr);
            System.out.println("value is: " + value);
            System.out.println("nearLeftIndex answer is: " + nearRight(arr, value));
        }
    }

    private static int comparator(int[] arr, int value) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= value) {
                return i;
            }
        }
        return -1;
    }

    private static int[] generateRandomArr(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() + 1) * maxSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((Math.random() + 1) * maxValue) - (int) ((Math.random() + 1) * maxValue);
        }
        return arr;
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
}
