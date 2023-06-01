package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class Util {

    public static String bufferedReaderToString(BufferedReader bufferedReader) throws IOException{
        String response, jsonAsString = "";
        while ((response = bufferedReader.readLine()) !=null)
                jsonAsString += response;

        return jsonAsString;
    }


    public static JsonNode stringToJson(String src) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readTree(src);
    }


}
