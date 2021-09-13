package ch.frankel.blog;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClassConfigurator implements ContextConfigurator {

    @Bean
    public Person john() {
        return new Person("John Doe");
    }

    @Bean
    public Person jane(@Qualifier("john") Person person) {
        return new Person("Jane Doe", person);
    }

    @Override
    public ApplicationContext getContext() {
        return new AnnotationConfigApplicationContext(ClassConfigurator.class);
    }
}
