package ch.frankel.blog;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

public class ComponentConfigurator implements ContextConfigurator {

    @Override
    public ApplicationContext getContext() {
        return new AnnotationConfigApplicationContext(John.class, Jane.class);
    }
}

@Component
class John extends Person {

    public John() {
        super("John Doe");
    }
}

@Component
class Jane extends Person {

    public Jane(John person) {
        super("Jane Doe", person);
    }
}
