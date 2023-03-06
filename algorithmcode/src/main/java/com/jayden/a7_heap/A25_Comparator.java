package com.jayden.a7_heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * 实现比较器:
 *
 * 1  比较器的实质就是重载比较运算符
 * 2 比较器可以很好的应用在特殊标准的排序上
 * 3 比较器可以很好的应用在根据特殊标准排序的结构上
 * 4 写代码变得异常容易，还用于范型编程
 *
 * 即如下方法：
 * @Override
 * public int compare(T o1, T o2) ;
 * 返回负数的情况，就是o1比o2优先的情况
 * 返回正数的情况，就是o2比o1优先的情况
 * 返回0的情况，就是o1与o2同样优先的情况
 */
public class A25_Comparator {

    public static class IdShengAgeJiangOrder implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id != o2.id ? (o1.id - o2.id) : (o1.age - o2.age);
        }
    }


    public static void main(String[] args) {
        // 只要时链表,数组等有排序感觉的结构都可以使用比较器进行排序,且时间复杂度为O(logn)
        Student student1 = new Student("A", 4, 40);
        Student student2 = new Student("B", 4, 21);
        Student student3 = new Student("C", 3, 12);
        Student student4 = new Student("D", 3, 62);
        Student student5 = new Student("E", 3, 42);
        // D E C A B

        Student[] students = new Student[]{student1, student2, student3, student4, student5};
        System.out.println("第一条打印");
        Arrays.sort(students, new IdShengAgeJiangOrder());
        for (int i = 0; i < students.length; i++) {
            Student s = students[i];
            System.out.println(s.name + "," + s.id + "," + s.age);
        }

        System.out.println("第二条打印");
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.sort(new IdShengAgeJiangOrder());
        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            System.out.println(s.name + "," + s.id + "," + s.age);
        }

        // N * logN
        System.out.println("第三条打印");
        student1 = new Student("A", 4, 40);
        student2 = new Student("B", 4, 21);
        student3 = new Student("C", 4, 12);
        student4 = new Student("D", 4, 62);
        student5 = new Student("E", 4, 42);
        TreeMap<Student, String> treeMap = new TreeMap<>((a, b) -> (a.id - b.id));
        treeMap.put(student1, "我是学生1，我的名字叫A");
        treeMap.put(student2, "我是学生2，我的名字叫B");
        treeMap.put(student3, "我是学生3，我的名字叫C");
        treeMap.put(student4, "我是学生4，我的名字叫D");
        treeMap.put(student5, "我是学生5，我的名字叫E");
        for (Student s : treeMap.keySet()) {
            System.out.println(s.name + "," + s.id + "," + s.age);
        }
    }

    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }
}
