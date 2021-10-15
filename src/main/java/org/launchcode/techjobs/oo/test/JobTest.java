package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

  // test the empty constructor
  @Test
  public void testSettingJobId() {
    // create two Job objects using the empty constructor
    Job job1 = new Job();
    Job job2 = new Job();

    // use assertNotEquals to verify that the id's of the two objects are distinct
    assertNotEquals(job1, job2);
  }

  // test the full constructor
  @Test
    public void testJobConstructorSetsAllFields() {
    // declare and initialize a new Job object
      Job job = new Job(
              "Product tester",
              new Employer("ACME"),
              new Location("Desert"),
              new PositionType("Quality control"),
              new CoreCompetency("Persistence")
            );

      // Use assertTrue and assertEquals statements to test that the constructor
      // correctly assigns both the class and value of each field.
     assertTrue(job.getName() instanceof String); // verify if this is needed
                                                                      // for autograder
      assertTrue(job.getEmployer() instanceof Employer);
      assertTrue(job.getLocation() instanceof Location);
      assertTrue(job.getPositionType() instanceof PositionType);
      assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

      assertEquals("Product tester", job.getName());
      assertEquals("ACME", job.getEmployer().getValue());
      assertEquals("Desert", job.getLocation().getValue());
      assertEquals("Quality control", job.getPositionType().getValue());
      assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    // Test the equals method to verify that two Job objects are not equal
    // Two Job objects are considered equal if they have the same id value,
    // even if one or more of the other fields differ.
    // Similarly, the two objects are NOT equal
    // if their id values differ, even if all the other fields are identical.
    @Test
    public  void testJobsForEquality(){
    // generate two Job objects that have identical field values (EXCEPT for id)
      Job job1 = new Job(
              "QA analyst",
              new Employer("Vanguard"),
              new Location("Philadelphia"),
              new PositionType("Quality control"),
              new CoreCompetency("Unit testing")
      );
      Job job2 = new Job(
              "QA analyst",
              new Employer("Vanguard"),
              new Location("Philadelphia"),
              new PositionType("Quality control"),
              new CoreCompetency("Unit testing")
      );

      // check equals method returns false to make sure the objects have different id's
      assertFalse(job1.equals(job2));
  }

  // The toString method should return a string that contains
  // a blank line before and after the job information.
  @Test
    public void testToStringStartsAndEndsWithNewLine() {
      // create a Job object
      Job job = new Job(
              "Junior Web developer",
              new Employer("Catalyst"),
              new Location("Baltimore"),
              new PositionType("Dev"),
              new CoreCompetency("HTML")
      );

      // toString method should return a string that contains a blank line
      // before and after the job information.
      assertEquals('\n',
              job.toString().charAt(0));
      assertEquals('\n',
              job.toString().charAt(job.toString().length()-1));
  }

  /// When passed a Job object, the toString method should return a string
  // that contains a label for each field, followed by the data stored in that field.
  // Each field should be on its own line.
  @Test
  public void testToStringContainsCorrectLabelsAndData(){
    // create a Job object
    Job job = new Job(
            "Web developer",
            new Employer("Catalyst"),
            new Location("Baltimore"),
            new PositionType("Dev"),
            new CoreCompetency("JavaScript")
    );

    // check toString method returns a properly formatted string with labels and fields
    assertEquals("\nID: " + job.getId() +
                    "\nName: Web developer" +
                    "\nEmployer: Catalyst" +
                    "\nLocation: Baltimore" +
                    "\nPosition Type: Dev" +
                    "\nCore Competency: JavaScript" +
                    "\n", job.toString()
    );
  }

  // If a field is empty, the method should add,
  // a message that the data is not available after the label.
  @Test
  public void testToStringHandlesEmptyField() {
    // create a Job object with some fields empty
    Job job = new Job(
            "Web developer II",
            new Employer("Catalyst"),
            new Location(""),
            new PositionType("Dev"),
            new CoreCompetency("")
    );

    // check toString method properly denotes empty fields
    String strDataNotAvailable = "Data not available";
    assertEquals(
            "\nID: " + job.getId() +
            "\nName: Web developer II" +
            "\nEmployer: Catalyst" +
            "\nLocation: " + strDataNotAvailable +
            "\nPosition Type: Dev" +
            "\nCore Competency: " + strDataNotAvailable +
            "\n",
            job.toString()
    );
  }

  // (Bonus) If a Job object ONLY contains data for the id field, the method
  // should return a message
  @Test
  public void testToStringHandlesJobObjectOnlyContainsDataForID() {
    // create a Job object with all empty fields (note: the job id will still be generated)
    Job job = new Job("",
            new Employer(""),
            new Location(""),
            new PositionType(""),
            new CoreCompetency("")
    );

   // check toString method returns a message when all fields (except id) are empty
    String strDataDoesNotExist = "OOPS! This job does not seem to exist.";
    assertEquals(strDataDoesNotExist, job.toString());
  }

}
