/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonat.enade.resources;


import com.jonat.enade.model.Resultado;
import com.jonat.enade.resources.ResultadoResource;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author jonat
 */
public class ResultadoResourceTest {

    ResultadoResource ResultadoResource = mock(ResultadoResource.class);
    List<Resultado> ResultadoList = new ArrayList<>();
    Resultado Resultado = mock(Resultado.class);

    public ResultadoResourceTest() {
    }

    @Test
    public void testFind() {
        when(ResultadoResource.find(Resultado.getIdResultado())).thenReturn(Resultado);
        assertEquals(Resultado, ResultadoResource.find(Resultado.getIdResultado()));
    }

    @Test
    public void testFindAll() {
        ResultadoList.add(Resultado);
        when(ResultadoResource.findAll()).thenReturn(ResultadoList);
        assertEquals(ResultadoList, ResultadoResource.findAll());
    }

    @Test
    public void testRemove() {
        when(ResultadoResource.remove(Resultado.getIdResultado())).thenReturn("Registro excluído com sucesso!");
        assertEquals("Registro excluído com sucesso!", ResultadoResource.remove(Resultado.getIdResultado()));
    }

    @Test
    public void testRemoveAll() {
        when(ResultadoResource.removeAll()).thenReturn("Exclusão feita com sucesso!");
        assertEquals("Exclusão feita com sucesso!", ResultadoResource.removeAll());
    }

    @Test
    public void testMerge() {
        when(ResultadoResource.merge(Resultado)).thenReturn("Registrado com sucesso!!");
        assertEquals("Registrado com sucesso!!", ResultadoResource.merge(Resultado));
    }

}

