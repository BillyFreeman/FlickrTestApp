package victor.tech.flickrtestapp.mvp;


public interface BasePresenter<V extends BaseView> {

    void onAttachView(V view);

    void onDetachView();
}
