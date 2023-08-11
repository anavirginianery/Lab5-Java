package documin.Visao;

import documin.Documento.Documento;
import documin.Elemento.Elemento;
import documin.Elemento.ElementoI;

import java.util.ArrayList;
/**
 * Representação de uma visão prioritária de um documento.
 */
public class VisaoPrioritaria implements VisaoI{
    /**
     * Array contendo a representação completa de cada elemento do documento.
     */
    private String[] visaoPrioritaria;
    
    /**
     * Construtor da visão prioritária dado o documento parametrado e a prioridade minima.
     * @param doc Documento a ser feita a visão.
     * @param prioridade Prioridade minima da visão
     */
    public VisaoPrioritaria(Documento doc, int prioridade) {
        ArrayList<ElementoI> listaElementos = doc.getElementos ();
        int cont = 0;
        for (ElementoI e : listaElementos){
            if (e.getPrioridade () >= prioridade){
                cont++;
            }
        }
        String[] visao = new String[cont];
        int index = 0;
        for (ElementoI el : listaElementos) {
            if (el.getPrioridade () >= prioridade) {
                visao[index] = el.representacaoCompleta ();
                index++;
            }
        }
        this.visaoPrioritaria = visao;
    }
    /**
     * Retorna a visão prioritária.
     * @return visão prioritária do documento.
     */
    public String[] exibeVisao(){
        return visaoPrioritaria.clone ();
    }
}
