/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.global;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author andre
 */
public class OutputFormatter {

    public List<ShowsByDay> convertAndSort(List<TimedShow> timedShows) {
        ShowDto showDto = new ShowDto(timedShows.get(0));
        ShowsByDay showsByDay = new ShowsByDay();
        showsByDay.setShows(Arrays.asList(showDto));
        showsByDay.setDateString(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(timedShows.get(0).getFrom()));
        return Arrays.asList(showsByDay);
    }

}
