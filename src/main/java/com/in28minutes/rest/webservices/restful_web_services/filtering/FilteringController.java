package com.in28minutes.rest.webservices.restful_web_services.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    @GetMapping("/filtering")
    public SomeBean filtering(){
        return new SomeBean("v1","v2","v3");
    }

    // while calling this api also v2 will not be available as @JsonIgnore is used as static filtering
    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList(){
        return Arrays.asList(new SomeBean("v1","v2","v3"),
                new SomeBean("v4","v5","v6"));
    }
}
