package Example7;

import java.util.concurrent.*;
import java.util.Scanner;

public class Wykonawca {
  public static void main(String[] args) {
    ExecutorService exec = Executors.newFixedThreadPool(2);

    TaskW t1 = new TaskW();
    TaskL t2 = new TaskL();
    t1.Calculate(500000000);
    t2.Calculate(500000000);

    long start = System.currentTimeMillis();
    // wywolanie sekwencyjne
    Double v1 = t1.call();
    Double v2 = t2.call();
    long end = System.currentTimeMillis();

    System.out.println("Czas " + (end - start));

    if (v1 == v2) {
      System.out.println("Ten sam wynik!");
      System.out.println(v1 + " " + v2);
    } else {
      System.out.println("Różny wynik!");
      System.out.println(v1 + " " + v2);
    }

    FutureTask<Double> task1 = new FutureTask<Double>(t1);
    FutureTask<Double> task2 = new FutureTask<Double>(t2);

    start = System.currentTimeMillis();
    exec.execute(task1);
    exec.execute(task2);

    // kończenie/zabijanie wykonawcy
    Thread.yield();
    exec.shutdown();

    try {
      exec.awaitTermination(60, TimeUnit.SECONDS);
    } catch (InterruptedException exc) {
    }
    System.out.println("Wykonawaca zabity: " + exec.isTerminated());

    try {
      Double v11 = task1.get();
      Double v12 = task2.get();
      end = System.currentTimeMillis();

      System.out.println("Czas " + (end - start));

      if (v11 == v12) {
        System.out.println("Ten sam wynik!");
        System.out.println(v11 + " " + v12);
      } else {
        System.out.println("Różny wynik!");
        System.out.println(v11 + " " + v12);
      }

      Scanner scanner = new Scanner(System.in);
      double radius = scanner.nextDouble();

      double resultW = v11.doubleValue() * radius * radius;
      double resultL = v12.doubleValue() * radius * radius;

      System.out.println("Pole policzone metodą Wallis'a: " + resultW);
      System.out.println("Pole policzone metodą Leibniz'a: " + resultL);
      System.out.println(""+Runtime.getRuntime().availableProcessors());

    } catch (Exception ex) {
    }

    // teraz wyświetli się na końcu

    System.out.println("Koniec maina!");
  }
}