package documin.Visao;

import documin.Documento.Documento;
import documin.Elemento.Elemento;
import documin.Elemento.ElementoI;

import java.util.ArrayList;

/**
 * Representação de uma visão completa de um documento.
 */
public class VisaoCompleta implements VisaoI {
    /**
     * Array contendo a representação completa de cada elemento do documento.
     */
    private String[] visaoCompleta;
    
    /**
     * Construtor da visão completa dado o documento parametrado, iniciando e adicionando as representações completas no array.
     * @param doc Documento a ser feita a visão
     */
    public VisaoCompleta(Documento doc) {
        ArrayList<ElementoI> listaElementos = doc.getElementos ();
        String[] visao = new String[listaElementos.size ()];
        for (int i = 0; i < listaElementos.size (); i++) {
            visao[i] = listaElementos.get (i).representacaoCompleta ();
        }
        this.visaoCompleta = visao;
    }
    
    /**
     * Retorna a visão completa.
     * @return visão completa do documento.
     */
    public String[] exibeVisao(){
        return visaoCompleta.clone ();
    }
}
