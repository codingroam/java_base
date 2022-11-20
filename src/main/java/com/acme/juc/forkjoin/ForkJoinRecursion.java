package com.acme.juc.forkjoin;

import java.util.concurrent.*;

public class ForkJoinRecursion {


    private static ExecutorService executorService;
    private static int[] numArr = new int[499999999];
    private static int MAX = 50000;



    static{
        long l = System.currentTimeMillis();
        int coreNum = Runtime.getRuntime().availableProcessors();
        executorService = Executors.newFixedThreadPool(coreNum);
        for(int i=0;i<numArr.length;i++){
            numArr[i] = i;
        }
        long end = System.currentTimeMillis();
        System.out.println("初始化数组"+(end-l)+"ms");
    }

    static class CalcForJoinTask extends RecursiveTask<Integer> {
        private Integer startValue; //子任务的开始计算的值
        private Integer endValue; //子任务结束计算的值

        public CalcForJoinTask(Integer startValue, Integer endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        protected Integer compute() {
            //如果当前的数据区间已经小于MAX了，那么接下来的计算不需要做拆分
            if (endValue - startValue < MAX) {
                Integer totalValue = 0;
                for (int i = this.startValue; i <= this.endValue; i++) {
                    totalValue += numArr[i];
                }
                return totalValue;
            }
            //任务拆分，拆分成两个任务
            CalcForJoinTask subTask = new CalcForJoinTask(startValue, (startValue + endValue) / 2);
            subTask.fork();

            CalcForJoinTask calcForJoinTask = new CalcForJoinTask((startValue + endValue) / 2 + 1, endValue);
            calcForJoinTask.fork();

            return subTask.join() + calcForJoinTask.join();
        }
    }



    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        int sum = 0;
        for(int i=0;i<numArr.length;i++){
            sum += numArr[i];
        }
        System.out.println("sum = "+sum);
        long end = System.currentTimeMillis();

        System.out.println("单线程相加耗时"+(end - start)+"ms");

        long startF = System.currentTimeMillis();


        CalcForJoinTask calcForJoinTask = new CalcForJoinTask(0, 499999998);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> submit = forkJoinPool.submit(calcForJoinTask);

        try {
            Integer integer = submit.get();
            System.out.println("sum = "+integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        long endF = System.currentTimeMillis();
        System.out.println("forkjoin相加耗时"+(endF - startF)+"ms");


    }


}
