package com.example.webdemo.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;


@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return (!response.getStatusCode().equals(HttpStatus.OK));
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse)
            throws ResponseStatusException, IOException {
        throw new ResponseStatusException(httpResponse.getStatusCode());

    }
}
