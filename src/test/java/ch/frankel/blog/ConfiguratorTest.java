package ch.frankel.blog;

import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class ConfiguratorTest {

    private XmlConfigurator configurator;

    static Stream<ContextConfigurator> configurators() {
        return Stream.of(
            new PropertyConfigurator(),
            new XmlConfigurator(),
            new ComponentConfigurator(),
            new ClassConfigurator(),
            new GroovyConfigurator(),
            new KotlinConfigurator(),
            new BeanConfigurator(),
            new BeanDefinitionConfigurator()
        );
    }

    @ParameterizedTest
    @MethodSource("configurators")
    void whenConfigureShouldRegisterBeans(ContextConfigurator configurator) {
        var context = configurator.getContext();
        var john = context.getBean("john", Person.class);
        var jane = context.getBean("jane", Person.class);
        assertThat(john).hasFieldOrPropertyWithValue("name", "John Doe")
                .hasFieldOrPropertyWithValue("manager", Optional.empty());
        assertThat(jane).hasFieldOrPropertyWithValue("name", "Jane Doe");
        assertThat(jane.getManager())
                .isPresent()
                .hasValueSatisfying(person -> person.equals(john));
    }
}
