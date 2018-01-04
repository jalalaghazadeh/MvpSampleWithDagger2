package com.jalal.mvpsamplewithdagger2.data;

import android.content.Context;
import android.content.res.Resources;


import com.jalal.mvpsamplewithdagger2.data.model.User;
import com.jalal.mvpsamplewithdagger2.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @Singleton ensure a single instance of a class globally.
 * So, there will be only one DbHelper class instance for the
 * app and whenever a class asks for DbHelper as a dependency,
 * it will be provided with the same instance that is maintained
 * in the Dagger’s dependency graph.
 */

@Singleton
public class DataManager {

    private Context mContext;
    private DbHelper mDbHelper;
    private SharedPrefsHelper mSharedPrefsHelper;

    /**
     * @Inject on the constructor instructs the Dagger to accumulate
     * all the parameter dependencies when the class is being constructed.
     */

    @Inject
    public DataManager(@ApplicationContext Context context,
                       DbHelper dbHelper,
                       SharedPrefsHelper sharedPrefsHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mSharedPrefsHelper = sharedPrefsHelper;
    }

    public void saveAccessToken(String accessToken) {
        mSharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, accessToken);
    }

    public String getAccessToken(){
        return mSharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, null);
    }

    public Long createUser(User user) throws Exception {
        return mDbHelper.insertUser(user);
    }

    public User getUser(Long userId) throws Resources.NotFoundException, NullPointerException {
        return mDbHelper.getUser(userId);
    }
}
