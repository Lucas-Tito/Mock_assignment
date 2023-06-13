package org.example;

import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception {

        ApiAccess apiAccess = new ApiAccess();
        System.out.println(apiAccess.abrirPokeList());
        System.out.println(apiAccess.getPokemonInfoByName("charmander"));


    }
}