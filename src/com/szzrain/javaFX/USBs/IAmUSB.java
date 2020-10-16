package com.szzrain.javaFX.USBs;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface IAmUSB {

    String openMethod() default "";

    String closeMethod() default "";

    String useMethod() default "";
}
