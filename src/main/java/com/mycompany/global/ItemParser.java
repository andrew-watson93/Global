/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.global;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
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
        List<Show> shows = new ArrayList<>();
        schedule.forEach(item -> {
            JsonObject itemJsonObject = item.getAsJsonObject();
            if (itemJsonObject.get("includedStationId") != null) {
                JsonArray scheduleNodes = itemJsonObject.getAsJsonArray("schedule");
                scheduleNodes.forEach(node -> {
                    shows.add(showParser.getShow(node.toString()));
                });
            } else {
                shows.add(showParser.getShow(itemJsonObject.toString()));
            }
        });
//        Set<Entry<String, JsonElement>> entrySet = schedule.entrySet();
//        return shows;
        return null;

    }

}
