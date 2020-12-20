package ru.barabanra.yandex.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.barabanra.yandex.dto.YandexProperties;
import ru.barabanra.yandex.dto.YandexWeatherRequestParams;
import ru.barabanra.yandex.dto.item.weather.YandexWeatherInfoItem;
import ru.barabanra.yandex.service.WeatherService;

import java.net.URI;

@Service
public class YandexWeatherService implements WeatherService {

    private final RestTemplate restTemplate;
    private final YandexProperties yandexProperties;

    public YandexWeatherService(@Qualifier("yandexRestTemplate") RestTemplate restTemplate,
                                @Qualifier("yandexProperties") YandexProperties yandexProperties) {
        this.restTemplate = restTemplate;
        this.yandexProperties = yandexProperties;
    }

    @Override
    public YandexWeatherInfoItem getWeatherInfo(YandexWeatherRequestParams params) {
        URI requestUri = buildWeatherInfoUrl(params);
        HttpHeaders requestHttpHeaders = buildHttpHeaders();

        RequestEntity<?> requestEntity = new RequestEntity<>(requestHttpHeaders, HttpMethod.GET, requestUri);
        ResponseEntity<YandexWeatherInfoItem> responseEntity = restTemplate.exchange(requestEntity, YandexWeatherInfoItem.class);
        return responseEntity.getBody();
    }

    private HttpHeaders buildHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Yandex-API-Key", yandexProperties.getToken());
        return httpHeaders;
    }

    private URI buildWeatherInfoUrl(YandexWeatherRequestParams params) {
        String urlString = String.format(yandexProperties.getWeatherInfoUrl(),
                params.getLatitude(),
                params.getLongitude(),
                params.getLanguage().getValue(),
                params.getDaysLimit(),
                params.getHourlyForecastEnabled(),
                params.getExtendedPrecipitationInformationEnabled());

        return URI.create(urlString);
    }

}