package com.mine.learn.javaguide;

import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
public abstract class FilterRestTemplate implements RestOperations {
    @Delegate
    protected volatile RestTemplate restTemplate;
}