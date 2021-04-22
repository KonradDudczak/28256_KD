package Example8;

import java.util.concurrent.*;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Wykonawca {

  static final int size = Runtime.getRuntime().availableProcessors();
  static int current_row_index = 1;

  static Random rand = new Random();
  static int[][] matrix = new int[size][size];
  static int[] vector = new int[size];
  static int[] result = new int[size];

  public static void main(String[] args) {

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        matrix[i][j] = rand.nextInt(11);
      }
    }

    for (int i = 0; i < size; i++) {
      vector[i] = rand.nextInt(11);
    }

    for (int i = 0; i < size; i++) {
      result[i] = 1;
    }

    long start = System.currentTimeMillis();

    ExecutorService exec = Executors.newFixedThreadPool(size);

    for (int i = 0; i < size; i++) {

      current_row_index = i;
      Counter task = new Counter();
      FutureTask<Integer> task1 = new FutureTask<Integer>(task);
      exec.execute(task1);

    }

    // kończenie/zabijanie wykonawcy
    Thread.yield();
    exec.shutdown();

    try {
      exec.awaitTermination(60, TimeUnit.SECONDS);
    } catch (InterruptedException exc) {
    }
    System.out.println("Wykonawaca zabity: " + exec.isTerminated());

    System.out.println();
    System.out.println("Rezultat: ");

    for (int i = 0; i < size; i++) {
      System.out.print(result[i] + " ");
    }

    System.out.println();

    /*for (int i = 0; i < size; i++) {
      System.out.print(vector[i] + " ");
    }*/

    long end = System.currentTimeMillis();

    System.out.println();

    System.out.println("Czas " + (end - start));

    for (int i = 0; i < size; i++) {
      System.out.println();
      for (int j = 0; j < size; j++) {
        System.out.print(matrix[i][j] + " ");
      }
    }

    // teraz wyświetli się na końcu

    System.out.println();

    System.out.println("Koniec maina!");
  }
}