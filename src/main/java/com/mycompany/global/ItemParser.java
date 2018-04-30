/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.global;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.List;

/**
 *
 * @author andre
 */
public class ItemParser {

    private final ShowParser showParser;

    public ItemParser(ShowParser showParser) {
        this.showParser = showParser;
    }

    public List<Show> parseItems(String json) {
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        JsonArray schedule = jsonObject.getAsJsonArray("schedule");
        schedule.forEach(item -> {
            JsonObject itemJsonObject = item.getAsJsonObject();
            if (itemJsonObject.get("includedStationId") != null) {
                JsonArray shows = itemJsonObject.getAsJsonArray("schedule");
                shows.forEach(show -> {
                    showParser.getShow(show.toString());
                });
            }
        });
//        Set<Entry<String, JsonElement>> entrySet = schedule.entrySet();
        return null;

    }

}
