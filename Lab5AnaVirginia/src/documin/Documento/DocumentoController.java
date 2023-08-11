package documin.Documento;

import documin.Visao.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Controlador dos métodos relacionados a documento, visão e elementos.
 */
public class DocumentoController {
    /**
     * Mapa de documentos e titulo do documento como chave.
     */
    private HashMap<String, Documento> documentos;
    /**
     * Coleção de visões dos documentos.
     */
    private ArrayList<VisaoI> visoes;
    /**
     * Posição das visões.
     */
    private int posicaoVisao;
    
    /**
     * Construtor da classe inicializando o mapa, a coleção e a variável de posição.
     */
    public DocumentoController(){
        this.documentos= new HashMap<> ();
        this.visoes = new ArrayList<> ();
        this.posicaoVisao = 0;
    }
    
    /**
     * Cria um documento passando como parâmetro o seu título.
     * @param titulo Titulo do documento
     * @return false, caso o mapa já contenha um documento com mesmo título, true, caso tenha sucesso o método.
     * @throws IllegalArgumentException caso seja um titulo inválido.
     */
    public boolean criaDocumento(String titulo){
        if (titulo.isBlank ()) { throw new IllegalArgumentException ("Título Inválido");}
        if (documentos.containsKey (titulo)) return false;
        Documento doc = new Documento (titulo);
        documentos.put (titulo, doc);
        return true;
    }
    /**
     * Cria um documento passando como parâmetro o seu título e o tamanho máximo
     * @param titulo Titulo do documento
     * @param tamanhoMaximo Quantidade máxima de elementos.
     * @return false, caso o mapa já contenha um documento com mesmo título, true, caso tenha sucesso o método.
     * @throws IllegalArgumentException caso seja um titulo ou um tamanho inválido.
     */
    public boolean criaDocumento(String titulo, int tamanhoMaximo){
        if (titulo.isBlank ()) { throw new IllegalArgumentException ("Título Inválido");}
        if (tamanhoMaximo <= 0) { throw new IllegalArgumentException ("Tamanho inválido"); }
        if (documentos.containsKey (titulo)) return false;
        Documento doc = new Documento (titulo, tamanhoMaximo);
        documentos.put (titulo, doc);
        return true;
    }
    
    /**
     * Remove cadastro do documento desejado.
     * @param titulo Titulo do documento a ser removido.
     * @throws IllegalArgumentException caso seja um titulo inválido.
     * @throws NoSuchElementException caso não tenha um documento com esse titulo.
     */
    public void removeDocumento(String titulo){
        if (titulo.isBlank ()) { throw new IllegalArgumentException ("Título Inválido");}
        if (documentos.get (titulo) == null) { throw new NoSuchElementException ("Documento não cadastrado");}
        documentos.remove (titulo);
    }
    
    /**
     * Conta a quantidade de elementos de um documento.
     * @param titulo Titulo do documento desejado
     * @return a quantidade de elementos do documento.
     * @throws IllegalArgumentException caso seja um titulo inválido.
     * @throws NoSuchElementException caso não tenha um documento com esse titulo.
     */
    public int contaElementos(String titulo){
        if (titulo.isBlank ()) { throw new IllegalArgumentException ("Título Inválido");}
        if (documentos.get (titulo) == null) { throw new NoSuchElementException ("Documento não cadastrado");}
        return documentos.get (titulo).getQuantidadeAtual();
    }
    
    /**
     * Exibe o documentos por um array de representações de cada elemento.
     * @param titulo Titulo do documento desejado
     * @return um array contendo a representação de cada elemento do documento.
     * @throws IllegalArgumentException caso seja um titulo inválido.
     * @throws NoSuchElementException caso não tenha um documento com esse titulo.
     */
    public String[] exibeDocumento(String titulo){
        if (titulo.isBlank ()) { throw new IllegalArgumentException ("Título Inválido");}
        if (documentos.get (titulo) == null) { throw new NoSuchElementException ("Documento não cadastrado");}
        return documentos.get (titulo).exibeDocumento ();
    }
    
