package com.novotec.samples.greetings;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Khue Cung on 1/15/18.
 */
public class GreetingServiceTest {

    private GreetingRepository repository;
    private GreetingService greetingService;

    @Before
    public void setup() {
        repository = Mockito.mock(GreetingRepository.class);
        greetingService = new GreetingServiceImpl(repository);
    }

    @Test
    public void testGreetingWithEmptyName() {

        String expectedMsg = "Hello World!";
        String name = null;

        reset(repository);

        testGreeting(name, expectedMsg);
    }

    @Test
    public void testGreetingWithGoodName() {
        String expectedMsg = "Hello Khue!";
        String name = "Khue";

        reset(repository);

        testGreeting(name, expectedMsg);
    }

    private void testGreeting(String name, String expectedMessage) {
        when(repository.save(any(Greeting.class))).thenReturn(null);

        Greeting greeting = greetingService.greet(name);

        verify(repository).save(any(Greeting.class));

        assertNotNull(greeting);
        assertEquals(expectedMessage, greeting.getMessage());
    }
}
