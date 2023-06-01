package org.example;

import netscape.javascript.JSObject;

import java.io.BufferedReader;

public class ResponseAccess {
    private ApiAccess apiAccess;
    public ResponseAccess(ApiAccess apiAccess){
        this.apiAccess = apiAccess;
    }
    public String getPokemonName(int pokeId) throws Exception {
        return apiAccess.searchPoke(pokeId);
    }


}
