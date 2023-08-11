package documin.Elemento;

import documin.Documento.Documento;

/**
 * Representação de um elemento do tipo atalho, que faz referencia a um documento.
 */

public class Atalho extends Elemento {
    /**
     * Construtor do elemento atalho inicializando valor e prioridade dado a superclasse, além de armazenar suas propriedades no mapa.
     * @param documento Documento referenciado
     */
    public Atalho(Documento documento){
        super(documento.mediaPrioridades (), documento.getTitulo ());
        propriedades.put ("COMPLETA", documento.representacaoCompletaAtalho ());
        propriedades.put ("RESUMIDA", documento.representacaoResumidaAtalho ());
    }
    
    /**
     * Pega e retorna a representação completa do elemento.
     * @return representação completa do elemento
     */
    @Override
    public String representacaoCompleta(){
        return propriedades.get ("COMPLETA");
    }
    
    /**
     * Pega e retorna a representação resumida do elemento.
     * @return representação resumida do elemento.
     */
    @Override
    public String representacaoResumida(){
        return propriedades.get ("RESUMIDA");
    }
    
    /**
     * Retorna a representação textual do elemento
     * @return representação textual do elemento
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
