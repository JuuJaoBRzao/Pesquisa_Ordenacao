import java.util.ArrayList;
import java.util.List;
 
public class TesteBolha {
 
    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        lista.add(5);
        lista.add(2);
        lista.add(9);
        lista.add(1);
        lista.add(5);
        lista.add(6);
 
        System.out.println("Antes: " + lista);
 
        bolha(lista);
 
        System.out.println("Depois: " + lista);
    }

    static void bolha(List<Integer> lista){
        boolean houveTroca;
        int tmp;
        int qtdComparacoes = 0;
        int qtdTrocas = 0;

        do{
            houveTroca = false;
            for(int i = 0; i < lista.size() - 1; i++){
                qtdComparacoes++;
                if (lista.get(i) > lista.get(i + 1)){
                    qtdTrocas++;
                    houveTroca = true;
                    tmp = lista.get(i);
                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, tmp);
                }
            }
            System.out.println("Passada: " + lista);
            
        } while (houveTroca);
        
        System.out.println("Comparações: " + qtdComparacoes);
        System.out.println("Trocas: " + qtdTrocas);

    }
}
