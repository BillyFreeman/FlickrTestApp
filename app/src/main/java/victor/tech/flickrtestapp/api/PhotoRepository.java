package victor.tech.flickrtestapp.api;


import java.util.List;

import io.reactivex.Observable;
import victor.tech.flickrtestapp.domain.entity.Photo;

public interface PhotoRepository {

    Observable<List<Photo>> getPhotos(int page, int perPage);
}
