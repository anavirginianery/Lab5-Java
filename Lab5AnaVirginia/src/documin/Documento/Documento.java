package documin.Documento;

import documin.Elemento.*;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Representação de um documento, com titulo e elementos, podendo ter quantidade máxima de elementos ou não,
 * com funcionalidades de exibir, adicionar elementos, pegar representações dos elementos, mover e apagar elementos.
 */
public class Documento {
    /**
     * Título do documento.
     */
    private String titulo;
    /**
     * Tamanho Máximo do documento, ou seja, quantidade máxima de elementos no documento
     */
    private int tamanhoMaximo;
    /**
     * Posição/Quantidade atual de elementos.
     */
    private int posicaoAtual;
    /**
     * Coleção de elementos.
     */
    private ArrayList<ElementoI> elementos;
    /**
     * Variável que armazena se o documento tem atalhos.
     */
    private boolean hasAtalhos;
    /**
     * Variável que armazena a informação se o documento é atalho.
     */
    private boolean isAtalho;
    
    /**
     * Construtor de documento que inicializa o titulo com o parametrado, a posição atual com zero
     *  e a coleção de elementos.
     *  Além de lançar uma excecção caso o titulo passado seja vazio ou nulo.
     * @param titulo Titulo do documento
     * @throws IllegalArgumentException caso o titulo seja invalido.
     */
    public Documento(String titulo){
        if (titulo.isBlank ()) { throw new IllegalArgumentException ("Título Inválido");}
        this.titulo = titulo;
        this.posicaoAtual = 0;
        this.elementos = new ArrayList<> ();
    }
    /**
     * Construtor de documento que inicializa o titulo e tamanho máximo com o parametrado, a posição atual com zero
     *  e a coleção de elementos.
     *  Além de lançar uma excecção caso o titulo passado seja vazio ou nulo.
     * @param titulo Titulo do documento
     * @param  tamanhoMaximo Quantidade máxima de elementos do documento
     * @throws IllegalArgumentException caso o título seja inválido ou o tamanho menor ou igual a 0
     */
    public Documento(String titulo, int tamanhoMaximo){
        if (titulo.isBlank ()) { throw new IllegalArgumentException ("Título Inválido");}
        if (tamanhoMaximo <= 0) { throw new IllegalArgumentException ("Tamanho inválido");}
        this.titulo =titulo;
        this.tamanhoMaximo = tamanhoMaximo;
        this.elementos = new ArrayList<> ();
    }
    
    /**
     * Exibe o documento.
     * @return Um array contendo a representação textual de cada elemento do documento.
     */
    public String[] exibeDocumento(){
        String[] saida = new String[posicaoAtual];
        if (posicaoAtual != 0){
        for (int i = 0; i < posicaoAtual; i++){
            saida[i] = elementos.get (i).toString ();
            }
        }
        return saida;
    }
    
    /**
     * Acessa e retorna a quantidade de elementos no documento.
     * @return a quantidade de elementos do documento.
     */
    public int getQuantidadeAtual() {
        return posicaoAtual;
    }
    
    /**
     * Cria um elemento do tipo texto e o adiciona na coleção de elementos.
     * @param valor Corpo do elemento.
     * @param prioridade Prioridade do elemento.
     * @return A posição do elemento na coleção.
     * @throws IndexOutOfBoundsException caso o documento tenha chegado na quantidade máxima de elementos.
     */
    public int criaTexto(String valor, int prioridade) {
        if (noLimite ()) throw new IndexOutOfBoundsException ();
        ElementoI e = new ElementoTexto (valor, prioridade);
        elementos.add(e);
        return posicaoAtual++;
    }
    
