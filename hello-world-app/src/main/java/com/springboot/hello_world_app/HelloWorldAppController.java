package com.springboot.hello_world_app;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 
  
@RestController
public class HelloWorldAppController { 
    @RequestMapping("/") public String helloworld() 
    { 
        return "Hello, This is a sample springboot application"; 
    } 
}