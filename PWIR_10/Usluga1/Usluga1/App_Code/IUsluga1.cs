using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

// UWAGA: możesz użyć polecenia „Zmień nazwę” w menu „Refaktoryzuj”, aby zmienić nazwę interfejsu „IUsluga1” w kodzie i pliku konfiguracji.
[ServiceContract]
public interface IUsluga1
{
    [OperationContract]
    int Dodawanie(int a, int b);
    [OperationContract]
    int Mnozenie(int a, int b);
    
    
}