    /**
     * Cria um elemento do tipo texto e o adiciona no documento passado.
     * @param tituloDoc Titulo do documento que sera adicionado o texto.
     * @param valor Corpo do elemento.
     * @param prioridade Prioridade do elemento
     * @return a posição do elemento no documento.
     * @throws IllegalArgumentException caso seja um titulo inválido.
     * @throws NoSuchElementException caso não tenha um documento com esse titulo.
     */
    public int criaTexto(String tituloDoc, String valor, int prioridade){
        if (tituloDoc.isBlank ()) { throw new IllegalArgumentException ("Título Inválido");}
        if (documentos.get (tituloDoc) == null) { throw new NoSuchElementException ("Documento não cadastrado");}
        return documentos.get (tituloDoc).criaTexto(valor,prioridade);
    }
    
    /**
     * Cria um elemento do tipo titulo e o adiciona no documento desejado.
     * @param tituloDoc Titulo do documento desejado.
     *
     * @param valor Corpo do elemento.
     * @param prioridade Prioridade do elemento
     * @param nivel Nivel do corpo do elemento
     * @param linkavel Se o elemento é linkavel ou não
     * @return a posição do elemetno no documento.
     * @throws IllegalArgumentException caso seja um titulo inválido.
     * @throws NoSuchElementException caso não tenha um documento com esse titulo.
     */
    public int criaTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel){
        if (tituloDoc.isBlank ()) { throw new IllegalArgumentException ("Título Inválido");}
        if (documentos.get (tituloDoc) == null) { throw new NoSuchElementException ("Documento não cadastrado");}
        return documentos.get (tituloDoc).criaTitulo(valor,prioridade,nivel,linkavel);
    }
    
    /**
     * Cria um elemento do tipo lista e o adiciona no documento desejado.
     * @param tituloDoc Titulo do documento desejado.
     * @param valorLista Corpo de texto do elemento
     * @param prioridade Prioridade do elemento
     * @param separador Separador do corpo de texto
     * @param charLista Char utlizado para listar.
     * @return a posição do elemento no documento
     * @throws IllegalArgumentException caso seja um titulo inválido.
     * @throws NoSuchElementException caso não tenha um documento com esse titulo.
     */
    public int criaLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista){
        if (tituloDoc.isBlank ()) { throw new IllegalArgumentException ("Título Inválido");}
        if (documentos.get (tituloDoc) == null) { throw new NoSuchElementException ("Documento não cadastrado");}
        return documentos.get (tituloDoc).criaLista(valorLista,prioridade,separador,charLista);
    }
    
    /**
     * Cria um elemento do tipo termos e o adiciona em um documento passado.
     * @param tituloDoc Titulo do documento desejado
     * @param valorTermos Corpo de texto do elemento
     * @param prioridade Prioridade do elemento
     * @param separador Separador do valor
     * @param ordem Ordem utilizada para organizar o valor
     * @return a posição do elemento no documento.
     * @throws IllegalArgumentException caso seja um titulo inválido.
     * @throws NoSuchElementException caso não tenha um documento com esse titulo.
     */
    public int criaTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem){
        if (tituloDoc.isBlank ()) { throw new IllegalArgumentException ("Título Inválido");}
        if (documentos.get (tituloDoc) == null) { throw new NoSuchElementException ("Documento não cadastrado");}
        return documentos.get (tituloDoc).criaTermos(valorTermos,prioridade,separador,ordem);
    }
    
    /**
     * Pega a representação completa de um elemento, dado sua posição no documento passado.
     * @param tituloDoc Titulo do documento desejado
     * @param elementoPosicao Posição do elemento desejado
     * @return "Posição inválida", caso seja passado uma posição não existente no documento, caso contrário retorna
     * uma String da representação completa do elemento desejado.
     * @throws IllegalArgumentException caso seja um titulo inválido.
     * @throws NoSuchElementException caso não tenha um documento com esse titulo.
     */
    public String pegaRepresentacaoCompleta(String tituloDoc, int elementoPosicao){
        if (tituloDoc.isBlank ()) { throw new IllegalArgumentException ("Título Inválido");}
        if (documentos.get (tituloDoc) == null) { throw new NoSuchElementException ("Documento não cadastrado");}
        return documentos.get (tituloDoc).pegaRepresentacaoCompleta(elementoPosicao);
    }
    /**
     * Pega a representação resumida de um elemento, dado sua posição no documento passado.
     * @param tituloDoc Titulo do documento desejado
     * @param elementoPosicao Posição do elemento desejado
     * @return "Posição inválida", caso seja passado uma posição não existente no documento, caso contrário retorna
     * uma String da representação resumida do elemento desejado.
     * @throws IllegalArgumentException caso seja um titulo inválido.
     * @throws NoSuchElementException caso não tenha um documento com esse titulo.
     */
    public  String pegaRepresentacaoResumida(String tituloDoc, int elementoPosicao){
        if (tituloDoc.isBlank ()) { throw new IllegalArgumentException ("Título Inválido");}
        if (documentos.get (tituloDoc) == null) { throw new NoSuchElementException ("Documento não cadastrado");}
        return documentos.get (tituloDoc).pegaRepresentacaoResumida(elementoPosicao);
    }
    
    /**
     * Apaga um elemento de um documento
     * @param tituloDoc Titulo do documento desejado
     * @param elementoPosicao POsição do elemento a ser apagado.
     * @return false, caso a posição seja inválida, caso contrário e sucesso do método, retorna true.
     * @throws IllegalArgumentException caso seja um titulo inválido.
     * @throws NoSuchElementException caso não tenha um documento com esse titulo.
     */
    public boolean apagaElemento(String tituloDoc, int elementoPosicao){
        if (tituloDoc.isBlank ()) { throw new IllegalArgumentException ("Título Inválido");}
        if (documentos.get (tituloDoc) == null) { throw new NoSuchElementException ("Documento não cadastrado");}
        return documentos.get (tituloDoc).apagaElemento(elementoPosicao);
    }
    
    /**
     * Move um elemento do documento para a posição superior/anterior.
     * @param tituloDoc Titulo do documento desejado
     * @param elementoPosicao Posição do elemento desejado.
     * @throws IllegalArgumentException caso seja um titulo inválido.
     * @throws NoSuchElementException caso não tenha um documento com esse titulo.
     */
    public void moveParaCima(String tituloDoc, int elementoPosicao){
        if (tituloDoc.isBlank ()) { throw new IllegalArgumentException ("Título Inválido");}
        if (documentos.get (tituloDoc) == null) { throw new NoSuchElementException ("Documento não cadastrado");}
        documentos.get (tituloDoc).moveParaCima(elementoPosicao);
    }
    
    /**
     * Move um elemento do documento para uma posição abaixo/sucessora.
     * @param tituloDoc Titulo do documento desejado.
     * @param elementoPosicao Posição do elemento no documento.
     * @throws IllegalArgumentException caso seja um titulo inválido.
     * @throws NoSuchElementException caso não tenha um documento com esse titulo.
     */
    public void moveParaBaixo(String tituloDoc, int elementoPosicao){
        if (tituloDoc.isBlank ()) { throw new IllegalArgumentException ("Título Inválido");}
        if (documentos.get (tituloDoc) == null) { throw new NoSuchElementException ("Documento não cadastrado");}
        documentos.get (tituloDoc).moveParaBaixo(elementoPosicao);
    }
    
    /**
     * Cria um elemento do tipo atalho e o adiciona no documento desejado.
     * @param tituloDoc Titulo do documento a receber o atalho.
     * @param tituloDocReferenciado Titulo do documento a ser utilizado como atalho.
     * @return a posição do elemento no documento.
     * @throws IllegalArgumentException caso seja um titulo inválido.
     * @throws NoSuchElementException caso não tenha um documento com esse titulo.
     * @throws IllegalStateException caso o documento referenciado tenha atalhos ou o documento principal seja atalho.
     */
    public int criaAtalho(String tituloDoc, String tituloDocReferenciado){
        if (tituloDoc.isBlank ()) { throw new IllegalArgumentException ("Título Inválido");}
        if (documentos.get (tituloDoc) == null) { throw new NoSuchElementException ("Documento não cadastrado");}
        if (tituloDocReferenciado.isBlank ()) { throw new IllegalArgumentException ("Título Inválido");}
        if (documentos.get (tituloDocReferenciado) == null) { throw new NoSuchElementException ("Documento não cadastrado");}
        if (documentos.get (tituloDocReferenciado).hasAtalhos ()) { throw new IllegalStateException ("Documento Referenciado tem atalhos");}
        if (documentos.get (tituloDoc).isAtalho ()) {throw new IllegalStateException ("Documento é atalho");}
        
        return documentos.get (tituloDoc).criaAtalho(documentos.get (tituloDocReferenciado));
    }
    
    /**
     * Cadastra uma visão completa do documento desejado.
     * @param tituloDoc Titulo do documento desejado
     * @return posição da visão na lista de visões.
     * @throws IllegalArgumentException caso seja um titulo inválido.
      * @throws NoSuchElementException caso não tenha um documento com esse titulo.
     */
    public int criaVisaoCompleta(String tituloDoc){
        if (tituloDoc.isBlank ()) { throw new IllegalArgumentException ("Título Inválido");}
        if (documentos.get (tituloDoc) == null) { throw new NoSuchElementException ("Documento não cadastrado");}
        Documento d = documentos.get (tituloDoc);
        VisaoI a = new VisaoCompleta (d);
        visoes.add (a);
        return posicaoVisao++;
    }
    /**
     * Cadastra uma visão resumida do documento desejado.
     * @param tituloDoc Titulo do documento desejado
     * @return posição da visão na lista de visões.
     * @throws IllegalArgumentException caso seja um titulo inválido.
     * @throws NoSuchElementException caso não tenha um documento com esse titulo.
     */
    public int criaVisaoResumida(String tituloDoc){
        if (tituloDoc.isBlank ()) { throw new IllegalArgumentException ("Título Inválido");}
        if (documentos.get (tituloDoc) == null) { throw new NoSuchElementException ("Documento não cadastrado");}
        Documento d = documentos.get (tituloDoc);
        VisaoI a = new VisaoResumida (d);
        visoes.add (a);
        return posicaoVisao++;
    }
    /**
     * Cadastra uma visão prioritária do documento desejado.
     * @param tituloDoc Titulo do documento desejado
     * @param prioridade Prioridade mínima dos elementos do documento.
     * @return posição da visão na lista de visões.
     * @throws IllegalArgumentException caso seja um titulo inválido.
     * @throws NoSuchElementException caso não tenha um documento com esse titulo.
     */
    public int criaVisaoPrioritaria(String tituloDoc, int prioridade){
        if (tituloDoc.isBlank ()) { throw new IllegalArgumentException ("Título Inválido");}
        if (documentos.get (tituloDoc) == null) { throw new NoSuchElementException ("Documento não cadastrado");}
        Documento d = documentos.get (tituloDoc);
        VisaoI a = new VisaoPrioritaria (d, prioridade);
        visoes.add (a);
        return posicaoVisao++;
    }
    /**
     * Cadastra uma visão titulo do documento desejado.
     * @param tituloDoc Titulo do documento desejado
     * @return posição da visão na lista de visões.
     * @throws IllegalArgumentException caso seja um titulo inválido.
     * @throws NoSuchElementException caso não tenha um documento com esse titulo.
     */
    public int criaVisaoTitulo(String tituloDoc){
        if (tituloDoc.isBlank ()) { throw new IllegalArgumentException ("Título Inválido");}
        if (documentos.get (tituloDoc) == null) { throw new NoSuchElementException ("Documento não cadastrado");}
        Documento d = documentos.get (tituloDoc);
        VisaoI a = new VisaoTitulo (d);
        visoes.add (a);
        return posicaoVisao++;
    }
    
    /**
     * Exibe uma visão cadastrada de acordo com seu id.
     * @param visaoId Id/Posição da visão desejada
     * @return um array contendo a visão do documento, por seus elementos.
     * @throws IllegalArgumentException caso seja uma posição inválida.
     */
    public String[] exibeVisao(int visaoId){
        if (visaoId < 0 || visaoId >= visoes.size ()) { throw new IllegalArgumentException ("Id Inválido"); }
        return visoes.get (visaoId).exibeVisao ();
    }
    
}
