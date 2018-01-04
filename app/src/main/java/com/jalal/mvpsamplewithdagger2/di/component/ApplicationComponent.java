package com.jalal.mvpsamplewithdagger2.di.component;

import android.app.Application;
import android.content.Context;


import com.jalal.mvpsamplewithdagger2.DemoApplication;
import com.jalal.mvpsamplewithdagger2.data.DataManager;
import com.jalal.mvpsamplewithdagger2.data.DbHelper;
import com.jalal.mvpsamplewithdagger2.data.SharedPrefsHelper;
import com.jalal.mvpsamplewithdagger2.di.ApplicationContext;
import com.jalal.mvpsamplewithdagger2.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;


/**
 * ApplicationComponent is an interface that is implemented by Dagger2. Using @Component we specify
 * the class to be a Component.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(DemoApplication demoApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    /**
     * In order to figure out the dependencies that a Module has to provide, we have to scan all
     * the classes in the graph that needs to be provided with dependencies and then figure out the
     * least number of objects that has to be provided.
     */

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();

}
