package org.example;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ResponseAccessTest {


    @Test
    public void responseAccessTest() throws Exception {
        ApiAccess apiAccess = mock(ApiAccess.class);
        when(apiAccess.searchPoke(eq(1))).thenReturn("bulbasaur");
        ResponseAccess responseAccess = new ResponseAccess(apiAccess);

        assertEquals("bulbasaur", responseAccess.getPokemonName(1));

    }
}