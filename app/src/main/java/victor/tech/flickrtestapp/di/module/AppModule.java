package victor.tech.flickrtestapp.di.module;


import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context appContext;

    public AppModule(Context appContext) {
        this.appContext = appContext;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return appContext;
    }

    @Singleton
    @Provides
    public RequestManager provideImageRequestManager(Context context) {
        return Glide.with(context);
    }

}
