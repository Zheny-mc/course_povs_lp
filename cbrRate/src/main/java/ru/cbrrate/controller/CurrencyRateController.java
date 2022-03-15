package ru.cbrrate.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.cbrrate.model.Worker;
import ru.cbrrate.services.CurrencyRateService;

@RestController
@Slf4j
@RequiredArgsConstructor
public class CurrencyRateController {

    public final CurrencyRateService currencyRateService;

    @GetMapping
    public Mono<Worker> getWorker()  {
	    //log.info("begin getMessage");
        var message = currencyRateService.getCurrencyRate();
        return message;
    }

	@GetMapping("/all")
	public Flux<Worker> getListWorker()  {
		//log.info("begin getMessage");
		var message = currencyRateService.getListWorker();
		return message;
	}
}