package documin;

import documin.Documento.DocumentoController;

public class Facade{
    private DocumentoController documentoController;
    public Facade(){}
    public boolean criarDocumento(String titulo){
        return documentoController.criaDocumento (titulo);
    }
    public boolean criarDocumento(String titulo, int tamanhoMaximo){
        return documentoController.criaDocumento (titulo, tamanhoMaximo);
    }
    public void removerDocumento(String titulo){
        documentoController.removeDocumento (titulo);
    }
    public int contarElementos(String titulo){
        return documentoController.contaElementos (titulo);
    }
    public String[] exibirDocumento(String titulo){
        return documentoController.exibeDocumento (titulo);
    }

    //

    public int criarTexto(String tituloDoc, String valor, int prioridade){
        return documentoController.criaTexto (tituloDoc, valor, prioridade);
    }
    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel){
        return documentoController.criaTitulo (tituloDoc, valor, prioridade, nivel, linkavel);
    }
    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista){
        return documentoController.criaLista (tituloDoc, valorLista, prioridade, separador, charLista);
    }
    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem){
        return documentoController.criaTermos (tituloDoc, valorTermos, prioridade, separador, ordem);
    }
    public  String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao){
        return documentoController.pegaRepresentacaoCompleta (tituloDoc, elementoPosicao);
    }
    public  String pegarrepresentacaoResumida(String tituloDoc, int elementoPosicao){
        return documentoController.pegaRepresentacaoResumida (tituloDoc, elementoPosicao);
    }
    public boolean apagarElemento(String tituloDoc, int elementoPosicao){
        return documentoController.apagaElemento (tituloDoc, elementoPosicao);
    }
    public void moverParaCima(String tituloDoc, int elementoPosicao){
        documentoController.moveParaCima (tituloDoc, elementoPosicao);
    }
    public void moverParaBaixo(String tituloDoc, int elementoPosicao){
        documentoController.moveParaBaixo (tituloDoc, elementoPosicao);
    }
    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
        return documentoController.criaAtalho (tituloDoc, tituloDocReferenciado);
    }
    public int criarVisaoCompleta(String tituloDoc){
        return documentoController.criaVisaoCompleta (tituloDoc);
    }
    public int criarVisaoResumida(String tituloDoc){
        return documentoController.criaVisaoResumida (tituloDoc);
    }
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade){
        return documentoController.criaVisaoPrioritaria (tituloDoc,prioridade);
    }
    public int criarVisaoTitulo(String tituloDoc){
        return documentoController.criaVisaoTitulo (tituloDoc);
    }
    public String[] exibirVisao(int visaoId){
        return documentoController.exibeVisao (visaoId);
    }
    
}
