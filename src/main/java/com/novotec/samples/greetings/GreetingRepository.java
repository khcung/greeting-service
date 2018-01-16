package com.novotec.samples.greetings;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Khue Cung on 1/15/18.
 */
public interface GreetingRepository extends CrudRepository<Greeting, Long> {
}
