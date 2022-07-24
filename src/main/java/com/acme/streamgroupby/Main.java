package com.acme.streamgroupby;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("wang",99));
        students.add(new Student("wang",9999));
        students.add(new Student("li",79));
        students.add(new Student("zhao",69));
        students.add(new Student("wu",19));

        Map<String, List<Student>> collect = students.stream().collect(Collectors.groupingBy(student -> student.getName()));
        Map<String, List<Student>> mapWithStudentList = getMapWithStudentList(students);
        Map<String, List<Student>> mapWithList = getMapGroupByListField(students,"name");

        System.out.println("kkk");


    }

    private static <E> Map<String,List<E>> getMapGroupByListField(List<E> list,String fieldName) throws Exception {
        Map<String,List<E>> map = new HashMap<>();
        String methodName = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
        for(E e : list){
            Method method = e.getClass().getMethod(methodName);
            String key = (String)method.invoke(e, null);
            if(map.containsKey(key)){
                map.get(key).add(e);
            }else{
                List<E> templist = new ArrayList<>();
                templist.add(e);
                map.put(key,templist);
            }
        }
        return map;
    }


    private static Map<String,List<Student>> getMapWithStudentList(List<Student> students){
        Map<String,List<Student>> map = new HashMap<>();
        for(Student student : students){
            String name = student.getName();
            if(map.containsKey(name)){
                map.get(name).add(student);
            }else{
                List<Student> tempStudents = new ArrayList<>();
                tempStudents.add(student);
                map.put(name,tempStudents);
            }

        }


        return map;
    }

}
