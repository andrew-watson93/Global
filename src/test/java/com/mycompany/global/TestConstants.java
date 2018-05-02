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

    public static final String SHOW_1_JSON_STRING
            = ("                {\n"
                    + "                     \"from\": \"2018-03-26T00:00:00.000+01:00\",\n"
                    + "                    \"to\": \"2018-03-26T04:00:00.000+01:00\",\n"
                    + "                    \"episode\" : {\n"
                    + "                        \"programme\" : {\n"
                    + "                            \"shortName\" : \"shortName\",\n"
                    + "                            \"synopsis\" : \"synopsis\"\n"
                    + "                        }\n"
                    + "                    }\n"
                    + "                }").trim();

    public static final String SHOW_2_JSON_STRING
            = ("                {\n"
                    + "                     \"from\": \"2018-03-26T04:00:00.000+01:00\",\n"
                    + "                    \"to\": \"2018-03-26T06:00:00.000+01:00\",\n"
                    + "                    \"episode\" : {\n"
                    + "                        \"programme\" : {\n"
                    + "                            \"shortName\" : \"shortName2\",\n"
                    + "                            \"synopsis\" : \"synopsis2\"\n"
                    + "                        }\n"
                    + "                    }\n"
                    + "                }").trim();

    public static final String NESTED_SHOWS_JSON_STRING
            = ("{\n"
                    + "    \"schedule\" : [\n"
                    + "        {\n"
                    + "            \"includedStationId\": 1,\n"
                    + "            \"schedule\" : [\n"
                    + SHOW_1_JSON_STRING
                    + ",\n"
                    + SHOW_2_JSON_STRING
                    + "            ]\n"
                    + "        }\n"
                    + "    ]\n"
                    + "}").trim();

    public static final String NON_NESTED_SHOWS_JSON_STRING
            = ("{\n"
                    + "    \"schedule\": [\n"
                    + "\n"
                    + SHOW_1_JSON_STRING
                    + "    ]\n"
                    + "}").trim();

    public static final String NESTED_AND_NON_NESTED_JSON_STRING = ("{\n"
            + "    \"schedule\" : [\n"
            + "        {\n"
            + "            \"includedStationId\": 1,\n"
            + "            \"schedule\" : [\n"
            + SHOW_1_JSON_STRING
            + ",\n"
            + SHOW_2_JSON_STRING
            + "            ]\n"
            + "        }\n"
            + ",\n"
            + SHOW_1_JSON_STRING
            + "    ]\n"
            + "}").trim();

    public static final Show SHOW_1 = new Show(
            "2018-03-26T00:00:00.000+01:00",
            "2018-03-26T04:00:00.000+01:00",
            new Episode(new Programme("longName", "synopsis"))
    );

    public static final Show SHOW_2 = new Show(
            "2018-03-26T04:00:00.000+01:00",
            "2018-03-26T06:00:00.000+01:00",
            new Episode(new Programme("longName", "synopsis"))
    );

    public static final Show SHOW_3 = new Show(
            "2018-03-27T04:00:00.000+01:00",
            "2018-03-27T06:00:00.000+01:00",
            new Episode(new Programme("longName", "synopsis"))
    );

    public static final TimedShow TIMED_SHOW_1 = new TimedShow(SHOW_1);
    public static final TimedShow TIMED_SHOW_2 = new TimedShow(SHOW_2);
    public static final TimedShow TIMED_SHOW_3 = new TimedShow(SHOW_3);

}