    /**
     * Cria e adiciona um elemento do tipo título na coleção de elementos
     * @param valor Corpo do elemento.
     * @param prioridade Prioridade do elemento.
     * @param nivel Nível do elemento.
     * @param linkavel true, caso o elemento seja linkável, false caso contrário.
     * @return A posição do elemento na coleção.
     * @throws IndexOutOfBoundsException caso o documento tenha chegado na quantidade máxima de elementos.
     */
    public int criaTitulo(String valor, int prioridade, int nivel, boolean linkavel) {
        if (noLimite ()) throw new IndexOutOfBoundsException ();
        ElementoI e = new ElementoTitulo (valor, prioridade,nivel,linkavel);
        elementos.add(e);
        return posicaoAtual++;
    }
    
    /**
     * Cria um elemento do tipo lista e o adiciona na coleção de elementos.
     * @param valorLista Corpo do elemento
     * @param prioridade Prioridade do elemento
     * @param separador Separador utilizado no corpo do elemento.
     * @param charLista Char utilizado para listar
     * @return Posição do elemento na coleção de elementos.
     * @throws IndexOutOfBoundsException caso o documento tenha chegado na quantidade máxima de elementos.
     */
    public int criaLista(String valorLista, int prioridade, String separador, String charLista) {
        if (noLimite ()) throw new IndexOutOfBoundsException ();
        ElementoI e = new ElementoLista (valorLista, prioridade,separador,charLista);
        elementos.add(e);
        return posicaoAtual++;
    }
    
    /**
     * Cria um elemento do tipo termo e o aidicona na lista de elementos.
     * @param valorTermos Corpo do elemento
     * @param prioridade Prioridade do elemento
     * @param separador Separador utilizado no corpo do elemento
     * @param ordem Ordem utilizada para organizar o corpo do elemento.
     * @return Posição do elemento na coleção de elementos.
     * @throws IndexOutOfBoundsException caso o documento tenha chegado na quantidade máxima de elementos.
     */
    public int criaTermos(String valorTermos, int prioridade, String separador, String ordem) {
        if (noLimite ()) throw new IndexOutOfBoundsException ();
        ElementoI e = new ElementoTermos (valorTermos, prioridade,separador,ordem);
        elementos.add(e);
        return posicaoAtual++;
    }
    
    /**
     * Pega a representação completa de um elemento que é passaado a posição.
     * @param elementoPosicao Posição do elemento a ser retornado sua representação.
     * @return A representação completa do elemento.
     */
    public String pegaRepresentacaoCompleta(int elementoPosicao) {
        if (elementoPosicao<0 || elementoPosicao>= elementos.size ()) return "Posição Inválida";
        return elementos.get (elementoPosicao).representacaoCompleta ();
    }
    
    /**
     * Pega a representação resumida do elemento que é passado a posição
     * @param elementoPosicao Posição do elemento que é desejado.
     * @return A representação resumida do elemento.
     */
    public String pegaRepresentacaoResumida(int elementoPosicao) {
        if (elementoPosicao<0 || elementoPosicao>= elementos.size ()) return "Posição Inválida";
        return elementos.get (elementoPosicao).representacaoResumida ();
    }
    
    /**
     * Apaga um elemento da coleção de elementos.
     * @param elementoPosicao Posição do elemento a ser apagado
     * @return true caso tenha sucesso o metodo, false caso a posição esteja fora do intervalo dos índices dos elementos.
     */
    public boolean apagaElemento(int elementoPosicao) {
        if (elementoPosicao < 0 || elementoPosicao >= elementos.size ()) return false;
        elementos.remove (elementoPosicao);
        return true;
    }
    
    /**
     * Move um elemento para um posição acima, troca de lugar com o elemento de posição anterior.
     * @param elementoPosicao POsição do elemento desejado.
     */
    public void moveParaCima(int elementoPosicao) {
        if (elementoPosicao > 0 && elementoPosicao < elementos.size ()) {
            ElementoI aux = elementos.get (elementoPosicao);
            elementos.add (elementoPosicao-1,aux);
            elementos.remove (elementoPosicao+1);
        }
    }
    
