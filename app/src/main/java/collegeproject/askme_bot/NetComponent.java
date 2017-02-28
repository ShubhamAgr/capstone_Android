package collegeproject.askme_bot;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by shubham on 1/3/17.
 */

    @Singleton
    @Component(modules={AppModule.class,NetModule.class})
    public interface NetComponent {
    void inject(MainActivity mainActivity);


}
