package victor.tech.flickrtestapp;

import android.app.Application;

import victor.tech.flickrtestapp.di.Injector;


public class FlickrTestApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Injector.getInstance().init(getApplicationContext());
    }
}
