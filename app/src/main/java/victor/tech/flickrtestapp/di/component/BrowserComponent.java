package victor.tech.flickrtestapp.di.component;

import dagger.Subcomponent;
import victor.tech.flickrtestapp.browser.presentation.PhotoBrowserActivity;
import victor.tech.flickrtestapp.browser.presentation.PhotoBrowserPresenterImp;
import victor.tech.flickrtestapp.di.ActivityScope;
import victor.tech.flickrtestapp.di.module.PhotoBrowserModule;

@ActivityScope
@Subcomponent(modules = {PhotoBrowserModule.class})
public interface BrowserComponent {

    void inject(PhotoBrowserActivity activity);

}
