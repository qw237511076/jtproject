package com.jt;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    protected ClassPathXmlApplicationContext ctx;

    /**
     * Rigorous Test :-)
     */
    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext();
    }

    @After
    public void destroy() {
        ctx.close();
    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
}
