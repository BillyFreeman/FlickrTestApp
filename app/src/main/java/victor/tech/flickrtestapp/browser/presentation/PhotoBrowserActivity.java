package victor.tech.flickrtestapp.browser.presentation;

import android.widget.Toast;

import com.bumptech.glide.RequestManager;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.listeners.ItemRemovedListener;

import javax.inject.Inject;

import victor.tech.flickrtestapp.R;
import victor.tech.flickrtestapp.di.Injector;
import victor.tech.flickrtestapp.domain.entity.Photo;
import victor.tech.flickrtestapp.mvp.MvpActivity;

public class PhotoBrowserActivity extends MvpActivity<PhotoBrowserPresenter>
        implements PhotoBrowserView {

    private Toast toast;
    private SwipePlaceHolderView swipeView;

    @Inject
    RequestManager requestManager;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void injectDependencies() {
        Injector.getInstance().getBrowserComponent().inject(this);
    }

    @Override
    protected void initViews() {
        swipeView = findViewById(R.id.swipeCardStackView);
        setupSwipeView();
    }

    private void setupSwipeView() {
        swipeView.getBuilder().setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(24)
                        .setRelativeScale(0.02f))
                .setSwipeType(SwipePlaceHolderView.SWIPE_TYPE_HORIZONTAL);
        swipeView.addItemRemoveListener(count -> {
            if (count == 7) {
                presenter.needMorePhotos();
            }
        });
    }

    @Override
    protected void onPresenterReady(PhotoBrowserPresenter presenter) {
        presenter.onAttachView(this);
        presenter.needMorePhotos();
    }

    @Override
    public void onPhotoReady(Photo photo) {
        swipeView.addView(new PhotoCard(photo, requestManager));
    }

    @Override
    protected void onCleanUp(PhotoBrowserPresenter presenter) {
        presenter.onDetachView();
    }

    @Override
    protected void onReleaseComponent() {
        Injector.getInstance().releaseBrowserComponent();
    }

    @Override
    public void showMessage(String message) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void showMessage(int messageId) {
        showMessage(getString(messageId));
    }

    @Override
    public void showProgress(boolean isShowing) {

    }
}
