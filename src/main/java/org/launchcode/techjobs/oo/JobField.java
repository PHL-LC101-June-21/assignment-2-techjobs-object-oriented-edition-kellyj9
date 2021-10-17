package org.launchcode.techjobs.oo;

abstract class JobField {

    private final int id;
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

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();
}
