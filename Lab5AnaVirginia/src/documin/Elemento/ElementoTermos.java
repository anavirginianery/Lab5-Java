package documin.Elemento;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Representação de um elemento termos do tipo elemento, contendo separador e ordem para representação
 */
public class ElementoTermos extends Elemento{
    /**
     * Construtor do elemento termos inicializando valor e prioridade dado a superclasse, além de armazenar suas propriedades no mapa.
     * @param valor Corpo de texto do elemento.
     * @param prioridade Prioridade do elemento
     * @param separador Separador do valor
     * @param ordem Ordem a ser utilizada para organizar o valor
     */
    public ElementoTermos(String valor, int prioridade, String separador, String ordem){
        super(prioridade, valor);
        propriedades.put("separador",separador);
        propriedades.put("ordem",ordem);
    }
    /**
     * Retorna a representação completa do elemento, dado separador e ordem.
     * @return a representação completa do elemento, dado separador e ordem.
     */
    @Override
    public String representacaoCompleta(){
        String sep = propriedades.get("separador");
        String[] lista = valor.split("\\s*"+sep+"\\s*");
        String saida = "Total termos: " + lista.length + "\n- ";
        switch (propriedades.get ("ordem")) {
            case "ALFABÉTICA":
                Arrays.sort (lista, String.CASE_INSENSITIVE_ORDER);
                saida += String.join (", ", lista);
                break;
            case "TAMANHO":
                Arrays.sort (lista, Comparator.comparingInt (String::length).reversed ());
                saida += String.join (", ", lista);
                break;
            case "NENHUM":
                saida += String.join (", ", lista);
                break;
        }
        return saida;
    }
    /**
     * Retorna a representação resumida do elemento, dado separador e caractere.
     * @return a representação resumida do elemento, dado separador e caractere.
     */
    @Override
    public String representacaoResumida(){
        String separador = propriedades.get ("separador");
        String[] lista = valor.split("\\s*"+separador+"\\s*");
        String saida = "";
        switch (propriedades.get ("ordem")) {
            case "ALFABÉTICA":
                Arrays.sort (lista, String.CASE_INSENSITIVE_ORDER);
                saida += String.join (" "+separador+" ", lista);
                break;
            case "TAMANHO":
                Arrays.sort (lista, Comparator.comparingInt (String::length).reversed ());
                saida += String.join (" "+separador+" ", lista);
                break;
            case "NENHUM":
                saida += String.join (" "+separador+" ", lista);
                break;
        }
        return saida;
    }
    /**
     * Retorna a representação textual do elemento.
     * @return representação textual do elemento.
     */
    @Override
    public String toString() {
        return representacaoResumida ();
    }
    @Override
    public int getPrioridade() {
        return prioridade;
    }
}
