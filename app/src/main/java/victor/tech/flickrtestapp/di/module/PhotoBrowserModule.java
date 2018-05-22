package victor.tech.flickrtestapp.di.module;

import android.graphics.Point;

import dagger.Module;
import dagger.Provides;
import victor.tech.flickrtestapp.browser.domain.GetPhotosUseCase;
import victor.tech.flickrtestapp.browser.presentation.PhotoBrowserPresenter;
import victor.tech.flickrtestapp.browser.presentation.PhotoBrowserPresenterImp;
import victor.tech.flickrtestapp.di.ActivityScope;


@Module
public class PhotoBrowserModule {

    @Provides
    @ActivityScope
    PhotoBrowserPresenter providerPhotoBrowserPresenter(GetPhotosUseCase getPhotosUseCase,
                                                        Point displayDimension){
        return new PhotoBrowserPresenterImp(getPhotosUseCase, displayDimension);
    }
}
