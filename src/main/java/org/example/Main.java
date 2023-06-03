package org.example;

public class Main {
    public static void main(String[] args) throws Exception {

        ApiAccess apiAccess = new ApiAccess();
        apiAccess.searchPoke();
        System.out.println(apiAccess.namePokemon(0));
    }
}