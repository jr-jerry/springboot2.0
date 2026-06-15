package com.ducat.springboot20.Controller;

import com.ducat.springboot20.dto.ApiResponse;
import com.ducat.springboot20.service.DemoApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test-api")
public class TestController {
    private final DemoApiService demoApiService;
    public TestController(DemoApiService demoApiService){
        this.demoApiService=demoApiService;
    }

    @GetMapping()
    public ResponseEntity<?> getEndpoint(){
       List<ApiResponse> list= demoApiService.getApi();

       if(list!=null){
           return new ResponseEntity<>(list, HttpStatus.OK);
       }
       return new ResponseEntity<>("Api hit nahi ho rhi hai",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
