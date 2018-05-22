package victor.tech.flickrtestapp.browser.presentation;

import android.graphics.Point;

import victor.tech.flickrtestapp.browser.domain.GetPhotosUseCase;
import victor.tech.flickrtestapp.browser.domain.params.GetPhotoParams;

public class PhotoBrowserPresenterImp implements PhotoBrowserPresenter {

    private PhotoBrowserView view;
    private GetPhotosUseCase getPhotosUseCase;
    private Point displayDimension;
    private int page = 0;


    public PhotoBrowserPresenterImp(GetPhotosUseCase getPhotosUseCase, Point displayDimension) {
        this.getPhotosUseCase = getPhotosUseCase;
        this.displayDimension = displayDimension;
    }

    @Override
    public void onAttachView(PhotoBrowserView view) {
        this.view = view;
        getPhotosUseCase.subscribe(null, photo -> {
            if (this.view != null) {
                this.view.onPhotoReady(photo);
            }
        }, error -> {
            if (this.view != null) {
                throw new Exception(error);
            }
        });
    }

    @Override
    public void onDetachView() {
        view = null;
        getPhotosUseCase.cancel();
    }

    @Override
    public void refreshPhotos() {
        page = 0;
        pullUpdates(page, DEFAULT_PAGE_SIZE);
    }

    @Override
    public void needMorePhotos() {
        page++;
        pullUpdates(page, DEFAULT_PAGE_SIZE);
    }

    private void pullUpdates(int page, int perPage) {
        getPhotosUseCase.pull(new GetPhotoParams(page, perPage, displayDimension.x, displayDimension.y));
    }
}
