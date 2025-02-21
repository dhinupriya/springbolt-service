package com.springbolt.springbolt_service.service;

import com.springbolt.springbolt_service.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateService {
public RestTemplate restTemplate;

@Autowired
public RestTemplateService(RestTemplate restTemplate){
    this.restTemplate=restTemplate;
}
    public Post getRestTemplatePostById(int id){
        String uri = "https://jsonplaceholder.typicode.com/posts/"+id;
        return restTemplate.getForObject(uri,Post.class);


    }

}
