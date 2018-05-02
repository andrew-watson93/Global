/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.global;

import static com.mycompany.global.TestConstants.NESTED_AND_NON_NESTED_JSON_STRING;
import static com.mycompany.global.TestConstants.NESTED_SHOWS_JSON_STRING;
import static com.mycompany.global.TestConstants.NON_NESTED_SHOWS_JSON_STRING;
import static com.mycompany.global.TestConstants.SHOW_1;
import static com.mycompany.global.TestConstants.TIMED_SHOW_1;
import java.util.List;
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
public class JsonMapperTest {

    @Mock
    private ShowParser showParser;

    @InjectMocks
    private JsonMapper jsonMapper;

    @Before
    public void setUp() {
        when(showParser.getShow(anyString())).thenReturn(SHOW_1);

    }

    @Test
    public void parseItem_CallsParserMultipleTimesForNestedItem() {
        jsonMapper.mapToTimedShowList(NESTED_SHOWS_JSON_STRING);
        verify(showParser, times(2)).getShow(anyString());
    }

    @Test
    public void parseItem_CallsParserOnceForNonNestedItem() {
        jsonMapper.mapToTimedShowList(NON_NESTED_SHOWS_JSON_STRING);
        verify(showParser).getShow(anyString());
    }

    @Test
    public void parseItem_HandlesBothTypesTogether() {
        jsonMapper.mapToTimedShowList(NESTED_AND_NON_NESTED_JSON_STRING);
        verify(showParser, times(3)).getShow(anyString());
    }

    @Test
    public void parseItem_ReturnsListOfTimedShow() {
        List<TimedShow> timedShows = jsonMapper.mapToTimedShowList(NON_NESTED_SHOWS_JSON_STRING);
        assertThat(timedShows.size(), is(1));
        TimedShow timedShow = timedShows.get(0);
        assertThat(timedShow, is(TIMED_SHOW_1));

    }

}
