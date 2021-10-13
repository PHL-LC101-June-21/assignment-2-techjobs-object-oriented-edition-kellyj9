package org.launchcode.techjobs.oo;

public abstract class JobField {

    private int id;
    private static int nextId = 1;
    private String value;

    // Constructors

    public JobField() {
        this.id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    // Getters

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    // Setter

    public void setValue(String value) {
        this.value = value;
    }

    // Custom methods

    @Override
    public String toString() {
        return value;
    }


}
