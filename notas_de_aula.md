# Aula 6 - 13/08/2026
- Revisão dos conceitos vistos na última aula
** Atividade **:
  Organizar código seguinte em MVC:
  '''C#
  using System;
using System.Collections.Generic;
using System.Diagnostics;
class Ordenacao
{

    public static void agitacao(List<int> lista)
    {
        bool houveTroca;
        int tmp;
        int ini = 0;
        int fim = lista.Count;
        int qtdComparacoes = 0, qtdTrocas = 0;  //avalia a complexidade ou o esforço

        do
        {
            houveTroca = false;
            for (int i = ini; i < fim - 1; i++)
            {
                qtdComparacoes++;
                if (lista[i] > lista[i + 1])
                {
                    qtdTrocas++;
                    houveTroca = true;
                    tmp = lista[i];
                    lista[i] = lista[i + 1];
                    lista[i + 1] = tmp;
                }
            }

            if (!houveTroca)
            {
                break;
            }
            fim--;

            houveTroca = false;
            for (int i = fim; i >= ini + 1; i--)
            {
                qtdComparacoes++;
                if (lista[i] < lista[i - 1])
                {
                    qtdTrocas++;
                    houveTroca = true;
                    tmp = lista[i];
                    lista[i] = lista[i - 1];
                    lista[i - 1] = tmp;
                }
            }
            ini++;

        } while (houveTroca);
    }
}

class Util
{
    public static void popular(List<int> lista, int quantidade)
    {
        Random gerador = new Random();
        for (int i = 0; i < quantidade; i++)
        {
            lista.Add(gerador.Next(100000));
        }

    }

    public static void exibir(List<int> lista)
    {
        foreach (var item in lista)
        {
            Console.WriteLine(item.ToString());
        }
    }

    public static void exibirTempo(Stopwatch sw, string frase)
    {
        Console.WriteLine(frase + " (ms): " + sw.ElapsedMilliseconds);
    }
}

public class Principal()
{
    public static void Main(string[] args)
    {
        
        List<int> listaAgitacao = new List<int>();      
        List<int> listaSort = new List<int>();
        Util.popular(listaAgitacao, 100000);
        Util.popular(listaSort, 100000);

        Stopwatch sw = new Stopwatch();

        sw.Start();
        Ordenacao.agitacao(listaAgitacao);
        sw.Stop();
        Util.exibirTempo(sw, "Ordenacao por agitacao");        
        sw.Reset();

        sw.Start();
        listaSort.Sort();
        sw.Stop();
        Util.exibirTempo(sw, "Ordenacao por sort nativo");
        sw.Reset();


        //Util.exibir(lista);
    }
}
''''

# Aula 5 - 10/08/2026
**Bolha**
  - Simples (memoria RAM)
  - Estável
  - 0 (n²)
  - A ideia da bolha é pq o maior valor em cada "pesado" é levado até o final da estrutura
 
**Seleção**
  - Simples
  - 0 (n²)
  - Instável
  - A ideia da seleção é pq a cada célula de vetor, ao avançar, se seleciona (ou laça) o menor valor para aquela posição

**Inserção**
  - Simples (memoria RAM)
  - Estável
  - 0 (n²)
  - A ideia da inserção é pq cada vetor da porção direita da estrutura é inserido na sua posição correta na porção esquerda

# Aula 4 - 06/08/2026
- Padrão de Desenvolvimento
  - Ideia de MVC
  - Documentação
