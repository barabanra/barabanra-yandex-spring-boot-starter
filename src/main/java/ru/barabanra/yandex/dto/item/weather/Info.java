package ru.barabanra.yandex.dto.item.weather;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class Info {

    private Boolean _h;
    @JsonAlias("def_pressure_mm")
    private Long defPressureMm;
    @JsonAlias("def_pressure_pa")
    private Long defPressurePa;

    private Boolean f;

    private Long geoid;

    private Double lat;

    private Double lon;

    private Boolean n;

    private Boolean nr;

    private Boolean ns;

    private Boolean nsr;

    private Boolean p;

    private String slug;

    private Tzinfo tzinfo;

    private String url;

    private Long zoom;

}