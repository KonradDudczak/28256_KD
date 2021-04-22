package Example7;

import java.util.concurrent.Callable;

class TaskL implements Callable<Double> {
  private long ACCURACY = 1;

  public void Calculate(long acc){
    ACCURACY = acc;
  }
  //Metoda Leibniza
  public Double call() {
    double tmp = 0.0, a_n;
    long i, N;

    N = ACCURACY; 

    for (i = 0; i < N; i++) {
        if (i % 2 == 0) {
            a_n = (double)(1.0 / (2.0*i + 1.0));
        } else {
            a_n = (double)(-1.0 / (2.0*i + 1.0));
        }

        tmp = tmp + a_n;
    }

    return (double)(4.0 * tmp);
  }
}