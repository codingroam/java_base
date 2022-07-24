package com.acme.menum;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public enum Operation {

    PLUS("+"){
        @Override
        public double apply(double x, double y) {
            return x+y;
        }
    },
    Minux("-"){
        @Override
        public double apply(double x, double y) {
            return x-y;
        }
    },
    TIMES("*"){
        @Override
        public double apply(double x, double y) {
            return x*y;
        }
    },
    DIVIDE("/"){
        @Override
        public double apply(double x, double y) {
            return x/y;
        }
    };

    private String operator;
    Operation(String operator){
        this.operator = operator;
    }

    public abstract double apply(double x,double y);

    @Override
    public String toString() {
        return this.operator;
    }

    private static final Map<String,Operation> enumMap = Stream.of(Operation.values()).collect(Collectors.toMap(Object::toString, e->e));

    public static Optional<Operation> fromString(String operator){
        return Optional.ofNullable(enumMap.get(operator));
    }

    public static void main(String[] args) {
        System.out.println("88"+Operation.DIVIDE+"22"+"="+Operation.DIVIDE.apply(88,22));
        Stream.of(Operation.values()).forEach(System.out::println);
        Optional<Operation> operation = Operation.fromString("*");
        double apply = operation.get().apply(7,8);
        System.out.println(apply);
        EnumSet<Operation> operations = EnumSet.allOf(Operation.class);
        operations.parallelStream().forEach(System.out::println);
        EnumMap<Operation, Object> operationObjectEnumMap = new EnumMap<>(Operation.class);
        //operationObjectEnumMap.forEach();
        operations.stream();
    }
}
