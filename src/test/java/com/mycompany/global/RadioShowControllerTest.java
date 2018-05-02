/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.global;

import static com.mycompany.global.TestConstants.NESTED_SHOWS_JSON_STRING;
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

}
