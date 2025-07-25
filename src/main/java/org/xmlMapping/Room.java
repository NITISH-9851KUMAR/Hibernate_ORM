package org.xmlMapping;

public class Room {

    private int id;
    private int space;
    private String color;
    private String owner;

    public Room() {
    }

    public Room(int id, int space, String color, String roomOwner) {
        this.id = id;
        this.space = space;
        this.color = color;
        this.owner = roomOwner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int spacee) {
        this.space = spacee;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String roomOwner) {
        this.owner = roomOwner;
    }
}
