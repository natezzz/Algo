package com.nate.algo.ds;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeDictTest {

    private IDictionary<String, Integer> dict;

    @Before
    public void populate() {
        dict = new TreeDict<String, Integer>();
        dict.put("Peter", 44);
        dict.put("Razor", 53);
        dict.put("Sean", 12);
        dict.put("Jack", 33);
    }

    @After
    public void tearDown() {
        dict = null;
    }

    @Test
    public void getTest() {
        assertEquals(53, dict.get("Razor").intValue());
        assertEquals(33, dict.get("Jack").intValue());
        assertEquals(44, dict.get("Peter").intValue());
        assertEquals(12, dict.get("Sean").intValue());
        assertEquals(null, dict.get("Whatever"));
    }

    @Test
    public void clearTest() {
        dict.clear();
        assertEquals(0, dict.size());
    }

    @Test
    public void removeTest() {
        dict.remove("Peter");
        assertEquals(null, dict.get("Peter"));
    }

    @Test
    public void putTest() {
        dict.put("Shally", 33);
        assertEquals(33, dict.get("Shally").intValue());
    }

    @Test
    public void putAgainTest() {
        dict.put("Peter", 53);
        assertEquals(53, dict.get("Peter").intValue());
    }

}