package sfg.Junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import sfg.HearingInterpreter;
import sfg.LaurelWordProducer;

import static org.junit.jupiter.api.Assertions.*;


@SpringJUnitConfig(classes = {HearingInterpreterInnerClassTest.testConfig.class})
class HearingInterpreterInnerClassTest {

    @Autowired
    HearingInterpreter hearingInterpreter;

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