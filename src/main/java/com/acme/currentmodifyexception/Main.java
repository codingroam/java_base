package com.acme.currentmodifyexception;

import java.util.*;

/**
 * @Description TODO
 * @Author wangkai
 * @Date 2022/9/25 18:41
 */
public class Main {


    public static void main(String[] args) {
        //List<Map<Object,Object>> list = new ArrayList<>();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("key1",null);
        map.put("key2o","dsf");
        map.put("keyl2","null");
        map.put("key2","dshjfds");
        map.put("kley2","dsf");
        map.put("ktecy2","dsfdsf");
        map.put("key2","sfdd");
        map.put("kegy2","dsfdsfds");
        map.put("kehhy2",null);
        map.put("keyb2","dsfdsfdsf");
        map.put("kwwey2","fdgjkfdj");
        Iterator<Object> iterator = map.keySet().iterator();
//        while(iterator.hasNext()){
//            Object next = iterator.next();
//            map.put("key1","kkk");
//        }
        Set<Object> objects = map.keySet();
        for(Object o : objects){
            map.put("key1555","kkk");
        }
        // list.add(map);
    }

//    public void test(List<Map<Object,Object>> results){
//        Map<Object,Object> fieldValueNameMap = new HashMap<>();
//        fieldValueNameMap.put("key1","123");
//        for(Map<Object, Object> recordMap : results) {
//            Iterator<Object> iterator = recordMap.keySet().iterator();
//            while (iterator.hasNext()) {
//                Object key = iterator.next();
//                Map<Object, Object> valueNameMap = fieldValueNameMap.get(key);
//                if(valueNameMap != null&& valueNameMap.size()>0){
//                    Object name = valueNameMap.get(recordMap.get(key)+"");
//                    if(name != null){
//                        String keyName = key.substring(0,key.length()-2)+"Name";
//                        recordMap.put(keyName,name);
//                        HashMap<String, Object> stringObjectHashMap = new HashMap<>(recordMap);
//                        stringObjectHashMap.put(keyName,name);
//                        resultCopy.add(stringObjectHashMap);
//                    }
//                }
//
//            }
//        }
//    }
}
