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

    }

}
