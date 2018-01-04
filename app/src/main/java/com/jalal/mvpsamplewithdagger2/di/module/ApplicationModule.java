package com.jalal.mvpsamplewithdagger2.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.jalal.mvpsamplewithdagger2.di.ApplicationContext;
import com.jalal.mvpsamplewithdagger2.di.DatabaseInfo;

import dagger.Module;
import dagger.Provides;


/**
 * Created by janisharali on 25/12/16.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application app) {
        mApplication = app;
    }

    /**
     * Thus @Qualifier is used to distinguish between objects of the same type but with different
     * instances. In this sample, we have ActivityContext and ApplicationContext so that the
     * Context object being injected can refer to the respectiveContext type.
     */

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return "demo-dagger.db";
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion() {
        return 2;
    }

    @Provides
    SharedPreferences provideSharedPrefs() {
        return mApplication.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }
}
