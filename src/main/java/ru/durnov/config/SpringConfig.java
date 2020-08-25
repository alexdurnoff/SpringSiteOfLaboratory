package ru.durnov.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.durnov.service.TestBean;

@Configuration
public class SpringConfig {
    @Bean
    public TestBean getTestBean(){
        return new TestBean("Дурновище!!!");
    }
}
