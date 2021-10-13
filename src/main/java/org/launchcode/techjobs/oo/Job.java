package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
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

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

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

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

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
     If a field is empty, the method should add, “Data not available” after the label.
    (Bonus) If a Job object ONLY contains data for the id field, the method should
    return, “OOPS! This job does not seem to exist.”
      */
    @Override
    public String toString() {
        String strDataNotAvailable = "Data not available";  // to denote an empty field

        // string that gets returned when all fields are empty or null EXCEPT for the id
        String strDataDoesNotExist = "OOPS! This job does not seem to exist.";

        String strEmployerValue = employer.getValue();
        String strLocationValue = location.getValue();
        String strPositionTypeValue = positionType.getValue();
        String strCoreCompetencyValue = coreCompetency.getValue();

        // if all fields are empty or null (EXCEPT for id)
        // then return a message that the job doesn't seem to exist...
        if ((name == null || name.equals("")) &&
                (strEmployerValue == null || strEmployerValue.equals("")) &&
                (strLocationValue == null || strLocationValue.equals("")) &&
                (strPositionTypeValue == null || strPositionTypeValue.equals("")) &&
                (strCoreCompetencyValue == null || strCoreCompetencyValue.equals(""))){
            return strDataDoesNotExist;
        }
        // ...otherwise concatenate the field headings and field values to create a string
        else {

            // start creating the string to return
            String tempToString = "\nID: " + id;

            // append the field heading
            tempToString += "\nName: ";
            //  if the field value is null or empty, denote that the
            //  data is not available for that field. Otherwise, append the field value.
            if (name == null || name.equals("")) {
                tempToString += strDataNotAvailable;
            } else {
                tempToString += name;
            }

            // append the field heading
            tempToString += "\nEmployer: ";
            //  if the field value is null or empty, denote that the
            //  data is not available for that field. Otherwise, append the field value.
            if (strEmployerValue == null || strEmployerValue.equals("")) {
                tempToString += strDataNotAvailable;
            } else {
                tempToString += strEmployerValue;
            }

            // append the field heading
            tempToString += "\nLocation: ";
            //  if the field value is null or empty, denote that the
            //  data is not available for that field. Otherwise, append the field value.
            if (strLocationValue == null || strLocationValue.equals("")) {
                tempToString += strDataNotAvailable;
            } else {
                tempToString += strLocationValue;
            }

            // append the field heading
            tempToString += "\nPosition Type: ";
            //  if the field value is null or empty, denote that the
            //  data is not available for that field. Otherwise, append the field value.
            if (strPositionTypeValue == null || strPositionTypeValue.equals("")) {
                tempToString += strDataNotAvailable;
            } else {
                tempToString += strPositionTypeValue;
            }

            // append the field heading
            tempToString += "\nCore Competency: ";
            //  if the field value is null or empty, denote that the
            //  data is not available for that field. Otherwise, append the field value.
            if (strCoreCompetencyValue == null || strCoreCompetencyValue.equals("")) {
                tempToString += strDataNotAvailable;
            } else {
                tempToString += strCoreCompetencyValue;
            }

            return tempToString += "\n";
        }
    }

}
