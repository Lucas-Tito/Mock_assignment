package org.example;

import netscape.javascript.JSObject;

import java.io.BufferedReader;

public class ResponseAccess {
    private ApiAccess apiAccess;
    public ResponseAccess(ApiAccess apiAccess){
        this.apiAccess = apiAccess;
    }
    public String getPokemonName(int pokeId) throws Exception {
        if(pokeId >= 0) {
            String name = apiAccess.namePokemon(pokeId);
            return name;
        }
        throw new IllegalStateException("id invalido");
    }


}
