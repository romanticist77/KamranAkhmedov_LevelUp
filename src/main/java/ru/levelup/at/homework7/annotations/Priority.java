package ru.levelup.at.homework7.annotations;

import io.qameta.allure.Epics;
import io.qameta.allure.LabelAnnotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ru.levelup.at.homework7.dictionary.PriorityLevel;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@LabelAnnotation(name = "priority")
public @interface Priority {

    PriorityLevel value();

}
