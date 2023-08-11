package documin.Elemento;

/**
 * Representação de um elemento lista do tipo elemento, que inclui também um tipo de separador e caractere.
 */

public class ElementoLista extends Elemento{
    /**
     * Construtor do elemento lista inicializando valor e prioridade dado a superclasse, além de armazenar suas propriedades no mapa.
     * @param valor Corpo de texto do elemento
     * @param prioridade Prioridade do elemento
     * @param separador Separador do valor.
     * @param caractere Caractere usado para listar o valor.
     */
    public ElementoLista(String valor,int prioridade, String separador, String caractere){
        super(prioridade, valor);
        super.propriedades.put("separador", separador);
        super.propriedades.put("caractere", caractere);
    }
    
    /**
     * Retorna a representação textual do elemento.
     * @return representação textual do elemento.
     */
    @Override
    public String toString() {
        return representacaoResumida ();
    }
    
    /**
     * Retorna a representação completa do elemento, dado separador e caractere.
     * @return a representação completa do elemento, dado separador e caractere.
     */
    @Override
    public String representacaoCompleta(){
        String sep = propriedades.get("separador");
        String car = propriedades.get("caractere");
        String saida = car + " " + valor.replace (sep, "\n"+car);
        return saida.trim();
    }
    
    /**
     * Retorna a representação resumida do elemento.
     * @return representaçãoi resumida do elemento.
     */
    @Override
    public String representacaoResumida(){
        return super.valor;
    }
    
    @Override
    public int getPrioridade() {
        return prioridade;
    }
}
