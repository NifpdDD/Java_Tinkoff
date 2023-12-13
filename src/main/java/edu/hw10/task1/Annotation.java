package edu.hw10.task1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface NotNull {}

@Retention(RetentionPolicy.RUNTIME)
@interface Min {
    int value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Max {
    int value();
}
