package com.jayden.a3_xor_operation;

/**
 * 不使用变量的情况下交换两个数
 */
public class A7_SwapWithoutVariable {

    public static void swapWithoutVariable(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int a = 13;
        int b = 63;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a : " + a);
        System.out.println("b : " + b);

        int[] arr = new int[]{13, 63};
        swapWithoutVariable(arr, 0, 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 注意地址指向不能为同一个数, 否则会导致N^N=0从而被刷成0
        swapWithoutVariable(arr, 0, 0);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
