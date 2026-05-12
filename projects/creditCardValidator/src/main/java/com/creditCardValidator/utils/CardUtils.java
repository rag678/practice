package com.creditCardValidator.utils;

import com.creditCardValidator.enums.CardType;

public class CardUtils {

    public static CardType getCardType(String cardNumber) {

        if (cardNumber.startsWith("4") &&
                (cardNumber.length() == 13 || cardNumber.length() == 16)) {
            return CardType.VISA;
        }

        if ((cardNumber.startsWith("51") || cardNumber.startsWith("52") ||
                cardNumber.startsWith("53") || cardNumber.startsWith("54") ||
                cardNumber.startsWith("55")) && cardNumber.length() == 16) {
            return CardType.MASTERCARD;
        }

        if ((cardNumber.startsWith("34") || cardNumber.startsWith("37")) &&
                cardNumber.length() == 15) {
            return CardType.AMEX;
        }

        return CardType.UNKNOWN;
    }
}