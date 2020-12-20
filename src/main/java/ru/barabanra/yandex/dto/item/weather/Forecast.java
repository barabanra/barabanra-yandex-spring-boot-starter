package ru.barabanra.yandex.dto.item.weather;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import java.util.List;

@Data
public class Forecast {

    private Biomet biomet;

    private String date;
    @JsonAlias("date_ts")
    private Long dateTs;

    private List<Hour> hours;
    @JsonAlias("moon_code")
    private Long moonCode;
    @JsonAlias("moon_text")
    private String moonText;

    private Parts parts;
    @JsonAlias("rise_begin")
    private String riseBegin;
    @JsonAlias("set_end")
    private String setEnd;

    private String sunrise;

    private String sunset;

    private Long week;

}