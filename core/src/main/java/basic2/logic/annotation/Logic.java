package basic2.logic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import basic2.logic.BaseLogic;
import basic2.logic.BaseLogicImp;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Logic {
    Class value();
}
