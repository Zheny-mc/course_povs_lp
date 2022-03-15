package ru.cbrrate.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.cbrrate.clients.RateClient;

import ru.cbrrate.model.CurrencyRate;

@Service
@Slf4j
@RequiredArgsConstructor
public class CurrencyRateEndpointService {
	private final RateClient rateClient;

    public Mono<CurrencyRate> getCurrencyRate() {
        return rateClient.getCurrencyRate();
    }
}
