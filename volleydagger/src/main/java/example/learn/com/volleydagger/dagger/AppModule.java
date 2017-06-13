package example.learn.com.volleydagger.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import example.learn.com.volleydagger.MyApplication;
import example.learn.com.volleydagger.SampleDaggerTestClass;

/**
 * Created by saunakc on 22/11/16.
 * This is the class file which is responsible for providing the objects.
 */
@Module
public class AppModule {

    MyApplication application;

    public AppModule(MyApplication application) {
        this.application = application;
    }
    @Provides @Singleton
    public Context provideContext(){
        return application;
    }

    @Provides
    public SampleDaggerTestClass providesSampleDaggerTestClassObj(){
        return new SampleDaggerTestClass();
    }
}
