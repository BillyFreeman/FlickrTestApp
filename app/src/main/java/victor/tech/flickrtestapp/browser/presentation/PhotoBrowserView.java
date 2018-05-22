package victor.tech.flickrtestapp.browser.presentation;


import victor.tech.flickrtestapp.domain.entity.Photo;
import victor.tech.flickrtestapp.mvp.BaseView;

public interface PhotoBrowserView extends BaseView {

    void onPhotoReady(Photo photo);

}
