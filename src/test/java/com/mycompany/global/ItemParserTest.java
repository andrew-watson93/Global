/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.global;

import static com.mycompany.global.TestConstants.NESTED_AND_NON_NESTED;
import static com.mycompany.global.TestConstants.NESTED_SHOWS;
import static com.mycompany.global.TestConstants.NON_NESTED_SHOWS;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
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
public class ItemParserTest {

    @Mock
    private ShowParser showParser;

    @InjectMocks
    private ItemParser itemParser;

    @Test
    public void parseItem_CallsParserMultipleTimesForNestedItem() {
        itemParser.parseItems(NESTED_SHOWS);
        verify(showParser, times(2)).getShow(anyString());
    }

    @Test
    public void parseItem_CallsParserOnceForNonNestedItem() {
        itemParser.parseItems(NON_NESTED_SHOWS);
        verify(showParser).getShow(anyString());
    }

    @Test
    public void parseItem_HandlesBothTypesTogether() {
        itemParser.parseItems(NESTED_AND_NON_NESTED);
        verify(showParser, times(3)).getShow(anyString());
    }

    @Test
    public void parseItem_ReturnsShowsFromShowParser() {
        Show expected = new Show("from", "to", new Episode(new Programme("longName", "synopsis")));
        when(showParser.getShow(anyString())).thenReturn(expected);
        List<Show> shows = itemParser.parseItems(NON_NESTED_SHOWS);
        assertThat(shows.size(), is(1));
        Show actual = shows.get(0);
        assertThat(expected, is(actual));
    }

}
