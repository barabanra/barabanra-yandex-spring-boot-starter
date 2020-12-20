package ru.barabanra.yandex.service;

import ru.barabanra.yandex.dto.YandexWeatherRequestParams;
import ru.barabanra.yandex.dto.item.weather.YandexWeatherInfoItem;

public interface WeatherService {

    /**
     * Запрос позволяет узнать фактическое значение и прогноз погоды для указанного населенного пункта.
     *
     * https://yandex.ru/dev/weather/doc/dg/concepts/forecast-test.html
     */
    YandexWeatherInfoItem getWeatherInfo(YandexWeatherRequestParams requestParams);

}