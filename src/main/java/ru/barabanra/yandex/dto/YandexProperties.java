package ru.barabanra.yandex.dto;

import lombok.Data;

@Data
public class YandexProperties {

    private String token;

    private String weatherInfoUrl = "https://api.weather.yandex.ru/v2/forecast?lat=%s&lon=%s&lang=%s&limit=%s&hours=%s&extra=%s";

}