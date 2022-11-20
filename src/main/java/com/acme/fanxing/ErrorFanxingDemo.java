package com.acme.fanxing;

/**
 * @Description TODO
 * @Author wangkai
 * @Date 2022/11/10 23:51
 */
public class ErrorFanxingDemo<T> {

    private T t = null;

    public void setData(T t){

        this.t = t;
    }

    public T getData(){
        CommonResult<T> tCommonResult = new CommonResult<>();
        T result = tCommonResult.getResult();
        return result;
    }


    public static void main(String[] args) {
        ErrorFanxingDemo<String> stringErrorFanxingDemo = new ErrorFanxingDemo<>();
        stringErrorFanxingDemo.setData("hhhh");
        String data = stringErrorFanxingDemo.getData();
        System.out.println(data);
    }
}
