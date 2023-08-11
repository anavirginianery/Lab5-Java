package documin.Elemento;

/**
 * Representação de um elemento titulo, um tipo de elemento, contendo nivel e linkavel.
 */
public class ElementoTitulo extends Elemento {
    /**
     * Construtor do elemento titulo incializando valor e prioridade dado a super classe, alem de armazenar suas prioridades no mapa.
     * @param valor Corpo de texto do elemento
     * @param prioridade Prioiridade do elemento
     * @param nivel NIvel do corpo de texto
     * @param linkavel Booleano que diz se o elemento é linkavel ou não.
     */
    public ElementoTitulo(String valor, int prioridade, int nivel, boolean linkavel){
        super(prioridade,valor);
        super.propriedades.put("nivel", String.valueOf(nivel));
        super.propriedades.put("linkavel", String.valueOf(linkavel));
    }
    
    /**
     * REtorna a representação completa do elemento.
     * @return representação completa do elemento.
     */
    @Override
    public String representacaoCompleta(){
        String saida = propriedades.get("nivel")+ ". " +super.valor;
        if (Boolean.parseBoolean (propriedades.get("linkavel"))){
            saida += " -- \n"+ propriedades.get("nivel") +"-"+super.valor.toUpperCase().replaceAll("\\s+","");
        }
        return saida;
    }
    
    /**
     * Retorna a representação resumida do elemento.
     * @return representação resumida do elemento.
     */
    @Override
    public String representacaoResumida(){
        return propriedades.get("nivel") + ". " + super.valor;
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
