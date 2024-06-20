package org.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// This is a custom annotation at the class level
@Target(ElementType.TYPE)
// This annotation will be available at runtime
@Retention(RetentionPolicy.RUNTIME)
// This annotation will be available only at the source level . It will be discarded by the compiler
//@Retention(RetentionPolicy.SOURCE)
// This annotation will be available at the compile time but not at runtime
//@Retention(RetentionPolicy.CLASS)
public @interface ClassLeveL {
}
