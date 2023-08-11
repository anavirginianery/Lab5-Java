package documinTest.DocumentoTest;

import documin.Documento.DocumentoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DocumentoControllerTest {
    private DocumentoController docController;
    
    @BeforeEach
    public void prepara(){
        docController = new DocumentoController ();
        docController.criaDocumento ("Estudos");
        docController.criaDocumento ("Com Tamanho", 1);
        docController.criaDocumento ("Programação");
        docController.criaDocumento ("Escola");
    }
    @Test
    public void testaCriaDocumentoExistente(){
        assertFalse (docController.criaDocumento ("Estudos"));
    }
    @Test
    public void testaCriaDocumentoComTamanhoExistente(){
        assertFalse (docController.criaDocumento ("Estudos",10));
    }
    @Test
    public void testaCriaDocumentoTituloInvalido(){
        assertThrows (IllegalArgumentException.class, () -> docController.criaDocumento (""), "Título Inválido");
        assertThrows (IllegalArgumentException.class, () -> docController.criaDocumento ("   "), "Título Inválido");
    }
    @Test
    public void testaCriaDocumentoComTamanhoTituloInvalido(){
        assertThrows (IllegalArgumentException.class, () -> docController.criaDocumento ("",5), "Título Inválido");
        assertThrows (IllegalArgumentException.class, () -> docController.criaDocumento ("   ",5), "Título Inválido");
    }
    @Test
    public void testaCriaDocumentoComTamanhoInvalido(){
        assertThrows (IllegalArgumentException.class, () -> docController.criaDocumento ("Drone",0), "Tamanho Inválido");
    }
    @Test
    public void testaCriaDocumento(){
        assertTrue (docController.criaDocumento ("LabProg"));
    }
    @Test
    public void testaCriaDocumentoComTamanho(){
        assertTrue (docController.criaDocumento ("LabProg",2));
    }
    @Test
    public void testaRemoveDocumentoTituloInvalido(){
        assertThrows (IllegalArgumentException.class, () -> docController.removeDocumento (""), "Título Inválido");
        assertThrows (IllegalArgumentException.class, () -> docController.removeDocumento ("   "), "Título Inválido");
    }
    @Test
    public void testaRemoveDocumentoNãoCadastrado(){
        assertThrows (NoSuchElementException.class,()-> docController.removeDocumento ("Ana"),"Documento não cadastrado");
    }
    @Test
    public void testaRemoveDocumento(){
        docController.removeDocumento ("Com Tamanho");
        assertThrows (NoSuchElementException.class,()->docController.exibeDocumento ("Com Tamanho"));
    }
    @Test
    public void testaContaElementosTituloInvalido(){
        assertThrows (IllegalArgumentException.class, () -> docController.contaElementos (""), "Título Inválido");
        assertThrows (IllegalArgumentException.class, () -> docController.contaElementos ("   "), "Título Inválido");
    }
    @Test
    public void testaContaElementosDocumentoNãoCadastrado(){
        assertThrows (NoSuchElementException.class,()-> docController.contaElementos ("Ana"),"Documento não cadastrado");
    }
    @Test
    public void testaContaElementos(){
        assertEquals (0, docController.contaElementos ("Estudos"));
    }
    @Test
    public void testaExibeDocumentosTituloInvalido(){
        assertThrows (IllegalArgumentException.class, () -> docController.exibeDocumento (""), "Título Inválido");
        assertThrows (IllegalArgumentException.class, () -> docController.exibeDocumento ("   "), "Título Inválido");
    }
    @Test
    public void testaExibeDocumentoNãoCadastrado(){
        assertThrows (NoSuchElementException.class,()-> docController.exibeDocumento ("Ana"),"Documento não cadastrado");
    }
    @Test
    public void testaExibeDocumentoVazio(){
        String[] arrayVazio = new String[0];
        assertArrayEquals (arrayVazio,docController.exibeDocumento ("Estudos"));
    }
    @Test
    public void testaExibeDocumento(){
        docController.criaTexto ("Estudos","é um teste JUnit",2);
        docController.criaTitulo ("Estudos","Testando casos",3,3,false);
        String[] esperado = {"é um teste JUnit","3. Testando casos"};
        assertArrayEquals (esperado, docController.exibeDocumento ("Estudos"));
    }
    @Test
    public void testaCriaTextoTituloDocInvalido(){
        assertThrows (IllegalArgumentException.class, () -> docController.criaTexto ("","s",2), "Título Inválido");
        assertThrows (IllegalArgumentException.class, () -> docController.criaTexto ("   ","s",2), "Título Inválido");
    }
    @Test
    public void testaCriaTextoNoLimite(){
        docController.criaTexto ("Com Tamanho", "Teste", 2);
        assertThrows (IndexOutOfBoundsException.class, () -> docController.criaTexto ("Com Tamanho", "Corpo do Texto", 2));
    }
    @Test
    public void testaCriaTextoDocNãoCadastrado(){
        assertThrows (NoSuchElementException.class,()-> docController.criaTexto ("Ana","s",2),"Documento não cadastrado");
    }
    @Test
    public void testaCriaTexto(){
        int saida = docController.criaTexto ("Estudos", "Corpo do Texto", 2);
        assertEquals (0, saida);
    }
    @Test
    public void testaCriaTituloTituloDocInvalido(){
        assertThrows (IllegalArgumentException.class, () -> docController.criaTitulo ("","s",2,2, true), "Título Inválido");
        assertThrows (IllegalArgumentException.class, () -> docController.criaTitulo ("   ","s",2,2,true), "Título Inválido");
    }
    @Test
    public void testaCriaTituloNoLimite(){
        docController.criaTexto ("Com Tamanho", "Teste", 2);
        assertThrows (IndexOutOfBoundsException.class, () -> docController.criaTitulo ("Com Tamanho", "Corpo do Texto", 2,3,false));
    }
    @Test
    public void testaCriaTituloDocNãoCadastrado(){
        assertThrows (NoSuchElementException.class,()-> docController.criaTitulo ("Ana","s",2,2,true),"Documento não cadastrado");
    }
    @Test
    public void testaCriaTitulo(){
        docController.criaTexto ("Estudos", "Corpo Humano", 2);
        int saida = docController.criaTitulo ("Estudos", "Corpo do Texto", 2,3,false);
        assertEquals (1, saida);
    }
    @Test
    public void testaCriaListaTituloDocInvalido(){
        assertThrows (IllegalArgumentException.class, () -> docController.criaLista ("","s | v",2,"|", "."), "Título Inválido");
        assertThrows (IllegalArgumentException.class, () -> docController.criaLista ("   ","s | v",2,"|","."), "Título Inválido");
    }
    @Test
    public void testaCriaListaNoLimite(){
        docController.criaTexto ("Com Tamanho", "Teste", 2);
        assertThrows (IndexOutOfBoundsException.class, () -> docController.criaLista ("Com Tamanho", "Corpo | do | Texto", 2,"|",".") );
    }
    @Test
    public void testaCriaListaDocNãoCadastrado(){
        assertThrows (NoSuchElementException.class,()-> docController.criaLista ("Ana","s | v",2,"|","."),"Documento não cadastrado");
    }
    @Test
    public void testaCriaLista(){
        docController.criaTexto ("Estudos", "Corpo Humano", 2);
        int saida = docController.criaLista ("Estudos", "Corpo | do | Texto", 2,"|",".");
        assertEquals (1, saida);
    }
    @Test
    public void testaCriaTermosTituloDocInvalido(){
        assertThrows (IllegalArgumentException.class, () -> docController.criaTermos ("","s, J, kalo",2,",", "NENHUMA"), "Título Inválido");
        assertThrows (IllegalArgumentException.class, () -> docController.criaTermos ("   ","s, J, Kalo",2,",","ALFABÉTICA"), "Título Inválido");
    }
    @Test
    public void testaCriaTermosNoLimite(){
        docController.criaTexto ("Com Tamanho", "Teste", 2);
        assertThrows (IndexOutOfBoundsException.class, () -> docController.criaTermos ("Com Tamanho", "Corpo, do, Texto", 2,",","TAMANHO"));
    }
    @Test
    public void testaCriaTermosDocNãoCadastrado(){
        assertThrows (NoSuchElementException.class,()-> docController.criaTermos ("Ana","s, m, kalo",2,",","NENHUMA"),"Documento não cadastrado");
    }
    @Test
    public void testaCriaTermos(){
        docController.criaTexto ("Estudos", "Corpo Humano", 2);
        int saida = docController.criaTermos ("Estudos", "Corpo, do, Texto", 2,",","TAMANHO");
        assertEquals (1, saida);
    }
    @Test
    public void testaPegaRepresentacaoCompletaPosicaoInvalida(){
        assertEquals ("Posição Inválida",docController.pegaRepresentacaoCompleta ("Estudos",2));
    }
    @Test
    public void testaPegaRepresentacaoCompletaTituloDocInvalido(){
        assertThrows (IllegalArgumentException.class, () -> docController.pegaRepresentacaoCompleta ("",2), "Título Inválido");
        assertThrows (IllegalArgumentException.class, () -> docController.pegaRepresentacaoCompleta ("     ",2), "Título Inválido");
    }
    @Test
    public void testaPegaRepresentacaoCompletaDocNaoCadastrado(){
        assertThrows (NoSuchElementException.class, () -> docController.pegaRepresentacaoCompleta ("Ana",5), "Documento não cadastrado");
    }
    @Test
    public void testaPegaRpresentacaoCompletaLista(){
        docController.criaLista ("Estudos","Orientação, De Objetos, POO",2,",","*");
        String esperado = "* Orientação\n* De Objetos\n* POO";
        assertEquals (esperado,docController.pegaRepresentacaoCompleta ("Estudos",0));
    }
    @Test
    public void testaPegaRpresentacaoCompletaTexto(){
        int a = docController.criaTexto ("Estudos","Orientação De Objetos POO",4);
        String esperado = "Orientação De Objetos POO";
        assertEquals (esperado,docController.pegaRepresentacaoCompleta ("Estudos",a));
    }
    @Test
    public void testaPegaRpresentacaoCompletaTitulo(){
        docController.criaLista ("Estudos","Orientação, De Objetos, POO",2,",","*");
        int a = docController.criaTitulo ("Estudos","Orientação De Objetos POO",1,6,true);
        String esperado = "6. Orientação De Objetos POO -- \n6-ORIENTAÇÃODEOBJETOSPOO";
        assertEquals (esperado,docController.pegaRepresentacaoCompleta ("Estudos",a));
    }
    @Test
    public void testaPegaRpresentacaoCompletaTermos(){
        int a = docController.criaTermos ("Estudos","Orientação / Objetos / POO / Jun",2,"/","TAMANHO");
        String esperado = "Total termos: 4\n- Orientação, Objetos, POO, Jun";
        assertEquals (esperado,docController.pegaRepresentacaoCompleta ("Estudos",a));
    }
    @Test
    public void testaPegaRepresentacaoResumidaPosicaoInvalida(){
        assertEquals ("Posição Inválida",docController.pegaRepresentacaoResumida ("Estudos",2));
    }
    @Test
    public void testaPegaRepresentacaoResumidaTituloDocInvalido(){
        assertThrows (IllegalArgumentException.class, () -> docController.pegaRepresentacaoResumida ("",2), "Título Inválido");
        assertThrows (IllegalArgumentException.class, () -> docController.pegaRepresentacaoResumida ("     ",2), "Título Inválido");
    }
    @Test
    public void testaPegaRepresentacaoResumidaDocNaoCadastrado(){
        assertThrows (NoSuchElementException.class, () -> docController.pegaRepresentacaoResumida ("Ana",5), "Documento não cadastrado");
    }
    @Test
    public void testaPegaRpresentacaoResumidaLista(){
        docController.criaLista ("Estudos","Orientação, De Objetos, POO",2,",","*");
        String esperado = "Orientação, De Objetos, POO";
        assertEquals (esperado,docController.pegaRepresentacaoResumida ("Estudos",0));
    }
    @Test
    public void testaPegaRpresentacaoResumidaTexto(){
        int a = docController.criaTexto ("Estudos","Orientação De Objetos POO",4);
        String esperado = "Orientação De Objetos POO";
        assertEquals (esperado,docController.pegaRepresentacaoResumida ("Estudos",a));
    }
    @Test
    public void testaPegaRpresentacaoResumidaTitulo(){
        docController.criaLista ("Estudos","Orientação, De Objetos, POO",2,",","*");
        int a = docController.criaTitulo ("Estudos","Orientação De Objetos POO",1,6,true);
        String esperado = "6. Orientação De Objetos POO";
        assertEquals (esperado,docController.pegaRepresentacaoResumida ("Estudos",a));
    }
    @Test
    public void testaPegaRpresentacaoResumidaTermos(){
        int a = docController.criaTermos ("Estudos","Orientação / Objetos / POO / Jun",2,"/","TAMANHO");
        String esperado = "Orientação / Objetos / POO / Jun";
        assertEquals (esperado,docController.pegaRepresentacaoResumida ("Estudos",a));
    }
    @Test
    public void testaApagaElementoTituloDocInvalido(){
        assertThrows (IllegalArgumentException.class, () -> docController.apagaElemento ("",2), "Titulo Inválido");
        assertThrows (IllegalArgumentException.class, () -> docController.apagaElemento ("     ",2), "Titulo Inválido");
    }
    @Test
    public void testaApagaElementoDocNaoCadastrado(){
        assertThrows (NoSuchElementException.class,() -> docController.apagaElemento ("Ana",5),"Documento não cadastrado");
    }
    @Test
    public void testaApagaElementoPosicaoInvalida(){
        assertFalse (docController.apagaElemento ("Estudos",3));
    }
    @Test
    public void testaApagaElemento(){
        int a = docController.criaLista ("Estudos","Orientação, De Objetos, POO",2,",","*");
        docController.criaTermos ("Estudos","Orientação / Objetos / POO / Jun",2,"/","TAMANHO");
        assertTrue(docController.apagaElemento ("Estudos",a));
        
        //Testando se o elemento 0 ficou vazio
        assertEquals ("Orientação / Objetos / POO / Jun",docController.pegaRepresentacaoResumida ("Estudos",0));
    }
    @Test
    public void testaMoveParaCimaTituloDocInvalido(){
        assertThrows (IllegalArgumentException.class, () -> docController.moveParaCima ("",2), "Titulo Inválido");
        assertThrows (IllegalArgumentException.class, () -> docController.moveParaCima ("     ",2), "Titulo Inválido");
    }
    @Test
    public void testaMoveParaCimaDocNaoCadastrado(){
        assertThrows (NoSuchElementException.class,() -> docController.moveParaCima ("Ana",5),"Documento não cadastrado");
    }
    @Test
    public void testaMoveParaCima(){
        docController.criaLista ("Estudos","Orientação, Aneis, Polimorfismo",2,",","*");
        docController.criaTermos ("Estudos","Orientação / Objetos / POO / Jun",2,"/","TAMANHO");
        docController.moveParaCima ("Estudos",1);
        assertEquals ("Orientação / Objetos / POO / Jun",docController.pegaRepresentacaoResumida ("Estudos",0));
    }
    @Test
    public void testaMoveParaCimaElementoZero(){
        docController.criaTermos ("Estudos","Orientação / Objetos / POO / Jun",2,"/","TAMANHO");
        docController.criaLista ("Estudos","Orientação, Aneis, Polimorfismo",2,",","*");
        docController.moveParaCima ("Estudos",0);
        assertEquals ("Orientação / Objetos / POO / Jun",docController.pegaRepresentacaoResumida ("Estudos",0));
    }
    @Test
    public void testaMoveParaBaixoTituloDocInvalido(){
        assertThrows (IllegalArgumentException.class, () -> docController.moveParaBaixo ("",2), "Titulo Inválido");
        assertThrows (IllegalArgumentException.class, () -> docController.moveParaBaixo ("     ",2), "Titulo Inválido");
    }
    @Test
    public void testaMoveParaBaixoDocNaoCadastrado(){
        assertThrows (NoSuchElementException.class,() -> docController.moveParaBaixo ("Ana",5),"Documento não cadastrado");
    }
    @Test
    public void testaMoveParaBaixo(){
        docController.criaLista ("Estudos","Orientação, Aneis, Polimorfismo",2,",","*");
        docController.criaTermos ("Estudos","Orientação / Objetos / POO / Jun",2,"/","TAMANHO");
        docController.moveParaBaixo ("Estudos",0);
        assertEquals ("Orientação, Aneis, Polimorfismo",docController.pegaRepresentacaoResumida ("Estudos",1));
    }
    @Test
    public void testaMoveParaBaixoUltimoElemento(){
        docController.criaLista ("Estudos","Orientação, Aneis, Polimorfismo",2,",","*");
        docController.criaTermos ("Estudos","Orientação / Objetos / POO / Jun",2,"/","TAMANHO");
        docController.moveParaBaixo ("Estudos",1);
        assertEquals ("Orientação / Objetos / POO / Jun",docController.pegaRepresentacaoResumida ("Estudos",1));
    }
    @Test
    public void testaCriaAtalhoTitulosInvalidos(){
        assertThrows (IllegalArgumentException.class, () -> docController.criaAtalho ("","B"), "Titulo Inválido");
        assertThrows (IllegalArgumentException.class, () -> docController.criaAtalho ("     ","B"), "Titulo Inválido");
        
        assertThrows (IllegalArgumentException.class, () -> docController.criaAtalho ("Programação",""), "Titulo Inválido");
        assertThrows (IllegalArgumentException.class, () -> docController.criaAtalho ("Programação","     "), "Titulo Inválido");
    }
    @Test
    public void testaCriaAtalhoNoLimite(){
        docController.criaTexto ("Com Tamanho", "Teste", 2);
        assertThrows (IndexOutOfBoundsException.class, () -> docController.criaAtalho ("Com Tamanho", "Programação"));
    }
    @Test
    public void testaCriaAtalhoDocumentosNaoCadastrados(){
        assertThrows (NoSuchElementException.class,() -> docController.criaAtalho ("Ana","Estudos"),"Documento não cadastrado");
        assertThrows (NoSuchElementException.class,() -> docController.criaAtalho ("Estudos","Ana"),"Documento Referenciado não cadastrado");
    }
    @Test
    public void testaCriaAtalhoDocumentoTemAtalhos(){
        docController.criaAtalho ("Programação","Escola");
        assertThrows (IllegalStateException.class,()-> docController.criaAtalho ("Estudos","Programação"),"Documento Referenciado tem atalhos");
    }
    @Test
    public void testaCriaAtalhoDocumentoEAtalho(){
        docController.criaAtalho ("Programação","Escola");
        assertThrows (IllegalStateException.class,()-> docController.criaAtalho ("Escola","Estudos"),"Documento é atalho");
    }
    @Test
    public void testaCriaAtalho(){
        docController.criaTexto ("Programação","POO - Orientação de Objetos",4);
        docController.criaTitulo ("Programação","Java - Linguagem",5,2,false);
        int a = docController.criaAtalho ("Estudos","Programação");
        assertEquals (0,a);
    }
    @Test
    public void testaPegaRepresentacaoCompletaAtalho(){
        docController.criaTexto ("Programação","POO - Orientação de Objetos",4);
        docController.criaTitulo ("Programação","Java - Linguagem",5,2,true);
        docController.criaAtalho ("Estudos","Programação");
        assertEquals ("POO - Orientação de Objetos\n2. Java - Linguagem -- \n2-JAVA-LINGUAGEM",docController.pegaRepresentacaoCompleta ("Estudos",0));
    }
    @Test
    public void testaPegaRepresentacaoResumidaAtalho(){
        docController.criaTexto ("Programação","POO - Orientação de Objetos",4);
        docController.criaTitulo ("Programação","Java - Linguagem",5,2,false);
        docController.criaAtalho ("Estudos","Programação");
        assertEquals ("POO - Orientação de Objetos\n2. Java - Linguagem",docController.pegaRepresentacaoResumida ("Estudos",0));
    }
    @Test
    public void testaCriaVisaoCompletaTituloInvalido(){
        assertThrows (IllegalArgumentException.class, () -> docController.criaVisaoCompleta (""), "Titulo Inválido");
        assertThrows (IllegalArgumentException.class, () -> docController.criaVisaoCompleta ("     "), "Titulo Inválido");
    }
    @Test
    public void testaCriaVisaoCompletaDocNaoCadastrado(){
        assertThrows (NoSuchElementException.class,() -> docController.criaVisaoCompleta ("Ana"),"Documento não cadastrado");
        
    }
    @Test
    public void testaCriaVisaoResumidaTituloInvalido(){
        assertThrows (IllegalArgumentException.class, () -> docController.criaVisaoResumida (""), "Titulo Inválido");
        assertThrows (IllegalArgumentException.class, () -> docController.criaVisaoResumida ("     "), "Titulo Inválido");
    }
    @Test
    public void testaCriaVisaoResumidaDocNaoCadastrado(){
        assertThrows (NoSuchElementException.class,() -> docController.criaVisaoResumida ("Ana"),"Documento não cadastrado");
        
    }
    @Test
    public void testaCriaVisaoPrioritariaTituloInvalido(){
        assertThrows (IllegalArgumentException.class, () -> docController.criaVisaoPrioritaria("",2), "Titulo Inválido");
        assertThrows (IllegalArgumentException.class, () -> docController.criaVisaoPrioritaria ("     ",2), "Titulo Inválido");
    }
    @Test
    public void testaCriaVisaoPrioritariaDocNaoCadastrado(){
        assertThrows (NoSuchElementException.class,() -> docController.criaVisaoPrioritaria ("Ana",2),"Documento não cadastrado");
        
    }
    @Test
    public void testaCriaVisaoTituloTituloDocInvalido(){
        assertThrows (IllegalArgumentException.class, () -> docController.criaVisaoTitulo (""), "Titulo Inválido");
        assertThrows (IllegalArgumentException.class, () -> docController.criaVisaoTitulo ("     "), "Titulo Inválido");
    }
    @Test
    public void testaCriaVisaoTituloDocNaoCadastrado(){
        assertThrows (NoSuchElementException.class,() -> docController.criaVisaoTitulo ("Ana"),"Documento não cadastrado");
        
    }
    @Test
    public void testaExibeVisaoIdInvalido(){
        docController.criaVisaoCompleta ("Estudos");
        assertThrows (IllegalArgumentException.class, () -> docController.exibeVisao (1), "Titulo Inválido");
        
    }
    @Test
    public void testaCriaVisaoCompleta(){
        int a = docController.criaVisaoCompleta ("Estudos");
        assertEquals (0, a);
    }
    @Test
    public void testaExibeVisaoCompleta(){
        docController.criaTexto ("Estudos","Testando em Junit",2);
        docController.criaTermos ("Estudos", "Ana - Virginia - Nery", 3, "-", "TAMANHO");
        int a = docController.criaVisaoCompleta ("Estudos");
        String[] exp = {"Testando em Junit", "Total termos: 3\n- Virginia, Nery, Ana"};
        assertArrayEquals (exp, docController.exibeVisao (a));
    }
    @Test
    public void testaCriaVisaoResumida(){
        docController.criaVisaoCompleta ("Programação");
        int a = docController.criaVisaoResumida ("Estudos");
        assertEquals (1, a);
    }
    @Test
    public void testaExibeVisaoResumida(){
        docController.criaTexto ("Estudos","Testando em Junit",2);
        docController.criaTermos ("Estudos", "Ana - Virginia - Nery", 3, "-", "TAMANHO");
        int a = docController.criaVisaoResumida ("Estudos");
        String[] exp = {"Testando em Junit", "Virginia - Nery - Ana"};
        assertArrayEquals (exp, docController.exibeVisao (a));
    }
    @Test
    public void testaCriaVisaoPrioritaria(){
        docController.criaVisaoPrioritaria ("Com Tamanho",1);
        int a = docController.criaVisaoPrioritaria ("Estudos",5);
        assertEquals (1, a);
    }
    @Test
    public void testaExibeVisaoPrioritaria(){
        docController.criaTexto ("Estudos","Testando em Junit",2);
        docController.criaTermos ("Estudos", "Ana - Virginia - Nery", 3, "-", "TAMANHO");
        docController.criaTexto ("Estudos", "Casa suja", 4);
        int a = docController.criaVisaoPrioritaria ("Estudos",3);
        String[] exp = {"Total termos: 3\n- Virginia, Nery, Ana","Casa suja"};
        assertArrayEquals (exp, docController.exibeVisao (a));
    }
    @Test
    public void testaCriaVisaoTitulo(){
        int a = docController.criaVisaoTitulo ("Estudos");
        assertEquals (0, a);
    }
    @Test
    public void testaExibeVisaoTitulo(){
        docController.criaTexto ("Estudos","Testando em Junit",2);
        docController.criaTermos ("Estudos", "Ana - Virginia - Nery", 3, "-", "TAMANHO");
        docController.criaTitulo ("Estudos", "Casa suja", 4, 2, true);
        int a = docController.criaVisaoTitulo ("Estudos");
        String[] exp = {"2. Casa suja"};
        assertArrayEquals (exp, docController.exibeVisao (a));
    }
    @Test
    public void testaExibeVisaoVazio(){
        int a = docController.criaVisaoTitulo ("Estudos");
        String[] exp = {};
        assertArrayEquals (exp, docController.exibeVisao (a));
    }
}