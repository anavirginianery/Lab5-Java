package documinTest.ElementoTest;

import documin.Elemento.ElementoLista;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoListaTest {
    private ElementoLista elementoLista;
    @BeforeEach
    public void prepara(){
        elementoLista = new ElementoLista  ("Laboratório | de | Programação",1,"|", "-");
    }
    @Test
    public void representacaoCompleta(){
        assertEquals ("- Laboratório \n- de \n- Programação", elementoLista.representacaoCompleta ());
    }
    @Test
    public void representacaoResumida(){
        assertEquals ("Laboratório | de | Programação", elementoLista.representacaoResumida ());
    }
    
}