package com.jalal.mvpsamplewithdagger2.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


import com.jalal.mvpsamplewithdagger2.DemoApplication;
import com.jalal.mvpsamplewithdagger2.R;
import com.jalal.mvpsamplewithdagger2.data.DataManager;
import com.jalal.mvpsamplewithdagger2.data.model.User;
import com.jalal.mvpsamplewithdagger2.di.component.ActivityComponent;
import com.jalal.mvpsamplewithdagger2.di.component.DaggerActivityComponent;
import com.jalal.mvpsamplewithdagger2.di.module.ActivityModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView {

    @Inject
    DataManager mDataManager;

    private ActivityComponent activityComponent;

    private MainPresenterImp mainPresenter;

    private TextView mTvUserInfo;
    private TextView mTvAccessToken;

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(DemoApplication.get(this).getComponent())
                    .build();
        }
        return activityComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        mainPresenter = new MainPresenterImp(mDataManager);

        mTvUserInfo = (TextView) findViewById(R.id.tv_user_info);
        mTvAccessToken = (TextView) findViewById(R.id.tv_access_token);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        createUser();
        getUser();
        mDataManager.saveAccessToken("ASDR12443JFDJF43543J543H3K543");

        String token = mainPresenter.getAccessToken();
        setAccessToken(token);
    }

    private void createUser(){
        try {
            mainPresenter.createUser();
        }catch (Exception e){e.printStackTrace();}
    }

    private void getUser(){
        try {
            User user = mainPresenter.getUser(1L);
            setUserInfo(user);
        }catch (Exception e){e.printStackTrace();}
    }

    @Override
    public void setUserInfo(User userInfo) {
        mTvUserInfo.setText(userInfo.toString());
    }

    @Override
    public void setAccessToken(String accessToken) {
        if(accessToken != null){
            mTvAccessToken.setText(accessToken);
        }
    }
}
