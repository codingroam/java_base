package com.acme.callback;

import java.util.concurrent.Callable;

/**
 * @Description TODO
 * @Author wangkai
 * @Date 2022/9/18 15:36
 */
public class Main {

    public static void main(String[] args) {
        KafkaProducer kafkaProducer = new KafkaProducer();
        kafkaProducer.send("你好", new CallBack() {
            @Override
            public void onCompalete(String parm) {
                System.out.println(parm);
            }
        });
    }
}
