package ch.frankel.blog;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class BeanConfigurator implements ContextConfigurator {

    @Override
    public ApplicationContext getContext() {
        var context = new GenericApplicationContext();
        context.registerBean("john", Person.class, "John Doe");
        context.registerBean("jane", Person.class, "Jane Doe", "john");
        context.refresh();
        return context;
    }
}
