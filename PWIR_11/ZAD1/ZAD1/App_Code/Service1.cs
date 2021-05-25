using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

// UWAGA: możesz użyć polecenia „Zmień nazwę” w menu „Refaktoryzuj”, aby zmienić nazwę klasy „Service1” w kodzie, usłudze i pliku konfiguracji.
public class Service1 : IService1
{
    public void DoWork()
    {
    }

    public int Fibonacci(int f)
    {
        if (!(f is int) || f < 0)
        {
            //znak błędu nie ma takiej liczby ciagu fibonacciego
            return 10;

        }
        else
        {
            if (f == 0 || f == 1)
            {
                return f;
            }

            else
            {
                return Fibonacci(f - 1) + Fibonacci(f - 2);
            }
        }
    }

    public int Silnia(int n)
    {
        if (!(n is int) || n < 0)
        {
            //znak błędu 
            return 0;

        }

        else
        {
            if (n == 0 || n == 1)
            {
                return 1;
            }

            else
            {
                return n * Silnia(n - 1);
            }
        }
    }

    public double Prostokat(double a, double b)
    {
        if (a <= 0 || b <= 0)
        {
            // jako błąd
            return 0;
        }


        else { return a * b; }
    }

    public string Trojkat(double a, double b, double c)
    {
        
        
        if (a<=0 || b<=0 || c <= 0)
        {
            return "Nieprawidłowa długość boków";
        }

        else
        {
            if (a + b > c && a + c > b && b + c > a)
            {
                return "Z podanych boków można zbudować trójkąt";
            }

            else
            {
                return "Z podanych boków nie można zbudować trójąta";
            }

        }

        
        
    }
}


