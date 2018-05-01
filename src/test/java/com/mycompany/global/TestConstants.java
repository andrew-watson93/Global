/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.global;

/**
 *
 * @author andre
 */
public class TestConstants {

    public static final String SHOW_1
            = "                {\n"
            + "                     \"from\": \"2018-03-26T00:00:00.000+01:00\",\n"
            + "                    \"to\": \"2018-03-26T04:00:00.000+01:00\",\n"
            + "                    \"episode\" : {\n"
            + "                        \"programme\" : {\n"
            + "                            \"shortName\" : \"shortName\",\n"
            + "                            \"synopsis\" : \"synopsis\"\n"
            + "                        }\n"
            + "                    }\n"
            + "                }";

    public static final String SHOW_2
            = "                {\n"
            + "                     \"from\": \"2018-03-26T00:00:00.000+01:00\",\n"
            + "                    \"to\": \"2018-03-26T04:00:00.000+01:00\",\n"
            + "                    \"episode\" : {\n"
            + "                        \"programme\" : {\n"
            + "                            \"shortName\" : \"shortName2\",\n"
            + "                            \"synopsis\" : \"synopsis2\"\n"
            + "                        }\n"
            + "                    }\n"
            + "                }";

    public static final String NESTED_SHOWS
            = "{\n"
            + "    \"schedule\" : [\n"
            + "        {\n"
            + "            \"includedStationId\": 1,\n"
            + "            \"schedule\" : [\n"
            + SHOW_1
            + ",\n"
            + SHOW_2
            + "            ]\n"
            + "        }\n"
            + "    ]\n"
            + "}";

    public static final String NON_NESTED_SHOWS
            = "{\n"
            + "    \"schedule\": [\n"
            + "\n"
            + SHOW_1
            + "    ]\n"
            + "}";

    public static final String NESTED_AND_NON_NESTED = "{\n"
            + "    \"schedule\" : [\n"
            + "        {\n"
            + "            \"includedStationId\": 1,\n"
            + "            \"schedule\" : [\n"
            + SHOW_1
            + ",\n"
            + SHOW_2
            + "            ]\n"
            + "        }\n"
            + ",\n"
            + SHOW_1
            + "    ]\n"
            + "}";

    public static final Show SHOW = new Show(
            "2018-03-26T00:00:00.000+01:00",
            "2018-03-26T04:00:00.000+01:00",
            new Episode(new Programme("longName", "synopsis"))
    );

    public static final TimedShow TIMED_SHOW = new TimedShow(SHOW);
}
