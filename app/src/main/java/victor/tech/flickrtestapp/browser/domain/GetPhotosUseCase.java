package victor.tech.flickrtestapp.browser.domain;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.subjects.ReplaySubject;
import victor.tech.flickrtestapp.api.PhotoRepository;
import victor.tech.flickrtestapp.browser.domain.params.GetPhotoParams;
import victor.tech.flickrtestapp.di.ActivityScope;
import victor.tech.flickrtestapp.di.module.RxModule;
import victor.tech.flickrtestapp.domain.StreamingUseCase;
import victor.tech.flickrtestapp.domain.entity.Photo;
import victor.tech.flickrtestapp.util.RectUtil;

@ActivityScope
public class GetPhotosUseCase extends StreamingUseCase<GetPhotoParams, Photo> {

    private PhotoRepository repository;
    private ReplaySubject<Photo> subject = ReplaySubject.create();


    @Inject
    protected GetPhotosUseCase(@Named(RxModule.TAG_IO) Scheduler subscribeScheduler,
                               @Named(RxModule.TAG_UI) Scheduler observeScheduler,
                               PhotoRepository repository) {
        super(subscribeScheduler, observeScheduler);
        this.repository = repository;
    }

    @Override
    protected Observable<Photo> prepareObservable(GetPhotoParams params) {
        return subject;
    }

    @Override
    public void pull(GetPhotoParams params) {
        int widthTreshold = params.getWidthTreshold();
        int heightTreshold = params.getHeightTreshold();
        subject.cleanupBuffer();
        repository.getPhotos(params.getPage(), params.getPerPage())
                .subscribeOn(subscribeScheduler)
                .flatMap(list -> Observable.just(RectUtil.findBestFitRect(widthTreshold, heightTreshold, list)))
                .subscribe(subject);
    }
}
