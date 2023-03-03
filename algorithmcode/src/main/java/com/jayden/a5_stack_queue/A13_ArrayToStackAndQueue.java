package com.jayden.a5_stack_queue;

/**
 * 数组实现栈和队列
 */
public class A13_ArrayToStackAndQueue {

    public static class MyQueue {
        private int[] arr;
        private int pushIndex; //begin
        private int pollIndex; //begin
        private int size;
        private int limit;

        public MyQueue(int limit) {
            arr = new int[limit];
            pushIndex = 0;
            pollIndex = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("队列满了，不能再加了");
            }
            size++;
            arr[pushIndex] = value;
            pushIndex = getNextIndex(pushIndex);
        }

        public int poll() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空,无法取出");
            }
            size--;
            int ans = arr[pollIndex];
            pollIndex = getNextIndex(pollIndex);
            return ans;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private int getNextIndex(int pushIndex) {
            return pushIndex < limit - 1 ? pushIndex++ : 0;
        }
    }

}
