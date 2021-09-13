package ch.frankel.blog;

import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class XmlConfigurator implements ContextConfigurator {

    @Override
    public ApplicationContext getContext() {
        return new ClassPathXmlApplicationContext("beans.xml");
    }
}
