/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.global;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author andre
 */
public class RadioShowJsonParser {

    private final ShowParser showParser;

    public RadioShowJsonParser(ShowParser showParser) {
        this.showParser = showParser;
    }

    public Map<String, List<TimedShow>> parseJson(String json) {
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        JsonArray schedule = jsonObject.getAsJsonArray("schedule");
        Map<String, List<TimedShow>> timedShows = new TreeMap<>();
        schedule.forEach(item -> {
            JsonObject itemJsonObject = item.getAsJsonObject();
            if (itemJsonObject.get("includedStationId") != null) {
                JsonArray scheduleNodes = itemJsonObject.getAsJsonArray("schedule");
                scheduleNodes.forEach(node -> {
                    getTimedShowAndAddToMap(node, timedShows);
                });
            } else {
                getTimedShowAndAddToMap(item, timedShows);
            }
        });
        return timedShows;

    }

    private void getTimedShowAndAddToMap(JsonElement node, Map<String, List<TimedShow>> timedShows) {
        TimedShow show = new TimedShow(showParser.getShow(node.toString()));
        String dateString = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(show.getFrom());
        List<TimedShow> shows = timedShows.get(dateString);
        if (shows == null) {
            shows = new ArrayList();
            timedShows.put(dateString, shows);
        }
        shows.add(show);
    }

}
