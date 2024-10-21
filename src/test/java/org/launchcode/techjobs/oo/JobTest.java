package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {

    //Test 1
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    //Test 2
    @Test
    public void testJobConstructorSetsAllFields() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        // assertEquals statements
        assertEquals("Product tester", job1.getName());
        assertEquals("ACME", job1.getEmployer().getValue());
        assertEquals("Desert", job1.getLocation().getValue());
        assertEquals("Quality control", job1.getPositionType().getValue());
        assertEquals("Persistence", job1.getCoreCompetency().getValue());

        // assertTrue statements
        assertTrue(job1.getName() instanceof String);
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);

    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        System.out.println("Job 1 ID: " + job1.getId());
        System.out.println("Job 2 ID: " + job2.getId());

        assertFalse(job1.equals(job2));

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String jobString = job1.toString();

        assertEquals(System.lineSeparator(), jobString.substring(0, System.lineSeparator().length()));
        assertEquals(System.lineSeparator(), jobString.substring(jobString.length() - System.lineSeparator().length()));
    }


    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(
                (System.lineSeparator() + "ID: " + job1.getId() + System.lineSeparator() +
                "Name: " + "Product tester" + System.lineSeparator() +
                "Employer: " + "ACME" + System.lineSeparator() +
                "Location: " + "Desert" + System.lineSeparator() +
                "Position Type: " + "Quality control" + System.lineSeparator() +
                "Core Competency: " + "Persistence" + System.lineSeparator()),

                (job1.toString())
                );
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job1 = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(
                (System.lineSeparator() + "ID: " + job1.getId() + System.lineSeparator() +
                        "Name: " + "Data not available" + System.lineSeparator() +
                        "Employer: " + "ACME" + System.lineSeparator() +
                        "Location: " + "Desert" + System.lineSeparator() +
                        "Position Type: " + "Quality control" + System.lineSeparator() +
                        "Core Competency: " + "Persistence" + System.lineSeparator()),

                (job1.toString())

        );
    }

    //TODO: Create your unit tests here
}
