/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.global;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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

    private static final String NESTED_SHOWS = "{\n"
            + "    \"schedule\": [\n"
            + "        {\n"
            + "            \"from\": \"2018-03-26T00:00:00.000+01:00\",\n"
            + "            \"to\": \"2018-03-26T06:00:00.000+01:00\",\n"
            + "            \"includedStationId\": 153,\n"
            + "            \"schedule\": [\n"
            + "                {\n"
            + "                    \"from\": \"2018-03-26T00:00:00.000+01:00\",\n"
            + "                    \"to\": \"2018-03-26T04:00:00.000+01:00\",\n"
            + "                    \"episode\": {\n"
            + "                        \"id\": 1398076,\n"
            + "                        \"stationId\": 153,\n"
            + "                        \"start\": \"2018-03-26T00:00:00.000+01:00\",\n"
            + "                        \"finish\": \"2018-03-26T04:00:00.000+01:00\",\n"
            + "                        \"programme\": {\n"
            + "                            \"id\": 2065,\n"
            + "                            \"shortName\": \"WillC\",\n"
            + "                            \"mediumName\": \"Will Cozens\",\n"
            + "                            \"longName\": \"Will Cozens\",\n"
            + "                            \"synopsis\": \"Will's going to get you moving with some of the BIGGEST, freshest hits and the latest celebrity gossip! Get involved @CapitalOfficial on Twitter.\",\n"
            + "                            \"contactFormUrl\": \"http://www.capitalfm.com/london/radio/shows-presenters/will-cozens\",\n"
            + "                            \"showPageUrl\": \"http://www.capitalfm.com/london/radio/shows-presenters/will-cozens\",\n"
            + "                            \"slideshowImage\": {\n"
            + "                                \"id\": 5227,\n"
            + "                                \"path\": \"ae7dd64a-3da6-4e6d-b544-f40c3e2c7206\",\n"
            + "                                \"mime\": \"image/png\",\n"
            + "                                \"width\": 0,\n"
            + "                                \"height\": 0\n"
            + "                            },\n"
            + "                            \"websiteImage\": {\n"
            + "                                \"id\": 5227,\n"
            + "                                \"path\": \"ae7dd64a-3da6-4e6d-b544-f40c3e2c7206\",\n"
            + "                                \"mime\": \"image/png\",\n"
            + "                                \"width\": 0,\n"
            + "                                \"height\": 0\n"
            + "                            },\n"
            + "                            \"squareImage\": {\n"
            + "                                \"id\": 5228,\n"
            + "                                \"path\": \"4ebe17e9-8c96-4ac9-bbef-794a544b77e9\",\n"
            + "                                \"mime\": \"image/png\",\n"
            + "                                \"width\": 0,\n"
            + "                                \"height\": 0\n"
            + "                            },\n"
            + "                            \"widescreenImage\": {\n"
            + "                                \"id\": 5227,\n"
            + "                                \"path\": \"ae7dd64a-3da6-4e6d-b544-f40c3e2c7206\",\n"
            + "                                \"mime\": \"image/png\",\n"
            + "                                \"width\": 0,\n"
            + "                                \"height\": 0\n"
            + "                            },\n"
            + "                            \"images\": [\n"
            + "                                {\n"
            + "                                    \"id\": 5228,\n"
            + "                                    \"path\": \"4ebe17e9-8c96-4ac9-bbef-794a544b77e9\",\n"
            + "                                    \"mime\": \"image/png\",\n"
            + "                                    \"width\": 0,\n"
            + "                                    \"height\": 0\n"
            + "                                }\n"
            + "                            ],\n"
            + "                            \"sources\": [\n"
            + "                                100\n"
            + "                            ]\n"
            + "                        },\n"
            + "                        \"sources\": []\n"
            + "                    }\n"
            + "                },\n"
            + "                {\n"
            + "                    \"from\": \"2018-03-26T04:00:00.000+01:00\",\n"
            + "                    \"to\": \"2018-03-26T06:00:00.000+01:00\",\n"
            + "                    \"episode\": {\n"
            + "                        \"id\": 1398077,\n"
            + "                        \"stationId\": 153,\n"
            + "                        \"start\": \"2018-03-26T04:00:00.000+01:00\",\n"
            + "                        \"finish\": \"2018-03-26T06:00:00.000+01:00\",\n"
            + "                        \"programme\": {\n"
            + "                            \"id\": 5428,\n"
            + "                            \"shortName\": \"AimeeV\",\n"
            + "                            \"mediumName\": \"Aimee Vivian\",\n"
            + "                            \"longName\": \"Aimee Vivian\",\n"
            + "                            \"synopsis\": \"Aimee's on hand with the biggest tunes from your favourite hit music stars. Catch up with all the latest now at CapitalFM.com\",\n"
            + "                            \"contactFormUrl\": \"http://www.capitalfm.com/radio/shows-presenters/aimee-vivian\",\n"
            + "                            \"showPageUrl\": \"http://www.capitalfm.com/radio/shows-presenters/aimee-vivian\",\n"
            + "                            \"slideshowImage\": {\n"
            + "                                \"id\": 5021,\n"
            + "                                \"path\": \"59ecb8ff-f4ad-45e3-89e9-0a4e9a21d861\",\n"
            + "                                \"mime\": \"image/png\",\n"
            + "                                \"width\": 0,\n"
            + "                                \"height\": 0\n"
            + "                            },\n"
            + "                            \"websiteImage\": {\n"
            + "                                \"id\": 5021,\n"
            + "                                \"path\": \"59ecb8ff-f4ad-45e3-89e9-0a4e9a21d861\",\n"
            + "                                \"mime\": \"image/png\",\n"
            + "                                \"width\": 0,\n"
            + "                                \"height\": 0\n"
            + "                            },\n"
            + "                            \"squareImage\": {\n"
            + "                                \"id\": 5022,\n"
            + "                                \"path\": \"c039386b-a3b1-493b-9151-790bd20f7055\",\n"
            + "                                \"mime\": \"image/png\",\n"
            + "                                \"width\": 0,\n"
            + "                                \"height\": 0\n"
            + "                            },\n"
            + "                            \"widescreenImage\": {\n"
            + "                                \"id\": 5021,\n"
            + "                                \"path\": \"59ecb8ff-f4ad-45e3-89e9-0a4e9a21d861\",\n"
            + "                                \"mime\": \"image/png\",\n"
            + "                                \"width\": 0,\n"
            + "                                \"height\": 0\n"
            + "                            },\n"
            + "                            \"images\": [\n"
            + "                                {\n"
            + "                                    \"id\": 5022,\n"
            + "                                    \"path\": \"c039386b-a3b1-493b-9151-790bd20f7055\",\n"
            + "                                    \"mime\": \"image/png\",\n"
            + "                                    \"width\": 0,\n"
            + "                                    \"height\": 0\n"
            + "                                }\n"
            + "                            ],\n"
            + "                            \"sources\": [\n"
            + "                                100\n"
            + "                            ]\n"
            + "                        },\n"
            + "                        \"sources\": []\n"
            + "                    }\n"
            + "                }\n"
            + "            ]\n"
            + "        }\n"
            + "    ]\n"
            + "}";

    @Test
    public void parseItem_CallsParserMultipleTimesForNestedItem() {
        itemParser.parseItems(NESTED_SHOWS);
        verify(showParser, times(2)).getShow(anyString());
    }

}
