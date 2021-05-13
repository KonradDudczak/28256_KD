using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

// UWAGA: możesz użyć polecenia „Zmień nazwę” w menu „Refaktoryzuj”, aby zmienić nazwę klasy „PiLeibniz” w kodzie, usłudze i pliku konfiguracji.
public class PiLeibniz : IPiLeibniz
{
    public void DoWork()
    {
    }

    public double CalculatePi(int accuracy)
    {
        double tmp = 0.0, a_n;
        long i, N;

        N = accuracy;

        for (i = 0; i < N; i++)
        {
            if (i % 2 == 0)
            {
                a_n = (double)(1.0 / (2.0 * i + 1.0));
            }
            else
            {
                a_n = (double)(-1.0 / (2.0 * i + 1.0));
            }

            tmp = tmp + a_n;
        }

        return (double)(4.0 * tmp);
    }
}
