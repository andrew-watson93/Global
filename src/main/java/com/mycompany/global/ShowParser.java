/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.global;

import com.google.gson.Gson;

/**
 *
 * @author andre
 */
public class ShowParser {

    Show getShow2(String json) {
        Gson gson = new Gson();
        Show show2 = gson.fromJson(json, Show.class);
        return show2;
    }

}
