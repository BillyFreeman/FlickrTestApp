package victor.tech.flickrtestapp.api;


import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import victor.tech.flickrtestapp.api.response.PhotoPageResponse;
import victor.tech.flickrtestapp.api.response.PhotoSizesResponse;

public interface FlickrApi {

    @GET("?method=flickr.photos.getRecent")
    Single<PhotoPageResponse> getRecentPhotos(@Query("page") int page, @Query("perpage") int perPage);

    @GET("?method=flickr.photos.getSizes")
    Single<PhotoSizesResponse> getPhotoSizes(@Query("photo_id") String photoId);
}
