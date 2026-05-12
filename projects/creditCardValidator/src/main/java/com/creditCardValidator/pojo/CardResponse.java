package com.creditCardValidator.pojo;

import lombok.Data;

@Data
public class CardResponse {
    private boolean valid;
    private String cardType;
    private String maskedNumber;

    public CardResponse(boolean valid, String cardType, String maskedNumber) {
        this.valid = valid;
        this.cardType = cardType;
        this.maskedNumber = maskedNumber;
    }

    public boolean isValid() {
        return valid;
    }

    // getters
}