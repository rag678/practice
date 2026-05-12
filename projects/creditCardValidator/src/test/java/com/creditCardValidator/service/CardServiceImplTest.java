package com.creditCardValidator.service;

import static org.junit.jupiter.api.Assertions.*;

import com.creditCardValidator.pojo.CardRequest;
import com.creditCardValidator.pojo.CardResponse;
import org.junit.jupiter.api.Test;

public class CardServiceImplTest {

    private final CardServiceImpl cardService = new CardServiceImpl();

    @Test
    void testValidVisaCard() {
        CardRequest request = new CardRequest();
        request.setCardNumber("4111111111111111");

        CardResponse response = cardService.validateCard(request);

        assertTrue(response.isValid());
        assertEquals("VISA", response.getCardType());
    }

    @Test
    void testInvalidCard() {
        CardRequest request = new CardRequest();
        request.setCardNumber("1234567890123456");

        CardResponse response = cardService.validateCard(request);

        assertFalse(response.isValid());
    }

    @Test
    void testMasking() {
        CardRequest request = new CardRequest();
        request.setCardNumber("4111111111111111");

        CardResponse response = cardService.validateCard(request);

        assertEquals("************1111", response.getMaskedNumber());
    }
}