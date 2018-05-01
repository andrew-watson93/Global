/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.global;

import java.text.ParseException;
import java.util.Date;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author andre
 */
public class ShowParserTest {

    private ShowParser showParser = new ShowParser();

    private static final String SHOW_STRING
            = "{\n"
            + "            \"from\": \"2018-03-26T00:00:00.000+01:00\",\n"
            + "            \"to\": \"2018-03-26T04:00:00.000+01:00\",\n"
            + "            \"episode\": {\n"
            + "                \"id\": 1398076,\n"
            + "                \"stationId\": 153,\n"
            + "                \"start\": \"2018-03-26T00:00:00.000+01:00\",\n"
            + "                \"finish\": \"2018-03-26T04:00:00.000+01:00\",\n"
            + "                \"programme\": {\n"
            + "                    \"id\": 2065,\n"
            + "                    \"shortName\": \"WillC\",\n"
            + "                    \"mediumName\": \"Will Cozens\",\n"
            + "                    \"longName\": \"Will Cozens\",\n"
            + "                    \"synopsis\": \"Will's going to get you moving with some of the BIGGEST, freshest hits and the latest celebrity gossip! Get involved @CapitalOfficial on Twitter.\",\n"
            + "                    \"contactFormUrl\": \"http://www.capitalfm.com/london/radio/shows-presenters/will-cozens\",\n"
            + "                    \"showPageUrl\": \"http://www.capitalfm.com/london/radio/shows-presenters/will-cozens\",\n"
            + "                    \"slideshowImage\": {\n"
            + "                        \"id\": 5227,\n"
            + "                        \"path\": \"ae7dd64a-3da6-4e6d-b544-f40c3e2c7206\",\n"
            + "                        \"mime\": \"image/png\",\n"
            + "                        \"width\": 0,\n"
            + "                        \"height\": 0\n"
            + "                    },\n"
            + "                    \"websiteImage\": {\n"
            + "                        \"id\": 5227,\n"
            + "                        \"path\": \"ae7dd64a-3da6-4e6d-b544-f40c3e2c7206\",\n"
            + "                        \"mime\": \"image/png\",\n"
            + "                        \"width\": 0,\n"
            + "                        \"height\": 0\n"
            + "                    },\n"
            + "                    \"squareImage\": {\n"
            + "                        \"id\": 5228,\n"
            + "                        \"path\": \"4ebe17e9-8c96-4ac9-bbef-794a544b77e9\",\n"
            + "                        \"mime\": \"image/png\",\n"
            + "                        \"width\": 0,\n"
            + "                        \"height\": 0\n"
            + "                    },\n"
            + "                    \"widescreenImage\": {\n"
            + "                        \"id\": 5227,\n"
            + "                        \"path\": \"ae7dd64a-3da6-4e6d-b544-f40c3e2c7206\",\n"
            + "                        \"mime\": \"image/png\",\n"
            + "                        \"width\": 0,\n"
            + "                        \"height\": 0\n"
            + "                    },\n"
            + "                    \"images\": [\n"
            + "                        {\n"
            + "                            \"id\": 5228,\n"
            + "                            \"path\": \"4ebe17e9-8c96-4ac9-bbef-794a544b77e9\",\n"
            + "                            \"mime\": \"image/png\",\n"
            + "                            \"width\": 0,\n"
            + "                            \"height\": 0\n"
            + "                        }\n"
            + "                    ],\n"
            + "                    \"sources\": [\n"
            + "                        100\n"
            + "                    ]\n"
            + "                },\n"
            + "                \"sources\": []\n"
            + "            }\n"
            + "        }";

    private Show show;

    @Before
    public void setup() {
        show = showParser.getShow(SHOW_STRING);
    }

    @Test
    public void getShow_ReturnsShowWithFrom() throws ParseException {
        Date expected = Show.DATE_FORMAT.parse("2018-03-26T00:00:00.000+01:00");
        assertThat(show.getFrom(), is(expected));
    }

    @Test
    public void getShow_ReturnsShowWithTo() throws ParseException {
        Date expected = Show.DATE_FORMAT.parse("2018-03-26T04:00:00.000+01:00");
        assertThat(show.getTo(), is(expected)
        );
    }

    @Test
    public void getShow_ReturnsShowWithLongName() {
        assertThat(show.getEpisode().getProgramme().getLongName(), is("Will Cozens"));
    }

    @Test
    public void getShow_ReturnsShowWithSynopsis() {
        assertThat(show.getEpisode().getProgramme().getSynopsis(), is("Will's going to get you moving with some of the BIGGEST, "
                + "freshest hits and the latest celebrity gossip! Get involved @CapitalOfficial on Twitter."));
    }

}
