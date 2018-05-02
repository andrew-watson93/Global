/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.global;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author andre
 */
public class RadioShowJsonParser {

    private final JsonMapper jsonMapper;

    public RadioShowJsonParser(ShowParser showParser, JsonMapper jsonNodeMapper) {
        this.jsonMapper = jsonNodeMapper;
    }

    public Map<String, List<SimpleTimedShow>> parseJson(String json) {
        Map<String, List<SimpleTimedShow>> timedShowsByDay = new TreeMap<>();
        List<TimedShow> allTimedShows = jsonMapper.mapToTimedShowList(json);
        fillMap(allTimedShows, timedShowsByDay);
        return timedShowsByDay;

    }

    private void fillMap(List<TimedShow> allTimedShows, Map<String, List<SimpleTimedShow>> timedShowsByDay) {
        allTimedShows.sort(Comparator.comparing(TimedShow::getFrom));
        allTimedShows.forEach(ts -> {
            addTimedShowToMap(ts, timedShowsByDay);
        });
    }

    private void addTimedShowToMap(TimedShow timedShow, Map<String, List<SimpleTimedShow>> showsByDay) {
        String dateString = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(timedShow.getFrom());
        List<SimpleTimedShow> shows = showsByDay.get(dateString);
        if (shows == null) {
            shows = new ArrayList();
            showsByDay.put(dateString, shows);
        }
        shows.add(new SimpleTimedShow(timedShow));
    }

}
