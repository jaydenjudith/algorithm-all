package com.jayden.a4_linkedlist;

public class A11_DeleteGivenNum {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }


    public static Node deleteGivenNum(Node head, int value) {
        while (head != null) {
            if (head.value!=value){
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while (cur !=null){
            if (cur.value==value){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
