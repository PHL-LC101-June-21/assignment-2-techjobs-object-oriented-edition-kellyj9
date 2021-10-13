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

    // use assertNotEquals to verify that the IDs of the two objects are distinct
    assertNotEquals(job1, job2);
  }

  // test the full constructor
  @Test
    public void testJobConstructorSetsAllFields() {
    // declare and initialize a new Job object
      Job job3 = new Job(
              "Product tester",
              new Employer("ACME"),
              new Location("Desert"),
              new PositionType("Quality control"),
              new CoreCompetency("Persistence")
            );
      // Use assertTrue and assertEquals statements to test that the constructor
      // correctly assigns both the class and value of each field.

      assertTrue(job3.getEmployer() instanceof Employer);
      assertTrue(job3.getLocation() instanceof Location);
      assertTrue(job3.getPositionType() instanceof PositionType);
      assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);

      assertEquals("Product tester", job3.getName());
      assertEquals("ACME", job3.getEmployer().getValue());
      assertEquals("Desert", job3.getLocation().getValue());
      assertEquals("Quality control", job3.getPositionType().getValue());
      assertEquals("Persistence", job3.getCoreCompetency().getValue());
    }

    // Test the equals method.
    // Two Job objects are considered equal if they have the same id value,
    // even if one or more of the other fields differ.
    // Similarly, the two objects are NOT equal
    // if their id values differ, even if all the other fields are identical.
    @Test
    public  void testJobsForEquality(){
    // Generate two Job objects that have identical field values (EXCEPT for id)
      Job job4 = new Job(
              "QA analyst",
              new Employer("Vanguard"),
              new Location("Philadelphia"),
              new PositionType("Quality control"),
              new CoreCompetency("Unit testing")
      );
      Job job5 = new Job(
              "QA analyst",
              new Employer("Vanguard"),
              new Location("Philadelphia"),
              new PositionType("Quality control"),
              new CoreCompetency("Unit testing")
      );
      // test that equals returns false to make sure the objects have different id's
      assertFalse(job4.equals(job5));
  }

  // When passed a Job object, toString() should return a string that contains
  // a blank line before and after the job information.
  @Test
    public void testToStringStartsAndEndsWithNewLine() {
      // create a Job object
      Job job6 = new Job(
              "Junior Web developer",
              new Employer("Catalyst"),
              new Location("Baltimore"),
              new PositionType("Dev"),
              new CoreCompetency("HTML")
      );
      // When passed a Job object, it should return a string that contains a blank line
      // before and after the job information.
      assertEquals('\n',
              job6.toString().charAt(0));
      assertEquals('\n',
              job6.toString().charAt(job6.toString().length()-1));
  }

  /// When passed a Job object, the toString() should return a string
  // that contains a label for each field, followed by the data stored
  // in that field. Each field should be on its own line.
  @Test
  public void testToStringContainsCorrectLabelsAndData(){
    // create a Job object
    Job job7 = new Job(
            "Web developer",
            new Employer("Catalyst"),
            new Location("Baltimore"),
            new PositionType("Dev"),
            new CoreCompetency("JavaScript")
    );

    assertEquals("\nID: " + job7.getId() +
                    "\nName: Web developer" +
                    "\nEmployer: Catalyst" +
                    "\nLocation: Baltimore" +
                    "\nPosition Type: Dev" +
                    "\nCore Competency: JavaScript" +
                    "\n", job7.toString());
  }

  // If a field is empty, the method should add,
  // “Data not available” after the label.
  @Test
  public void testToStringHandlesEmptyField() {
    // create a Job object with some fields empty
    Job job8 = new Job(
            "Web developer II",
            new Employer("Catalyst"),
            new Location(""),
            new PositionType("Dev"),
            new CoreCompetency("")
    );

    String strDataNotAvailable = "Data not available";
    assertEquals(
            "\nID: " + job8.getId() +
            "\nName: Web developer II" +
            "\nEmployer: Catalyst" +
            "\nLocation: " + strDataNotAvailable +
            "\nPosition Type: Dev" +
            "\nCore Competency: " + strDataNotAvailable +
            "\n",
            job8.toString());

  }

  // (Bonus) If a Job object ONLY contains data for the id field, the method
  // should return, “\nOOPS! This job does not seem to exist.\n”
  @Test
  public void testToStringHandlesJobObjectOnlyContainsDataForID() {
    // create a Job object with all empty fields (note: the job id will still be generated)
    Job job9 = new Job("",
            new Employer(""),
            new Location(""),
            new PositionType(""),
            new CoreCompetency("")
    );
    String strDataDoesNotExist = "\nOOPS! This job does not seem to exist.\n";
    assertEquals(strDataDoesNotExist, job9.toString());
  }

}
