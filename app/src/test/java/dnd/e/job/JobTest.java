package dnd.e.job;

import org.junit.jupiter.api.Test;

import job.Job;
import job.JobFactory;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Scanner;

public class JobTest {
    @Test
    public void barbarianTest() throws IOException {
        Scanner scan = new Scanner(System.in);
        JobFactory fac = new JobFactory(scan);
        Job j = fac.createJob("barbarian");

        assertEquals(2, j.getMaxRages());
        assertEquals(2, j.getCurrRages());
        assertEquals(2, j.getRageDamage());
    }
}
