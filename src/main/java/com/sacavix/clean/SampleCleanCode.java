package com.sacavix.clean;

import java.math.BigDecimal;

public class SampleCleanCode {

    /// # 1- Usa nombres descriptivos y claros.

    // INCORRECTO
    public static float div(float a, float b) {
        float c = a / b;
        System.out.println("El resultado es: " + c);
        return c;
    }

    // CORRECTO
    public static float dividir(float dividendo, float divisor) {
        float cociente = dividendo / divisor;
        System.out.println("El resultado es: " + cociente);
        return cociente;
    }

    /// # 2- Mantén las funciones pequeñas y con una sola responsabilidad.

    // INCORRECTO
    public static void calcularYGuardarEnLaBase(BigDecimal valor) {
        //logica de calcular
        //logica de guardar
    }

    // CORRECTO
    public static void calcular(BigDecimal valor) {
        //logica de calcular
    }

    public static void guardar(BigDecimal valor) {
        //logica de guardar
    }

    /// # 3- Evita comentarios innecesarios; deja que el código se explique solo.

    // Este metodo divide el dividendo entre el divisor
    public static float dividir1(float dividendo, float divisor) {
        float cociente = dividendo / divisor;
        System.out.println("El resultado es: " + cociente);
        return cociente;
    }

    ///# 4- Usa objetos o estructuras en lugar de tipos primitivos.

    // INCORRECTO
    class Person {
        private String nombre;
        private String phone;
    }

    // CORRECTO
    class Persona {
        private String nombre;
        private PhoneNumber phone; // Ejemplo correcto
    }

    class PhoneNumber {
        private String phone;

        public boolean isValid() {
            // validaciones
            return true;
        }
    }

    ///# 5- Elimina duplicaciones en tu código (principio DRY).

    // Ejemplo de función reusable
    public static boolean isPositive(BigDecimal valor) {
        return valor.compareTo(BigDecimal.ZERO) > 0;
    }

    // Ejemplo de violacion del principio DRY
    public static BigDecimal sumValues(BigDecimal num1, BigDecimal num2) {
        if (num1.compareTo(BigDecimal.ZERO) > 0 || num2.compareTo(BigDecimal.ZERO) > 0) {
            throw new RuntimeException("Invalid parameters");
        }

        return num1.add(num2);
    }

    // Ejemplo correcto reusando el codigo sin repetir
    public static BigDecimal sumPositives(BigDecimal num1, BigDecimal num2) {
        if (!isPositive(num1) || !isPositive(num2)) {
            throw new RuntimeException("Invalid parameters");
        }

        return num1.add(num2);
    }



    ///# 6- Maneja errores con excepciones, no con códigos de error.

    // INCORRECTO
    public static Integer retrieveUserId() {
        Integer userId = null;
        // userId = resultado consulta a la base de datos
        if (userId != null) {
            return userId;
        }
        return -1;
    }

    // CORRECTO
    public static Integer getUserId() {
        Integer userId = null;
        // userId = resultado consulta a la base de datos
        if (userId != null) {
            return userId;
        }
        throw new RuntimeException("User not found"); // Usar un excepcion de negocio
    }


    ///# 7- Desacopla las clases y métodos, sigue el principio de responsabilidad única.



    // 8- Minimiza la anidación; prefiere la salida temprana.
    // 9- Mantén clases y métodos cohesivos.
    // 10-  Escribe y mantén pruebas unitarias para asegurar la calidad.

    public static void main(String[] args) {

    }
}
