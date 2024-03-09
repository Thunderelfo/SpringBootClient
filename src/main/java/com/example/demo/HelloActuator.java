package com.example.demo;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import static java.lang.StringTemplate.STR;

@Component
@Endpoint(id="coolname")
public class HelloActuator {

    @ReadOperation
    public String getPhrase(){
        return "nice";
    }

    @WriteOperation
    public String printPhrase(@Selector String phrase){
        return STR."Your phrase is: \{phrase}";
    }
}
