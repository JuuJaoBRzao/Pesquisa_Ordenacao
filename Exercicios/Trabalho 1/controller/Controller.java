using System;
using System.Collections.Generic;
using System.Diagnostics;

public class Controller
{
    public void Executar()
    {
        try
        {
            int quantidade = View.LerQuantidade();

            List<int> listaOriginal = new List<int>();
            Util.PopularLista(listaOriginal, quantidade);

            List<int> listaSort = Util.ClonarLista(listaOriginal);
            List<int> listaBolha = Util.ClonarLista(listaOriginal);
            List<int> listaSelecao = Util.ClonarLista(listaOriginal);
            List<int> listaInsercao = Util.ClonarLista(listaOriginal);
            List<int> listaAgitacao = Util.ClonarLista(listaOriginal);

            Stopwatch sw = new Stopwatch();

            sw.Start();
            listaSort.Sort();
            sw.Stop();
            View.ExibirResultado("Sort nativo", new ResultadoOrdenacao { TempoMs = sw.ElapsedMilliseconds });
            sw.Reset();

            sw.Start();
            ResultadoOrdenacao resultadoBolha = Ordenacao.Bolha(listaBolha);
            sw.Stop();
            resultadoBolha.TempoMs = sw.ElapsedMilliseconds;
            View.ExibirResultado("Bolha", resultadoBolha);
            sw.Reset();

            sw.Start();
            ResultadoOrdenacao resultadoSelecao = Ordenacao.Selecao(listaSelecao);
            sw.Stop();
            resultadoSelecao.TempoMs = sw.ElapsedMilliseconds;
            View.ExibirResultado("Seleção", resultadoSelecao);
            sw.Reset();

            sw.Start();
            ResultadoOrdenacao resultadoInsercao = Ordenacao.Insercao(listaInsercao);
            sw.Stop();
            resultadoInsercao.TempoMs = sw.ElapsedMilliseconds;
            View.ExibirResultado("Inserção", resultadoInsercao);
            sw.Reset();

            sw.Start();
            ResultadoOrdenacao resultadoAgitacao = Ordenacao.Agitacao(listaAgitacao);
            sw.Stop();
            resultadoAgitacao.TempoMs = sw.ElapsedMilliseconds;
            View.ExibirResultado("Agitação", resultadoAgitacao);
            sw.Reset();
        }
        catch (Exception e)
        {
            View.ExibirErro(e.Message);
        }
    }
}
