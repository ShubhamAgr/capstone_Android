package collegeproject.askme_bot;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shubham on 1/3/17.
 */
@Module
public class AppModule {
    AskMe_App application;

    public AppModule(AskMe_App application){
        this.application = application;
    }
    @Provides
    @Singleton
    AskMe_App providesApplication(){
        return  application;
    }
}
