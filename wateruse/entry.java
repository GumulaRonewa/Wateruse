package com.example.user.wateruse;

public class entry {
    // Store the id of the  movie poster
    public String date;
    // Store the name of the movie
    private int total ;

    public entry(String date, int total) {
        this.date = date;
        this.total = total;

    }

    public int getTotal() {
        return total;
    }

    public String getDate() {
        return date;
    }


}
