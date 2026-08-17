using System;
using System.Collections.Generic;

public static class View
{
    public static int LerQuantidade()
    {
        Console.Write("Quantos números deseja trabalhar? ");
        return int.Parse(Console.ReadLine());
    }

    public static void ExibirResultado(string nomeAlgoritmo, ResultadoOrdenacao resultado)
    {
        Console.WriteLine("--- " + nomeAlgoritmo + " ---");
        Console.WriteLine("Quantidade comparações: " + resultado.QtdComparacoes);
        Console.WriteLine("Quantidade trocas: " + resultado.QtdTrocas);
        Console.WriteLine("Tempo (ms): " + resultado.TempoMs);
        Console.WriteLine();
    }

    public static void ExibirLista(List<int> lista)
    {
        foreach (int item in lista)
        {
            Console.WriteLine(item);
        }
    }

    public static void ExibirErro(string mensagem)
    {
        Console.WriteLine(mensagem);
    }
}
