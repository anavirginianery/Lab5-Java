package documin.Elemento;

/**
 * Interface de contrato de um elemento.
 */
public interface ElementoI {
    /**
     * Representação textual de um elemento
     * @return uma String de uma representação textual de um elemento
     */
    String toString();
    /**
     * Representação completa de um elemento
     * @return uma String de uma representação completa de um elemento
     */
    String representacaoCompleta();
    /**
     * Representação resumida de um elemento
     * @return uma String de uma representação resumida de um elemento
     */
    String representacaoResumida();
    /**
     * Retorna a prioridade um elemento.
     * @return prioridade do elemento
     */
    int getPrioridade();
}
