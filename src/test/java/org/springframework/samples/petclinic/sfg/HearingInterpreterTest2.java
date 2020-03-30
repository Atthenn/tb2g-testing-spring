package org.springframework.samples.petclinic.sfg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@ActiveProfiles("base-test")
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BaseConfig.class, YannyConfig.class})
public class HearingInterpreterTest2 {


    @Autowired
    HearingInterpreter hearingInterpreter;

  /*  @Before
    public void setUp() throws Exception {
        hearingInterpreter = new HearingInterpreter(new YannyWordProducer());
    }
 */
    @Test
    public void whatIheard() {
        String word = hearingInterpreter.whatIheard();
        assertEquals("Yanny",word);
    }
}