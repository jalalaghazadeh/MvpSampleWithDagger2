package com.jalal.mvpsamplewithdagger2.di.module;

import android.app.Activity;
import android.content.Context;


import com.jalal.mvpsamplewithdagger2.di.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * To provide the dependency for a class we have to create a Module class. This class defines the
 * methods that provide the dependency. A Module class is identified by @Module and the dependency
 * provider method in identified by @Provides .
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }
}
