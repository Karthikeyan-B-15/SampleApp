package com.example.sample.view;

import static org.junit.Assert.*;

import android.app.Activity;


import androidx.test.core.app.ActivityScenario;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)

public class MainActivityTest {
 Validator validator=new Validator();
 MainActivity mainActivity=null;

    @Test
    public void isEmpty(){
        assertEquals("karthi",validator.isValid());
    }


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }
}