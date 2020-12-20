package ru.barabanra.yandex.dto.item.weather;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class Fact {

    private Long cloudness;

    private String condition;

    private String daytime;
    @JsonAlias("feels_like")
    private Long feelsLike;

    private Long humidity;

    private String icon;
    @JsonAlias("is_thunder")
    private Boolean isThunder;
    @JsonAlias("obs_time")
    private Long obsTime;

    private Boolean polar;
    @JsonAlias("prec_prob")
    private Long precProb;
    @JsonAlias("prec_strength")
    private Long precStrength;
    @JsonAlias("prec_type")
    private Long precType;
    @JsonAlias("pressure_mm")
    private Long pressureMm;
    @JsonAlias("pressure_pa")
    private Long pressurePa;

    private String season;
    @JsonAlias("soil_moisture")
    private Double soilMoisture;
    @JsonAlias("soil_temp")
    private Long soilTemp;

    private String source;

    private Long temp;
    @JsonAlias("temp_water")
    private Long tempWater;

    private Long uptime;
    @JsonAlias("uv_index")
    private Long uvIndex;
    @JsonAlias("wind_dir")
    private String windDir;
    @JsonAlias("wind_gust")
    private Double windGust;
    @JsonAlias("wind_speed")
    private Double windSpeed;

}