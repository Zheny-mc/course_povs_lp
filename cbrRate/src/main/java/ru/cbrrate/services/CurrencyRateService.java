package ru.cbrrate.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import ru.cbrrate.model.Worker;

import javax.security.auth.callback.Callback;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
public class CurrencyRateService {
    public Mono<Worker> getCurrencyRate() {
        return Mono.just(
                Worker.builder()
			        .name("Evgeny")
			        .birthday("14/03/2022")
			        .post("head")
			        .experienceYear("5")
			        .build()
        );
    }

	public Flux<Worker> getListWorker() {
		var future = new CompletableFuture<List<Worker>>();
		future.completeAsync(() -> createListWorker(),
				CompletableFuture.delayedExecutor(3, TimeUnit.SECONDS));
		return Mono.fromFuture(future).flatMapMany(Flux::fromIterable);
	}

	private List<Worker> createListWorker() {
    	return List.of(
    			Worker.builder()
					    .name("Evgeny1")
					    .birthday("14/03/2022")
					    .post("head")
					    .experienceYear("5")
					    .build(),
			    Worker.builder()
					    .name("Evgeny2")
					    .birthday("10/03/2021")
					    .post("worker")
					    .experienceYear("2")
					    .build()
	            );


	}
}
