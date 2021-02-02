package com.igp.studentservice;

import com.igp.studentservice.util.pattern.PatternMatcher;
import org.junit.Test;

import static org.junit.Assert.*;

public class PatternMatchingTest {

    @Test
    public void assertPatternMatching_HandlesConstantIntegerCases_Correctly() {
        PatternMatcher<Integer, Boolean> matcher = new PatternMatcher<Integer, Boolean>()
                .defineCase(1, true)
                .defineCase(3, true)
                .defineCase(5, true)
                .defaultCase(false);

        assertTrue(matcher.match(1));
        assertTrue(matcher.match(3));
        assertTrue(matcher.match(5));
        assertFalse(matcher.match(4));
    }

    @Test
    public void assertPatternMatching_HandlesConstantStringCases_Correctly() {
        PatternMatcher<String, String> matcher = new PatternMatcher<String, String>()
                .defineCase("hello", "world")
                .defaultCase("rip");

        assertEquals(matcher.match("hello"), "world");
        assertEquals(matcher.match("hi"), "rip");
    }
}
