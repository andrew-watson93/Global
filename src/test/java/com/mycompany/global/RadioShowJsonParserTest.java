/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.global;

import static com.mycompany.global.TestConstants.NESTED_AND_NON_NESTED;
import static com.mycompany.global.TestConstants.NESTED_SHOWS;
import static com.mycompany.global.TestConstants.NON_NESTED_SHOWS;
import static com.mycompany.global.TestConstants.SHOW;
import static com.mycompany.global.TestConstants.TIMED_SHOW;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
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
    private ShowParser showParser;

    @InjectMocks
    private RadioShowJsonParser radioShowJsonParser;

    @Before
    public void setUp() {
        when(showParser.getShow(anyString())).thenReturn(SHOW);

    }

    @Test
    public void parseItem_CallsParserMultipleTimesForNestedItem() {
        radioShowJsonParser.parseJson(NESTED_SHOWS);
        verify(showParser, times(2)).getShow(anyString());
    }

    @Test
    public void parseItem_CallsParserOnceForNonNestedItem() {
        radioShowJsonParser.parseJson(NON_NESTED_SHOWS);
        verify(showParser).getShow(anyString());
    }

    @Test
    public void parseItem_HandlesBothTypesTogether() {
        radioShowJsonParser.parseJson(NESTED_AND_NON_NESTED);
        verify(showParser, times(3)).getShow(anyString());
    }

    @Test
    public void parseItem_ReturnsShowsFromShowParser() throws ParseException {

        Map<String, List<TimedShow>> showsMap = radioShowJsonParser.parseJson(NON_NESTED_SHOWS);
        assertThat(showsMap.size(), is(1));
        assertThat(showsMap.containsKey("2018-03-26"), is(true));
        List<TimedShow> showsList = showsMap.get("2018-03-26");
        assertThat(showsList.size(), is(1));
        TimedShow actualTimedShow = showsList.get(0);
        assertThat(TIMED_SHOW, is(actualTimedShow));
    }

}
