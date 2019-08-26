package com.company;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        //Inicializacion del Programa
        System.out.println("Ingrese la cantidad de N° Aleatorios que quiera ingresar (N° deben ser Positivos)");
        Integer dim = validarNumero();
        Integer[] arreglo = new Integer[dim];

        randomGenerator(arreglo, dim);
        mostrarArreglo(arreglo);
        ordenamiento(arreglo);

    }

    //Metodo que Valida que la entrada sea un Numero y que este sea Mayor a 0.
    private static int validarNumero() {
        Scanner teclado = new Scanner(System.in);

        Integer entrada = 0;
        do {
            try {
                entrada = teclado.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Ingrese un Numero Positivo");
                teclado.next();
                entrada = -1;
            }
        } while (entrada < 0);
        return entrada;
    }

    //Metodo que Llama a un menu en el que se puede escoger los 4 tipos de Ordenamientos.
    private static void ordenamiento(Integer[] arreglo) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Selecciona la operacion a realizar");
        System.out.println("1 - Ordenar de Menor a Mayor (Metodo Burbuja)");
        System.out.println("2 - Ordenar de Mayor a Menor (Metodo Burbuja)");
        System.out.println("3 - Ordenar de Menor a Mayor (Por Clase Arrays)");
        System.out.println("4 - Ordenar de Mayor a Menor (Por Clase Arrays)");
        System.out.println("9 - Salir del Menu");
        boolean ejec = true;
        do {
            int opcion = validarNumero();

            if (opcion >= 1 && opcion <= 4) {
                seleccion(opcion, arreglo);
                System.out.println("Seleccione una operacion");
            } else if (opcion == 9) {
                ejec = false;
            } else {
                System.out.println("Opcion no valida");
            }

        } while (ejec);
    }

    //Metodo que llama a los metodos de Ordenamiento a traves de un Switch.
    private static void seleccion(int opcion, Integer[] arreglo) {
        switch(opcion){
            case 1:
                menorToMayor(arreglo);
                break;
            case 2:
                mayorToMenor(arreglo);
                break;
            case 3:
                menorToMayorArraySort(arreglo);
                break;
            case 4:
                mayorToMenorArraySort(arreglo);
                break;
            default:
                break;
        }

    }

    //Metodo que ordena de Mayor a Menor el arreglo con un metodo de la Clase Array, teniendo este un contador que cuenta el tiempo que demora en ordenar.
    private static void mayorToMenorArraySort(Integer[] arreglo) {
        double startTime = System.currentTimeMillis();

        Arrays.sort(arreglo, Collections.reverseOrder());
        mostrarArreglo(arreglo);

        double stopTime = System.currentTimeMillis();
        double elapsedTime = ((stopTime - startTime)/1000);
        System.out.println("El tiempo de ejecucion fue de: "+elapsedTime+ " Segundos");
    }

    //Metodo que ordena de Menor a Mayor el arreglo con un metodo de la Clase Array, teniendo este un contador que cuenta el tiempo que demora en ordenar.
    private static void menorToMayorArraySort(Integer[] arreglo) {
        double startTime = System.currentTimeMillis();

        Arrays.sort(arreglo);
        mostrarArreglo(arreglo);

        double stopTime = System.currentTimeMillis();
        double elapsedTime = ((stopTime - startTime)/1000);
        System.out.println("El tiempo de ejecucion fue de: "+elapsedTime+ " Segundos");
    }

    //Metodo que llama al Metodo Sort de la Clase Array.
    public static void sort(Integer[] arreglo) {
        Arrays.sort(arreglo);
        System.out.println(Arrays.toString(arreglo));
    }

    //Metodo que Muestra el Arreglo.
    private static void mostrarArreglo(Integer[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("["+arreglo[i]+"\t]");
        }
        System.out.println("");
    }

    //Metodo que Genera X (Siendo entre 0 y la Dimension del arreglo indicado) Numeros Aleatorios.
    private static void randomGenerator(Integer[] arreglo, Integer dim) {
        Random rnum = new Random();
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = rnum.nextInt(dim);
        }
    }

    //Metodo que ordena por medio del metodo de la Burbuja de Menor a Mayor, teniendo este un contador que cuenta el tiempo que demora en ordenar.
    private static void menorToMayor(Integer[] arreglo) {
        double startTime = System.currentTimeMillis();

        for (int i = 0; i < arreglo.length-1; i++) {
            for (int j = 0; j < arreglo.length-1; j++) {
                if(arreglo[j]>arreglo[j+1]){
                    int aux = arreglo[j];
                    arreglo[j]=arreglo[j+1];
                    arreglo[j+1]=aux;
                }
            }
        }
        mostrarArreglo(arreglo);

        double stopTime = System.currentTimeMillis();
        double elapsedTime = ((stopTime - startTime)/1000);
        System.out.println("El tiempo de ejecucion fue de: "+elapsedTime+ " Segundos");
    }

    //Metodo que ordena por medio del metodo de la Burbuja de Mayor a Menor, teniendo este un contador que cuenta el tiempo que demora en ordenar.
    private static void mayorToMenor(Integer[] arreglo) {
        double startTime = System.currentTimeMillis();

        for (int i = 0; i < arreglo.length-1; i++) {
            for (int j = 0; j < arreglo.length-1; j++) {
                if(arreglo[j]<arreglo[j+1]){
                    int aux = arreglo[j];
                    arreglo[j]=arreglo[j+1];
                    arreglo[j+1]=aux;
                }
            }
        }
        mostrarArreglo(arreglo);

        double stopTime = System.currentTimeMillis();
        double elapsedTime = ((stopTime - startTime)/1000);
        System.out.println("El tiempo de ejecucion fue de: "+elapsedTime+ " Segundos");
    }

}
