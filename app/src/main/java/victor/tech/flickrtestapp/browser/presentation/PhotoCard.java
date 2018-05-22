package victor.tech.flickrtestapp.browser.presentation;


import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import victor.tech.flickrtestapp.R;
import victor.tech.flickrtestapp.domain.entity.Photo;

@Layout(R.layout.view_card)
public class PhotoCard {

    @View(R.id.photo)
    ImageView imageView;

    @View(R.id.photoTitle)
    TextView titleView;

    @View(R.id.progressIndicator)
    ProgressBar progressBar;

    private Photo photo;
    private RequestManager requestManager;

    public PhotoCard(Photo photo, RequestManager requestManager) {
        this.photo = photo;
        this.requestManager = requestManager;
    }

    @Resolve
    void bind() {
        titleView.setText(photo.getTitle());
        progressBar.setVisibility(android.view.View.VISIBLE);
        requestManager.load(photo.getUrl())
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        progressBar.setVisibility(android.view.View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        progressBar.setVisibility(android.view.View.GONE);
                        return false;
                    }
                }).into(imageView);
    }
}
