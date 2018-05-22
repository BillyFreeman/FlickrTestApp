package victor.tech.flickrtestapp.domain;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;


public abstract class UseCase<P, R> {

    protected Scheduler subscribeScheduler;
    protected Scheduler observeScheduler;

    private Disposable subscription = Disposables.empty();

    protected UseCase(Scheduler subscribeScheduler, Scheduler observeScheduler) {
        this.subscribeScheduler = subscribeScheduler;
        this.observeScheduler = observeScheduler;
    }

    protected abstract Observable<R> prepareObservable(P params);

    public void subscribe(P params, Consumer<R> onNext, Consumer<Throwable> onError) {
        subscription = prepareObservable(params)
                .subscribeOn(subscribeScheduler)
                .observeOn(observeScheduler)
                .subscribe(onNext, onError);
    }


    public void cancel() {
        if (!subscription.isDisposed()) {
            subscription.dispose();
        }
    }
}
