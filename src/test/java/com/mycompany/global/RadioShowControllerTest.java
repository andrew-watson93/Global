/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.global;

import static com.mycompany.global.TestConstants.NESTED_SHOWS_JSON_STRING;
import static com.mycompany.global.TestConstants.SIMPLE_TIMED_SHOW_1;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
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
public class RadioShowControllerTest {

    @Mock
    private RadioShowJsonParser radioShowJsonParser;

    @InjectMocks
    private RadioShowController radioShowController;

    @Test
    public void createSchedule_CallsRadioShowJsonParser() {
        radioShowController.createSchedule(NESTED_SHOWS_JSON_STRING);
        verify(radioShowJsonParser).parseJson(eq(NESTED_SHOWS_JSON_STRING));
    }

    @Test
    public void createSchedule_ReturnsMapReturnedFromService() {
        SimpleTimedShow s = new SimpleTimedShow();
        List<SimpleTimedShow> simpleTimedShows = Arrays.asList(SIMPLE_TIMED_SHOW_1);
        Map<String, List<SimpleTimedShow>> map = new TreeMap<>();
        map.put("key", simpleTimedShows);
        when(radioShowJsonParser.parseJson(NESTED_SHOWS_JSON_STRING)).thenReturn(map);
        Map<String, List<SimpleTimedShow>> returnedMap = radioShowController.createSchedule(NESTED_SHOWS_JSON_STRING);
        assertThat(returnedMap, is(map));
    }

}
