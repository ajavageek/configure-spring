package ch.frankel.blog;

import java.util.Optional;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public class Person {

    @NonNull
    private final String name;

    @Nullable
    private final Person manager;

    public Person(String name, Person manager) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        this.name = name;
        this.manager = manager;
    }

    public Person(String name) {
        this(name, null);
    }

    public Optional<Person> getManager() {
        return Optional.ofNullable(manager);
    }

    public String getName() {
        return name;
    }
}
