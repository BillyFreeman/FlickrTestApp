package victor.tech.flickrtestapp.di.module;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public class RxModule {

    public static final String TAG_IO = "io_scheduler";
    public static final String TAG_UI = "ui_scheduler";

    @Singleton
    @Provides
    @Named(TAG_IO)
    public Scheduler provideIOScheduler() {
        return Schedulers.io();
    }

    @Singleton
    @Provides
    @Named(TAG_UI)
    public Scheduler provideUIScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
