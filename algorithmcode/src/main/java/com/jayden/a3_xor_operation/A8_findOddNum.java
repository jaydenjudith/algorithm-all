package com.jayden.a3_xor_operation;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * 1 一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这种数
 * 2 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这种数
 */
public class A8_findOddNum {

    // 有一个数奇数次
    private static void printOddTimesNum1(int[] arr1) {
        int result = 0;
        for (int i : arr1) {
            result = result ^ i;
        }
        System.out.println(result);
    }

    // 有两个数出现了奇数次
    private static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        // a 和 b是两种数
        // eor != 0
        // eor最右侧的1，提取出来
        // eor :     00110010110111000
        // rightOne :00000000000001000
        int rightOne = eor & (-eor); // 提取出最右的1


        int onlyOne = 0; // eor'
        for (int i = 0; i < arr.length; i++) {
            //  arr[1] =  111100011110000
            // rightOne=  000000000010000
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }


    // 有两个奇数
    public static void findTwo(int[] arr) {
        int TWO = 0;
        for (int i : arr) {
            TWO ^= i;
        }
        //找到一个1
        int RIGHTONE = TWO & (-TWO);
        int theOne = 0;
        for (int i = 0; i <arr.length; i++) {
            if ((arr[i] & RIGHTONE) != 0) {
                theOne ^= arr[i];
            }
        }
        System.out.println(theOne + "   " + (TWO ^ theOne));

    }


    public static void main(String[] args) {
        int[] arr1 = {3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1};
        printOddTimesNum1(arr1);

        int[] arr2 = {4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2};
        findTwo(arr2);
    }
}
