package org.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
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
        when(apiAccess.searchPoke(eq(1))).thenReturn("bulbasaur");
        assertEquals("bulbasaur", responseAccess.getPokemonName(1));

    }
    @Test
    public void idNegative() throws Exception {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> responseAccess.getPokemonName(-1));
        assertEquals("id invalido",exception.getMessage());

    }
}