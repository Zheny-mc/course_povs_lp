package ru.cbrrate.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.cbrrate.model.CurrencyRate;
import ru.cbrrate.services.CurrencyRateEndpointService;


@RestController
@Slf4j
@RequiredArgsConstructor
public class CurrencyRateEndpointController {

    public final CurrencyRateEndpointService currencyRateEndpointService;

    @GetMapping
    public Mono<CurrencyRate> getCurrencyRate()  {
        log.info("getCurrencyRate, currency:{}, date:{}");
        return currencyRateEndpointService.getCurrencyRate();
    }
}