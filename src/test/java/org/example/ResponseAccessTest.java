package org.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.Mockito.*;

import java.io.BufferedReader;
import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class ResponseAccessTest {
    ApiAccess apiAccess = mock(ApiAccess.class);
    ResponseAccess responseAccess = new ResponseAccess(apiAccess);

    @Test
    public void abrirPokeList() throws Exception {
        when(apiAccess.abrirPokeList()).thenReturn("");
        assertEquals("", responseAccess.abrirPokeList());

    }
    @Test
   public void getPokemonInfoByNameTest() throws Exception {
        when(apiAccess.getPokemonInfoByName("bulbasaur")).thenReturn("");
        assertEquals("", responseAccess.getPokemonInfoByName("bulbasaur"));
    }

    @Test
    public void validArgument() throws Exception {
        ResponseAccess responseAccess1 = mock(ResponseAccess.class);
        Mockito.when(responseAccess1.getPokemonInfoByName("bulbasaur")).thenReturn("");

        ArgumentCaptor<String> acString = ArgumentCaptor.forClass(String.class);

        Mockito.doReturn(null).when(responseAccess1).getPokemonInfoByName(acString.capture());
        responseAccess1.getPokemonInfoByName("bulbasaur");

        Mockito.verify(responseAccess1,Mockito.times(1)).getPokemonInfoByName(Mockito.anyString());

        assertEquals("bulbasaur",acString.getValue());

    }

}