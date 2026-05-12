package com.creditCardValidator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LuhnValidatorTest {

    @Test
    void testValidCard() {
        assertTrue(LuhnValidator.isValid("4111111111111111"));
    }

    @Test
    void testInvalidCard() {
        assertFalse(LuhnValidator.isValid("1234567890123456"));
    }

    @Test
    void testEdgeCaseEmpty() {
        assertFalse(LuhnValidator.isValid(""));
    }

}