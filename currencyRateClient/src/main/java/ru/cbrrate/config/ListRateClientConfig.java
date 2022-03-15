package ru.cbrrate.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "cbr-rate-client-all")
public class ListRateClientConfig {
	String url;
}
