package collegeproject.askme_bot;

import android.util.Log;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URISyntaxException;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by shubham on 1/3/17.
 */
@Module
public class NetModule {
        String baseUrl;
        String baseUrl2;

        public NetModule(String baseUrl,String baseUrl2) {
            this.baseUrl = baseUrl;
            this.baseUrl2 = baseUrl2;
        }
        //okhttp cache
        @Provides
        @Singleton
        Cache providesOkHttp(AskMe_App application) {
            int cacheSize = 10*1024*1024;//10MiB
            Cache cache = new Cache(application.getCacheDir(),cacheSize);
            return  cache;
        }

        @Provides @Singleton
        Gson providesGson() {
            GsonBuilder gsonBuilder = new GsonBuilder();
            return gsonBuilder.create();
        }

        @Provides @Singleton
        OkHttpClient providesHttpClient(Cache cache) {
            OkHttpClient client = new OkHttpClient();

//        client.setCache(cache);
            return  client;
        }

        @Provides @Named("vipin") @Singleton
        Retrofit provideRetrofit(Gson gson,OkHttpClient okHttpClient) {

            Retrofit retrofit = new Retrofit.Builder().addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory
                    (GsonConverterFactory.create(gson)).baseUrl
                    (baseUrl)
                    .client(okHttpClient).build();
            return retrofit;
        }


      @Provides @Named("shubham") @Singleton
        Retrofit provideRetrofit2(OkHttpClient okHttpClient) {
          GsonBuilder gsonBuilder = new GsonBuilder();
          Gson gson1 =  gsonBuilder.create();
          Retrofit retrofit = new Retrofit.Builder().addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory
                (GsonConverterFactory.create(gson1)).baseUrl(baseUrl2).client(okHttpClient).build();
        return retrofit;
    }

        @Provides @Singleton
        Socket provideSocket(){
            Socket socket = null;
            try {
                socket = IO.socket(baseUrl);
                socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
                    @Override
                    public void call(Object... args) {
                        Log.d("Event_Connect","socket connected");
                    }
                });
                socket.on(Socket.EVENT_CONNECT_ERROR, new Emitter.Listener() {
                    @Override
                    public void call(Object... args) {

                    }
                });
                socket.on(Socket.EVENT_CONNECT_TIMEOUT, new Emitter.Listener() {
                    @Override
                    public void call(Object... args) {

                    }
                });
                socket.on(Socket.EVENT_CONNECTING, new Emitter.Listener() {
                    @Override
                    public void call(Object... args) {

                    }
                });
                socket.on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
                    @Override
                    public void call(Object... args) {
                        Log.d("Event_Disconnect","socket disconnected");
                    }
                });
                socket.on(Socket.EVENT_ERROR, new Emitter.Listener() {
                    @Override
                    public void call(Object... args) {

                    }
                });
                socket.connect();

            }
            catch (URISyntaxException uriException){
                Log.e("URI Exception", String.valueOf(uriException));
            }
            return socket;
        }
}
