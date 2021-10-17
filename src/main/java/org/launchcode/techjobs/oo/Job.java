package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private final int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors -
    //  one to initialize a unique ID and a second to initialize the other five fields.
    //  The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location,
               PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods.
    //  Consider two Job objects "equal" when their id fields match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // TODO: Add getters for each field EXCEPT nextId.
    //  Add setters for each field EXCEPT nextID and id.

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    /*
    When passed a Job object, this method returns a string that contains a
    blank line before and after the job information.
    The string should contain a label for each field, followed by the data stored in
    that field. Each field should be on its own line.
     If a field is empty, the method should add a message after the label that
     the data is not available.
    (Bonus) If a Job object ONLY contains data for the id field, the method should
    return a message
      */
    @Override
    public String toString() {

        // get the values for all the fields
        String strEmployerValue = employer.getValue();
        String strLocationValue = location.getValue();
        String strPositionTypeValue = positionType.getValue();
        String strCoreCompetencyValue = coreCompetency.getValue();

        //  used to note when all fields are empty or null EXCEPT for the id
        String dataDoesNotExist = "OOPS! This job does not seem to exist.";

        // if all fields are empty (EXCEPT for id)
        // then return a message that the job doesn't seem to exist...
        if (
                name.equals("") &&
                strEmployerValue.equals("") &&
                strLocationValue.equals("") &&
                strPositionTypeValue.equals("") &&
                strCoreCompetencyValue.equals("")) {
            return dataDoesNotExist;
        }
        // ...otherwise concatenate the field labels and field values to create a string
        else {
            return "\nID: " + id +
                    toStringFieldLabelAndValue("Name", name) +
                    toStringFieldLabelAndValue("Employer", strEmployerValue) +
                    toStringFieldLabelAndValue("Location",  strLocationValue) +
                    toStringFieldLabelAndValue("Position Type", strPositionTypeValue) +
                    toStringFieldLabelAndValue("Core Competency",  strCoreCompetencyValue) +
                    "\n";
        }
    }

     /*
     Appends a field label and its value to the string tempToString in a
     specific format and returns the formatted string
     When a field value is an empty string, append a message that
     the data is not available
      */
    public String toStringFieldLabelAndValue(String fieldLabel,
                                             String fieldValue) {

        // used to note that data is not available when a field is empty
        String dataNotAvailable = "Data not available";

        // start building the string
        String tempToString = "\n" + fieldLabel + ": ";

        //  if the field value is empty, append a note for that field that the
        //  data is not available and return the result...
        if (fieldValue.equals("")) {
            return tempToString + dataNotAvailable;
       //  ...otherwise, append the field value and return the result
        } else {
            return tempToString + fieldValue;
        }
    }

}
