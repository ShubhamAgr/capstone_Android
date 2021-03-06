package collegeproject.askme_bot;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;

import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;
import javax.inject.Named;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    @Inject @Named("vipin")
    Retrofit retrofit;

    @Inject @Named("shubham")
    Retrofit retrofit2;

    //These are the only permissions defined as dangerous in the manifest
    //Internet and access current state aren't dangerous
    final String[] perms = {Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.RECORD_AUDIO};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            //Permission requesting only applies to Android M (API 23) and above
            checkPermissions();
        }
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this,FirstActivity.class);
        startActivity(intent);
    }

    public void checkPermissions(){
        if(!granted(perms)) {
            Log.i("Permissions", "Missing permissions. Requesting...");
            ActivityCompat.requestPermissions(this, perms, 101);
        }else{
            Log.i("Permissions", "All permissions granted!");
        }
    }

    private boolean granted(String[] permissions) {
        for(String s : permissions) {
            int result = ContextCompat.checkSelfPermission(this, s);
            if (result != PackageManager.PERMISSION_GRANTED) {
                // If the permission isn't granted, just return false. The permission requesting system doesn't
                // request already granted permissions, so this
                // also works as a shortcut
                return false;
            }
        }
        return true;
    }
}


