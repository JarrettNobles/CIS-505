package Module_6;
/*
 * ------------------------------------------------------------
 * Program: ComposerApp (Assignment 6.2)
 * File: Composer.java
 * Author: Jarrett Nobles
 * Course: CIS-505 — Software Engineering
 * Date: 2025-10-17
 * Description:
 * POJO representing a Composer entity with id, name, and genre.
 * Includes default and full constructors, accessors, and toString()
 * that prints each field on its own line.
 * ------------------------------------------------------------
 */
public class Composer {
    //private data fields
    private int id;
    private String name;
    private String genre;
    //default constructor
    public Composer() {
        this.id = 0;
        this.name = "";
        this.genre = "";
    }//end default constructor

    /**
     * Full argument constructor creating a composer with all fields
     * @param id numeric identifier
     * @param name name of the composer
     * @param genre genre of the composer
     */
    public Composer(int id, String name, String genre){
        this.id = id;
        this.name = name;
        this.genre = genre;
    }//end constructor

    //Accessors
    public int getId(){
        return id;
    }//end getId
    public String getName(){
        return name;
    }//end getName
    public String getGenre(){
        return genre;
    }//end getGenre

    /**
     * return a multi-line description of the composer with each field on its own line.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(" Id: ").append(id).append('\n');
        sb.append(" Name: ").append(name).append('\n');
        sb.append(" Genre: ").append(genre);
        return sb.toString();
    }//end toString

}//end class
