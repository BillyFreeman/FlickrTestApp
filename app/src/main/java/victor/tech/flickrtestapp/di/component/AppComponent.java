package victor.tech.flickrtestapp.di.component;

import javax.inject.Singleton;

import dagger.Component;
import victor.tech.flickrtestapp.api.FlickrPhotoDataSource;
import victor.tech.flickrtestapp.api.PhotoRepository;
import victor.tech.flickrtestapp.di.module.ApiModule;
import victor.tech.flickrtestapp.di.module.AppModule;
import victor.tech.flickrtestapp.di.module.DisplayModule;
import victor.tech.flickrtestapp.di.module.RepositoryModule;
import victor.tech.flickrtestapp.di.module.RxModule;

@Singleton
@Component(modules = {
        AppModule.class,
        ApiModule.class,
        RxModule.class,
        DisplayModule.class,
        RepositoryModule.class})
public interface AppComponent {

    BrowserComponent plusBrowserComponent();

}
