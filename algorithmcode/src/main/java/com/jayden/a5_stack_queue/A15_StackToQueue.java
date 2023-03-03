package com.jayden.a5_stack_queue;

import java.util.Stack;

/**
 * 栈实现队列, 队列可以实现广度优先遍历
 */
public class A15_StackToQueue {
    public static class StackToQueue<T>{
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public StackToQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        public void add(Integer data){
            stackPush.push(data);
            stackPushToStackPop();
        }

        public int poll(){
            if (stackPop.isEmpty()&&stackPush.isEmpty()){
                throw new RuntimeException("Queue is empty!!");
            }
            stackPushToStackPop();
            return stackPop.pop();
        }

        public int peek(){
            if (stackPop.isEmpty()&&stackPush.isEmpty()){
                throw new RuntimeException("Queue is empty!!");
            }
            stackPushToStackPop();
            return stackPop.peek();
        }


        private void stackPushToStackPop(){
            if (stackPop.isEmpty()){
                while(! stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
            }
        }
    }

    public static void main(String[] args) {
        StackToQueue<Integer> queue = new StackToQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }
}
