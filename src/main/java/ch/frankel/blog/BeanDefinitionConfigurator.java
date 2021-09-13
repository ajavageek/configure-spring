package ch.frankel.blog;

import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class BeanDefinitionConfigurator implements ContextConfigurator {

    @Override
    public ApplicationContext getContext() {
        var context = new GenericApplicationContext();
        context.registerBeanDefinition("john", new PersonBeanDefinition("John Doe"));
        context.registerBeanDefinition("jane", new PersonBeanDefinition("Jane Doe", "john"));
        context.refresh();
        return context;
    }
}

class PersonBeanDefinition extends GenericBeanDefinition {

    public PersonBeanDefinition(String name) {
        this(name, null);
    }

    public PersonBeanDefinition(String name, String manager) {
        setBeanClass(Person.class);
        var arguments = new ConstructorArgumentValues();
        arguments.addGenericArgumentValue(name, "java.lang.String");
        if (manager != null) {
            arguments.addGenericArgumentValue(manager, "ch.frankel.blog.Person");
        }
        setConstructorArgumentValues(arguments);
    }
}
