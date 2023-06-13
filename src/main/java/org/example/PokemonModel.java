package org.example;

public class PokemonModel {

    public int base_experience;
    public int height;
    public int id;
    public boolean is_default;
    public String name;
    public int order;
    public int weight;

    public int getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(int base_experience) {
        this.base_experience = base_experience;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIs_default() {
        return is_default;
    }

    public void setIs_default(boolean is_default) {
        this.is_default = is_default;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Sobre "+this.name+": \n" +
                "  base_experience=" + base_experience +"\n"+
                "  height=" + height +"\n"+
                "  id=" + id +"\n"+
                "  is_default=" + is_default +"\n"+
                "  name='" + name + '\'' +"\n"+
                "  order=" + order +"\n"+
                "  weight=" + weight;
    }
}
