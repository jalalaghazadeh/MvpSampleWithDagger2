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
    /**
     * We have to provide the dependencies expressed in the DemoApplication class. This class needs
     * DataManager and to provide this class we have to provide the dependencies expressed by
     * DataManager , which as mentioned in the constructor are Context, DbHelper, and
     * SharedPrefsHelper . We then move further in the graph.

     Context has to be ApplicationContext
     DbHelper needs Context, dbName, and version. This does not have any further branching.
     SharedPrefsHelper needs SharedPreferences
     We now accumulate the superset of all these dependencies, which turn out to be: Context, dbName,
     version, and SharedPreferences

     Now to provide these dependencies we create ApplicationModule
     */

    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;

    public static DemoApplication get(Context context) {
        return (DemoApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        /*
         * DaggerApplicationComponent is the generated class by the Dagger, implementing the
         * ApplicationComponent. We provide the ApplicationModule class that is used to construct
         * the dependencies.

         * We have also called the inject method of applicationComponent and passed the instance of
         * the DemoApplication class. This is done to use it for providing the
         * DataManager.ApplicationComponent instance is retained so as to access all the classes
         * that are available in the dependency graph and is express for access.
         */
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
