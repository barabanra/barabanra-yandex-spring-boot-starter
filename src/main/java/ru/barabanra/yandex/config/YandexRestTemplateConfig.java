package ru.barabanra.yandex.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import ru.barabanra.yandex.web.interceptors.RestTemplateLoggingInterceptor;

@Configuration
public class YandexRestTemplateConfig {

    @Bean
    @Qualifier("yandexClientHttpRequestInterceptor")
    @ConditionalOnMissingBean(name = "yandexClientHttpRequestInterceptor")
    public ClientHttpRequestInterceptor yandexClientHttpRequestInterceptor() {
        return new RestTemplateLoggingInterceptor();
    }

    @Bean
    @Qualifier("yandexRestTemplate")
    @ConditionalOnMissingBean(name = "yandexRestTemplate")
    public RestTemplate yandexRestTemplate(@Qualifier("yandexClientHttpRequestFactory") ClientHttpRequestFactory clientHttpRequestFactory,
                                             @Qualifier("yandexClientHttpRequestInterceptor")ClientHttpRequestInterceptor clientHttpRequestInterceptor) {
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        restTemplate.getInterceptors().add(clientHttpRequestInterceptor);
        return restTemplate;
    }

    @Bean
    @Qualifier("yandexClientHttpRequestFactory")
    @ConditionalOnMissingBean(name = "yandexClientHttpRequestFactory")
    public ClientHttpRequestFactory yandexClientHttpRequestFactory() {
        return new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
    }

}