- Medir tempo de ordenação:
(https://github.com/JuuJaoBRzao/Pesquisa_Ordenacao/tree/main/Exercicios/Exercicio%201)

# Aula 3 - 03/08/2026

- Padrão Arquitetural: dividem o código entre camadas
  - MVC (Model View Controller):
   (https://github.com/alexandrezamberlan/estruturasDeDados/tree/master/00%20-%20anosAnteriores/exemploJava_usoLista_MVC)

<img width="748" height="552" alt="image" src="https://github.com/user-attachments/assets/70b1a101-fa0d-459f-9288-02d7485b7d1a" />

- Critérios de Categorização

* **Memória Interna vs. Externa:** 
  * **Interna:** Ocorre inteiramente na RAM (o vetor cabe na memória principal).
  * **Externa:** Utilizada para grandes volumes de dados que não cabem na RAM, recorrendo ao disco/SSD.
* **Estabilidade:**
  * **Estável:** Preserva a ordem relativa de elementos com chaves/valores iguais.
  * **Instável:** Não garante a preservação da ordem relativa de elementos iguais.
* **Complexidade:** Expressa pela notação Big-O no pior caso (ou caso médio padrão).
* **Porção Ordenada:** Indica onde a sublista ordenada é construída durante a execução (Início, Final, etc.).

---

- Tabela Geral

| Algoritmo | Memória | Estabilidade | Complexidade (Pior Caso) | Porção Ordenada |
| :--- | :---: | :---: | :---: | :---: |
| **Bubble Sort (Bolha)** | Interna | Estável | $\mathcal{O}(n^2)$ | Final |
| **Selection Sort (Seleção)** | Interna | Instável | $\mathcal{O}(n^2)$ | Início |
| **Insertion Sort (Inserção)** | Interna | Estável | $\mathcal{O}(n^2)$ | Início |
| **Comb Sort (Pente)** | Interna | Instável | $\mathcal{O}(n^2)$ | Final |
| **Cocktail Sort (Agitação)** | Interna | Estável | $\mathcal{O}(n^2)$ | Início e Final |
| **Shell Sort** | Interna | Instável | $\mathcal{O}(n^2)$ / $\mathcal{O}(n \log^2 n)$ | Espalhada (Gaps) |
| **Bucket Sort (Balde)** | Interna / Externa | Estável* | $\mathcal{O}(n^2)$ / $\mathcal{O}(n + k)$ | Baldes locais |
| **Radix Sort** | Interna | Estável | $\mathcal{O}(n \cdot k)$ | Posição dos dígitos |
| **Heap Sort** | Interna | Instável | $\mathcal{O}(n \log n)$ | Final |
| **Merge Sort** | Interna / Externa | Estável | $\mathcal{O}(n \log n)$ | Dividir e Conquistar |
| **Quick Sort** | Interna | Instável | $\mathcal{O}(n^2)$ | Em torno do Pivô |

- Detalhamento por Algoritmo

 1. Bubble Sort (Bolha)
  * **Memória:** Interna
  * **Estabilidade:** Estável
  * **Complexidade:** $\mathcal{O}(n^2)$
  * **Porção Ordenada:** Final (os maiores elementos "flutuam" até o fim)

 2. Selection Sort (Seleção)
  * **Memória:** Interna
  * **Estabilidade:** Instável
  * **Complexidade:** $\mathcal{O}(n^2)$
  * **Porção Ordenada:** Início (encontra o menor elemento e o coloca na posição correta)
  
 3. Insertion Sort (Inserção)
  * **Memória:** Interna
  * **Estabilidade:** Estável
  * **Complexidade:** $\mathcal{O}(n^2)$
  * **Porção Ordenada:** Início (insere cada elemento na sua posição relativa correta)
  
 4. Comb Sort (Pente)
  * **Memória:** Interna
  * **Estabilidade:** Instável
  * **Complexidade:** $\mathcal{O}(n^2)$ no pior caso ($\mathcal{O}(n \log n)$ no caso médio)
  * **Porção Ordenada:** Final (evolução do Bubble Sort usando um intervalo variável de comparação)
  
 5. Cocktail Sort / Shakesort (Agitação)
  * **Memória:** Interna
  * **Estabilidade:** Estável
  * **Complexidade:** $\mathcal{O}(n^2)$
  * **Porção Ordenada:** Início e Final (Bubble Sort bidirecional)
  
 6. Shell Sort
  * **Memória:** Interna
  * **Estabilidade:** Instável
  * **Complexidade:** Varia com a sequência de *gaps* — $\mathcal{O}(n^2)$ no pior caso clássico, podendo chegar a $\mathcal{O}(n^{1.3})$ ou $\mathcal{O}(n \log^2 n)$
  * **Porção Ordenada:** Espalhada (aplica Inserção em elementos espaçados por um intervalo/gap)
  
 7. Bucket Sort (Balde)
  * **Memória:** Interna (pode ser adaptado para Externa)
  * **Estabilidade:** Estável (se o algoritmo interno utilizado nos baldes for estável)
  * **Complexidade:** $\mathcal{O}(n + k)$ no caso médio, $\mathcal{O}(n^2)$ no pior caso
  * **Porção Ordenada:** Distribuída em baldes independentes
  
 8. Radix Sort
  * **Memória:** Interna
  * **Estabilidade:** Estável
  * **Complexidade:** $\mathcal{O}(n \cdot k)$, onde $k$ é o número de dígitos/caracteres
  * **Porção Ordenada:** Processada dígito por dígito (do menos significativo para o mais significativo, ou vice-versa)
  
 9. Heap Sort
  * **Memória:** Interna
  * **Estabilidade:** Instável
  * **Complexidade:** $\mathcal{O}(n \log n)$
  * **Porção Ordenada:** Final (utiliza uma estrutura de árvore *Heap* para extrair repetidamente o maior elemento)
  
 10. Merge Sort
  * **Memória:** Interna / Externa (muito utilizado em ordenação externa pela facilidade de intercalar)
  * **Estabilidade:** Estável
  * **Complexidade:** $\mathcal{O}(n \log n)$
  * **Porção Ordenada:** Dividir e Conquistar (intercala sublistas previamente ordenadas)
  
 11. Quick Sort
  * **Memória:** Interna
  * **Estabilidade:** Instável
  * **Complexidade:** $\mathcal{O}(n \log n)$ no caso médio, $\mathcal{O}(n^2)$ no pior caso
  * **Porção Ordenada:** Em torno do Pivô (elementos menores à esquerda, maiores à direita)


# Aula 2 - 30/07/2026

- ordenação: velocidade na pesquisa, organizar dados; otimizar a busca através de índices ou chaves
  - quantidade de comparações + quantidade de trocas = complexidade da ordenação
- pesquisa (SEARCH/FIND): localizar um dado dentro de alguma estrutura utilizando alguma chave
  - apenas a quantidade de comparações = complexidade
- recuperar (RETRIEVE): localizar ou buscar dados om relevância (semântica ou significado)

- complexidade de um algoritmo: esforço computacional de algum algoritmo, ou seja, quanto de recurso ele aloca para realizar suas tarefas
  - alta complexidade: mais esforço
  - baixa complexidade: menos esforço
  
- notação Big O:
  - O (n!) = fatorial        -maior complexidade
  - O (n ^ x) = exponencial
  - O (log n + n) = (tambem logaritmico)
  - O (n) = linear (pode ser usado o BUBBLE SORT para esse tipo de comparação)
  - O (log n) = logaritmico        -menor complexidade


# Aula 1 - 27/07/2026

- Introdução da matéria: Professor introduziu os elementos básicos da matéria, conceitos e discutimos sobre vários programas e aplicativos que têm relevância com a matéria.
- Explicação sobre o funcionamento das notas desse semestre.
- Complexidade: esforço computacional, se o algoritmo faz muito esforço é ruim

- Conceitos Principais: SORT, SELECT, BUBBLE, INSERT
- Outros Conceitos: Agitação, Shell, Pente (COMB_SORT), Radix, Bucket
