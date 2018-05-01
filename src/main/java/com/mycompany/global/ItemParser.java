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

    public List<TimedShow> parseItems(String json) {
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        JsonArray schedule = jsonObject.getAsJsonArray("schedule");
        List<TimedShow> timedShows = new ArrayList<>();
        schedule.forEach(item -> {
            JsonObject itemJsonObject = item.getAsJsonObject();
            if (itemJsonObject.get("includedStationId") != null) {
                JsonArray scheduleNodes = itemJsonObject.getAsJsonArray("schedule");
                scheduleNodes.forEach(node -> {
                    timedShows.add(new TimedShow(showParser.getShow(node.toString())));
                });
            } else {
                timedShows.add(new TimedShow(showParser.getShow(itemJsonObject.toString())));
            }
        });
        return timedShows;

    }

}
