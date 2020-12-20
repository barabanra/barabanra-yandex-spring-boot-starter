package ru.barabanra.yandex.dto.item.weather;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;

import java.util.List;

@Data
public class YandexWeatherInfoItem {

    private Fact fact;

    private List<Forecast> forecasts;
    @JsonAlias("geo_object")
    private GeoObject geoObject;

    private Info info;

    private Long now;
    @JsonAlias("now_dt")
    private String nowDt;

    private Yesterday yesterday;

}