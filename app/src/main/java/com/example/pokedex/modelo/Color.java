package com.example.pokedex.modelo;

public class Color {

    private String hex_value, colour_name;

    public String getHex_value() {
        return hex_value;
    }

    public void setHex_value(String hex_value) {
        this.hex_value = hex_value;
    }

    public String getColour_name() {
        return colour_name;
    }

    public void setColour_name(String colour_name) {
        this.colour_name = colour_name;
    }

    @Override
    public String toString() {
        return "Color{" +
                "hex_value='" + hex_value + '\'' +
                ", colour_name='" + colour_name + '\'' +
                '}';
    }
}//Fin clase Color
