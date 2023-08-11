package documin.Visao;

/**
 * Interface de contrato com as classes visões, para exibição.
 */
public interface VisaoI {
    /**
     * Retorna a visão de um documento
     * @return um array contendo a visão do documento, uma representação dos elementos.
     */
    String[] exibeVisao();
}
