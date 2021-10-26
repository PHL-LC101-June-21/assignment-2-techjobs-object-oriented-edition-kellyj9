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

    // Two constructors -
    //  One to initialize a unique ID and a second to initialize the other five fields.
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

    // Custom equals and hashCode methods.
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

    // Add getters for each field EXCEPT nextId.
    //  Add setters for each field EXCEPT nextId and id.

    // Custom getter
    // Returns the name field or a message that the data is not available
    // when the name is empty or null
    public String getName() {
        // used to note that data is not available when the name field is null or empty
        String dataNotAvailable = "Data not available";

        // if the name is null or an empty string,
        // then return a string noting that the data is not available;
        // otherwise return the name
        if (name == null || name.isEmpty()) {
            return dataNotAvailable;
        }
        else {
            return name;
        }
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
        String strJobName = getName(); // using getName() here because the method can
                                                   // determine when the name data isn't available.
        String strEmployerValue = employer.getValue();
        String strLocationValue = location.getValue();
        String strPositionTypeValue = positionType.getValue();
        String strCoreCompetencyValue = coreCompetency.getValue();

        //  used to note when all fields are empty or null EXCEPT for the id
        String dataDoesNotExist = "OOPS! This job does not seem to exist.";

        // if all fields are null or empty (EXCEPT for id)
        // then return a message that the job doesn't seem to exist...
        if (
                strJobName.equals("Data not available") &&
                strEmployerValue.equals("Data not available") &&
                strLocationValue.equals("Data not available") &&
                strPositionTypeValue.equals("Data not available") &&
                strCoreCompetencyValue.equals("Data not available")) {
            return dataDoesNotExist;
        }
        // ...otherwise concatenate the field labels and field values to create a string
        else {
            return "\nID: " + id +
                concatenateFieldLabelAndValue("Name", strJobName) +
                concatenateFieldLabelAndValue("Employer", strEmployerValue) +
                concatenateFieldLabelAndValue("Location",  strLocationValue) +
                concatenateFieldLabelAndValue("Position Type", strPositionTypeValue) +
                concatenateFieldLabelAndValue("Core Competency",  strCoreCompetencyValue) +
                "\n";
        }
    }

    /*
    Concatenates a field label and the field value in a specific format and
    returns the formatted string
    */
    public String concatenateFieldLabelAndValue(String fieldLabel, String fieldValue) {
        //  append the field value and return the result
        return "\n" + fieldLabel + ": " + fieldValue;
    }
}
