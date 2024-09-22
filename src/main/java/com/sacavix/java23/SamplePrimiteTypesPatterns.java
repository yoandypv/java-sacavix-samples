package com.sacavix.java23;

public class SamplePrimiteTypesPatterns {

    /// Bad code, just a sample
    // JEP 455
    public static String getDayOfWeek(int day){
        return switch (day) {
            case 1 -> "Sunday";
            case 2 -> "Monday";
            case 3 -> "Tuesday";
            case 4 -> "Wednesday";
            case 5 -> "Thursday";
            case 6 -> "Friday";
            case 7 -> "Saturday";
            default -> "Unknown";
        };
    }

    public static boolean isInt (Object number) {
        return number instanceof int;
    }

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(7));

        System.out.println(isInt(1));
        System.out.println(isInt("Peperoni"));
    }

}
