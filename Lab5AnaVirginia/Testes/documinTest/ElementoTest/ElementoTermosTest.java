package documinTest.ElementoTest;

import documin.Elemento.ElementoTermos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoTermosTest {
    private ElementoTermos elementoA;
    private ElementoTermos elementoT;
    private ElementoTermos elementoN;

    @BeforeEach
    public void prepara(){
        elementoA = new ElementoTermos ("Teste / termos / Aleatórios",1,"/", "ALFABÉTICA");
        elementoT = new ElementoTermos ("Teste - termos - Aleatórios",2,"-", "TAMANHO");
        elementoN = new ElementoTermos ("Teste @ termos @ Aleatórios",3,"@", "NENHUM");
    }
    @Test
    public void representacaoCompletaAlfabetica(){
        assertEquals ("Total termos: 3\n- Aleatórios, termos, Teste", elementoA.representacaoCompleta ());
    }
    @Test
    public void representacaoCompletaTamanho(){
        assertEquals ("Total termos: 3\n- Aleatórios, termos, Teste", elementoT.representacaoCompleta ());
    }
    @Test
    public void representacaoCompletaNenhuma(){
        assertEquals ("Total termos: 3\n- Teste, termos, Aleatórios", elementoN.representacaoCompleta ());
    }
    @Test
    public void representacaoResumidaAlfabetica(){
        assertEquals ("Aleatórios / termos / Teste", elementoA.representacaoResumida ());
    }
    @Test
    public void representacaoResumidaTamanho(){
        assertEquals ("Aleatórios - termos - Teste", elementoT.representacaoResumida ());
    }
    @Test
    public void representacaoResumidaTamanhoIguais(){
        ElementoTermos elementoTI = new ElementoTermos ("Joao - Casa - Vida",2,"-", "TAMANHO");
        assertEquals ("Joao - Casa - Vida",elementoTI.representacaoResumida ());
    }
    @Test
    public void representacaoResumidaNenhuma(){
        assertEquals ("Teste @ termos @ Aleatórios", elementoN.representacaoResumida ());
    }
}