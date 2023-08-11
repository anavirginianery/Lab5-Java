package documin.Visao;

import documin.Documento.Documento;
import documin.Elemento.Elemento;
import documin.Elemento.ElementoI;
import documin.Elemento.ElementoTitulo;

import java.util.ArrayList;
/**
 * Representação de uma visão titulo de um documento.
 */
public class VisaoTitulo implements VisaoI{
    /**
     * Array contendo a representação completa de cada elemento do documento.
     */
    private String[] visaoTitulo;
    
    /**
     * Construtor da visão titulo dado o documento parametrado, incializando e adicionando a representação
     * resumida dos elementos titulo ao array.
     * @param doc Documento a ser feita a visão
     */
    public VisaoTitulo(Documento doc) {
        ArrayList<ElementoI> listaElementos = doc.getElementos ();
        int cont = 0;
        for (ElementoI e : listaElementos){
            if (e instanceof ElementoTitulo){
                cont++;
            }
        }
        String[] visao = new String[cont];
        int index = 0;
        for (ElementoI el : listaElementos) {
            if (el instanceof ElementoTitulo) {
                visao[index] = el.representacaoResumida ();
                index++;
            }
        }
        this.visaoTitulo = visao;
    }
    /**
     * Retorna a visão titulo.
     * @return visão titulo do documento.
     */
    public String[] exibeVisao(){
        return visaoTitulo.clone ();
    }
}
