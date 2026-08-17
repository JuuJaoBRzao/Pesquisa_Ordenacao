using System.Collections.Generic;

public static class Ordenacao
{
    public static ResultadoOrdenacao Bolha(List<int> lista)
    {
        bool houveTroca;
        int tmp;
        ResultadoOrdenacao resultado = new ResultadoOrdenacao();

        do
        {
            houveTroca = false;
            for (int i = 0; i < lista.Count - 1; i++)
            {
                resultado.QtdComparacoes++;
                if (lista[i] > lista[i + 1])
                {
                    resultado.QtdTrocas++;
                    houveTroca = true;
                    tmp = lista[i];
                    lista[i] = lista[i + 1];
                    lista[i + 1] = tmp;
                }
            }
        } while (houveTroca);

        return resultado;
    }

    public static ResultadoOrdenacao Selecao(List<int> lista)
    {
        int posMenor;
        int tmp;
        ResultadoOrdenacao resultado = new ResultadoOrdenacao();

        for (int i = 0; i < lista.Count - 1; i++)
        {
            posMenor = i;
            for (int j = i + 1; j < lista.Count; j++)
            {
                resultado.QtdComparacoes++;
                if (lista[j] < lista[posMenor])
                {
                    posMenor = j;
                }
            }
            if (i != posMenor)
            {
                resultado.QtdTrocas++;
                tmp = lista[i];
                lista[i] = lista[posMenor];
                lista[posMenor] = tmp;
            }
        }

        return resultado;
    }

    public static ResultadoOrdenacao Insercao(List<int> lista)
    {
        int i, j;
        int tmp;
        ResultadoOrdenacao resultado = new ResultadoOrdenacao();

        for (i = 1; i < lista.Count; i++)
        {
            tmp = lista[i];
            for (j = i - 1; j >= 0; j--)
            {
                resultado.QtdComparacoes++;
                if (tmp < lista[j])
                {
                    lista[j + 1] = lista[j]; //shift eh trocar para o lado
                    resultado.QtdTrocas++;
                }
                else break;
            }
            lista[j + 1] = tmp;
            resultado.QtdTrocas++;
        }

        return resultado;
    }

    public static ResultadoOrdenacao Agitacao(List<int> lista)
    {
        bool houveTroca;
        int tmp;
        int inicio = 0;
        int fim = lista.Count - 1;
        ResultadoOrdenacao resultado = new ResultadoOrdenacao();

        do
        {
            houveTroca = false;

            for (int i = inicio; i < fim; i++)
            {
                resultado.QtdComparacoes++;
                if (lista[i] > lista[i + 1])
                {
                    tmp = lista[i];
                    lista[i] = lista[i + 1];
                    lista[i + 1] = tmp;
                    resultado.QtdTrocas++;
                    houveTroca = true;
                }
            }
            fim--;

            if (!houveTroca) break;
            houveTroca = false;

            for (int i = fim; i > inicio; i--)
            {
                resultado.QtdComparacoes++;
                if (lista[i] < lista[i - 1])
                {
                    tmp = lista[i];
                    lista[i] = lista[i - 1];
                    lista[i - 1] = tmp;
                    resultado.QtdTrocas++;
                    houveTroca = true;
                }
            }
            inicio++;

        } while (houveTroca);

        return resultado;
    }
}
