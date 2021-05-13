using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

// UWAGA: możesz użyć polecenia „Zmień nazwę” w menu „Refaktoryzuj”, aby zmienić nazwę klasy „Calculator” w kodzie, usłudze i pliku konfiguracji.
public class Calculator : ICalculator
{
    public void DoWork()
    {
    }

    public int ADD(int a, int b)
    {
        return a + b;
    }
}
