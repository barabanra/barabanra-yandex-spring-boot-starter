package ru.barabanra.yandex.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Language {

    RU("ru_RU", "Русский язык для домена России"),
    RU_UA("ru_UA", "Русский язык для домена Украины"),
    UA("uk_UA", "Украинский язык для домена Украины"),
    BY("be_BY", "Белорусский язык для домена Беларуси"),
    KZ("kk_KZ", "Казахский язык для домена Казахстана"),
    TR("tr_TR", "Турецкий язык для домена Турции"),
    US("en_US", "Международный английский");

    private final String value;
    private final String description;

}