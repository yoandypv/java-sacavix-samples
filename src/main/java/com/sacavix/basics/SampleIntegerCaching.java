package com.sacavix.basics;

import java.lang.management.ManagementFactory;
import java.util.List;

//JVM option -XX:AutoBoxCacheMax=200
public class SampleIntegerCaching {


    public static void printArgs(){
        List<String> jvmArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
        System.out.println("JVM Arguments:");
        for (String arg : jvmArguments) {
            System.out.println(arg);
        }
    }

    public void sample128() {
        Integer var1 = 128;
        Integer var2 = 128;
    }

    public void sample1() {
        Integer varx = 1;
        Integer vary = 1;
    }

    public static void main(String[] args) {
        printArgs();
       Integer a = 201;
       Integer b = 201;

        System.out.println(a == b);

    }
}
