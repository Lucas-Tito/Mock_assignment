package org.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.Mockito.*;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class ResponseAccessTest {
    ApiAccess apiAccess = mock(ApiAccess.class);
    ResponseAccess responseAccess = new ResponseAccess(apiAccess);

    @Test
    public void responseAccessTest() throws Exception {
        when(apiAccess.namePokemon(0)).thenReturn("bulbasaur");
        assertEquals("bulbasaur", responseAccess.getPokemonName(0));

    }
    @Test
    public void idNegative() throws Exception {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> responseAccess.getPokemonName(-1));
        assertEquals("id invalido",exception.getMessage());

    }
    @Test
    public void validArgument() throws Exception {
        ResponseAccess responseAccess1 = mock(ResponseAccess.class);
        Mockito.when(responseAccess1.getPokemonName(1)).thenReturn("ivsaur");

        ArgumentCaptor<Integer> acInteger = ArgumentCaptor.forClass(Integer.class);

        Mockito.doReturn(null).when(responseAccess1).getPokemonName(acInteger.capture());
        responseAccess1.getPokemonName(1);

        Mockito.verify(responseAccess1,Mockito.times(1)).getPokemonName(Mockito.anyInt());

        assertEquals(1,acInteger.getValue());


    }
}