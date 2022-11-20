package com.acme.imitate_springaop.easy_version;

import com.acme.imitate_springaop.MathCalculator;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

public class TestPrinciple {


    public static void main(String args[]) throws Exception {

        AppcationContext appcationContext = new AppcationContext();
        MathCalculator mathCalculator = appcationContext.getBean(MathCalculator.class);
        mathCalculator.div(50,5);


    }
}
