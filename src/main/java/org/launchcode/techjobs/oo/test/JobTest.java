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

  @Test
  public void testSettingJobId() {
      Job job1 = new Job();
      Job job2 = new Job();
      assertNotEquals(job1, job2);
  }

  @Test
    public void testJobConstructorSetsAllFields() {
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

    @Test
    public  void testJobsForEquality(){
      Job job4 = new Job("QA analyst", new Employer("Vanguard"), new Location("Philadelphia"), new PositionType("Quality control"), new CoreCompetency("Unit testing"));
      Job job5 = new Job("QA analyst", new Employer("Vanguard"), new Location("Philadelphia"), new PositionType("Quality control"), new CoreCompetency("Unit testing"));
      assertFalse(job4.equals(job5));
  }
}
