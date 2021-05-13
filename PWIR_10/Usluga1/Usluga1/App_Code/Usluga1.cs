using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

// UWAGA: możesz użyć polecenia „Zmień nazwę” w menu „Refaktoryzuj”, aby zmienić nazwę klasy „Usluga1” w kodzie, usłudze i pliku konfiguracji.
public class Usluga1 : IUsluga1
{
    
    public int Dodawanie(int a, int b)
    {
        return a + b;
    }

    
    public int Mnozenie(int a, int b)
    {
        return a * b;
    }
}
