package org.example;

import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        ResponseAccess responseService = new ResponseAccess(new ApiAccess());
        //System.out.println(responseService.abrirPokeList())
        responseService.abrirPokeList();
        Scanner scan = new Scanner(System.in);
        String poquemon = scan.nextLine();
        responseService.getPokemonInfoByName(poquemon);
        //System.out.println();


    }
}