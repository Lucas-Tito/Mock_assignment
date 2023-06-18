package org.example;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ApiAccess {

    /*
    * This method consult the poke api to get a name of a pokemon
    * the pokemon to search is determined by a int that represents his id
    * from that the method returns only the name of the pokemon chosen
    * */
    JsonNode node;
    private PokeDeckModel pkm;

    private PokemonModel pkmModel;
    private URL url;
    public JsonNode searchPoke() throws Exception{
        try{
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //connectionHTTP(connection);

            BufferedReader response = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String reponseString = Util.bufferedReaderToString(response);
            this.node = Util.stringToJson(reponseString);

            response.close();
            connection.disconnect();

            return node;

        }catch (Exception e){
            throw new Exception("Erro: " + e);
        }
    }

    /*public RuntimeException connectionHTTP(HttpURLConnection connection) throws IOException {
        if(connection.getResponseCode() != 200)
            throw new RuntimeException("HTTP error code: " + connection.getResponseCode());

        return null;
    }*/



    public void setRequest(String endpoint) throws Exception {
        this.setUrl(new URL(endpoint));
        this.searchPoke();
    }



    public String abrirPokeList() throws Exception {
        this.setRequest("https://pokeapi.co/api/v2/pokemon/");
        this.pkm = new Gson().fromJson(this.node.toString(),PokeDeckModel.class);
        System.out.println(this.node.toString());

        return this.pkm.pokemonListName();
    }




    public String getPokemonInfoByName(String pokeName) throws Exception {
        System.out.println("\n----------------------------------------------------------- \n");
        for (PokeDeckModel.Results pk : this.pkm.results) {
            if(!pk.getName().equals(pokeName)) continue;
            this.setRequest(pk.getUrl());
            this.pkmModel = new Gson().fromJson(this.node.toString(), PokemonModel.class);
            System.out.println(this.node.toString());
            return this.pkmModel.toString();
        }
        return "Pokemon não econtrado";
    }

    public void setUrl(URL url) { // Setter para a URL
        this.url = url;
    }
}
