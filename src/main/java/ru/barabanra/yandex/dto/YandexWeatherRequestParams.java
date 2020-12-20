package ru.barabanra.yandex.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class YandexWeatherRequestParams {

    public static final Integer MAX_DAYS_LIMIT = 7;

    /**
     * Долгота в градусах. Обязательное поле.
     */
    private BigDecimal longitude;

    /**
     * Широта в градусах. Обязательное поле.
     */
    private BigDecimal latitude;

    /**
     * Сочетания языка и страны, для которых будут возвращены данные погодных формулировок. Допустимые значения:
     *
     * «ru_RU» — русский язык для домена России.
     * «ru_UA» — русский язык для домена Украины.
     * «uk_UA» — украинский язык для домена Украины.
     * «be_BY» — белорусский язык для домена Беларуси.
     * «kk_KZ» — казахский язык для домена Казахстана.
     * «tr_TR» — турецкий язык для домена Турции.
     * «en_US» — международный английский.
     */
    private Language language;


    /**
     * Количество дней в прогнозе, включая текущий.
     *
     * Для тарифа «Тестовый» максимально допустимое значение — 7.
     */
    private Integer daysLimit;

    /**
     * Для каждого из дней ответ будет содержать прогноз погоды по часам. Допустимые значения:
     *
     * «true» — значение по умолчанию, почасовой прогноз возвращается.
     * «false» — почасовой прогноз не возвращается.
     */
    private Boolean hourlyForecastEnabled;

    /**
     * Расширенная информация об осадках. Допустимые значения:
     *
     * «true» — расширенная информация об осадках возвращается.
     * «false» — значение по умолчанию, расширенная информация об осадках не возвращается.
     */
    private Boolean extendedPrecipitationInformationEnabled;

    public static YandexWeatherRequestParams.YandexWeatherRequestParamsBuilder defaultExtendedBuilder() {
        return YandexWeatherRequestParams.builder()
                .language(Language.RU)
                .daysLimit(YandexWeatherRequestParams.MAX_DAYS_LIMIT)
                .hourlyForecastEnabled(true)
                .extendedPrecipitationInformationEnabled(true);
    }

}