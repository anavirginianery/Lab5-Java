package documin.Visao;

import documin.Documento.Documento;
import documin.Elemento.Elemento;
import documin.Elemento.ElementoI;

import java.util.ArrayList;
/**
 * Representação de uma visão resumida de um documento.
 */
public class VisaoResumida implements VisaoI{
    /**
     * Array contendo a representação completa de cada elemento do documento.
     */
    private String[] visaoResumida;
    
    /**
     * Construtor da visão resumida dado o documento parametrado, incializando e adicionando a representação resumida
     * dos elementos do documento.
     * @param doc Documento a ser feita a visão.
     */
    public VisaoResumida(Documento doc) {
        ArrayList<ElementoI> listaElementos = doc.getElementos ();
        String[] visao = new String[listaElementos.size ()];
        for (int i = 0; i < listaElementos.size (); i++) {
            visao[i] = listaElementos.get (i).representacaoResumida ();
        }
        this.visaoResumida = visao;
    }
    /**
     * Retorna a visão resumida.
     * @return visão resumida do documento.
     */
    public String[] exibeVisao(){
        return visaoResumida.clone ();
    }
}
