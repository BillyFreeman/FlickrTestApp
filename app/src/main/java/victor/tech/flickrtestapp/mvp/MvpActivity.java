package victor.tech.flickrtestapp.mvp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

public abstract class MvpActivity<P extends BasePresenter> extends AppCompatActivity {

    @Inject
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        initViews();
        injectDependencies();
        if (presenter != null) {
            onPresenterReady(presenter);
        }
    }

    protected abstract int getContentViewId();

    protected abstract void initViews();

    protected void injectDependencies() {

    }

    protected void onPresenterReady(P presenter) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onCleanUp(presenter);
        if (isFinishing()) {
            onReleaseComponent();
        }
    }

    protected void onCleanUp(P presenter) {

    }

    protected void onReleaseComponent() {

    }
}
