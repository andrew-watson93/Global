/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.global;

import static com.mycompany.global.TestConstants.TIMED_SHOW;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author andre
 */
public class OutputFormatterTest {

    private OutputFormatter outputFormatter = new OutputFormatter();

    @Test
    public void convertAndSort_ConvertsListOfTimedShowToShowDto() {
        ShowDto expected = new ShowDto(TIMED_SHOW);
        List<ShowsByDay> showsByDay = outputFormatter.convertAndSort(Arrays.asList(TIMED_SHOW));
        assertThat(showsByDay.size(), is(1));
        ShowsByDay day = showsByDay.get(0);
        assertThat(day.getDateString(), is("2018-03-26"));
        assertThat(day.getShows().size(), is(1));
        ShowDto showDto = day.getShows().get(0);
        assertThat(showDto.getFrom(), is("2018-03-26T00:00+01:00[Europe/London]"));
        assertThat(showDto.getTo(), is("2018-03-26T04:00+01:00[Europe/London]"));
        assertThat(showDto.getSynopsis(), is("synopsis"));
        assertThat(showDto.getLongName(), is("longName"));

    }

}
