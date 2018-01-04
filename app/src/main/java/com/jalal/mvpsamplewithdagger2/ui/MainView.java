package com.jalal.mvpsamplewithdagger2.ui;


import com.jalal.mvpsamplewithdagger2.data.model.User;

/**
 * Created by Jalal on 1/4/2018.
 */

public interface MainView {
    void setUserInfo(User userInfo);

    void setAccessToken(String accessToken);

}
