package com.jayden.a6_recursion;

/**
 * 递归实现查找最大的数
 */
public class A17_GetMax {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 4, 1, 5, 9,7,12,1};
        int maxNumber = getMax(arr, 0, arr.length - 1);
        System.out.println(maxNumber);
    }

    //递归
    private static int getMax(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int leftMax = getMax(arr, L, mid);
        int rightMax = getMax(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }
}
