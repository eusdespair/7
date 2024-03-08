import java.util.Arrays;

public class NumerosPrimosYFibonacci {
    private int limite;

    public NumerosPrimosYFibonacci(int limite) {
        this.limite = limite;
    }

    // Método para calcular los números primos hasta el límite dado
    public int[] calcularNumerosPrimos() {
        int[] primos = new int[limite];
        int contador = 0;
        int numero = 2; // Comenzamos con el primer número primo

        while (contador < limite) {
            if (esPrimo(numero)) {
                primos[contador] = numero;
                contador++;
            }
            numero++;
        }

        return primos;
    }

    // Método para verificar si un número es primo
    private boolean esPrimo(int numero) {
        if (numero <= 1)
            return false;
        if (numero <= 3)
            return true;
        if (numero % 2 == 0 || numero % 3 == 0)
            return false;

        int i = 5;
        while (i * i <= numero) {
            if (numero % i == 0 || numero % (i + 2) == 0)
                return false;
            i += 6;
        }
        return true;
    }

    // Método para calcular la secuencia de Fibonacci hasta el límite dado
    public int[] calcularFibonacci() {
        int[] fibonacci = new int[limite];
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for (int i = 2; i < limite; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        return fibonacci;
    }

    public static void main(String[] args) {
        NumerosPrimosYFibonacci numeros = new NumerosPrimosYFibonacci(50); // Se inicializa con un límite de 10

        int[] primos = numeros.calcularNumerosPrimos();
        System.out.println("Números primos:");
        imprimirArreglo(primos);

        int[] fibonacci = numeros.calcularFibonacci();
        System.out.println("\nSucesión de Fibonacci:");
        imprimirArreglo(fibonacci);
    }

    // Método para imprimir un arreglo hasta el límite
    private static void imprimirArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != 0) {
                if (i > 0)
                    System.out.print(", ");
                System.out.print(arreglo[i]);
            } else {
                break;
            }
        }
        System.out.println(", ... hasta " + arreglo.length + " números");
    }
}

