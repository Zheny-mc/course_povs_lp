package ru.cbrrate.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.cbrrate.config.CbrRateClientConfig;
import ru.cbrrate.model.CurrencyRate;

@Service("cbr")
@RequiredArgsConstructor
@Slf4j
public class CbrRateClient implements RateClient {

    private final CbrRateClientConfig config;
    private final ru.cbrrate.clients.HttpClient httpClient;
    private final ObjectMapper objectMapper;

    @Override
    public Mono<CurrencyRate> getCurrencyRate() {
        var urlWithParams = String.format("%s", config.getUrl());
        try {
            return httpClient.performRequest(urlWithParams)
                    .map(this::parse);
        } catch (HttpClientException ex) {
            throw new RateClientException("Error from Cbr Client host:" + ex.getMessage());
        } catch (Exception ex) {
            throw new RateClientException("Can't get currencyRate. currency:");
        }
    }

	private CurrencyRate parse(String rateAsString) {
        try {
            return objectMapper.readValue(rateAsString, CurrencyRate.class);
        } catch (Exception ex) {
            throw new RateClientException("Can't parse string:" + rateAsString);
        }
    }
}
