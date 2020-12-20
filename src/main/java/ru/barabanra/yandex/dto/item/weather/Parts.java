package ru.barabanra.yandex.dto.item.weather;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class Parts {

    private Day day;
    @JsonAlias("day_short")
    private DayShort dayShort;

    private Evening evening;

    private Morning morning;

    private Night night;
    @JsonAlias("night_short")
    private NightShort nightShort;

}