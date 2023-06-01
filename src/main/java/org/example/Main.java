package org.example;

public class Main {
    public static void main(String[] args) throws Exception {

        ApiAccess apiAccess = new ApiAccess();
        System.out.println(apiAccess.searchPoke(1));
    }
}