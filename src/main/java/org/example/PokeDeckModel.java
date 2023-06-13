package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class PokeDeckModel {

    private float count;
    private String next;
    private String previous = null;
    ArrayList<PokeDeckModel.Results> results = new ArrayList < PokeDeckModel.Results > ();


    // Getter Methods

    public float getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    // Setter Methods

    public void setCount(float count) {
        this.count = count;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public class Results
    {
        public String name;
        public String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "Results{" +
                    "name='" + name + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {

        return "PokeDeckModel{" +
                "count=" + count +
                ", next='" + next + '\'' +
                ", previous='" + previous + '\'' +
                ", results=" + results.toString() +
                '}';
    }

    public String pokemonListName()
    {
        String stringNames = "";
        for (PokeDeckModel.Results o: results) {
            stringNames = stringNames + o.getName() +" , \n" ;
        }

        return stringNames.substring(0,(stringNames.length()-4));
    }
}
