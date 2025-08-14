public class Fibonacci {

  // Método iterativo optimizado - O(n) tiempo, O(1) espacio
  public static long fibonacci(int n) {
    if (n <= 1)
      return n;

    long prev = 0, curr = 1;

    for (int i = 2; i <= n; i++) { // CORREGIDO: <= en lugar de <
      long next = prev + curr;
      prev = curr;
      curr = next;
    }

    return curr;
  }

  // Generar secuencia hasta N términos
  public static void printSequence(int terms) {
    System.out.print("Secuencia: ");
    for (int i = 0; i < terms; i++) {
      System.out.print(fibonacci(i));
      if (i < terms - 1)
        System.out.print(", ");
    }
    System.out.println();
  }

  // Verificar si un número está en la secuencia de Fibonacci
  public static boolean isFibonacci(long num) {
    if (num < 0)
      return false;
    if (num == 0 || num == 1)
      return true;

    long prev = 0, curr = 1;

    while (curr < num) { // Condición correcta: seguir mientras curr < num
      long next = prev + curr;
      prev = curr;
      curr = next;
    }

    return curr == num; // CORREGIDO: retorna true si curr == num
  }

  // Encontrar la posición de un número Fibonacci
  public static int findFibonacciIndex(long num) {
    if (num < 0)
      return -1;
    if (num == 0)
      return 0;
    if (num == 1)
      return 1;

    long prev = 0, curr = 1;
    int index = 1;

    while (curr < num) {
      long next = prev + curr;
      prev = curr;
      curr = next;
      index++;
    }

    return curr == num ? index : -1; // Retorna -1 si no es Fibonacci
  }

  // Calcular suma de los primeros N términos
  public static long fibonacciSum(int n) {
    if (n <= 0)
      return 0;
    if (n == 1)
      return 0;
    if (n == 2)
      return 1;

    // Propiedad: suma de F(0) a F(n-1) = F(n+1) - 1
    return fibonacci(n + 1) - 1;
  }

  // Números Fibonacci pares menores que N
  public static void evenFibonacci(long limit) {
    System.out.print("Fibonacci pares < " + limit + ": ");

    long prev = 0, curr = 1;
    long sum = 0;

    while (curr < limit) {
      if (curr % 2 == 0) {
        System.out.print(curr + " ");
        sum += curr;
      }
      long next = prev + curr;
      prev = curr;
      curr = next;
    }

    System.out.println("\nSuma total: " + sum);
  }

  public static void main(String[] args) {
    // Casos de prueba
    System.out.println("SECUENCIA DE FIBONACCI");
    System.out.println("F(10) = " + fibonacci(10));
    System.out.println("F(20) = " + fibonacci(20));
    System.out.println("F(50) = " + fibonacci(50));

    System.out.println();
    printSequence(15);

    // Pruebas de verificación
    System.out.println();
    System.out.println("¿Es 55 Fibonacci? " + isFibonacci(55));
    System.out.println("¿Es 100 Fibonacci? " + isFibonacci(100));
    System.out.println("¿Es 8 Fibonacci? " + isFibonacci(8));

    // Nuevas funcionalidades
    System.out.println();
    System.out.println("--- FUNCIONALIDADES ADICIONALES ---");
    System.out.println("Posición de 55 en Fibonacci: F(" + findFibonacciIndex(55) + ")");
    System.out.println("Posición de 21 en Fibonacci: F(" + findFibonacciIndex(21) + ")");
    System.out.println("Posición de 100: " + findFibonacciIndex(100) + " (-1 = no es Fibonacci)");

    System.out.println();
    System.out.println("Suma de primeros 10 Fibonacci: " + fibonacciSum(10));
    System.out.println("Suma de primeros 15 Fibonacci: " + fibonacciSum(15));

    System.out.println();
    evenFibonacci(100);
    System.out.println();
    evenFibonacci(1000);
  }
}