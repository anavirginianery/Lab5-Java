package documin.Elemento;
import java.util.Map;
import java.util.HashMap;

/**
 * Representação abstrata de um elemento, contendo valor e prioridade.
 */
public abstract class Elemento implements ElementoI{
    /**
     * Prioridade do elemento.
     */
    protected int prioridade;
    /**
     * Corpo de texto do elemento.
     */
    protected String valor;
    /**
     * Mapa contendo as propriedades do elemento.
     */
    protected Map<String,String> propriedades;
    
    /**
     * Construtor do elemento inicializando os atributos.
     * @param prioridade Prioridade do elemento.
     * @param valor Corpo de texto do elemento.
     */
    public Elemento(int prioridade, String valor){
        this.prioridade = prioridade;
        this.valor = valor;
        this.propriedades = new HashMap<> ();
    }
}
