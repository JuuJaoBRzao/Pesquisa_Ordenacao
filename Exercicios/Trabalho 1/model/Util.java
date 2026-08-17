using System;
using System.Collections.Generic;

public static class Util
{
    public static void PopularLista(List<int> lista, int quantidade)
    {
        Random gerador = new Random();
        for (int i = 0; i < quantidade; i++)
        {
            lista.Add(gerador.Next(100000));
        }
    }

    public static List<int> ClonarLista(List<int> lista)
    {
        return new List<int>(lista);
    }
}
