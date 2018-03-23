package com.demo.transmission.plugin.interceptor;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class OutgoingInterceptor implements ClientHttpRequestInterceptor {

    private Logger logger = LoggerFactory.getLogger(OutgoingInterceptor.class);

    public OutgoingInterceptor() {
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body,
                                        ClientHttpRequestExecution execution) throws IOException {
        HttpHeaders headers = request.getHeaders();
        headers.add("X-User-Id", ThreadLocalStoragedVar.get());
        logger.info(">> Calling " + request.getURI().toString() + " with user-id: " + ThreadLocalStoragedVar.get());
        return execution.execute(request, body);
    }
}
