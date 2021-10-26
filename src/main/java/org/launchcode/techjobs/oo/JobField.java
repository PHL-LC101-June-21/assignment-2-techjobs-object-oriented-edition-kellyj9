package org.launchcode.techjobs.oo;

import java.util.Objects;

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

    // Custom getter
    // Returns the field value or a message that the data is not available
    // when the field value is empty or null
    public String getValue() {
        // used to note that data is not available when a field is null or empty
        String dataNotAvailable = "Data not available";

        // if the string is null or an empty string,
        // then return a string noting that the data is not available;
        // otherwise return the field's value.
        if (value == null || value.isEmpty()) {
            return dataNotAvailable;
        }
        else {
            return value;
        }
    }

    // Setter

    public void setValue(String value) {
        this.value = value;
    }

    // Custom Methods

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobField jobField = (JobField) o;
        return id == jobField.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
