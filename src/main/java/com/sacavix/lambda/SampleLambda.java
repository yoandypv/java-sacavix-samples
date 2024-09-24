package com.sacavix.lambda;

public class SampleLambda {

    private static void printGeneric(PrintText printText) {
        printText.print();
    }


    public static void main(String[] args) {

        Person person = new Person("Pepe");
        //person.print();
        //printGeneric(person);

        printGeneric(() -> {
            System.out.println(person.getName());
        });

        PrintText printText = () -> {
            System.out.println(person.getName());
        };



        PrintText printTextAnonima = new PrintText() {
            @Override
            public void print() {
                System.out.println("Anonima");
            }
        };

        PrintText printTextLambda = () -> {
            System.out.println("Lambda ");
        };

        printTextAnonima.print();
        printTextLambda.print();

    }
}
