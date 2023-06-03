package ru.levelup.at.lesson03.unit.testing.tools.groups.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.Tag;
import ru.levelup.at.lesson03.unit.testing.tools.groups.TagNames;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Tag(TagNames.POSITIVE_TAG)
public @interface PositiveTag {

}
