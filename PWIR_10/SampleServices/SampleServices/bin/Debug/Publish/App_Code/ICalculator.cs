using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

// UWAGA: możesz użyć polecenia „Zmień nazwę” w menu „Refaktoryzuj”, aby zmienić nazwę interfejsu „ICalculator” w kodzie i pliku konfiguracji.
[ServiceContract]
public interface ICalculator
{
	[OperationContract]
	void DoWork();

	[OperationContract]
	int ADD(int a, int b);
}
