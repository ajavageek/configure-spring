package ch.frankel.blog;

import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class PropertyConfigurator implements ContextConfigurator {

    @Override
    @SuppressWarnings("deprecation")
    public ApplicationContext getContext() {
        var context = new GenericApplicationContext();
        var factory = context.getDefaultListableBeanFactory();
        var reader = new PropertiesBeanDefinitionReader(factory);
        var properties = new ClassPathResource("beans.properties");
        reader.loadBeanDefinitions(properties);
        context.refresh();
        return context;
    }
}
