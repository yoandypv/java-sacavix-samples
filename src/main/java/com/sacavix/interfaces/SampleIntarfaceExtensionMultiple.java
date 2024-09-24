package com.sacavix.interfaces;

// sample interface multiple extension
interface A {
     void foo();
}

interface B {
    void bar();
}

interface C extends A, B {
    void yeah();
}

public class SampleIntarfaceExtensionMultiple implements C {

    @Override
    public void yeah() {

    }

    @Override
    public void foo() {

    }

    @Override
    public void bar() {

    }
}
