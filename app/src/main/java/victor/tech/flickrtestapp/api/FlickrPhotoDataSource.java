package victor.tech.flickrtestapp.api;


import java.util.List;

import io.reactivex.Observable;
import victor.tech.flickrtestapp.api.response.PhotoSizesResponse;
import victor.tech.flickrtestapp.domain.entity.Photo;

public class FlickrPhotoDataSource implements PhotoRepository {

    private FlickrApi api;


    public FlickrPhotoDataSource(FlickrApi api) {
        this.api = api;
    }


    @Override
    public Observable<List<Photo>> getPhotos(int page, int perPage) {
        return api.getRecentPhotos(page, perPage)
                .map(response -> {
                    if (!response.isOk()) throw new Exception();
                    return response;
                })
                .flatMapObservable(response -> Observable.fromIterable(response.getPage().getPhotos()))
                .flatMap(photoData -> api.getPhotoSizes(photoData.getId()).toObservable())
                .flatMap(response -> Observable.fromIterable(response.getSizes().getSize())
                        .map(size -> new Photo(null, size.getSource(), null, size.getWidth(), size.getHeight()))
                        .toList()
                        .toObservable());
    }
}
