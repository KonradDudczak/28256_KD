package Example8;

import java.util.concurrent.Callable;

class Counter implements Callable<Integer> {

  private int current_row_index = 0;

  Counter(int i) {
    this.current_row_index = i;
  }

  public Integer call() {
    for (int i = 0; i < Wykonawca.size; i++) {
      Wykonawca.result[current_row_index] += Wykonawca.matrix[current_row_index][i] * Wykonawca.vector[i];

    }

    return 0;
  }
}