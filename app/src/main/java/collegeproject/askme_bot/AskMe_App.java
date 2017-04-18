package collegeproject.askme_bot;

import android.app.Application;
import android.util.Log;

import dagger.Component;

/**
 * Created by shubham on 1/3/17.
 */
public class AskMe_App extends Application {
    private  static AskMe_App appInstance;
    private static NetComponent netComponent;
    private static String baseurl;
    private  static String baseurl2;
    @Override
    public void onCreate(){
        super.onCreate();
        baseurl = "http://vipinbharti.pythonanywhere.com/";
        baseurl2 = "http://4a7e7321.ngrok.io/";
//        baseurl = "http://43218e1e.ngrok.io";//temp
        appInstance = this;
        netComponent = DaggerNetComponent.builder().appModule(new AppModule(this)).netModule(new NetModule(baseurl,baseurl2)).build();

    }


    @Override
    public void onTerminate(){
        super.onTerminate();
        Log.d("onTerminate","Invoked");

    }

    @Override
    public void onLowMemory(){
        super.onLowMemory();
    }
    public static synchronized  AskMe_App getInstance(){
        return appInstance;
    }
    public NetComponent getNetAppComponent() {
        return netComponent;
    }
}
