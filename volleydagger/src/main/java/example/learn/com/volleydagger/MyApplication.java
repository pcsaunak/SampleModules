package example.learn.com.volleydagger;

import android.app.Application;

import example.learn.com.volleydagger.dagger.AppComponent;
import example.learn.com.volleydagger.dagger.AppModule;
import example.learn.com.volleydagger.dagger.DaggerAppComponent;

/**
 * Created by saunakc on 22/11/16.
 */

public class MyApplication extends Application {
    private static AppComponent appComponent;
    private static MyApplication application = new MyApplication();

    public static MyApplication getApplicationInstance(){
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        getAppComponent();
    }

    public AppComponent getAppComponent() {
        if(appComponent == null){
            appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        }
        return appComponent;
    }


}
