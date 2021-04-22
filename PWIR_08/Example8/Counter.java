package Example8;

import java.util.concurrent.Callable;

class Counter implements Callable<Integer> {

  

  public Integer call() {
    for (int i = 0; i < Wykonawca.size; i++) {
      Wykonawca.result[Wykonawca.current_row_index] += Wykonawca.matrix[Wykonawca.current_row_index][i]
          * Wykonawca.vector[i];

          
    }

    return 0;
  }
}