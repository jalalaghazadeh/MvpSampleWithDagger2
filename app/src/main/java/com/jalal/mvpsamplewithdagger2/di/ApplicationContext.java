package com.jalal.mvpsamplewithdagger2.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * @ApplicationContext Qualifier facilitates DbHelper to get the
 * context object of the application from dagger’s dependency graph
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationContext {
}
