package com.application.library.kotlin.data.api;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by eminartiys on 7/24/17.
 */

@Target(TYPE)
@Retention(RUNTIME)
public @interface AutoGson {
}
