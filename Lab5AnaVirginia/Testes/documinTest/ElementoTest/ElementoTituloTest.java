package documinTest.ElementoTest;

import documin.Elemento.ElementoTitulo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoTituloTest {
    private ElementoTitulo et1;
    private ElementoTitulo et2;
    @BeforeEach
    public void prepara(){
        et1 = new ElementoTitulo ("Laboratório de Programação", 1, 2,true);
        et2 = new ElementoTitulo ("Orientação de Objetos", 2, 3,false);

    }
    
    @Test
    public void representacaoCompletaLinkavel(){
        assertEquals ("2. Laboratório de Programação -- \n2-LABORATÓRIODEPROGRAMAÇÃO", et1.representacaoCompleta ());
    }
    @Test
    public void representacaoCompletaNaoLinkavel(){
        assertEquals ("3. Orientação de Objetos", et2.representacaoCompleta ());
    }
    @Test
    public void representacaoResumidaLinkavel(){
        assertEquals ("2. Laboratório de Programação", et1.representacaoResumida ());
    }
    @Test
    public void representacaoResumidaNaoLinkavel(){
        assertEquals ("3. Orientação de Objetos", et2.representacaoResumida ());
    }
}