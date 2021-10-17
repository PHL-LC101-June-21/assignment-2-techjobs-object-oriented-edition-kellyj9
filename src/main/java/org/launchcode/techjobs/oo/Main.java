package org.launchcode.techjobs.oo;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Job job1 = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );
        Job job2 = new Job(
                "Web Developer",
                new Employer("LaunchCode"),
                new Location("St. Louis"),
                new PositionType("Front-end developer"),
                new CoreCompetency("JavaScript")
        );
        Job job3 = new Job(
                "Ice cream tester",
                new Employer(""),
                new Location("Home"),
                new PositionType("UX"),
                new CoreCompetency("Tasting ability")
        );

        ArrayList<Job> jobs = new ArrayList<>();
        jobs.add(job1);
        jobs.add(job2);
        jobs.add(job3);

        for (Job job : jobs){
            System.out.println(job);
        }

        // Tests used to debug:
//        CoreCompetency coreComp1 = new CoreCompetency("Tasting ability1");
//        CoreCompetency coreComp2 = new CoreCompetency("Tasting ability2");
//        System.out.println(coreComp1.getId());
//        System.out.println(coreComp2.getId());
//        System.out.println(coreComp1);
//        System.out.println(coreComp2);
//
//        Location location1 = new Location("Philadelphia1");
//        Location location2 = new Location("Philadelphia2");
//
//        System.out.println(location1.getId());
//        System.out.println(location2.getId());
//        System.out.println(location1);
//        System.out.println(location2);
    }

}
