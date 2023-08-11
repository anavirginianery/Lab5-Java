package documinTest.ElementoTest;

import documin.Elemento.ElementoTexto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoTextoTest{
    private ElementoTexto elementoTexto;
    @BeforeEach
    public void prepara(){
        elementoTexto = new ElementoTexto ("Laboratório de Programação", 1);
    }
    
    @Test
    public void representacaoCompleta(){
        assertEquals ("Laboratório de Programação", elementoTexto.representacaoCompleta ());
    }
    @Test
    public void representacaoResumida(){
        assertEquals ("Laboratório de Programação", elementoTexto.representacaoResumida ());
    }
}