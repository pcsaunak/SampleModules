package example.learn.com.volleydagger.dagger;

import dagger.Module;
import dagger.Provides;

/**
 * Created by saunakc on 22/11/16.
 */

@Module
public class SampleDaggerModule {

    @Provides
    public SampleDaggerModule providesSampleDaggerClasObj(){
        return new SampleDaggerModule();
    }
}
