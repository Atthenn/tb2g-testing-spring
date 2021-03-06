package org.springframework.samples.petclinic.sfg.Junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.samples.petclinic.sfg.HearingInterpreter;
import org.springframework.samples.petclinic.sfg.LaurelWordProducer;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("inner-class")
@SpringJUnitConfig(classes = {HearingInterpreterInnerClassTest.testConfig.class})
class HearingInterpreterInnerClassTest {

    @Autowired
    HearingInterpreter hearingInterpreter;

    @Profile("inner-class")
    @Configuration
    static class testConfig{
        @Bean
        HearingInterpreter hearingInterpreter(){
            return  new HearingInterpreter(new LaurelWordProducer());
        }
    }
    
    @Test
    void whatIheard() {
        String word = hearingInterpreter.whatIheard();
        assertEquals("Laurel", word);
    }

}