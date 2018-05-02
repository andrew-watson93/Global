/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.global;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author andre
 */
@RestController
public class RadioShowController {

    private final RadioShowJsonParser radioShowJsonParser;

    public RadioShowController(RadioShowJsonParser radioShowJsonParser) {
        this.radioShowJsonParser = radioShowJsonParser;
    }

    @RequestMapping("/")
    public String index() {
        return "Hello world";
    }

    public void createSchedule(String json) {
        radioShowJsonParser.parseJson(json);
    }
}
