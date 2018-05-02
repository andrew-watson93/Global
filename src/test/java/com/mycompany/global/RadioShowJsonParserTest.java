/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.global;

import static com.mycompany.global.TestConstants.NON_NESTED_SHOWS_JSON_STRING;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.eq;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
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

    @Test
    public void parseJson_CallsMapper() {
        radioShowJsonParser.parseJson(NON_NESTED_SHOWS_JSON_STRING);
        verify(jsonMapper).mapToTimedShowList(eq(NON_NESTED_SHOWS_JSON_STRING));
    }

}
