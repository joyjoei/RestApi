package com.example.restapi.controller;

import com.example.restapi.model.BookQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping(path = "/hello")
    public String hello(){
        var html = "<html><body><h1>test</h1></body></html>";
        return html;
    }

    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(@PathVariable String message, @PathVariable int age, @PathVariable boolean isMan){
                    //@PathVariable (name="message")String msg
        System.out.println("echo : " + message);
        System.out.println("age : " + age);
        System.out.println("isMan : " + isMan);

        return message;
    }

    @GetMapping(path = "/book")
    public void queryParam(@RequestParam String category, @RequestParam int issuedYear, @RequestParam(name = "issued-month") int issuedMonth, @RequestParam String issued_day ){
        System.out.println("category : " + category);
        System.out.println("issuedYear : " + issuedYear);
        System.out.println("issuedMonth : " + issuedMonth);
        System.out.println("issued_day : " + issued_day);
    }

    @GetMapping(path = "/book2")
    public void queryParam2(BookQueryParam bookQueryParam){
        System.out.println("bookQueryParam : " + bookQueryParam);
    }

    @DeleteMapping(path = {"/user/{userName}/delete", "/user/{userName}/del"})
    public void delete(@PathVariable String userName){
        log.info("user-name : {}", userName);
    }


    }
