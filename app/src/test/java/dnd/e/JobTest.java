package dnd.e;

import org.junit.jupiter.api.Test;

import job.Job;
import job.JobFactory;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class JobTest {
    @Test
    public void barbarianTest() throws IOException {
        JobFactory fac = new JobFactory();
        Job j = fac.createJob("barbarian");

        assertEquals(2, j.getMaxRageNum());
        assertEquals(2, j.getCurrRageNum());
        assertEquals(2, j.getRageDamage());
    }
}
