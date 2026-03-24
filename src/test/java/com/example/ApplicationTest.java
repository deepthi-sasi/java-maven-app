package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ApplicationTest {
    @Test
    public void testApp(){
        Application myApp = new Application();

        String result = myApp.getStatus();

        assertEquals("OK", result);
    }
}