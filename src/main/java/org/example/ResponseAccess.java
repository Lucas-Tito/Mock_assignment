package org.example;

import netscape.javascript.JSObject;

import java.io.BufferedReader;

public class ResponseAccess {
    private ApiAccess apiAccess;
    public ResponseAccess(ApiAccess apiAccess){
        this.apiAccess = apiAccess;
    }
    public String abrirPokeList() throws Exception {
        String listName = apiAccess.abrirPokeList();
        return listName;
    }

    public String getPokemonInfoByName(String pokeName) throws Exception {
        String pokeInfo = apiAccess.getPokemonInfoByName(pokeName);
        return pokeInfo;
    }


}
