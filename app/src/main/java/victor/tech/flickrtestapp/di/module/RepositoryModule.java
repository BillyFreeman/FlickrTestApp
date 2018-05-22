package victor.tech.flickrtestapp.di.module;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import victor.tech.flickrtestapp.api.FlickrApi;
import victor.tech.flickrtestapp.api.FlickrPhotoDataSource;
import victor.tech.flickrtestapp.api.PhotoRepository;

@Module
public class RepositoryModule {

    public static final String TAG_FLICKR_REPO = "flickr_repository";

    @Provides
    @Singleton
    public PhotoRepository provideFlickrRepository(FlickrApi api){
        return new FlickrPhotoDataSource(api);
    }
}
