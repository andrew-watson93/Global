/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.global;

import static com.mycompany.global.TestConstants.NESTED_SHOWS_JSON_STRING;
import static com.mycompany.global.TestConstants.NON_NESTED_SHOWS_JSON_STRING;
import static com.mycompany.global.TestConstants.TIMED_SHOW_1;
import static com.mycompany.global.TestConstants.TIMED_SHOW_2;
import static com.mycompany.global.TestConstants.TIMED_SHOW_3;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.eq;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author andre
 */
@RunWith(MockitoJUnitRunner.class)
public class RadioShowJsonParserTest {

    @Mock
    private JsonMapper jsonMapper;

    @InjectMocks
    private RadioShowJsonParser radioShowJsonParser;

    private static final List<TimedShow> UNSORTED_SAME_DAYS = Arrays.asList(TIMED_SHOW_2, TIMED_SHOW_1);
    private static final List<TimedShow> UNSORTED_DIFFERENT_DAYS = Arrays.asList(TIMED_SHOW_2, TIMED_SHOW_1, TIMED_SHOW_3);

    @Before
    public void setUp() {
        when(jsonMapper.mapToTimedShowList(NON_NESTED_SHOWS_JSON_STRING)).thenReturn(UNSORTED_SAME_DAYS);
        when(jsonMapper.mapToTimedShowList(NESTED_SHOWS_JSON_STRING)).thenReturn(UNSORTED_DIFFERENT_DAYS);
    }

    @Test
    public void parseJson_CallsMapper() {
        radioShowJsonParser.parseJson(NON_NESTED_SHOWS_JSON_STRING);
        verify(jsonMapper).mapToTimedShowList(eq(NON_NESTED_SHOWS_JSON_STRING));
    }

    @Test
    public void parseJson_ReturnsMapWithDateStringAsKey() {
        setupTestAndValidateCommonAssertions();
    }

    @Test
    public void parseJson_ReturnsMapOfSortedLists() {
        Map<String, List<TimedShow>> showsByDay = setupTestAndValidateCommonAssertions();
        verifySortedListAssertions(showsByDay);
    }

    @Test
    public void parseJson_HandlesMultipleDays() {
        Map<String, List<TimedShow>> showsByDay = radioShowJsonParser.parseJson(NESTED_SHOWS_JSON_STRING);
        assertThat(showsByDay.size(), is(2));
        String key1 = (String) showsByDay.keySet().toArray()[0];
        String key2 = (String) showsByDay.keySet().toArray()[1];
        assertThat(key1, is("2018-03-26"));
        assertThat(key2, is("2018-03-27"));
        verifySortedListAssertions(showsByDay);
        List<TimedShow> day2 = showsByDay.get(key2);
        assertThat(day2.size(), is(1));
        assertThat(day2.get(0), is(TIMED_SHOW_3));

    }

    private Map<String, List<TimedShow>> setupTestAndValidateCommonAssertions() {
        Map<String, List<TimedShow>> showsByDay = radioShowJsonParser.parseJson(NON_NESTED_SHOWS_JSON_STRING);
        assertThat(showsByDay.size(), is(1));
        assertThat(showsByDay.containsKey("2018-03-26"), is(true));
        return showsByDay;
    }

    private void verifySortedListAssertions(Map<String, List<TimedShow>> showsByDay) {
        List<TimedShow> sortedShows = showsByDay.get("2018-03-26");
        assertThat(sortedShows.size(), is(2));
        assertThat(sortedShows.get(0), is(TIMED_SHOW_1));
        assertThat(sortedShows.get(1), is(TIMED_SHOW_2));
    }

}
