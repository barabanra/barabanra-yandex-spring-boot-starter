package ru.barabanra.yandex.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.barabanra.yandex.dto.YandexProperties;

@Configuration
@ComponentScan("ru.barabanra.yandex")
public class YandexApplicationConfig {

    @Bean
    @Qualifier("yandexProperties")
    @ConfigurationProperties(prefix = "yandex.properties")
    @ConditionalOnMissingBean(name = "yandexProperties")
    public YandexProperties yandexProperties() {
        return new YandexProperties();
    }

}