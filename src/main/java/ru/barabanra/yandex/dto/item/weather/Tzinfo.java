package ru.barabanra.yandex.dto.item.weather;

import lombok.*;

@Data
public class Tzinfo {

    private String abbr;

    private Boolean dst;

    private String name;

    private Long offset;

}