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
 * Created by janisharali on 08/12/16.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(DemoApplication demoApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();

}
