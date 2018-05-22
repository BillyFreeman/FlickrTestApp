package victor.tech.flickrtestapp.di;


import android.content.Context;

import victor.tech.flickrtestapp.di.component.AppComponent;
import victor.tech.flickrtestapp.di.component.BrowserComponent;
import victor.tech.flickrtestapp.di.component.DaggerAppComponent;
import victor.tech.flickrtestapp.di.module.ApiModule;
import victor.tech.flickrtestapp.di.module.AppModule;
import victor.tech.flickrtestapp.di.module.RxModule;

public final class Injector {

    private static Injector INSTANCE;

    private AppComponent appComponent;
    private BrowserComponent browserComponent;

    private Injector() {

    }

    public static Injector getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Injector();
        }
        return INSTANCE;
    }

    public void init(Context appContext) {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(appContext))
                .apiModule(new ApiModule())
                .rxModule(new RxModule())
                .build();
    }

    public AppComponent getAppComponent() {
        ensureValidState();
        return appComponent;
    }

    public BrowserComponent getBrowserComponent() {
        ensureValidState();
        if (browserComponent == null) {
            browserComponent = appComponent.plusBrowserComponent();
        }
        return browserComponent;
    }

    public void releaseBrowserComponent() {
        browserComponent = null;
    }

    private void ensureValidState() {
        if (appComponent == null) {
            throw new IllegalStateException("AppComponent is not initialized");
        }
    }
}
