package com.novotec.samples.greetings;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Khue Cung on 1/15/18.
 */
@Configuration
@ComponentScan("com.novotec.samples.greetings")
@EnableTransactionManagement
@Import({H2RepositoryConfig.class})
public class ITestConfig {
}
