/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.global;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

/**
 *
 * @author andre
 */
@Service
public class ShowParser {

    Show getShow(String json) {
        Gson gson = new Gson();
        Show show = gson.fromJson(json, Show.class);
        return show;
    }

}
