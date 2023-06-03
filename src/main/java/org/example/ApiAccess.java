package org.example;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiAccess {

    /*
    * This method consult the poke api to get a name of a pokemon
    * the pokemon to search is determined by a int that represents his id
    * from that the method returns only the name of the pokemon chosen
    * */
    JsonNode node;
    public JsonNode searchPoke() throws Exception{
        try{
            URL url = new URL("https://pokeapi.co/api/v2/pokemon/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connectionHTTP(connection);

            BufferedReader response = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String reponseString = Util.bufferedReaderToString(response);
            this.node = Util.stringToJson(reponseString);

            return node;
        }catch (Exception e){
            throw new Exception("Erro: " + e);
        }
    }

    public RuntimeException connectionHTTP(HttpURLConnection connection) throws IOException {
        if(connection.getResponseCode() != 200)
            throw new RuntimeException("HTTP error code: " + connection.getResponseCode());

        return null;
    }

    public String namePokemon(int id){
       return this.node.get("results").get(id).toString();
    }
}
