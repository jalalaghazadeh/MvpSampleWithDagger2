package com.jalal.mvpsamplewithdagger2.di.component;


import com.jalal.mvpsamplewithdagger2.di.PerActivity;
import com.jalal.mvpsamplewithdagger2.di.module.ActivityModule;
import com.jalal.mvpsamplewithdagger2.ui.MainActivity;

import dagger.Component;

/*
 * ActivityComponent specify ApplicationComponent and ActivityModule . ApplicationComponent is added
 * to use the graph that has already been generated in the previous step and do exists because the
 * DemoApplication class persists till the application is running.

 * @PerActivity is a scope and is used to tell the Dagger that the Context and Activity provided by
 * the ActivityModule will be instantiated each time an Activity is created. So, these objects
 * persist till that activity lives and each activity has its own set of these.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