    /**
     * Move um elemento para uma posição abaixo, trocando de lugar com o elemento de posição sucessora.
     * @param elementoPosicao Posição do elemento desejado.
     */
    public void moveParaBaixo(int elementoPosicao) {
        if (elementoPosicao >= 0 && elementoPosicao < elementos.size ()-1) {
            ElementoI aux = elementos.get (elementoPosicao);
            elementos.remove (elementoPosicao);
            elementos.add (elementoPosicao+1, aux);
        }
    }
    
    /**
     * Média das prioridades dos elementos do documento.
     * @return média das prioridades dos elementos do documento.
     */
    public int mediaPrioridades(){
        int soma = 0;
        for (ElementoI e: elementos){
            soma += e.getPrioridade();
        }
        if (elementos.size () == 0) return soma;
        return soma/elementos.size ();
    }
    
    /**
     * Pega a representação completa dos elementos de prioridade 4 e 5.
     * @return representação completa dos elementos de prioridade 4 e 5.
     */
    public String representacaoCompletaAtalho(){
        String saida = "";
        for (ElementoI e : elementos){
            if (e.getPrioridade () == 4 || e.getPrioridade ()==5){
                saida += e.representacaoCompleta ()+ "\n";
            }
        }
        return saida.trim ();
    }
    /**
     * Pega a representação completa dos elementos de prioridade 4 e 5.
     * @return representação completa dos elementos de prioridade 4 e 5.
     */
    public String representacaoResumidaAtalho() {
        String saida = "";
        for (ElementoI e : elementos){
            if (e.getPrioridade () == 4 || e.getPrioridade ()==5){
                saida += e.representacaoResumida ()+ "\n";
            }
        }
        return saida.trim ();
    }
    
    /**
     * Retorna se o documento tem ou não atalhos.
     * @return true, caso o documento tenha atalhos, false caso contrario.
     */
    public boolean hasAtalhos() {
        return hasAtalhos;
    }
    
    /**
     * Acessa e retorna o título do documento.
     * @return o titulo do documento.
     */
    public String getTitulo(){
        return titulo;
    }
    
    /**
     * Atualiza o documento como é atalho.
     */
    public void setAtalho(){
        isAtalho = true;
    }
    
    /**
     * Retorna se o documento é ou não atalho.
     * @return Se o elemento é atalho ou não
     */
    public boolean isAtalho() {
        return isAtalho;
    }
    
    /**
     * Cria um elemento do tipo atalho que é um outro documento e o adiciona na coleção de elementos.
     * @param documento Documento referenciado a se tornar um atalho.
     * @return Posição do elemento na coleção.
     * @throws IllegalStateException caso o documento referenciado tenha atalhos ou o documento principal seja atalho.
     * @throws IndexOutOfBoundsException caso o documento tenha chegado na quantidade máxima de elementos.
     */
    public int criaAtalho(Documento documento) {
        if (documento.hasAtalhos ()) { throw new IllegalStateException ("Documento Referenciado tem atalhos");}
        if (isAtalho ()) {throw new IllegalStateException ("Documento é atalho");}
        if (noLimite ()) throw new IndexOutOfBoundsException ();
        ElementoI e = new Atalho (documento);
        elementos.add (e);
        documento.setAtalho ();
        hasAtalhos = true;
        return posicaoAtual++;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Documento documento = (Documento) o;
        return Objects.equals (titulo, documento.titulo);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash (titulo);
    }
    
    /**
     * Verifica se o documento chegou ao limite máximo de elementos, caso seja um documento com tamanho máximo.
     * @return true, caso já esteja completo, false caso contrário.
     */
    private boolean noLimite(){
        if (tamanhoMaximo != 0 && elementos.size () == tamanhoMaximo) return true;
        return false;
    }
    
    /**
     * Retorna a coleção de elementos do documento.
     * @return a coleção de elementos do documento.
     */
    public ArrayList<ElementoI> getElementos(){
        return new ArrayList<> (elementos);
    }
}

