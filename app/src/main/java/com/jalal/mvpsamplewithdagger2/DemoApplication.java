package com.jalal.mvpsamplewithdagger2;

import android.app.Application;
import android.content.Context;


import com.jalal.mvpsamplewithdagger2.data.DataManager;
import com.jalal.mvpsamplewithdagger2.di.component.ApplicationComponent;
import com.jalal.mvpsamplewithdagger2.di.component.DaggerApplicationComponent;
import com.jalal.mvpsamplewithdagger2.di.module.ApplicationModule;

import javax.inject.Inject;

/**
 * Created by janisharali on 25/12/16.
 */

public class DemoApplication extends Application {

    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;

    public static DemoApplication get(Context context) {
        return (DemoApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                                    .builder()
                                    .applicationModule(new ApplicationModule(this))
                                    .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }
}
