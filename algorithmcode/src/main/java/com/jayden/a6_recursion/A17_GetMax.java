package com.jayden.a6_recursion;

/**
 * 递归实现查找最大的数
 */
public class A17_GetMax {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 4, 1, 5, 9,7,12,1};
        int maxNumber = getMax(arr);
        System.out.println(maxNumber);
    }

    public static int getMax(int[] arr){
        return process(arr,0,arr.length-1);
    }

    //递归
    private static int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }
}
