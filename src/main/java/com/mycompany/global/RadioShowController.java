/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.global;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @PostMapping("/schedule")
    public @ResponseBody
    Map<String, List<SimpleTimedShow>> createSchedule(@RequestBody String json) {
        return radioShowJsonParser.parseJson(json);
    }
}
