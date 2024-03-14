package com.example.demo;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import static java.lang.StringTemplate.STR;

@ManagedResource(
        objectName="OmegaPoint:category=Kompetensdag,name=testBean",
        description="Actuators as MBeans")
@Component("testMbean")
public class HelloActuator2 {

    @ManagedOperation(description = "Get the message")
    public String getPhrase(){
        return "nice";
    }

    @ManagedOperation(description = "Send a message and receive one.")
    @ManagedOperationParameters({
            @ManagedOperationParameter(name = "PrintPhrase",
                    description = " A description")}
    )
    public String printPhrase(@Selector String phrase){
        return STR."Your phrase is: \{phrase}";
    }
}
