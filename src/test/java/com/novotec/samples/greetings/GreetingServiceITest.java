package com.novotec.samples.greetings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Khue Cung on 1/15/18.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ITestConfig.class)
@Transactional
public class GreetingServiceITest {

    @Autowired
    private GreetingService greetingService;

    @Autowired
    private GreetingRepository greetingRepository;

    @Test
    public void assertGreetingService() {
        assertNotNull(greetingService);
    }

    @Test
    public void greetWithEmptyName() {

        String name = null;
        String expectedMessage = "Hello World!";

        Greeting greeting = greetingService.greet(name);

        assertEquals(expectedMessage, greeting.getMessage());

        Greeting persistedGreeting = greetingRepository.findOne(greeting.getId());

        assertNotNull(persistedGreeting);
        assertEquals(greeting.getMessage(), persistedGreeting.getMessage());
    }

}
