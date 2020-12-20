package ru.barabanra.yandex.dto.item.weather;

import lombok.Data;

@Data
public class GeoObject {

    private Country country;

    private District district;

    private Locality locality;

    private Province province;

}