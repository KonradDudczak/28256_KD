package Example7;

import java.util.concurrent.Callable;

class TaskW implements Callable<Double> {
  private long ACCURACY = 1;

  public void Calculate(long acc){
    ACCURACY = acc;
  }
  //Metoda Wallis'a
  public Double call() {
    double tmp = 1.0, a_n;
    long i, N;

    N = ACCURACY;

    for (i = 1; i <= N; i++) {
        a_n = (double)(4.0*i*i / (4.0*i*i - 1.0));
        tmp = tmp * a_n;
    }

    return (double)(2.0 * tmp);
  }
}