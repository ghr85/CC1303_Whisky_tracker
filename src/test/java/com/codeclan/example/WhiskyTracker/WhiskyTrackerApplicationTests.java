package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {
@Autowired
    WhiskyRepository whiskyRepository;
@Autowired
    DistilleryRepository distilleryRepository;
	@Test
	public void contextLoads() {
	}

	@Test
	public void findWhiskiesByYear() {
		List<Whisky> found = whiskyRepository.findWhiskiesByYear(1991);
		assertEquals("The Rosebank 12 - Flora and Fona", found.get(0).getName());
	}

	@Test
    public void getDistilleriesByRegion(){
    List<Distillery> found = distilleryRepository.findDistilleriesByRegion("Speyside");
    assertEquals("Macallan",found.get(0).getName());
    }

    @Test
    public void getWhiskiesByDistilleryAge(){
	   List<Whisky> found = whiskyRepository.findWhiskyByDistilleryAndAge("Balvenie",14);
	   assertEquals("Balvenie Caribbean Cask",found.get(0).getName());
    }
    @Test
    public void getWhiskiesByRegion(){
	    List<Whisky> found =whiskyRepository.findWhiskiesByRegion("Speyside");
	    assertEquals(2,found.size());

        
    }

}
