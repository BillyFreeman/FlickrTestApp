package victor.tech.flickrtestapp;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;

import victor.tech.flickrtestapp.browser.presentation.PhotoBrowserActivity;
import victor.tech.flickrtestapp.mvp.MvpActivity;

public class SplashActivity extends MvpActivity {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initViews() {
        ValueAnimator animator = ValueAnimator.ofInt(0, 10).setDuration(1000);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                moveForward();
            }
        });
        animator.start();
    }

    private void moveForward() {
        Intent mainActivityIntent = new Intent(this, PhotoBrowserActivity.class);
        mainActivityIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(mainActivityIntent);
    }
}
