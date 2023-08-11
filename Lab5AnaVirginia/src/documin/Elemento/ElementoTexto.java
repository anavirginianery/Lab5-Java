package documin.Elemento;

/**
 * Representação de um elemento texto, um tipo de elemento.
 */
public class ElementoTexto extends Elemento{
    /**
     * COnstrutor do elemento texto incializando valor e prioridade.
     * @param valor Corpo do texto.
     * @param prioridade Prioridade do elemento
     */
    public ElementoTexto(String valor, int prioridade){
        super(prioridade, valor);

    }
    
    /**
     * Retorna a representação completa do elemento.
     * @return representação completa do elemento
     */
    @Override
    public String representacaoCompleta(){
        return super.valor;
    }
    /**
     * Retorna a representação resumida do elemento.
     * @return representação resumida do elemento
     */
    @Override
    public String representacaoResumida(){
        return super.valor;
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
