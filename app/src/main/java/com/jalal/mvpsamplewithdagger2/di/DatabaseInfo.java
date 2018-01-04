package com.jalal.mvpsamplewithdagger2.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * @DatabaseInfo qualifier helps the dagger to distinguish between
 * String and Integer Dependencies from existing same types in the
 * dependency graph.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface DatabaseInfo {
}
