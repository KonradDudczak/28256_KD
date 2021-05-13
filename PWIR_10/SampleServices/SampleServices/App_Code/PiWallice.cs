using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

// UWAGA: możesz użyć polecenia „Zmień nazwę” w menu „Refaktoryzuj”, aby zmienić nazwę klasy „PiWallice” w kodzie, usłudze i pliku konfiguracji.
public class PiWallice : IPiWallice
{
    public void DoWork()
    {
    }

    public double CalculatePi(int accuracy)
    {
        double temp = 1.0;

        double tmp = 1.0, a_n;
        long i, N;

        N = accuracy;

        for (i = 1; i <= N; i++)
        {
            a_n = (double)(4.0 * i * i / (4.0 * i * i - 1.0));
            tmp = tmp * a_n;
        }

        return (double)(2.0 * tmp);
    }
}
