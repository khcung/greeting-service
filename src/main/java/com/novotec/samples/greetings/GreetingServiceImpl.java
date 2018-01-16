package com.novotec.samples.greetings;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created by Khue Cung on 1/15/18.
 */
@Service
public class GreetingServiceImpl implements GreetingService {

    private static final String MESSAGE_TEMPLATE = "Hello %s!";

    private final GreetingRepository greetingRepository;

    @Autowired
    public GreetingServiceImpl(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    @Transactional
    public Greeting greet(String name) {
        String msg = StringUtils.isBlank(name) ? "World" : name.trim();
        Greeting greeting = Greeting.newBuilder()
                .withMessage(String.format(MESSAGE_TEMPLATE, msg))
                .withGreetingTime(new Date())
                .build();

        greetingRepository.save(greeting);

        return greeting;
    }

}
