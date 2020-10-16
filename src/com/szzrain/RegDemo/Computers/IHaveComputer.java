package com.szzrain.RegDemo.Computers;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface IHaveComputer {
    int prize();

    int gainEffect();

    String openMethod();
}
