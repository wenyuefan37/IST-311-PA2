package com.company;

import java.util.ArrayList;

public class Album implements Comparable<Album> {

    private int numericalID;
    private ArrayList<String> artistNames;
    private String title;
    protected int numberOfSongs;

    public Album(){}
    public Album(int numericalID, ArrayList<String> artistNames, String title, int numberOfSongs) {
        this.numericalID = numericalID;
        this.artistNames = artistNames;
        this.title = title;
        this.numberOfSongs = numberOfSongs;
    }

    public int getID(){
        return numericalID;
    }

    public void setID (int id){
        this.numericalID = id;
    }

    public ArrayList<String> getName(){
        return artistNames;
    }

    public void setName(ArrayList<String> name){
        this.artistNames = name;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public int getNumSong(){
        return numberOfSongs;
    }

    public void setNumSong(int num){
        this.numberOfSongs = num;
    }
    @Override
    public String toString() {
        return numericalID + ": " + numberOfSongs + " -- " + artistNames;
    }

    @Override
    public int compareTo(Album o) {

        if (this.numberOfSongs == o.numberOfSongs) {
            return  0;
        }

        if (this.numberOfSongs < o.numberOfSongs) {
            return -1;
        }
        else {
            return 1;
        }


    }
}
