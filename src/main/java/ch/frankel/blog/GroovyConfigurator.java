package ch.frankel.blog;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class GroovyConfigurator implements ContextConfigurator {

    @Override
    public ApplicationContext getContext() {
        return new GenericGroovyApplicationContext("beans.groovy");
    }
}
