package com.jalal.mvpsamplewithdagger2.di.module;

import android.app.Activity;
import android.content.Context;


import com.jalal.mvpsamplewithdagger2.di.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by janisharali on 08/12/16.
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
