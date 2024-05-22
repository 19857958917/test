package com.selenium.Junit;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;


public class JunitDemo {

    @Test
    public void myFirstTest() {
        assertEquals(2+2, 4);
    }

}