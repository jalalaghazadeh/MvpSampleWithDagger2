package com.jalal.mvpsamplewithdagger2.di.component;


import com.jalal.mvpsamplewithdagger2.di.PerActivity;
import com.jalal.mvpsamplewithdagger2.di.module.ActivityModule;
import com.jalal.mvpsamplewithdagger2.ui.MainActivity;

import dagger.Component;

/**
 * Created by janisharali on 08/12/16.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
