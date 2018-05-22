package victor.tech.flickrtestapp.mvp;


public interface BaseView {

    void showMessage(String message);

    void showMessage(int messageId);

    void showProgress(boolean isShowing);

}
