package victor.tech.flickrtestapp.domain;

import io.reactivex.Scheduler;

public abstract class StreamingUseCase<P, R> extends UseCase<P, R> {

    protected StreamingUseCase(Scheduler subscribeScheduler, Scheduler observeScheduler) {
        super(subscribeScheduler, observeScheduler);
    }

    public abstract void pull(P params);
}
