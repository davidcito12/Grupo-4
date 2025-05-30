package com.mycompany.grupo_4;

import java.util.Scanner;

/**
 * @author Niños
 */
public class Grupo_4 {

    // Método factorial original
    public static long factorial(int n) {
        long resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    // Método suma de dígitos original
    public static int sumaDigitos(int n) {
        n = Math.abs(n);
        int suma = 0;
        while (n > 0) {
            suma += n % 10;
            n /= 10;
        }
        return suma;
    }

    // Variables y PIN para el simulador bancario
    private static double saldo = 1500.00;
    private static final int PIN_CORRECTO = 1234;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n----- Menú de Ejercicios -----");
            System.out.println("1. Factorial");
            System.out.println("2. Suma de dígitos");
            System.out.println("3. Cajero Bancario");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Llamada a factorial
                    System.out.print("Ingrese un número para calcular su factorial: ");
                    int numFact = scanner.nextInt();
                    System.out.println("El factorial de " + numFact + " es: " + factorial(numFact));
                    break;

                case 2:
                    // Llamada a suma de dígitos
                    System.out.print("Ingrese un número para sumar sus dígitos: ");
                    int numSum = scanner.nextInt();
                    System.out.println("La suma de dígitos de " + numSum + " es: " + sumaDigitos(numSum));
                    break;

                case 3:
                    // Lógica del cajero bancario
                    System.out.print("Ingrese su PIN: ");
                    int pinIngresado = scanner.nextInt();
                    if (pinIngresado != PIN_CORRECTO) {
                        System.out.println("PIN incorrecto. Acceso denegado.");
                        break;
                    }
                    int opcionBanco;
                    do {
                        System.out.println("\nBienvenido al Cajero Automático");
                        System.out.println("1. Consultar saldo");
                        System.out.println("2. Retirar dinero");
                        System.out.println("3. Salir del cajero");
                        System.out.print("Seleccione una opción: ");
                        opcionBanco = scanner.nextInt();
                        switch (opcionBanco) {
                            case 1:
                                System.out.printf("Su saldo actual es: $%.2f\n", saldo);
                                break;
                            case 2:
                                System.out.print("Ingrese el monto a retirar: $");
                                double monto = scanner.nextDouble();
                                if (monto <= 0) {
                                    System.out.println("El monto debe ser mayor a cero.");
                                } else if (monto > saldo) {
                                    System.out.println("Fondos insuficientes.");
                                } else {
                                    saldo -= monto;
                                    System.out.printf("Retiro exitoso. Su nuevo saldo es: $%.2f\n", saldo);
                                }
                                break;
                            case 3:
                                System.out.println("Gracias por usar el cajero automático. Hasta luego.");
                                break;
                            default:
                                System.out.println("Opción no válida.");
                        }
                    } while (opcionBanco != 3);
                    break;

                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
