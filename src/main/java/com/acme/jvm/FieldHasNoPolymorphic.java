package com.acme.jvm;


/**
 * field不存在多态.方法存在多态
 */
public class FieldHasNoPolymorphic {

    static class Father {
        public int money = 1;

        public Father(){
            money = 2;
            showMeMoney();

        }

        public void showMeMoney(){
            System.out.println("Father money = "+money);
        }
    }

    static class Son extends Father{

        public int money = 6;
        public Son(){
            money = 3;
            showMeMoney();
        }

        public void showMeMoney(){
            System.out.println("Son money = "+money);
        }
    }

    public static void main(String[] args) {

        /**
         * Son money = 0
         * Son money = 3
         * main money=2
         */
        Father father = new Son();
        System.out.println("main money="+father.money);
    }
}
