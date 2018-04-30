/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.global;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * @author andre
 */
public class ShowParser {

    JsonObject getSchedule(String json) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Show getShow(String json) {
        JsonObject showObject = new JsonParser().parse(json).getAsJsonObject();
        Show show = new Show();
        show.setFrom(showObject.get("from").getAsString());
        show.setTo(showObject.get("to").getAsString());
        JsonObject programme = getProgramme(showObject);
        show.setLongName(programme.get("longName").getAsString());
        show.setSynopsis(programme.get("synopsis").getAsString());
        return show;
    }

    private JsonObject getProgramme(JsonObject showObject) {
        JsonObject episode = showObject.getAsJsonObject("episode");
        return episode.getAsJsonObject("programme");

    }

}
