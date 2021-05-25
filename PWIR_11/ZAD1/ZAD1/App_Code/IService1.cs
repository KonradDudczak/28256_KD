using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

// UWAGA: możesz użyć polecenia „Zmień nazwę” w menu „Refaktoryzuj”, aby zmienić nazwę interfejsu „IService1” w kodzie i pliku konfiguracji.
[ServiceContract]
public interface IService1
{
    [OperationContract]
    void DoWork();

    [OperationContract]
    int Fibonacci(int f);

    [OperationContract]
    int Silnia(int n);

    [OperationContract]
    double Prostokat(double a, double b);

    [OperationContract]
    string Trojkat(double a, double b, double c);
   
}
