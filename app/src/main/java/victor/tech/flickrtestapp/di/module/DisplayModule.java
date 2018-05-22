package victor.tech.flickrtestapp.di.module;


import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DisplayModule {

    @Provides
    @Singleton
    public Point provideDisplayDimensionInPx(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size;
    }
}
