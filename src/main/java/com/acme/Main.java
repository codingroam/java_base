package com.acme;

import java.util.HashMap;
import java.util.Map;

public class Main<T> {

    private Map<Class<T>,T> map = new HashMap<>();
    public static void main(String[] args) {
	// write your code here
        Student[] stuArr = new Student[2];
        stuArr[0] = new Student(8);
        Student temp = stuArr[0];
        stuArr[0].setAge(10);

    }
}
