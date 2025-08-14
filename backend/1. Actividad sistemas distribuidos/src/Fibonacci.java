public class Fibonacci {

  // Método iterativo optimizado - O(n) tiempo, O(1) espacio
  public static long fibonacci(int n) {
    if (n <= 1)
      return n;

    long prev = 0, curr = 1;

    for (int i = 2; i <= n; i++) {
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

  public static void main(String[] args) {
    // Casos de prueba
    System.out.println("SECUENCIA DE FIBONACCI");
    System.out.println("F(10) = " + fibonacci(10));
    System.out.println("F(20) = " + fibonacci(20));
    System.out.println("F(50) = " + fibonacci(50));

    System.out.println();
    printSequence(15);
  }
}