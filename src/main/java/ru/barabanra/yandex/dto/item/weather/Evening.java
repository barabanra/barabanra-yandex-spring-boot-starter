package ru.barabanra.yandex.dto.item.weather;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class Evening {

    private String _source;

    private Long cloudness;

    private String condition;

    private String daytime;
    @JsonAlias("feels_like")
    private Long feelsLike;

    private Long humidity;

    private String icon;

    private Boolean polar;
    @JsonAlias("prec_mm")
    private Long precMm;
    @JsonAlias("prec_period")
    private Long precPeriod;
    @JsonAlias("prec_prob")
    private Long precProb;
    @JsonAlias("prec_strength")
    private Double precStrength;
    @JsonAlias("prec_type")
    private Long precType;
    @JsonAlias("pressure_mm")
    private Long pressureMm;
    @JsonAlias("pressure_pa")
    private Long pressurePa;
    @JsonAlias("soil_moisture")
    private Double soilMoisture;
    @JsonAlias("soil_temp")
    private Long soilTemp;
    @JsonAlias("temp_avg")
    private Long tempAvg;
    @JsonAlias("temp_max")
    private Long tempMax;
    @JsonAlias("temp_min")
    private Long tempMin;
    @JsonAlias("temp_water")
    private Long tempWater;
    @JsonAlias("uv_index")
    private Long uvIndex;
    @JsonAlias("wind_dir")
    private String windDir;
    @JsonAlias("wind_gust")
    private Double windGust;
    @JsonAlias("wind_speed")
    private Double windSpeed;

}