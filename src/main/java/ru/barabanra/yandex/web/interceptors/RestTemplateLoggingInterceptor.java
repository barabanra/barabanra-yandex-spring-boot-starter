package ru.barabanra.yandex.web.interceptors;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class RestTemplateLoggingInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        String requestLog = getRequestLog(httpRequest, bytes);
        ClientHttpResponse response = clientHttpRequestExecution.execute(httpRequest, bytes);
        String responseLog = getResponseLog(response);

        log.debug("[Rest Template] Request - [{}],\n Response - [{}]", requestLog, responseLog);
        return response;
    }

    private String getRequestLog(HttpRequest httpRequest, byte[] bytes) {
        String body = new String(bytes, StandardCharsets.UTF_8);
        return String.format("Url - {%s}, Http method - {%s}, Body - {%s}, Headers - {%s}",
                httpRequest.getURI().toString(),
                httpRequest.getMethodValue(),
                body,
                httpRequest.getHeaders());
    }

    @SneakyThrows
    private String getResponseLog(ClientHttpResponse response) {
        String body = IOUtils.toString(response.getBody(), StandardCharsets.UTF_8);

        return String.format("Status Code - {%s}, Body - {%s}, Headers - {%s}",
                response.getRawStatusCode(),
                body,
                response.getHeaders());
    }

}