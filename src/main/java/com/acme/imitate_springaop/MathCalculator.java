package com.acme.imitate_springaop;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MathCalculator {

    public Integer div(int x,int y){

        log.info("MathCalculator.....div..");
        return x/y;
    }
}