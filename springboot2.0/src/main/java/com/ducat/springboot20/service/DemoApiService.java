package com.ducat.springboot20.service;

import com.ducat.springboot20.dto.ApiResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class DemoApiService {
    private   final RestTemplate restTemplate;
    private static final String ApiURL="https://jsonplaceholder.typicode.com/posts";

    public DemoApiService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    public List<ApiResponse> getApi(){
       ResponseEntity<List<ApiResponse>> responseEntity= restTemplate.exchange(ApiURL, HttpMethod.GET,null,new ParameterizedTypeReference<List<ApiResponse>>(){});
       return responseEntity.getBody();
    }
}
