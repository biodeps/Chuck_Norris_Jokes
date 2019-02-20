package com.chuckgame.chucknorrisjokes;


public class Joke {
    /* Joke structure must be the same shown on http://api.icndb.com/jokes/random. It is also useful
    to view the complete structure on https://jsonlint.com/ to get a more "human" idea of how it looks like.

    @SerializedName("joke") ---> This is necessary only when you want to change variable name on your Class

    */
    private String type;
    private Value value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
