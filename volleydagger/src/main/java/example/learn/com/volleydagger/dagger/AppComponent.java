package example.learn.com.volleydagger.dagger;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import example.learn.com.volleydagger.MainActivity;
import example.learn.com.volleydagger.SampleDaggerTestClass;

/**
 * Created by saunakc on 22/11/16.
 * This is a class which tells the framework about the modules present.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject (MainActivity activity);
    void inject (SampleDaggerTestClass myclass);
}
