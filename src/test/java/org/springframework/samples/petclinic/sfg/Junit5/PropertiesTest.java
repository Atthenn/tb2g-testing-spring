package org.springframework.samples.petclinic.sfg.Junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.sfg.HearingInterpreter;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestPropertySource("classpath:yanny.properties")
@ActiveProfiles("externalized")
@SpringJUnitConfig(classes = {PropertiesTest.TestClass.class})
public class PropertiesTest {

    @Autowired
    HearingInterpreter hearingInterpreter;


    @Configuration
    @ComponentScan("org.springframework.samples.petclinic.sfg")
    static class TestClass{

    }

    @Test
    void whatIheard() {
        String word = hearingInterpreter.whatIheard();
        assertEquals("yaNNy",word);
    }
}
