package victor.tech.flickrtestapp.browser.presentation;


import victor.tech.flickrtestapp.mvp.BasePresenter;

public interface PhotoBrowserPresenter extends BasePresenter<PhotoBrowserView> {

    int DEFAULT_PAGE_SIZE = 10;

    void refreshPhotos();

    void needMorePhotos();
}
