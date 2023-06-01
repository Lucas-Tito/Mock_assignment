package org.example;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiAccess {

    /*
    * This method consult the poke api to get a name of a pokemon
    * the pokemon to search is determined by a int that represents his id
    * from that the method returns only the name of the pokemon chosen
    * */
    public String searchPoke(int pokeToSearch) throws Exception{
        try{
            URL url = new URL("https://pokeapi.co/api/v2/pokemon/" + pokeToSearch);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            if(connection.getResponseCode() != 200)
                throw new RuntimeException("HTTP error code: " + connection.getResponseCode());

            BufferedReader response = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String reponseString = Util.bufferedReaderToString(response);
            JsonNode node = Util.stringToJson(reponseString);

            return node.get("name").asText();
        }catch (Exception e){
            throw new Exception("Erro: " + e);
        }
    }



}
