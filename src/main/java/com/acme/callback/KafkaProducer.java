package com.acme.callback;


/**
 * @Description TODO
 * @Author wangkai
 * @Date 2022/9/18 15:28
 */
public class KafkaProducer {



    public void send(String msg, CallBack callBack) {

        new Thread(()->{
            System.out.println("send msg"+msg);
            callBack.onCompalete("消息成功发送！");
        }).start();




    }
}
